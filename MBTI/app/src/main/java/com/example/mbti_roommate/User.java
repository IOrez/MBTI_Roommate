package com.example.mbti_roommate;

public class User extends UserInfo {

    public static Singleton getInstance() {
        if(instance==null)
            instance = new User();
        return instance;
    }
}
