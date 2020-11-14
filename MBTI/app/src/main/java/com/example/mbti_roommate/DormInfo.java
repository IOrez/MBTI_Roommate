package com.example.mbti_roommate;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DormInfo {
    private static JSONObject univObject = new JSONObject();
    private static JSONObject dormObject = new JSONObject();
    private DormInfo(){};
    private static DormInfo instance;
    private static void initUnivObjs(){
        try{
            univObject.put("1111","경북대학교(대구캠퍼스)");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private static void initDormObjs(){
        try{
            dormObject.put("11110001","첨성관");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    private static void init(){
        initUnivObjs();
        initDormObjs();
    }

    public static DormInfo getInstance(){
        if(instance==null){
            instance = new DormInfo();
            instance.init();
        }
        return instance;
    }

    public static JSONObject getUnivObjects() {
        return univObject;
    }

    public static JSONObject getDormObjects() {
        return dormObject;
    }
}
