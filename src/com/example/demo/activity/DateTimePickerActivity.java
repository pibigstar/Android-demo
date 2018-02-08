package com.example.demo.activity;

import java.util.Calendar;

import com.example.demo.R;
import com.example.demo.R.id;
import com.example.demo.R.layout;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class DateTimePickerActivity extends Activity{
	
	private TimePicker timePicker;
	private DatePicker datePicker;
	private Calendar cal;//日历工具类
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("日历时间选择器");
		setContentView(R.layout.demo_datetime);
		
		
		cal = Calendar.getInstance();
		//获得年月日 时分
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);//他是从0开始计算的
		day = cal.get(Calendar.DAY_OF_MONTH);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minute = cal.get(Calendar.MINUTE);
		
		datePicker = (DatePicker) findViewById(R.id.datePicker);
		
		//初始化时这个month他会自己给你加1，但是监听里面还是从0开始的
		datePicker.init(year, month, day, new OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				Toast.makeText(getApplicationContext(), year+":"+(monthOfYear+1)+":"+dayOfMonth, Toast.LENGTH_SHORT).show();
			}
		});
		
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				Toast.makeText(getApplicationContext(), hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
			}
		});
		
		
		//以对话框形式弹出日期选择器
		new DatePickerDialog(this, new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), year+":"+(month+1)+":"+dayOfMonth, Toast.LENGTH_SHORT).show();
			}
		}, year, month, day).show();
	}
}
