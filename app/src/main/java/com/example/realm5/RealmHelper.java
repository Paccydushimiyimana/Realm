package com.example.realm5;

import java.util.ArrayList;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public ArrayList<String> retrieve0() {

        ArrayList<String> Regno = new ArrayList<>();

        RealmResults<Student> students = realm.where(Student.class).findAll();
        for (Student std : students) {
            Regno.add(std.getRegno());
        }
            return Regno;


    }

    public ArrayList<String> retrieve1() {


        ArrayList<String> Fname = new ArrayList<>();

        RealmResults<Student> students = realm.where(Student.class).findAll();
        for (Student std : students) {
            Fname.add(std.getFname());
        }

        return Fname;

    }

    public ArrayList<String> retrieve2(){

        ArrayList<String> Lname=new ArrayList<>();

        RealmResults<Student> students=realm.where(Student.class).findAll();
        for (Student std: students){
            Lname.add(std.getLname());
        }
        return Lname;
    }

}


