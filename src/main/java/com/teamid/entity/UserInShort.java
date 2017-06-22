package com.teamid.entity;

/**
 * Created by 伟宸 on 2017/6/3.
 */
public class UserInShort {
    String username;
    boolean gender;
    String phone;

    public UserInShort(String username, boolean gender, String phone) {
        this.username = username;
        this.gender = gender;
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }
}
