package com.dnerd.dipty.pricecalculatingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox pizza,burger,coffee;
    Spinner spinnerPizza,spinnerBurger,spinnerCoffee;
    TextView pizzaPr,burgerPr,coffeePr,total;
    String[] quantity = {"0","1","2","3","4","5","6"};
    Integer result = 0,qn=1,x=1,y=1,z=1;
    Button or;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza = (CheckBox) findViewById(R.id.checkBoxPizza);
        burger = (CheckBox) findViewById(R.id.checkBoxBurger);
        coffee = (CheckBox) findViewById(R.id.checkBoxCoffee);

        spinnerPizza = (Spinner) findViewById(R.id.spinnerPizza);
        spinnerBurger = (Spinner) findViewById(R.id.spinnerBurger);
        spinnerCoffee = (Spinner) findViewById(R.id.spinnerCoffee);
        pizzaPr = (TextView) findViewById(R.id.pizzaPrice);
        burgerPr = (TextView) findViewById(R.id.burgePrice);
        coffeePr = (TextView) findViewById(R.id.coffeePrice);
        total = (TextView) findViewById(R.id.totalPrice);
        or = (Button) findViewById(R.id.order);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,quantity);
        spinnerPizza.setAdapter(adapter);
        spinnerBurger.setAdapter(adapter);
        spinnerCoffee.setAdapter(adapter);

        pizza.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

               // result+=(quantity[0]*Integer.parseInt((String) pizzaPr.getText()));
                spinnerPizza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        result+=(Integer.parseInt(quantity[i])*Integer.parseInt((String) pizzaPr.getText()));//-Integer.parseInt((String) pizzaPr.getText());

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


            }
        });

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //result+=(quantity[0]*Integer.parseInt((String) burgerPr.getText()));
                spinnerBurger.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        result+=(Integer.parseInt(quantity[i])*Integer.parseInt((String) burgerPr.getText()));//-Integer.parseInt((String) burgerPr.getText());

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                /*if(y==1)
                {
                    result+=(Integer.parseInt(quantity[0])*Integer.parseInt((String) burgerPr.getText()));
                }*/

            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // result+=(quantity[0]*Integer.parseInt((String) coffeePr.getText()));
                spinnerCoffee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        result+=(Integer.parseInt(quantity[i])*Integer.parseInt((String) coffeePr.getText()));//-Integer.parseInt((String) coffeePr.getText());
                        z=0;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                /*if(z==1)
                {
                    result+=(Integer.parseInt(quantity[0])*Integer.parseInt((String) coffeePr.getText()));
                }*/

            }

        });

        or.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                total.setText("");

                StringBuilder s = new StringBuilder();
                s.append(result);
                total.setText(s);

                if(pizza.isChecked())
                {
                    pizza.setChecked(false);
                    spinnerPizza.setAdapter(adapter);
                    x=1;
                }
                if(burger.isChecked())
                {
                    burger.setChecked(false);
                    spinnerBurger.setAdapter(adapter);
                    y=1;
                }
                if(coffee.isChecked())
                {
                    coffee.setChecked(false);
                    spinnerCoffee.setAdapter(adapter);
                    z=1;
                }
                result=0;

            }
        });

    }
}
