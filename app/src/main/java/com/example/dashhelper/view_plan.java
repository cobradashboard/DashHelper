package com.example.dashhelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class view_plan extends AppCompatActivity {

    DatabaseReference dbRefV;
    ListView listView;
    ArrayList<add_planA> arrayList = new ArrayList<>();
    ArrayAdapter<add_planA> arrayAdapter;
    Button btnDelete;
    wdelplan wDelPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plan);

        dbRefV = FirebaseDatabase.getInstance().getReference().child("plan");

        listView = (ListView) findViewById(R.id.listviewtxt);
        btnDelete = (Button)findViewById(R.id.btnDelete);

        wDelPlan=((wdelplan)getApplicationContext());

        arrayAdapter = new ArrayAdapter<add_planA>(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        dbRefV.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for ( DataSnapshot postSnapshot: dataSnapshot.getChildren() ) {
                    add_planA add_p = postSnapshot.getValue(add_planA.class);
                    arrayList.add(add_p);

                }
                arrayAdapter.notifyDataSetChanged();
                Log.d("get","Get files");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String str = wDelPlan.getGvalue_workoutName().substring(0,8);
                if (str.equals("")){
                    Toast.makeText(view_plan.this,"Please Select Item before Delete..!",Toast.LENGTH_SHORT).show();
                }else {
                    dbRefV.child("Workout").child(str).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            dbRefV.child(str).removeValue();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(view_plan.this,"Workout is Deleted..!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),view_plan.class);
                    startActivity(intent);
                }
            }
        });


    }
}
