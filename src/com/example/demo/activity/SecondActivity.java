package com.example.demo.activity;

import com.example.demo.R;
import com.example.demo.R.id;
import com.example.demo.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity{

	private Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("data", "我是第二个页面传递过来的数据");
				//将数据发给第一个页面，第一个参数是一个标识
				setResult(2,data);
				
				//关闭此页面
				finish();
			}
		});
	}
	
	
}
