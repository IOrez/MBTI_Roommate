package com.example.mbti_roommate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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
                    case R.id.nav_more:
                        startActivity(new Intent(getApplicationContext(), More.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });

        //goSeeMatchResultButton = (Button)findViewById(R.id.go_see_match_result_button);
        //goSeeMatchResultButton.setOnClickListener(new View.OnClickListener(){

    }
    public void buttonClick(View v){
        Intent intent = new Intent(getApplicationContext(), MatchResult.class);
        startActivity(intent);
    }
}