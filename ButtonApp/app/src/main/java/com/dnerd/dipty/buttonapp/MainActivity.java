package com.dnerd.dipty.buttonapp;

import android.support.v4.widget.SearchViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn2;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn =  (Button) findViewById(R.id.buttonClick);
        btn2 = (Button) findViewById(R.id.buttonClick2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c--;
                Toast.makeText(getApplicationContext(),c+" times Button1 is Clicked",Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                Toast.makeText(getApplicationContext(),c+" times Button2 is  Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

}
