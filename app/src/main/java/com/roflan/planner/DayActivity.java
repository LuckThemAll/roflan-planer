package com.roflan.planner;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.framgia.library.calendardayview.CalendarDayView;
import com.framgia.library.calendardayview.data.IEvent;

import java.util.ArrayList;
import java.util.Calendar;

public class DayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);
        CalendarDayView dayView = (CalendarDayView) findViewById(R.id.dayView);
        ArrayList<IEvent> events = new ArrayList<>();

        {
            int eventColor = ContextCompat.getColor(this, R.color.eventColor2);
            Calendar timeStart = Calendar.getInstance();
            timeStart.set(Calendar.HOUR_OF_DAY, 11);
            timeStart.set(Calendar.MINUTE, 0);
            Calendar timeEnd = (Calendar) timeStart.clone();
            timeEnd.set(Calendar.HOUR_OF_DAY, 15);
            timeEnd.set(Calendar.MINUTE, 30);
            Event event = new Event(1, timeStart, timeEnd, "Event", "Hockaido", eventColor);

            events.add(event);
        }

        {
            int eventColor = ContextCompat.getColor(this, R.color.eventColor1);
            Calendar timeStart = Calendar.getInstance();
            timeStart.set(Calendar.HOUR_OF_DAY, 16);
            timeStart.set(Calendar.MINUTE, 0);
            Calendar timeEnd = (Calendar) timeStart.clone();
            timeEnd.set(Calendar.HOUR_OF_DAY, 17);
            timeEnd.set(Calendar.MINUTE, 30);
            Event event = new Event(1, timeStart, timeEnd, "Another event", "Hockaido", eventColor);

            events.add(event);
        }
        dayView.setEvents(events);
    }

}
