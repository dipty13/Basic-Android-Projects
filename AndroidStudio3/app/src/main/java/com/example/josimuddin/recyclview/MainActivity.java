package com.example.josimuddin.recyclview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.josimuddin.recyclview.R.styleable.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static CustomAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private static ArrayList<DataModel> data;

    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removeItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOnClickListener = new MyOnClcikListener(this);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i<MyData.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id[i],
                    MyData.drawableArray[i]
            ));
        }

        removeItems =  new ArrayList<Integer>();

        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private class MyOnClcikListener implements View.OnClickListener {
        private final Context context;
        public MyOnClcikListener(Context context) {
            this.context = context;

        }

        @Override
        public void onClick(View v) {
            removeItems(v);
        }
        private void removeItems(View v)
        {
            int selectedItemProsition = recyclerView.getChilddPosition(v);
            RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForPosition(selectedItemProsition);

            TextView textViewName = viewHolder.itemView.findViewById(R.id.text_view_name);
            String selectedName = (String) textViewName.getText();

            int selectedItemId = -1;
            for(int i = 0; i < MyData.nameArray.length ; i++)
            {
                if(selectedName.equals(MyData.nameArray[i]))
                {
                    selectedItemId = MyData.id[i];
                }
            }
            removeItems.add(selectedItemId);
            data.remove(selectedItemProsition);
            adapter.notifyItemRemoved(selectedItemProsition);


        }

    }
    public boolean onCreatOptionsMenu(Menu menu)
    {
        super.onCreateOptionMenu(menu);

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOtionSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.addItem)
        {
            //check if any items to add
            if(removeItems.size()!=0)
            {
                addReamovedItemsToList();
            }else{
                Toast.makeText(getApplicationContext(),"Nothing to add",Toast.LENGTH_LONG).show();
            }
        }
        return true;
    }

    private void addReamovedItemsToList() {
        int addItemAtPosition = 3;

        data.add(addItemAtPosition,new DataModel(
                MyData.nameArray[removeItems.get(0)],
                MyData.versionArray[removeItems.get(0)],
                MyData.id[removeItems.get(0)],
                MyData.drawableArray[removeItems.get(0)]
        ));

        adapter.notifyItemInserted(addItemAtPosition);
        removeItems.remove(0);

    }

}
