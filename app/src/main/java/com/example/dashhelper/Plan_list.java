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

public class Plan_list extends ArrayAdapter {
    private Activity context;
    private List<add_planA> list;

    public Plan_list(Activity context, List<add_planA> list){
        super(context,R.layout.list_temp,list);

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.list_temp, null, true);

        TextView textView_plan = (TextView) listView.findViewById(R.id.id_plan);

        add_planA plan = list.get(position);

        textView_plan.setText(plan.toString());

        return listView;
    }
}
