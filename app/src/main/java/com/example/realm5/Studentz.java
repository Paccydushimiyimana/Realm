package com.example.realm5;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class Studentz extends AppCompatActivity {

    ListView listView;
    Button deletebtn;
    EditText number;
    SearchView searchView;

    ArrayList<String> student0;
    ArrayList<String> student1;
    ArrayList<String> student2;

    Realm realm;

    RealmHelper helper = new RealmHelper(realm);

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentz);

        realm = Realm.getDefaultInstance();
        listView = findViewById(R.id.listview);
        deletebtn=findViewById(R.id.btndelete);
        number=findViewById(R.id.txtreg);

        student0 = helper.retrieve0();
        student1 = helper.retrieve1();
        student2 = helper.retrieve2();


        Myadapter adapter = new Myadapter(this, student0, student1, student2);

        listView.setAdapter(adapter);

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int regno= Integer.parseInt(number.getText().toString());
                 final RealmResults<Student> studn = realm.where(Student.class).equalTo("Regno", regno).findAll();

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        studn.deleteFromRealm(0);


                    }
                });

                Toast.makeText(Studentz.this, "Done!! refresh to see changes", Toast.LENGTH_SHORT).show();
            }

        });

        //adapter.notifyDataSetChanged();
    }





   @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_src, menu);

        MenuItem searchItem = menu.findItem(R.id.sear);

        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("Searchingaa..");
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {


                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

}


class Myadapter extends ArrayAdapter<String>{
    Context context;
    String stud0z[];
    String stud1z[];
    String stud2z[];


    Myadapter(Context c, ArrayList<String> stud0, ArrayList<String> stud1, ArrayList<String> stud2){
        super(c,R.layout.laying,R.id.textview1,stud1);
        this.context=c;
        this.stud0z= stud0.toArray(new String[0]);
        this.stud1z= stud1.toArray(new String[0]);
        this.stud2z= stud2.toArray(new String[0]);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)getContext().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View laying=layoutInflater.inflate(R.layout.laying,parent,false);

        TextView mystud0=laying.findViewById(R.id.textview0);
        TextView mystud1=laying.findViewById(R.id.textview1);
        TextView mystud2=laying.findViewById(R.id.textview2);

        mystud0.setText(stud0z[position]);
        mystud1.setText(stud1z[position]);
        mystud2.setText(stud2z[position]);

        return laying;
    }

}

