package com.example.mbti_roommate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//하단바에서 "매칭" 탭을 누르면 나오는 화면 클래스

public class Match extends AppCompatActivity {

    Button goSeeMatchResultButton;
    Button goWriteNewProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.nav_match);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_match:
                        return true;
                }
                return false;
            }
        });



    }
    public void matchButtonClick(View v){               //매칭하기 버튼 클릭 시 호출 함수
          User appuser = User.getInstance();
          sendRequest(
               appuser.info.getId(),
               appuser.info.getPassword(),
               appuser.info.getPname(),
               String.valueOf(appuser.info.getPgender()),
               String.valueOf(appuser.info.getPmbti()),
               String.valueOf(appuser.info.getPdormitory()),
               String.valueOf(appuser.info.getUniv()),
               appuser.info.getEmail(),
                  String.valueOf(appuser.info.getPsmoke()),
                  appuser.info.getPcomment(),
                  String.valueOf(appuser.info.getPage()),
                  appuser.info.getPcontact(),
                  String.valueOf(appuser.info.getPstime()),
                  String.valueOf(appuser.info.getPshour())
          );




//        Intent intent = new Intent(getApplicationContext(), MatchResult.class);
//        ArrayList<UserInfo> uInfos = new ArrayList<UserInfo>();
//        uInfos.add(new UserInfo("guest2","password","이종제",
//                1,12,11110001,1111,
//                "kkk1111@knu.ac.kr",0,"Hello!",25,
//                "전화번호",12,6,0,0,null));
//        uInfos.add(new UserInfo("guest3","password","김수현",1,5,11110001,1111,
//                "ijk2020@knu.ac.kr",1,"hi!",25,
//                "삐삐번호",10,7,0,0,null));
//
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("UserInfos",uInfos);
//        intent.putExtras(bundle);
//        startActivity(intent);
    }

    public void openSavedMatchResults(View v){          //이전 매칭 결과 불러오기 클릭 시 호출 함수

            //이것도 따로 구현 필요
    }

    public void sendRequest(final String id, final String password, final String pname, final String pgender, final String pmbti, final String pdormitory, final String univ, final String email,
                            final String psmoke, final String pcomment, final String page, final String pcontact, final String pstime, final String pshour){
        RequestQueue requestQueue = Volley.newRequestQueue(Match.this);
        String url = urlManager.newMatchURL;
        Log.e("url",url);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    try {
                        JSONObject jsonObj = new JSONObject(response);
                        boolean isSuccessed = jsonObj.getBoolean("success");
                        Log.e("Success",String.valueOf(isSuccessed));
                        if(isSuccessed) {
                            Intent intent = new Intent(getApplicationContext(), MatchResult.class);
                            ArrayList<UserInfo> uInfos = new ArrayList<UserInfo>();
                            JSONArray UserObjs = jsonObj.getJSONArray("Users");
                            try {
                                for(int i =0;i<UserObjs.length();++i) {
                                    JSONObject userObj = UserObjs.getJSONObject(i);
                                    userObj.getString("id");
                                    uInfos.add(new UserInfo(
                                            userObj.getString("id"),
                                            userObj.getString("password"),
                                            userObj.getString("pname"),
                                            userObj.getInt("pgender"),
                                            userObj.getInt("pmbti"),
                                            userObj.getInt("pdormitory"),
                                            userObj.getInt("univ"),
                                            userObj.getString("email"),
                                            userObj.getInt("psmoke"),
                                            userObj.getString("pcomment"),
                                            userObj.getInt("page"),
                                            userObj.getString("pcontact"),
                                            userObj.getInt("pstime"),
                                            userObj.getInt("pshour"),
                                            userObj.getInt("hasMatchBefore"),
                                            userObj.getInt("isMatched"),
                                            null));
                                }
                            }catch (JSONException e){
                                e.printStackTrace();
                            }


                            Bundle bundle = new Bundle();
                            bundle.putSerializable("UserInfos",uInfos);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                        else{
                            Toast info = Toast.makeText(getApplicationContext(),jsonObj.getString("reason"),Toast.LENGTH_LONG);
                            info.show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error",error.toString());
            }
        }){
            @Override
            protected Map<String,String> getParams() {
                Map<String,String> params = new HashMap<String,String>();
                params.put("id",id);
                params.put("password",password);
                params.put("pname", pname);
                params.put("pgender", pgender);
                params.put("pmbti", pmbti);
                params.put("pdormitory", pdormitory);
                params.put("univ", univ);
                params.put("email", email);
                params.put("psmoke", psmoke);
                params.put("pcomment", pcomment);
                params.put("page", page);
                params.put("pcontact", pcontact);
                params.put("pstime", pstime);
                params.put("pshour", pshour);
                return params;
            }
            @Override
            public  Map<String,String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("Context-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}