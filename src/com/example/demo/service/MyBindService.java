package com.example.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {
	
	@Override
	public void onCreate() {
		Log.i("main", "MyBindService--onCreate");
		super.onCreate();
	}
	
	/**
	 * �̳�Binder���������ط������
	 * @author pibigstar
	 */
	public class MyBinder extends Binder{
		public MyBindService getService() {
			return MyBindService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i("main", "MyBindService--onBind");
		return new MyBinder();
	}
	@Override
	public boolean onUnbind(Intent intent) {
		Log.i("main", "MyBindService--onUnbind");
		return super.onUnbind(intent);
	}
	
	public void paly() {
		Log.i("main", "����");
	}

	public void paush() {
		Log.i("main", "��ͣ");
	}
}
