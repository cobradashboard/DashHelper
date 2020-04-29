package com.example.dashhelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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


//        wDelPlan=((wdelplan)getApplicationContext());

        dbRefV.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for ( DataSnapshot postSnapshot: dataSnapshot.getChildren() ) {
                    add_planA add_p = postSnapshot.getValue(add_planA.class);
                    arrayList.add(add_p);
                }
                Plan_list planList = new Plan_list(view_plan.this,arrayList);
                listView.setAdapter(planList);
                Log.d("get","Get files");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                add_planA plan = arrayList.get(position);
                showUpdate(plan);
            }
        });
    }

    private void showUpdate(final add_planA plan) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.activity_update_plan,null);

        builder.setView(view);

        final EditText edit_title = view.findViewById(R.id.edit_title);
        final EditText edit_distance = view.findViewById(R.id.edit_diatance);
        final EditText edit_start = view.findViewById(R.id.edit_start);
        final EditText edit_end = view.findViewById(R.id.edit_end);
        Button update = view.findViewById(R.id.update);

        edit_title.setText(plan.getWorkoutName());
//        edit_distance.setText(plan.getDistance());
        edit_start.setText(plan.getStartingTime());
        edit_end.setText(plan.getEndingTime());


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = edit_title.getText().toString();
                String start = edit_start.getText().toString();
                String end = edit_end.getText().toString();
                String distance = edit_distance.getText().toString();

                int dis =Integer.parseInt(distance);

                add_planA newPlan = new add_planA(title,start,end,dis);

                DatabaseReference updateDB =  FirebaseDatabase.getInstance().getReference().child(plan.getID());

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
