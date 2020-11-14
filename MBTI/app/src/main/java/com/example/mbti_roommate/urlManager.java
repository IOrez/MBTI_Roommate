package com.example.mbti_roommate;

public class urlManager {
    static String targetURL = new String("http://15.164.217.53:5000");
    //static String targetURL = new String("http://192.168.56.1:5000");
    static String loginURL = new String(targetURL+"/User/Login");
    static String registerURL = new String(targetURL+"/User/Register");
    static String newMatchURL = new String(targetURL+"/User/NewMatch");
    static String prevMatchURL = new String(targetURL+"/User/PrevMatch");
}
