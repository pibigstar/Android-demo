package com.example.demo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MsgOneReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
		String msg = intent.getStringExtra("msg");
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		Log.i("main",msg);
		//记得要在AndroidManifest里面配置receiver
		
	}

}
