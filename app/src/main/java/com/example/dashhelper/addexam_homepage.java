package com.example.dashhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class    addexam_homepage extends AppCompatActivity implements View.OnClickListener {
    private CardView add, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addexam_homepage);

        add = (CardView) findViewById(R.id.cardid001AE);
        view = (CardView) findViewById(R.id.cardid002AE);
        add.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intentp;

        switch (view.getId()) {
            case R.id.cardid001AE:
                intentp = new Intent(this,addexam_page.class);
                startActivity(intentp);
                break;
            case R.id.cardid002AE:
                intentp = new Intent(this,newaddexam_view.class);
                startActivity(intentp);
                break;
            default:break;
        }
    }
}