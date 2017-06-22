package com.teamid.service;

import com.teamid.entity.User;

/**
 * Created by Skye on 2017/6/3.
 */
public interface UserService {

    boolean add(User user);
    User findUserById(long id);
    User login(String phone, String password);

}
