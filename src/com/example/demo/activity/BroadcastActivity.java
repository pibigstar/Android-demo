package com.example.demo.activity;

import com.example.demo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BroadcastActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_broadcast);
		setTitle("广播的使用");
	}
	public void sendBroad(View view) {
		switch (view.getId()) {
		case R.id.sendBC_bt:
			Intent intent = new Intent();
			intent.putExtra("msg", "这是一个普通的广播");
			intent.setAction("msg_one");
			sendBroadcast(intent);
			break;

		default:
			break;
		}
		
	}

}
