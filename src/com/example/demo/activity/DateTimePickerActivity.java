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
	private Calendar cal;//����������
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("����ʱ��ѡ����");
		setContentView(R.layout.demo_datetime);
		
		
		cal = Calendar.getInstance();
		//��������� ʱ��
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);//���Ǵ�0��ʼ�����
		day = cal.get(Calendar.DAY_OF_MONTH);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minute = cal.get(Calendar.MINUTE);
		
		datePicker = (DatePicker) findViewById(R.id.datePicker);
		
		//��ʼ��ʱ���month�����Լ������1�����Ǽ������滹�Ǵ�0��ʼ��
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
		
		
		//�ԶԻ�����ʽ��������ѡ����
		new DatePickerDialog(this, new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), year+":"+(month+1)+":"+dayOfMonth, Toast.LENGTH_SHORT).show();
			}
		}, year, month, day).show();
	}
}
