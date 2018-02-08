package com.example.demo.activity;

import com.example.demo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AlterDialogActivity extends Activity{
	private Button button;
	private TextView txt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_alerdialog);
		button = (Button) findViewById(R.id.showAlerDialog);
		txt = (TextView) findViewById(R.id.alerDialog_txt);
		AlertDialog.Builder builder = new AlertDialog.Builder(AlterDialogActivity.this);
		builder.setTitle("弹窗提示");
		//确认按钮
		builder.setMessage("你确认要卸载吗？");
		builder.setPositiveButton("残忍卸载", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				txt.setText("拜拜了");
			}
		});
		builder.setNegativeButton("再想想",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				txt.setText("我又能继续陪伴你了！");
			}
		});
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
		
	}

}
