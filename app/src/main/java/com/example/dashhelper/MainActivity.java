package com.example.dashhelper;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView work,holiday,timetable,community;
    private Button login,logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        work=(CardView)findViewById(R.id.cardId1);
        holiday=(CardView)findViewById(R.id.cardId2);
        timetable=(CardView)findViewById(R.id.cardId3);
        community=(CardView)findViewById(R.id.cardId4);
        login=(Button)findViewById(R.id.button3);
        logout=(Button)findViewById(R.id.button18);
        work.setOnClickListener(this);
        holiday.setOnClickListener(this);
        timetable.setOnClickListener(this);
        community.setOnClickListener(this);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId())
        {



            case R.id.cardId4 : i=new Intent(this,community.class);startActivity(i);break;
            case R.id.button3 : i=new Intent(this,login.class);startActivity(i);break;
             case R.id.cardId1 : i=new Intent(this,workouthome.class);startActivity(i);break;
            case R.id.cardId3 : i=new Intent(this,timetable.class);startActivity(i);break;



        }

    }

}
