package com.example.dashelper;


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


public class Holiday_UI3 extends AppCompatActivity {
    DatabaseReference databaseReference;
    ListView listView;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    Button btndel;
    Holi_Del holi_del;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_ui3);

        databaseReference=FirebaseDatabase.getInstance().getReference("HolidayData");
        listView=(ListView)findViewById(R.id.holidaylistview);
        btndel=(Button)findViewById(R.id.btndel);
        holi_del=((Holi_Del)getApplicationContext());
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String Value =dataSnapshot.getValue(HolidayData.class).toString();
                arrayList.add(Value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               holi_del.setGvalue_Hname(arrayList.get(position));
               holi_del.setGvalue_Hname(arrayList.get(position));
           }
       });
       btndel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String str=holi_del.getGvalue_Hname();
               if(str==""){
                   Toast.makeText(Holiday_UI3.this,"Please select item to delete",Toast.LENGTH_LONG).show();
               }else{
                   databaseReference.child("HolidayData").child(str).addListenerForSingleValueEvent(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                           databaseReference.child(str).removeValue();
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError databaseError) {

                       }
                   });
                   Toast.makeText(Holiday_UI3.this,"Record is deleted",Toast.LENGTH_LONG).show();
                   Intent intent=new Intent(getApplicationContext(),Holiday_UI3.class);
                   startActivity(intent);
               }
           }
       });
    }


}
//