package com.example.dashhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class view_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);
    }
    public  void study (View view){
        Intent studyintent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("http://study.sliit.lk/"));
        startActivity(studyintent);
    }
}
