package com.example.dashhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class workouthome extends AppCompatActivity implements View.OnClickListener {

    private CardView walk,run,cycle,swim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouthome);

        //assign variables
        walk = (CardView) findViewById(R.id.walk);
        run = (CardView) findViewById(R.id.run);
        cycle = (CardView) findViewById(R.id.cycle);
        swim = (CardView) findViewById(R.id.swim);

        //define clicklistner method to each page
        run.setOnClickListener(this);
        walk.setOnClickListener(this);
        cycle.setOnClickListener(this);
        swim.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent01;

        switch (view.getId()){
            case R.id.walk: intent01 = new Intent(this,walking.class);
                startActivity(intent01);
                break;
            case R.id.run: intent01 = new Intent(this,running.class);
                startActivity(intent01);
                break;
            case R.id.cycle: intent01 = new Intent(this,cycling.class);
                startActivity(intent01);
                break;
            case R.id.swim: intent01 = new Intent(this,swimming.class);
                startActivity(intent01);
                break;
            default:    break;
        }

    }
}
