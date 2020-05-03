package com.example.dashhelper;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class showExameDetails extends AppCompatActivity {
    EditText editText_place;
    EditText editText_exam;
    EditText editText_subject;
    EditText editText_date;
    EditText editText_time;

    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;

    Calendar cal1;
    DatePickerDialog DPD1;
    Button button_update;
    Button button_delete;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_exame_details);

        Intent getIntent = getIntent();
        newaddexammodel model = (newaddexammodel) getIntent.getSerializableExtra("OBJECT");

        final String ID = model.getID();

        reference = FirebaseDatabase.getInstance().getReference("Exam").child(ID);

        editText_exam = findViewById(R.id.edit_exam);
        editText_subject = findViewById(R.id.edit_subject2);
        editText_place = findViewById(R.id.edit_place2);
        editText_date = findViewById(R.id.edit_date2);
        editText_time = findViewById(R.id.edit_time2);

        button_delete = findViewById(R.id.delete2);
        button_update = findViewById(R.id.update2);


        editText_date.setText(model.getDate());
        editText_place.setText(model.getPlace());
        editText_subject.setText(model.getSubject());
        editText_exam.setText(model.getExam());

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.removeValue();
                Toast.makeText(showExameDetails.this,"Deleted Successfully",Toast.LENGTH_LONG).show();
            }
        });

        editText_time.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(showExameDetails.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if(hourOfDay >= 12){
                            hourOfDay =  hourOfDay - 12;
                            amPm = "PM";
                        }else {
                            amPm = "AM";
                        }
                        editText_time.setText(String.format("%02d:%02d",hourOfDay,minutes) + amPm);
                    }
                },currentHour,currentMinute,true);
                timePickerDialog.show();
            }

        });
        editText_date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                cal1 = Calendar.getInstance();
                int day = cal1.get(Calendar.DAY_OF_MONTH);
                int month = cal1.get(Calendar.MONTH);
                int year = cal1.get(Calendar.YEAR);
                DPD1 = new DatePickerDialog(showExameDetails.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        editText_date.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
                    }
                }, day, month, year);
                DPD1.show();
            }
        });

        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = editText_date.getText().toString();
                String exam = editText_exam.getText().toString();
                String place = editText_place.getText().toString();
                String subject = editText_subject.getText().toString();

                if(date.isEmpty() || exam.isEmpty() || place.isEmpty() || subject.isEmpty()){
                    Toast.makeText(showExameDetails.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                }else{

                    newaddexammodel newaddexammodel = new newaddexammodel(exam,subject,place,date,ID);

                    reference.setValue(newaddexammodel);
                    Toast.makeText(showExameDetails.this,"Data updated Successfully",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}
