package com.teamid.service;

import com.teamid.dao.UserDAO;
import com.teamid.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean add(User user) {
        return userDAO.add(user);
    }

    @Override
    public User findUserById(long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public User login(String phone, String password) {
        User user = userDAO.findUserByPhone(phone);
        if (user == null) {
            return null;
        }
        if(user.getPassword().equals(password))
            return user;
        return null;
    }
}
