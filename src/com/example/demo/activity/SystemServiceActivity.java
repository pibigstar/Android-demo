package com.example.demo.activity;

import com.example.demo.R;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SystemServiceActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_systemservice);
		setTitle("系统服务");
	}
	
	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.getNetwork_bt:
			if (isNetWorkConnect(SystemServiceActivity.this)) {
				Toast.makeText(SystemServiceActivity.this, "网络已打开", 1000).show();
			}else {
				Toast.makeText(SystemServiceActivity.this, "网络已关闭", 1000).show();
			}
			break;
		case R.id.openWiFi_bt:
			WifiManager wifiManager = (WifiManager) SystemServiceActivity.this.getSystemService(WIFI_SERVICE);
			if (wifiManager.isWifiEnabled()) {
				wifiManager.setWifiEnabled(false);
				Toast.makeText(SystemServiceActivity.this, "wifi已关闭", 1000).show();
			}else {
				wifiManager.setWifiEnabled(true);
				Toast.makeText(SystemServiceActivity.this, "wifi已打开", 1000).show();
			}
			
			break;
		case R.id.openCamera_bt:
			
			break;

		default:
			break;
		}
	}
	
	private boolean isNetWorkConnect(Context context) {
		if (context!=null) {
			ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = manager.getActiveNetworkInfo();
			if (networkInfo!=null) {
				return networkInfo.isAvailable();
			}
		}
		return false;
	}
}
