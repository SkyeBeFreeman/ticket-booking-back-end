package com.teamid.dao;

import com.teamid.entity.User;
import com.teamid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Skye on 2017/6/3.
 */

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean add(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public User findUserById(long id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    public User findUserByPhone(String phone) {
        User user = userRepository.findUserByPhone(phone);
        return user;
    }
}
