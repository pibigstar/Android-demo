package com.example.demo;

import com.example.demo.activity.SecondActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnCheckedChangeListener{

	private ImageButton imgbt;
	private AutoCompleteTextView acText;
	private ToggleButton tgBt;
	private TextView dataText;
	private Button inBt;
	private Button toDemoBt;
	private SeekBar seekBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imgbt = (ImageButton) findViewById(R.id.imgbt);
		imgbt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//С���������Զ���ʧ
				Toast.makeText(getApplicationContext(),"�����ͼƬ��ť",Toast.LENGTH_SHORT).show();
			}
		});
		
		//�Զ�ƥ���ı���
		acText = (AutoCompleteTextView) findViewById(R.id.acTextView1);
		String [] ac = {"henan1","hebei","hujian","shanghai1","shanghai2"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, ac);
		acText.setAdapter(adapter);
		
		//���ذ�ť
		tgBt = (ToggleButton) findViewById(R.id.tgBt1);
		tgBt.setOnCheckedChangeListener(this);
		
		//��תҳ��
		inBt = (Button) findViewById(R.id.inBt);
		inBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this,SecondActivity.class);
				startActivityForResult(intent, 1);
				
			}
		});
		
		dataText = (TextView) findViewById(R.id.dataText);
		
		toDemoBt = (Button) findViewById(R.id.toDemoBt);
		
		toDemoBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,DemoMainActivity.class);
				startActivity(intent);
			}
		});
		
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			//ֹͣ����
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			//��ʼ����
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			//�϶�
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				Toast.makeText(getApplicationContext(), "progress:"+progress, Toast.LENGTH_SHORT).show();
				
			}
		});
	}
	/**
	 * ����ҳ�洫�ݹ���������
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		super.onActivityResult(requestCode, resultCode, data);
		//�ж��Ƿ��ǵڶ���ҳ�洫�ݹ���������
		if (requestCode==1&&resultCode==2) {
			String txt = data.getStringExtra("data");
			dataText.setText(txt);
		}
	}
	
	//����ToggleButton��״̬
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		
		if (isChecked) {
			Log.i("demo","����");
		}else {
			Log.i("demo","�ر���");
		}
	}
	
}
