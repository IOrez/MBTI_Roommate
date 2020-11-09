package com.example.mbti_roommate;

public abstract class Singleton  {

    protected static Singleton instance;
    public static Singleton getInstance(){
        return instance;
    }
}
