package com.example.mbti_roommate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    String contactInfo;                             //상대 연락처 변수 (오픈 카톡 링크, 전화번호, 이메일 등이 가능

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
        matchResultUserLifeStyle = (EditText)findViewById(R.id.match_result_user_selfIntroduction);
        viewUserContactInfoButton = (Button)findViewById(R.id.view_user_contact_info_button);

        viewUserContactInfoButton.setOnClickListener(new View.OnClickListener(){    //연락처 열람 버튼 클릭 시 pop-up 이 뜰 수 있게 설정
            @Override
            public void onClick(View view) {
                openContactInfo();
            }
        });

    }

    public void openContactInfo(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(" 연락처 정보"); alertDialogBuilder.setMessage(contactInfo);         //contactInfo 가 실제 연락처 정보
        alertDialogBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(IndividualProfileResult.this, "프로필 열람을 완료하였습니다.",
                                Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}


