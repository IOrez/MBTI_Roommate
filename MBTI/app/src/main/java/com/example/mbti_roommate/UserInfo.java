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
    public boolean psmoke;
    public String pcomment;
    public int page;
    public String pcontact;
    public int pstime;
    public int pshour;

    public static Singleton getInstance() {
        if(instance == null){
            Singleton.instance = new UserInfo();
        }
        return instance;
    }
}
