package com.nasrudeen.calendarapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kumar on 07/09/16.
 */
public class CalendarMainAdapter extends BaseAdapter {
    Context mContext;
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
        return view;
    }
}
