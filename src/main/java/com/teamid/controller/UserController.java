package com.teamid.controller;

import com.teamid.entity.User;
import com.teamid.entity.UserForm;
import com.teamid.entity.UserInShort;
import com.teamid.service.UserService;
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

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UserForm UserForm) {

        String username = UserForm.getUsername();
        String password = UserForm.getPassword();
        boolean gender = UserForm.getGender();
        String phone = UserForm.getPhone();

        User user = new User(username, password, gender, phone);
        userService.add(user);

        return new ResponseEntity<>(new UserInShort(username, gender, phone), HttpStatus.OK);

    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody String phone, @RequestBody String password) {

        User user = userService.login(phone, password);

        // 登录失败
        if (user == null) {
            // TODO
            return null;
        }

        else {
            return new ResponseEntity<>(new UserInShort(user.getUsername(), user.getGender(), user.getPhone()), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/userinfo")
    public ResponseEntity<?> userinfo(HttpSession session){

        long userId = (long)session.getAttribute("userId");
        User user = userService.findUserById(userId);
        return new ResponseEntity<>(new UserInShort(user.getUsername(), user.getGender(), user.getPhone()), HttpStatus.OK);

    }
}
