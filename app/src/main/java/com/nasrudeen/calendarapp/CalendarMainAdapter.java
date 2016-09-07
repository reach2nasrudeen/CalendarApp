package com.nasrudeen.calendarapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kumar on 07/09/16.
 */
public class CalendarMainAdapter extends BaseAdapter {
    Context mContext;
    private CalendarAdapter cal_adapter;
    ArrayList<CalendarModel> arrayList;
    public CalendarMainAdapter(Context context, ArrayList<CalendarModel> arrayList){
        this.mContext = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.calender,null);
        TextView textMonth = (TextView) view.findViewById(R.id.textMonth);
//        Log.i("Position ", String.valueOf(i));
//        textMonth.setText(android.text.format.DateFormat.format("MMM yyyy", arrayList.get(i).getStrCalendarMonth()));
        textMonth.setText(arrayList.get(i).getStrTextMonth());
        cal_adapter = new CalendarAdapter(mContext, arrayList.get(i).getStrCalendarMonth());
        GridView gridview = (GridView) view.findViewById(R.id.gv_calendar);
        gridview.setAdapter(cal_adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                ((CalendarAdapter) parent.getAdapter()).setSelected(v,position);
                String selectedGridDate = CalendarAdapter.day_string
                        .get(position);

                String[] separatedTime = selectedGridDate.split("-");
                String gridvalueString = separatedTime[2].replaceFirst("^0*","");
                int gridvalue = Integer.parseInt(gridvalueString);

//                if ((gridvalue > 10) && (position < 8)) {
//                    setPreviousMonth();
//                    refreshCalendar();
//                } else if ((gridvalue < 7) && (position > 28)) {
//                    setNextMonth();
//                    refreshCalendar();
//                }

                Toast.makeText(mContext,"Item Clicked",Toast.LENGTH_SHORT).show();
//                ((CalendarAdapter) parent.getAdapter()).setSelected(v,position);


//                ((CalendarAdapter) parent.getAdapter()).getPositionList(selectedGridDate, CalenderActivity.this);
            }

        });
        return view;
    }
}
