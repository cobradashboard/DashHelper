package com.example.dashhelper;


import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class add_plan extends AppCompatActivity implements View.OnClickListener {


    EditText txtworkout,txtstrtm,txtendtm,txtdist;
    Button btnadd,btnclr,add,start,end;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;

    DatabaseReference dbRefw;
    add_planA aPA;

    private void clearControls(){
        txtworkout.setText("");
        txtstrtm.setText("");
        txtendtm.setText("");
        txtdist.setText("");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        txtworkout = findViewById(R.id.edit_title);
        txtstrtm =  findViewById(R.id.edit_start);
        txtendtm = findViewById(R.id.edit_end);
        txtdist = findViewById(R.id.edit_diatance);


        btnadd = findViewById(R.id.update);
        btnclr = findViewById(R.id.btnclrA);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);

        aPA = new add_planA();

        // define variables
        add = (Button) findViewById(R.id.update);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(add_plan.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if(hourOfDay >= 12){
                            hourOfDay =  hourOfDay - 12;
                            amPm = "PM";
                        }else {
                            amPm = "AM";
                        }
                        txtstrtm.setText(String.format("%02d:%02d",hourOfDay,minutes) + amPm);
                        aPA.setStartingTime(String.format("%02d:%02d",hourOfDay,minutes) + amPm);
                    }
                },currentHour,currentMinute,true);
                timePickerDialog.show();
            }

        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(add_plan.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12){
                            hourOfDay = hourOfDay - 12;
                            amPm = "PM";
                        }else {
                            amPm = "AM";
                        }
                        txtendtm.setText(String.format("%02d:%02d",hourOfDay,minutes) + amPm);
                        aPA.setEndingTime(String.format("%02d:%02d",hourOfDay,minutes) + amPm);
                    }
                },currentHour,currentMinute,true);
                timePickerDialog.show();
            }
        });

        //define onClickListner method for each page
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRefw = FirebaseDatabase.getInstance().getReference("plan");

                aPA.setDistance(Integer.parseInt(txtdist.getText().toString()));
                aPA.setWorkoutName(txtworkout.getText().toString());

                String ID = dbRefw.push().getKey();

                aPA.setID(ID);

                dbRefw.child(ID).setValue(aPA);
                Toast.makeText(add_plan.this,"New Plan Added",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(add_plan.this,workouthome.class);
                startActivity(intent);
                Log.d("added","data aded");
            }

        });


        // Add workout plan clear btn toast message
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = txtworkout.getText().toString();
                String text2 = txtstrtm.getText().toString();
                String text3 = txtendtm.getText().toString();
                String text4 = txtdist.getText().toString();
                if (text1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Workout Name is Empty...!", Toast.LENGTH_SHORT).show();
                    if (text2.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Starting Time is Empty...!", Toast.LENGTH_SHORT).show();
                        if (text3.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Ending Time is Empty...!", Toast.LENGTH_SHORT).show();
                            if (text4.isEmpty()) {
                                Toast.makeText(getApplicationContext(), "Distance is Empty...!", Toast.LENGTH_SHORT).show();
                            } else {
                                txtdist.setText("");
                            }
                        } else {
                            txtendtm.setText("");
                        }
                    } else {
                        txtstrtm.setText("");
                    }
                } else {
                    txtworkout.setText("");
                }
//                if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty() || text4.isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "Workout Name is Empty...!", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getApplicationContext(), "Starting Time is Empty...!", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getApplicationContext(), "Ending Time is Empty...!", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getApplicationContext(), "Distance is Empty...!", Toast.LENGTH_SHORT).show();
//
//                } else {
//                    txtdist.setText("");
//                    txtendtm.setText("");
//                    txtstrtm.setText("");
//                    txtworkout.setText("");
//
//                }
            }


        });




    }




    @Override
    public void onClick(View view) {
        Intent intent06;

        switch (view.getId()){
            case R.id.cardId5: intent06 = new Intent(this,view_plan.class);
                startActivity(intent06);
                break;
            default:break;
        }



        dbRefw = FirebaseDatabase.getInstance().getReference().child("Workout");


        try {
            if (TextUtils.isEmpty(txtworkout.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtstrtm.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a Starting Time", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtendtm.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a Ending Time", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtdist.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a Distance", Toast.LENGTH_SHORT).show();
            else {
                aPA.setWorkoutName(txtworkout.getText().toString().trim());
                aPA.setStartingTime(txtstrtm.getText().toString().trim());
                aPA.setEndingTime(txtendtm.getText().toString().trim());
                aPA.setDistance(Integer.parseInt(txtdist.getText().toString().trim()));
//                    dbRefw.push().setValue(aPA);
                dbRefw.child(txtworkout.getText().toString()).setValue(aPA);

                Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                clearControls();
            }

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid Data Inserted", Toast.LENGTH_SHORT).show();
        }
    }
}
