package com.example.dashelper;

public class HolidayData {
    private String Hname;
    private String Sdate;
    private String Edate;
    private String Hdescription;
    private String Id;

    public HolidayData() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHdescription() {
        return Hdescription;
    }

    public void setHdescription(String hdescription) {
        this.Hdescription = hdescription;
    }

    public String getHname() {
        return Hname;
    }

    public void setHname(String hname) {
        this.Hname = hname;
    }

    public String getSdate() {
        return Sdate;
    }

    public void setSdate(String sdate) {
        this.Sdate = sdate;
    }

    public String getEdate() {
        return Edate;
    }

    public void setEdate(String edate) {
        this.Edate = edate;
    }

    public String toString() {
        return this.Hname + "\n" +Sdate+"\n" + Edate+"\n" + Hdescription;
    }

}
//

