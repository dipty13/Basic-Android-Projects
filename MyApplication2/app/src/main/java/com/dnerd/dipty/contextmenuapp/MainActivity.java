package com.dnerd.dipty.contextmenuapp;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] names = {"Milon","Shaila","Ajmeeri","Istekharul","Jasimuddin","Ibrahim"};
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);

        lv.setAdapter(adapter);
        registerForContextMenu(lv);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //setting the header for the menu
        menu.setHeaderTitle("Select Action");
        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"Message");
        menu.add(0,v.getId(),0,"Block");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle() == "Call")
        {
            Toast.makeText(getApplicationContext(),"You selected "+item.getTitle(),Toast.LENGTH_LONG).show();
        }

        else if(item.getTitle() == "Message")
        {
            Toast.makeText(getApplicationContext(),"You selected "+item.getTitle(),Toast.LENGTH_LONG).show();
        }

        else if(item.getTitle() == "Block")
        {
            Toast.makeText(getApplicationContext(),"You selected "+item.getTitle(),Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);

    }

}
