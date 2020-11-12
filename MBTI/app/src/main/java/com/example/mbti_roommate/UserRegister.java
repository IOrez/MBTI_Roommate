package com.example.mbti_roommate;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;


//회원가입 클래스

public class UserRegister extends AppCompatActivity {

    Spinner mbti_spinner;
    Spinner age_spinner;
    Spinner email_spinner;
    Spinner dorm_spinner;
    Spinner univ_spinner;
    Spinner PMAM_spinner;
    Spinner psTime_spinner;
    Spinner psHour_spinner;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mbti_spinner = findViewById(R.id.MBTI_spinner);
        age_spinner = findViewById(R.id.age_spinner);
        email_spinner = findViewById(R.id.email_spinner);
        dorm_spinner = findViewById(R.id.dorm_spinner);
        univ_spinner = findViewById(R.id.univ_spinner);
        PMAM_spinner = findViewById(R.id.PMAM_spinner);
        psTime_spinner = findViewById(R.id.psTime_spinner);
        psHour_spinner = findViewById(R.id.psHour_spinner);


        ArrayAdapter mbtiAdapter = ArrayAdapter.createFromResource
                (this, R.array.mbti_array, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter ageAdapter = ArrayAdapter.createFromResource
                (this, R.array.age_array, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter emailAdapter = ArrayAdapter.createFromResource
                (this, R.array.email_array, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter dormAdapter = ArrayAdapter.createFromResource
                (this, R.array.dorm_array, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter univAdapter = ArrayAdapter.createFromResource
                (this, R.array.univ_array, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter PMAMAdapter = ArrayAdapter.createFromResource
                (this, R.array.PMAM_array, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter psTimeAdapter = ArrayAdapter.createFromResource
                (this, R.array.pstime_array, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter psHourAdapter = ArrayAdapter.createFromResource
                (this, R.array.pshour_array, android.R.layout.simple_spinner_dropdown_item);

        mbtiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mbti_spinner.setAdapter(mbtiAdapter);

        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        age_spinner.setAdapter(ageAdapter);

        emailAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        email_spinner.setAdapter(emailAdapter);

        dormAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dorm_spinner.setAdapter(dormAdapter);

        univAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        univ_spinner.setAdapter(univAdapter);

        PMAMAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PMAM_spinner.setAdapter(PMAMAdapter);

        psTimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        psTime_spinner.setAdapter(psTimeAdapter);

        psHourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        psHour_spinner.setAdapter(psHourAdapter);





    }



}
