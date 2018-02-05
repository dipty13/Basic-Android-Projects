package com.dnerd.dipty.checkboxapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox pizza,burger,coffee;
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza = (CheckBox) findViewById(R.id.checkBoxPizza);
        burger = (CheckBox) findViewById(R.id.checkBoxBurger);
        coffee = (CheckBox) findViewById(R.id.checkBoxCoffee);
        order = (Button) findViewById(R.id.buttonOrder);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalAmount = 0;
                StringBuilder result = new StringBuilder();

                result.append("Selected Items: \n");

                if(pizza.isChecked())
                {
                   result.append("\n Pizza 700tk");
                    totalAmount+=700;
                }
                if(burger.isChecked())
                {
                    result.append("\n Burger 200tk");
                    totalAmount+=200;
                }
                if(coffee.isChecked())
                {
                    result.append("\n Coffee 100tk");
                    totalAmount+=100;
                }
                result.append("\nTotal amount is: "+totalAmount+"tk");
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();
                if(pizza.isChecked())
                {
                    pizza.setChecked(false) ;

                }
                if(burger.isChecked())
                {
                    burger.setChecked(false) ;
                }
                if(coffee.isChecked())
                {
                    coffee.setChecked(false) ;
                }

            }
        });


    }
}
