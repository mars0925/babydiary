package com.example.student.babydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class FeedActivity extends AppCompatActivity {
    //Spinner spinner;
    TextView tv6;
    /*声明日期及时间变量*/
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    /*声明对象变量*/
    TimePicker tp;
    DatePicker dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        //spinner = findViewById(R.id.spinner);
       // ArrayAdapter<CharSequence>  adapter = ArrayAdapter.createFromResource(FeedActivity.this,
              //  R.array.feedfood,android.R.layout.simple_dropdown_item_1line);
        //spinner.setAdapter(adapter);

        /*取得目前日期与时间*/
        Calendar c=Calendar.getInstance();
        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDay=c.get(Calendar.DAY_OF_MONTH);
        mHour=c.get(Calendar.HOUR_OF_DAY);
        mMinute=c.get(Calendar.MINUTE);
        tv6 = (TextView) findViewById(R.id.sleep_showtime);
        updateDisplay();
        dp = new DatePicker(FeedActivity.this);
        dp.init(mYear,mMonth,mDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int  year, int monthOfYear, int dayOfMonth) {
                mYear=year;
                mMonth= monthOfYear;
                mDay=dayOfMonth;
                /*调用updateDisplay()来改变显示日期*/
                updateDisplay();
            }
        });

        /*取得TimePicker对象，并设置为24小时制显示*/
        tp = new TimePicker(FeedActivity.this);
        tp.setIs24HourView(true);
        /*setOnTimeChangedListener，并重写onTimeChanged event*/
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                mHour=hourOfDay;
                mMinute=minute;
                /*调用updateDisplay()来改变显示时间*/
                updateDisplay();
            }
        });


    }
    /*设置显示日期时间的方法*/
    private void updateDisplay() {
        tv6.setText(
                new StringBuilder().append(mYear).append("/")
                        .append(format(mMonth + 1)).append("/")
                        .append(format(mDay)).append("　")
                        .append(format(mHour)).append(":")
                        .append(format(mMinute)));
    }

    /*日期时间显示两位数的方法*/
    private String format(int x)
    {
        String s=""+x;
        if(s.length()==1) s="0"+s;
        return s;
    }


    public void clickadd(View v)
    {

    }
}
