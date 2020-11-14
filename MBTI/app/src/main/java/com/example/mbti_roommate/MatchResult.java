package com.example.mbti_roommate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;


//매칭된 3명을 나타내는 클래스

public class MatchResult extends AppCompatActivity {

    Button rematchButton;           //재매칭하기 버튼

    ListView listView;
    ListViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_result);

        Intent intent = getIntent();
        Bundle bundleObject = getIntent().getExtras();
        ArrayList<UserInfo> uInfos = (ArrayList<UserInfo>)bundleObject.getSerializable("UserInfos");
        adapter = new ListViewAdapter();
        listView = findViewById(R.id.profilelistView);
        rematchButton = findViewById(R.id.rematch_btn);
        listView.setAdapter(adapter);
        for(int i=0;i<uInfos.size();++i){
            adapter.addItem(uInfos.get(i));
        }
//        adapter.addItem(new UserInfo("guest2","password","이종제",1,12,11110001,1111,"kkk1111@knu.ac.kr",0,"Hello!",25,"전화번호",12,6,0,0,null));
//        adapter.addItem(new UserInfo("guest3","password","김수현",1,5,11110001,1111,"ijk2020@knu.ac.kr",1,"hi!",25,"삐삐번호",10,7,0,0,null));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserInfo userInfo = (UserInfo)parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), IndividualProfileResult.class);
                intent.putExtra("UserInfo",userInfo);
                startActivity(intent);
            }
        });

        rematchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //재매칭하기 버튼을 클릭했을 때 다시 매칭 알고리즘이 돌아가도록 구현해야함

            }
        });

    }


}
