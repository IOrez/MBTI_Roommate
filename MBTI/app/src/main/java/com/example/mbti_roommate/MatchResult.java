package com.example.mbti_roommate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


//매칭된 3명을 나타내는 클래스

public class MatchResult extends AppCompatActivity {

    ImageView firstMatch;
    ImageView secondMatch;
    ImageView thirdMatch;
    Button rematchButton;           //재매칭하기 버튼

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_result);

        firstMatch = (ImageView)findViewById(R.id.first_rank_mbti_image);
        secondMatch = (ImageView)findViewById(R.id.second_rank_mbti_image);
        thirdMatch = (ImageView)findViewById(R.id.third_rank_mbti_image);


        //매칭된 3명 중 어느 하나를 클릭해도 무조건 IndividualProfileResult로 가는데, 이때 어떤 상대의 프로필을 열람
        //해야하는지 데이터를 넘겨줘야할듯

        firstMatch.setOnClickListener(new View.OnClickListener(){       //첫 번째 매칭 상대 클릭 시

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IndividualProfileResult.class);
                startActivity(intent);
            }
        });

        secondMatch.setOnClickListener(new View.OnClickListener(){      //두 번째 매칭 상대 클릭 시

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IndividualProfileResult.class);
                startActivity(intent);
            }
        });

        thirdMatch.setOnClickListener(new View.OnClickListener(){       //세 번째 매칭 상대 클릭 시

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IndividualProfileResult.class);
                startActivity(intent);
            }
        });

        /*
        rematchButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                //재매칭하기 버튼을 클릭했을 때 다시 매칭 알고리즘이 돌아가도록 구현해야함

            }
        });
        */
    }
}
