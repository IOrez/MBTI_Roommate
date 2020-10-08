package com.example.mbti_roommate;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.function.IntUnaryOperator;

public class InitialMatchPageFragment extends Fragment{

    Button goWriteNewProfileButton;
    Button goSeeMatchResultButton;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InitialMatchPageFragment() {
    }
/*
    // TODO: Rename and change types and number of parameters
    public static InitialMatchPageFragment newInstance(String param1, String param2) {
        InitialMatchPageFragment fragment = new InitialMatchPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_initial_match_page, container, false);

        goSeeMatchResultButton = (Button)v.findViewById(R.id.go_see_match_result_button);
        goSeeMatchResultButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),MatchResult.class);
                ((MainActivity)getActivity()).startActivity(in);
            }
        });

        return v;
    }


}
