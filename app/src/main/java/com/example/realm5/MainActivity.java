package com.example.realm5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    EditText Regno,Fname,Lname;
    Button Save,View;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Regno=findViewById(R.id.etRegno);
        Fname=findViewById(R.id.etFname);
        Lname=findViewById(R.id.etLname);

        Save=findViewById(R.id.bSave);
        View=findViewById(R.id.bView);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                realm=Realm.getDefaultInstance();
                int Regnostr= Integer.parseInt(Regno.getText().toString().trim());
                String Fnamestr=Fname.getText().toString().trim();
                String Lnamestr=Lname.getText().toString().trim();

                realm.beginTransaction();

                Student std=realm.createObject(Student.class);
                std.setRegno(Regnostr);
                std.setFname(Fnamestr);
                std.setLname(Lnamestr);

                realm.commitTransaction();

            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                startActivity(new Intent(getApplicationContext(),Studentz.class));

            }
        });
    }
}
