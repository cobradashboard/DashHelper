package com.example.dashhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class showCourseDetails extends AppCompatActivity {

    EditText editText_place;
    EditText editText_time;
    EditText editText_teacher;
    EditText editText_subject;
    EditText editText_date;

    Button button_update;
    Button button_delete;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_course_details);

        Intent getIntent = getIntent();
        addcoursemodel model = (addcoursemodel) getIntent.getSerializableExtra("OBJECT");

        final String ID = model.getID();

        reference = FirebaseDatabase.getInstance().getReference("TimeTable").child(ID);

        editText_time = findViewById(R.id.edit_time);
        editText_teacher = findViewById(R.id.edit_teacher);
        editText_subject = findViewById(R.id.edit_subject);
        editText_place = findViewById(R.id.edit_place);
        editText_date = findViewById(R.id.edit_date);

        button_delete = findViewById(R.id.delete);
        button_update = findViewById(R.id.update);


        editText_date.setText(model.getDate());
        editText_place.setText(model.getPlace());
        editText_subject.setText(model.getSubject());
        editText_teacher.setText(model.getTeacher());
        editText_time.setText(model.getTime());

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.removeValue();
                Toast.makeText(showCourseDetails.this,"Deleted Successfully",Toast.LENGTH_LONG).show();
            }
        });

        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = editText_date.getText().toString();
                String time = editText_time.getText().toString();
                String place = editText_place.getText().toString();
                String teacher = editText_teacher.getText().toString();
                String subject = editText_subject.getText().toString();

                if(date.isEmpty() || time.isEmpty() || place.isEmpty() || teacher.isEmpty() || subject.isEmpty()){
                    Toast.makeText(showCourseDetails.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                }else{

                    addcoursemodel addcoursemodel = new addcoursemodel(subject,teacher,place,time,date,ID);

                    reference.setValue(addcoursemodel);
                    Toast.makeText(getApplicationContext(),"Data updated Successfully",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
