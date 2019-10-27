package com.roflan.planner;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EventActivity extends AppCompatActivity {

    Date startDate = new Date(0), endDate = new Date(Long.MAX_VALUE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);
    }

    public void showDatePickerDialog(final View view) {
        final Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(EventActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker date_picker_view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.HOUR, 0);
                TextView tView = (TextView) findViewById(view.getId());
                switch (tView.getId()){
                    case R.id.start_date: {
                        startDate.setTime(calendar.getTimeInMillis());
                        break;
                    }
                    case R.id.end_date: {
                        endDate.setTime(calendar.getTimeInMillis());
                        break;
                    }
                }
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                tView.setText(dateFormat.format(calendar.getTime()));
                tView.setTextColor(Color.BLACK);
            }
        },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void showTimePickerDialog(final View view) {
        final Calendar calendar = Calendar.getInstance();
        TimePickerDialog mTimePicker;
        new TimePickerDialog(EventActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                TextView tView = (TextView) findViewById(view.getId());
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                switch (tView.getId()){
                    case R.id.start_time: {
                        calendar.setTime(startDate);
                        calendar.set(Calendar.HOUR, selectedHour);
                        calendar.set(Calendar.MINUTE, selectedMinute);
                        startDate.setTime(calendar.getTimeInMillis());
                        break;
                    }
                    case R.id.end_time: {
                        calendar.setTime(endDate);
                        calendar.set(Calendar.HOUR, selectedHour);
                        calendar.set(Calendar.MINUTE, selectedMinute);
                        endDate.setTime(calendar.getTimeInMillis());
                        break;
                    }
                }
                tView.setTextColor(Color.BLACK);
                tView.setText( selectedHour + ":" + selectedMinute);
            }
        },      calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), true).
                show();
    }
}
