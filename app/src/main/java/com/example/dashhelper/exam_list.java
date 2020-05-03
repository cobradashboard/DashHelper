package com.example.dashhelper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class exam_list extends ArrayAdapter {

    private Activity context;
    private List<newaddexammodel> list;



    public exam_list(@NonNull Activity context, List<newaddexammodel> list) {
        super(context, R.layout.list_model, list);

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listView = inflater.inflate(R.layout.list_model,null,true);


        TextView date = (TextView) listView.findViewById(R.id.id_date);
        TextView exam = (TextView) listView.findViewById(R.id.id_time);
        TextView subject = (TextView) listView.findViewById(R.id.id_subject);
        TextView place = (TextView) listView.findViewById(R.id.id_place);

        newaddexammodel model = list.get(position);

        date.setText(model.getDate());
        place.setText(model.getPlace());
        exam.setText(model.getExam());
        subject.setText(model.getSubject());

        return listView;
    }
}
