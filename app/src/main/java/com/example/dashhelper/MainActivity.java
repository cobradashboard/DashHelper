package com.example.dashhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener {


    private CardView work,holiday,timetable,community;
    private Button login,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        work=(CardView)findViewById(R.id.cardId1);

        work.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId())
        {
            case R.id.cardId1 : i=new Intent(this,workouthome.class);startActivity(i);break;




        }

    }


}
