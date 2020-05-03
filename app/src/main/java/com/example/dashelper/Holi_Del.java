package com.example.dashelper;

import android.app.Application;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Holi_Del extends Application {
    public ArrayList<String> garrList= new ArrayList<>();
    public ArrayAdapter<String> garrAdp;
    public String gvalue_Hname;
    public String gvalue_Hdiscription;

    public String getGvalue_Hname() {
        return gvalue_Hname;
    }
    public void setGvalue_Hname(String gvalue_hname) {
        this.gvalue_Hname=gvalue_hname;
    }
    public String getGvalue_Hdiscription() {
        return gvalue_Hdiscription;
    }
    public void setGvalue_Hdiscription(String gvalue_hdiscription) {
        this.gvalue_Hdiscription=gvalue_hdiscription;
    }
}
//

