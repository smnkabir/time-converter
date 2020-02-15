package com.example.timeconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView long_time;
    Button convert;
    EditText hour;
    EditText minute;
    Date date;

    RadioButton radioButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long_time = findViewById(R.id.tv_long);
        convert = findViewById(R.id.button_convert);
        hour = (EditText)findViewById(R.id.et_hour);
        minute = findViewById(R.id.et_min);
        long_time = findViewById(R.id.tv_long);
        radioGroup = findViewById(R.id.radiogroup);



        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTime();
            }
        });

    }

    private void convertTime() {
        int h = Integer.parseInt(String.valueOf(hour.getText()));
        int m = Integer.parseInt(String.valueOf(minute.getText()));
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE,1);
        cal.set(Calendar.MONTH,1);
        cal.set(Calendar.YEAR,2000);
        cal.set(Calendar.HOUR,h);
        cal.set(Calendar.MINUTE,m);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);

        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        if(radioButton.getText().equals("am"))
            cal.set(Calendar.AM_PM,Calendar.AM);
        else
            cal.set(Calendar.AM_PM,Calendar.PM);

        date = cal.getTime();

        long_time.setText(date.getTime() + "");

    }

    public  void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }
}
