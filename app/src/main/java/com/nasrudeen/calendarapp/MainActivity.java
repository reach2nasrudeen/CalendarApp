package com.nasrudeen.calendarapp;

import android.annotation.TargetApi;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Calendar mCalendar;
    GridView mGridView;
    int mToday[]=new int[]{};
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// get date
        mCalendar = Calendar.getInstance();
        mToday[0] = mCalendar.get(Calendar.DAY_OF_MONTH);
        mToday[1] = mCalendar.get(Calendar.MONTH); // zero based
        mToday[2] = mCalendar.get(Calendar.YEAR);


// get display metrics
        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


// set adapter
        mGridView = (GridView)findViewById(R.id.gridview);
//        mGridView.setAdapter(new MonthAdapter(this, mToday[1], mToday[2], metrics) {
        mGridView.setAdapter(new MonthAdapter(this, mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.YEAR), metrics) {
            @Override
            protected void onDate(int[] date, int position, View item) {
                Toast.makeText(getApplicationContext(),"Test",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
