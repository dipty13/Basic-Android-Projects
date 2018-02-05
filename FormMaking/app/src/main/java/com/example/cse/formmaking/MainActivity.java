package com.example.cse.formmaking;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox f,s,t;
    private TextView tx1,tx2,tx3;
    private EditText tv1,tv2,tv3,txtDate,txtTime;
    int mYear,mMonth,mDay,mHour,mMinute;
private  Button button,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f= (CheckBox) findViewById(R.id.checkBox);
        s= (CheckBox) findViewById(R.id.checkBox2);
        t = (CheckBox) findViewById(R.id.checkBox3);


         button= (Button) findViewById(R.id.btn);
         btn2= (Button) findViewById(R.id.btnDate);
         btn3= (Button) findViewById(R.id.btnTime);
        tx1= (TextView) findViewById(R.id.t1);
        tx2= (TextView) findViewById(R.id.t2);
        tx3= (TextView) findViewById(R.id.t3);
        tv1= (EditText) findViewById(R.id.et1);
        tv2= (EditText) findViewById(R.id.et2);
        tv3= (EditText) findViewById(R.id.et3);
        txtDate=(EditText)findViewById(R.id.d);
        txtTime=(EditText)findViewById(R.id.time);
       // btn2= (Button) findViewById(R.id.button4);
        btn2.setOnClickListener( this);
        btn3.setOnClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // System.out.println("UserName: "+tv1.getText());
                Toast.makeText(getApplicationContext(),tv1.getText(),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),tv2.getText(),Toast.LENGTH_LONG).show();

                if(f.isChecked()){
                    Toast.makeText(getApplicationContext(),"Female",Toast.LENGTH_LONG).show();
                }
                else if(s.isChecked()){
                    Toast.makeText(getApplicationContext(),"Male",Toast.LENGTH_LONG).show();
                }
               else if(t.isChecked()){
                    Toast.makeText(getApplicationContext(),"Other",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    @Override
    public void onClick(View v) {
        if(v==btn2)
        {
            //get current date
            final Calendar c= Calendar.getInstance();
            mYear=c.get(Calendar.YEAR);
            mMonth=c.get(Calendar.MONTH);
            mDay=c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txtDate.setText(dayOfMonth+"-"+month+"-"+year);
                        }
                    },mYear,mMonth,mDay);
            datePickerDialog.show();

        }
        if(v==btn3)
        {
            //get current time
            final Calendar c=Calendar.getInstance();
            mHour=c.get(Calendar.HOUR_OF_DAY);
            mMinute=c.get(Calendar.MINUTE);
            //launch time picker dialog
            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txtTime.setText(hourOfDay+":"+minute);
                }
            },mHour,mMinute,false);
            timePickerDialog.show();
        }
    }
}
