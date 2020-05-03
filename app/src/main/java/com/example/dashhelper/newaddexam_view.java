package com.example.dashhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class newaddexam_view extends AppCompatActivity {

    ListView listOfExam;
    List<newaddexammodel> examList;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaddexam_view);

        reference = FirebaseDatabase.getInstance().getReference("Exam");
        listOfExam = findViewById(R.id.lv2);
        examList = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot :  dataSnapshot.getChildren()){
                    newaddexammodel model = snapshot.getValue(newaddexammodel.class);
                    examList.add(model);
                }
                exam_list list = new exam_list(newaddexam_view.this,examList);
                listOfExam.setAdapter(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listOfExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                newaddexammodel newaddexammodel = examList.get(position);

                Intent intent = new Intent(newaddexam_view.this,showExameDetails.class);
                intent.putExtra("OBJECT", newaddexammodel);

                startActivity(intent);
            }
        });
    }
}
