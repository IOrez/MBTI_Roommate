package com.example.mbti_roommate;

public class User extends UserInfo {

    public static Singleton getInstance() {
        return UserInfo.getInstance();
    }
}
