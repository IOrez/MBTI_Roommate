package com.example.mbti_roommate;

public class UserInfo extends Singleton{

    public String id;
    public String password;
    public String pname;
    public int pgender;
    public int pmbti;
    public int pdormitory;
    public int univ;
    public String email;
    public int psmoke;
    public String pcomment;
    public int page;
    public String pcontact;
    public int pstime;
    public int pshour;
    public int hasMatchBefore;

    public static Singleton getInstance(){
        return instance;
    }
}
