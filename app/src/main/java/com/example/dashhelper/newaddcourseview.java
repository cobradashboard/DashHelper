package com.example.dashhelper;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class newaddcourseview extends AppCompatActivity {
    DatabaseReference dbRefV;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    Button btndeleteAC;
    wdelplan delttb;

    List<addcoursemodel> listOfmodels;
    //private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaddcourseview);
        dbRefV = FirebaseDatabase.getInstance().getReference("TimeTable");
        listView = (ListView) findViewById(R.id.lv1);
        btndeleteAC = (Button)findViewById(R.id.btndeleteAC);


        listOfmodels = new ArrayList<>();
//        delttb = (wdelplan)getApplicationContext();


        dbRefV.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                addcoursemodel model = new addcoursemodel();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    model = snapshot.getValue(addcoursemodel.class);
                    listOfmodels.add(model);
                }

                course_list course_list = new course_list(newaddcourseview.this,listOfmodels);
                listView.setAdapter(course_list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                addcoursemodel  addcoursemodel = listOfmodels.get(position);

                Intent intent = new Intent(newaddcourseview.this,showCourseDetails.class);
                intent.putExtra("OBJECT", addcoursemodel);

                startActivity(intent);

            }
        });
//        btndeleteAC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                final String ttb = delttb.getGval_subject().substring(0,3);
//                if (ttb==""){
//                    Toast.makeText(newaddcourseview.this,"Please Select Item before Delete..!",Toast.LENGTH_SHORT).show();
//                }else {
//                    dbRefV.child("TimeTable").child(ttb).addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            dbRefV.child(ttb).removeValue();
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                        }
//                    });
//                    Toast.makeText(newaddcourseview.this,"Course is Deleted..!",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(),newaddcourseview.class);
//                    startActivity(intent);
//                }
//            }
//        });
    }

}
