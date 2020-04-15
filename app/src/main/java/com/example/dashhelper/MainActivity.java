package com.example.dashhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView work,holiday,timetable,community;
    private Button login,logout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        work = (CardView)findViewById(R.id.crdId1);
        work.setOnClickListener(this);

        }

    @Override
    public void onClick(View view) {
        intent i;

        Switch(view.getId()){
            case R.id.crdId1 : i=new Intent(this,workouthome.class);startActivity(i);break;

            default:break;
        }
    }


}
