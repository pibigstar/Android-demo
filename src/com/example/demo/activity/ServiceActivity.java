package com.example.demo.activity;

import com.example.demo.R;
import com.example.demo.service.MyBindService;
import com.example.demo.service.MyBindService.MyBinder;
import com.example.demo.service.MyStartService;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class ServiceActivity extends Activity{
	private Intent intent1,intent2;
	private MyBindService service;
	ServiceConnection conn = new ServiceConnection() {
		
		@Override//bindService异常终止调用的方法
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override//服务启动调用的方法
		public void onServiceConnected(ComponentName name, IBinder binder) {
			 service = ((MyBinder)binder).getService();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_service);
		setTitle("服务demo");
		
	}
	
	public void doClick(View view) {
		switch (view.getId()) {
		case R.id.startService:
			intent1 = new Intent(ServiceActivity.this,MyStartService.class);
			startService(intent1);
			break;
		case R.id.stopService:
			stopService(intent1);
			break;
		case R.id.bindService://绑定服务
			intent2 = new Intent(ServiceActivity.this,MyBindService.class);
			bindService(intent2, conn, Service.BIND_AUTO_CREATE);
			break;
		case R.id.play:
			service.paly();
			break;
		case R.id.paush:
			service.paush();
			break;

		default:
			break;
		}
	}

}
