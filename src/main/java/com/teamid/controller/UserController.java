package com.teamid.controller;

import com.teamid.entity.User;
import com.teamid.entity.UserForm;
import com.teamid.entity.UserInShort;
import com.teamid.entity.exception.NotAcceptableException;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.entity.exception.UnauthorizedException;
import com.teamid.service.UserService;
import com.teamid.utils.LoginUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by 伟宸 on 2017/6/3.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UserForm UserForm) {

        String username = UserForm.getUsername();
        String password = UserForm.getPassword();
        boolean gender = UserForm.getGender();
        String phone = UserForm.getPhone();

        User user = new User(username, password, gender, phone);
        if (userService.add(user))
            return new ResponseEntity<>(new UserInShort(username, gender, phone), HttpStatus.OK);
        else
            throw new NotAcceptableException("Phone has been registered");

    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(String phone, String password, HttpSession session) {

        User user = userService.login(phone, password);

        if (session.isNew()) {
            logger.info("session创建成功，session的id是：" + session.getId());
        } else {
            logger.info("服务器已经存在该session了，session的id是："+ session.getId());
        }

        if (user != null) {
            session.setAttribute("userId", user.getId());
            return new ResponseEntity<>(new UserInShort(user.getUsername(), user.getGender(), user.getPhone()), HttpStatus.OK);
        }
        else
            throw new UnauthorizedException("Username or password incorrect");


    }

    @GetMapping(value = "/userinfo")
    public ResponseEntity<?> userinfo(HttpSession session){

        long userId = LoginUtils.getLoginUserId(session);
        User user = userService.findUserById(userId);

        if (user != null)
            return new ResponseEntity<>(new UserInShort(user.getUsername(), user.getGender(), user.getPhone()), HttpStatus.OK);
        else
            throw new NotFoundException("User not found");
    }
}
