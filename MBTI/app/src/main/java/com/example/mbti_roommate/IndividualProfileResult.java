package com.example.mbti_roommate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;

public class IndividualProfileResult extends AppCompatActivity {


    ImageView matchResultUserMBTIImage;             //상대 MBTI 이미지
    TextView matchResultUsername;                   //상대 유저 이름
    TextView matchResultUserMBTI;                   //상대 MBTI 유형
    TextView mbtiMatchExplanationResult;            //상대와의 궁합 설명
    TextView matchResultUserAge;                    //상대 나이
    TextView matchResultUserMajor;                  //상대 학과
    TextView matchResultUserSmoke;                  //상대 흡연 유무
    EditText matchResultUserLifeStyle;              //상대 라이프스타일 설명
    Button viewUserContactInfoButton;               //상대 연락처 열람하기 버튼임

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_profile_result);

        //레이아웃 구성 위젯 연결 및 초기화 단계
        matchResultUserMBTIImage = (ImageView)findViewById(R.id.match_result_user_mbti_image);
        matchResultUsername = (TextView)findViewById(R.id.match_result_username);
        matchResultUserMBTI = (TextView)findViewById(R.id.match_result_user_mbti);
        mbtiMatchExplanationResult = (TextView)findViewById(R.id.mbti_match_explanation_result);
        matchResultUserAge = (TextView)findViewById(R.id.match_result_user_age);
        matchResultUserMajor = (TextView)findViewById(R.id.match_result_user_major);
        matchResultUserSmoke = (TextView)findViewById(R.id.match_result_user_smoke);
        matchResultUserLifeStyle = (EditText)findViewById(R.id.match_result_user_lifestyle);
        viewUserContactInfoButton = (Button)findViewById(R.id.view_user_contact_info_button);







    }

}


