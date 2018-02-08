package com.example.demo;

import com.example.demo.activity.AlterDialogActivity;
import com.example.demo.activity.BroadcastActivity;
import com.example.demo.activity.DateTimePickerActivity;
import com.example.demo.activity.GridViewActivity;
import com.example.demo.activity.ListViewActivity;
import com.example.demo.activity.ProgressActivity;
import com.example.demo.activity.ScrollViewActivity;
import com.example.demo.activity.ServiceActivity;
import com.example.demo.activity.SpinnerActivity;
import com.example.demo.activity.UserLoginActivity;
import com.example.demo.activity.ViewPagerActivity;
import com.example.demo.activity.WebViewActivity;
import com.example.demo.dao.SQLiteDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DemoMainActivity extends Activity{
	
	private Button listViewBt;
	private Button dateTimeBt;	
	private Button gridViewBt;	
	private Button spinnerBt;	
	private Button progressBt;	
	private Button webViewBt;	
	private Button alterDialogBt;	
	private Button viewPagerBt;	
	private Button scrollViewBt;	
	private Button userloginBt;	
	private Button sqliteBt;	
	private Button broadcastBt;	
	private Button serviceBt;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_main);
		
		listViewBt = (Button) findViewById(R.id.to_listViewBt);
		
		listViewBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,ListViewActivity.class);
				startActivity(intent);
				
			}
		});
		
		dateTimeBt = (Button) findViewById(R.id.to_dateTimeBt);
		dateTimeBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,DateTimePickerActivity.class);
				startActivity(intent);
			}
		});
		
		
		gridViewBt = (Button) findViewById(R.id.to_gridview);
		gridViewBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,GridViewActivity.class);
				startActivity(intent);
			}
		});
		
		spinnerBt = (Button) findViewById(R.id.to_spinner);
		spinnerBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,SpinnerActivity.class);
				startActivity(intent);
			}
		});
		
		progressBt = (Button) findViewById(R.id.to_progress);
		progressBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,ProgressActivity.class);
				startActivity(intent);
			}
		});
		
		webViewBt = (Button) findViewById(R.id.to_webView);
		webViewBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,WebViewActivity.class);
				startActivity(intent);
			}
		});
		
		alterDialogBt = (Button) findViewById(R.id.to_alter);
		alterDialogBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,AlterDialogActivity.class);
				startActivity(intent);
			}
		});
		
		viewPagerBt = (Button) findViewById(R.id.to_viewPager);
		viewPagerBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,ViewPagerActivity.class);
				startActivity(intent);
			}
		});
		
		scrollViewBt = (Button) findViewById(R.id.to_scrollView);
		scrollViewBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,ScrollViewActivity.class);
				startActivity(intent);
			}
		});
		
		userloginBt = (Button) findViewById(R.id.to_userlogin);
		userloginBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,UserLoginActivity.class);
				startActivity(intent);
			}
		});
		
		sqliteBt = (Button) findViewById(R.id.to_SQLite);
		sqliteBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,SQLiteDemo.class);
				startActivity(intent);
			}
		});
		
		broadcastBt = (Button) findViewById(R.id.to_broadcast);
		broadcastBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,BroadcastActivity.class);
				startActivity(intent);
			}
		});
		
		serviceBt = (Button) findViewById(R.id.to_service);
		serviceBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoMainActivity.this,ServiceActivity.class);
				startActivity(intent);
				
			}
		});
	}

}
