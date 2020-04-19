package com.example.dashhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class walking extends AppCompatActivity  implements View.OnClickListener {

    private CardView add,view,done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);

        //assign variables
        add = (CardView) findViewById(R.id.cardId5);
        view = (CardView) findViewById(R.id.cardId6);
        done = (CardView) findViewById(R.id.cardId7);

        //define onClicklistner method to each page
        add.setOnClickListener(this);
        view.setOnClickListener(this);
        done.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent02;

        switch (view.getId()){
            case R.id.cardId5: intent02 = new Intent(this,add_plan.class);
                startActivity(intent02);
                break;
            case R.id.cardId6: intent02 = new Intent(this,view_plan.class);
                startActivity(intent02);
                break;
            case R.id.cardId7: intent02 = new Intent(this,donned_workouts.class);
                startActivity(intent02);
                break;
            default:                  break;
        }

    }
}
