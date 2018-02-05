package com.dnerd.dipty.mydatabaseapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Mydatabase mdb = new Mydatabase(this);
    EditText etName,etLocation,etSal;
    Button insertButton;
    ListView lv;

    SimpleCursorAdapter sca;
    Cursor cursor;
    ContentValues cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cv = new ContentValues();
                cv.put("name",etName.getText().toString());
                cv.put("location",etLocation.getText().toString());
                cv.put("salary", Integer.parseInt(etSal.getText().toString()));

                //inserting value to db
                mdb.empInsert(cv);

                Toast.makeText(getApplicationContext(),"values Inserted",Toast.LENGTH_LONG).show();

                etName.setText(null);
                etLocation.setText(null);
                etSal.setText(null);


                //query again for new entry
                cursor.requery();

            }
        });
        //retrieve the data using getemp
        cursor = mdb.getEmp();
        String[] fromDb = {"name","location","salary"};

        int[] toList = {R.id.textViewName,R.id.textViewLocation,R.id.textViewSalary};
        sca = new SimpleCursorAdapter(this,R.layout.row,cursor,fromDb,toList);

        lv.setAdapter(sca);
        sca.notifyDataSetChanged();
        cursor.requery();

    }

    private void initializeViews() {
        etName = (EditText) findViewById(R.id.editTextName);
        etLocation = (EditText) findViewById(R.id.editTextLocation);
        etSal = (EditText) findViewById(R.id.editTextSalary);
        lv = (ListView) findViewById(R.id.listData);
        insertButton = (Button) findViewById(R.id.buttonInsert);


    }
}
