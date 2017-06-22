package com.teamid.entity;

/**
 * Created by 伟宸 on 2017/6/3.
 */
public class UserForm {
    String username;
    String password;
    boolean gender;
    String phone;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }
}
