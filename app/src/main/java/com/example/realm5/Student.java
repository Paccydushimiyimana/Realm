package com.example.realm5;

import io.realm.RealmObject;

public class Student extends RealmObject {

    int Regno;
    String Fname;
    String Lname;

    public String getRegno() {
        return String.valueOf(Regno);
    }

    public void setRegno(int regno) {
        Regno = regno;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }


}
