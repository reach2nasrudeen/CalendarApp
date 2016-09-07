package com.nasrudeen.calendarapp;

import java.util.GregorianCalendar;

/**
 * Created by kumar on 07/09/16.
 */
public class CalendarModel {
    public String strTextMonth;
    public GregorianCalendar strCalendarMonth;

    public String getStrTextMonth() {
        return strTextMonth;
    }

    public void setStrTextMonth(String strTextMonth) {
        this.strTextMonth = strTextMonth;
    }

    public GregorianCalendar getStrCalendarMonth() {
        return strCalendarMonth;
    }

    public void setStrCalendarMonth(GregorianCalendar strCalendarMonth) {
        this.strCalendarMonth = strCalendarMonth;
    }
}
