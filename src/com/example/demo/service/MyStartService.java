package com.example.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyStartService extends Service{

	@Override
	public void onCreate() {
		Toast.makeText(this, "service--onCreate", 1000).show();
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "service--onStartCommand", 1000).show();
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		Toast.makeText(this, "service--onDestroy", 1000).show();
		super.onDestroy();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Toast.makeText(this, "service--onBind", 1000).show();
		return null;
	}

}
