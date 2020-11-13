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


//매칭된 3명을 나타내는 클래스

public class MatchResult extends AppCompatActivity {

    Button rematchButton;           //재매칭하기 버튼

    ListView listView;
    String user_name[]= {"이종훈","이종제","권모씨"};
    String mbti_name[]={"INFJ","ENFJ","INFP"};
    String isSmoke[]={"NO","NO","YES"};
    int images[]={R.drawable.mbti_isfj,R.drawable.mbti_enfj,R.drawable.mbti_infp};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_result);



        listView = findViewById(R.id.profilelistView);
        CAdapter adapter = new CAdapter(this,user_name,mbti_name,images,isSmoke);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(getApplicationContext(), IndividualProfileResult.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(getApplicationContext(), IndividualProfileResult.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(getApplicationContext(), IndividualProfileResult.class);
                    startActivity(intent);
                }
            }
        });

        rematchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //재매칭하기 버튼을 클릭했을 때 다시 매칭 알고리즘이 돌아가도록 구현해야함

            }
        });

    }

    class CAdapter extends ArrayAdapter<String>{
        Context context;
        String r_user_name[];
        String r_mbit_name[];
        int r_image[];
        String r_isSmoke[];

        CAdapter(Context c,String user_name[],String mbti[],int imgs[],String isSmoke[]){
            super(c,R.layout.profile_default_info,R.id.user_name,user_name);
            this.context = c;
            this.r_user_name = user_name;
            this.r_mbit_name = mbti;
            this.r_image = imgs;
            this.r_isSmoke = isSmoke;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.profile_default_info,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView user_name = row.findViewById(R.id.user_name);
            TextView mbti_name = row.findViewById(R.id.mbti_name);
            TextView isSmoke = row.findViewById(R.id.isSmoke);

            images.setImageResource(r_image[position]);
            user_name.setText(r_user_name[position]);
            mbti_name.setText(r_mbit_name[position]);
            isSmoke.setText(r_isSmoke[position]);

            return row;
        }
    }
}
