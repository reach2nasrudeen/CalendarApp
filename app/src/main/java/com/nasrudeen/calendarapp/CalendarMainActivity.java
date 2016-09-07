package com.nasrudeen.calendarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class CalendarMainActivity extends AppCompatActivity {
    ArrayList<CalendarModel> arrayList;
    CalendarMainAdapter calendarMainAdapter;
    ListView listView;
    public GregorianCalendar cal_month, cal_month_copy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_main);
        listView = (ListView) findViewById(R.id.mainList);
        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();

        arrayList = new ArrayList<CalendarModel>();
        for(int i=0;i<12;i++){
            CalendarModel calendarModel = new CalendarModel();
            if(i == 0){
                Log.i("TAG -->","Condition if");
//                Log.i("\n\nDate -->", String.valueOf(cal_month));
                Log.i("\n\nDate -->", String.valueOf(android.text.format.DateFormat.format("MMM yyyy",cal_month)));
//                calendarModel.setStrCalendarMonth(cal_month);
                calendarModel.setStrTextMonth(String.valueOf(android.text.format.DateFormat.format("MMM yyyy",cal_month)));
                calendarModel.setStrCalendarMonth(cal_month);
            }else {
                Log.i("TAG -->","Condition else");
//                Log.i("\n\nDate -->", String.valueOf(android.text.format.DateFormat.format("MMM yyyy",cal_month)));
                cal_month.set(GregorianCalendar.MONTH,cal_month.get(GregorianCalendar.MONTH)+1);
                calendarModel.setStrCalendarMonth(cal_month);
                calendarModel.setStrTextMonth(String.valueOf(android.text.format.DateFormat.format("MMM yyyy",cal_month)));
            }
            arrayList.add(calendarModel);
        }
        calendarMainAdapter = new CalendarMainAdapter(getApplicationContext(),arrayList);
        listView.setAdapter(calendarMainAdapter);
    }
//    private GregorianCalendar setNextMonth(GregorianCalendar calendarValue) {
//        GregorianCalendar gregorianCalendar = calendarValue;
//        if (gregorianCalendar.get(GregorianCalendar.MONTH) == gregorianCalendar.getActualMaximum(GregorianCalendar.MONTH)) {
//            gregorianCalendar.set((gregorianCalendar.get(GregorianCalendar.YEAR) + 1),gregorianCalendar.getActualMinimum(GregorianCalendar.MONTH), 1);
//        } else {
//            gregorianCalendar.set(GregorianCalendar.MONTH,gregorianCalendar.get(GregorianCalendar.MONTH) + 1);
//        }
//        return gregorianCalendar;
//    }
}
