package com.example.dashelper;

import android.app.Application;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Holi_Del extends Application {
    public ArrayList<String> garrList= new ArrayList<>();
    public ArrayAdapter<String> garrAdp;
    public String gvalue_Hid;
    public String gvalue_Hname;
    

    public String getGvalue_Hname() {
        return gvalue_Hname;
    }
    public void setGvalue_Hname(String gvalue_hname) {
        this.gvalue_Hname=gvalue_hname;
    }
    public String getGvalue_Hid() {
        return gvalue_Hid;
    }
    public void setGvalue_Hid(String gvalue_hid) {
        this.gvalue_Hid=gvalue_hid;
    }
}
//

