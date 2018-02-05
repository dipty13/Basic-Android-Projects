package com.dnerd.dipty.toolbarapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        ActionBar  ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        ab.setTitle("Home");
        ab.setIcon(R.mipmap.ic_launcher_round);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_id_add)
        {
            Toast.makeText(getApplicationContext(),"You selsected: "+item.getTitle(),Toast.LENGTH_LONG).show();
        }
        if(item.getItemId()==R.id.menu_id_home)
        {
            Toast.makeText(getApplicationContext(),"You selsected: "+item.getTitle(),Toast.LENGTH_LONG).show();
        }
        if(item.getItemId()==R.id.menu_id_search)
        {
            Toast.makeText(getApplicationContext(),"You selsected: "+item.getTitle(),Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
