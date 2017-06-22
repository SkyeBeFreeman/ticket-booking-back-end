package com.teamid.repository;

import com.teamid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Skye on 2017/6/3.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByPhone(String phone);

}
