package com.example.demo.activity;

import com.example.demo.R;
import com.example.demo.R.drawable;
import com.example.demo.R.id;
import com.example.demo.R.layout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressActivity extends Activity implements OnClickListener{
	
	 	private ProgressBar progress;  
	    private Button btAdd, btReduce, btReset,btShowDialog;  
	    private TextView tvShow;  
	    private ProgressDialog prodialog;  
	  
	    @Override  
	    protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	          
	        /*���ô�������*/  
	        requestWindowFeature(Window.FEATURE_PROGRESS);//�ڱ����������ô����ȵĽ�����  
	        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);//�ڱ����������ò������ȵĽ�����  
	          
	        setContentView(R.layout.demo_progress);  
	          
	        /*��ʾ���ֽ�����*/  
	        setProgressBarVisibility(true);//��ʾ�����ȵĽ�����  
	        setProgressBarIndeterminateVisibility(false);//��ʾ�������ȵĽ�������trueΪ�ڱ��������ҷ���ʾԲ�ν�����  
	          
	        /*��������ˮƽ�������Ľ���ֵ*/  
	        setProgress(6000);//���ֵMax=10000  
	  
	        init();
	    }

		private void init() {
			progress = (ProgressBar)findViewById(R.id.progress);  
	        btAdd = (Button) findViewById(R.id.btAdd);  
	        btReduce = (Button) findViewById(R.id.btReduce);  
	        btReset = (Button) findViewById(R.id.btReset);  
	        btShowDialog=(Button) findViewById(R.id.btShowDialog);  
	        tvShow = (TextView) findViewById(R.id.tvShow);  
	        
	        //��ȡ��������һ����
	        int firstPro = progress.getProgress();
	        //��ȡ�ڶ�����
	        int secondPro = progress.getSecondaryProgress();
	        //��ȡ������
	        int max = progress.getMax();
	        tvShow.setText("��һ���ȣ�"+(int)(firstPro/(float)max*100)+"%  "+"�ڶ����ȣ�"+(int)(secondPro/(float)max*100)+"%");
	       
	        btAdd.setOnClickListener(this);
	        btReduce.setOnClickListener(this);
	        btReset.setOnClickListener(this);
	        btShowDialog.setOnClickListener(this);
		}  
	  
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btAdd:
				progress.incrementProgressBy(10);//��һ������
				progress.incrementSecondaryProgressBy(10);//�ڶ�������
				break;
			case R.id.btReduce:
				progress.incrementProgressBy(-10);
				progress.incrementSecondaryProgressBy(-10);
				break;
			case R.id.btReset:
				progress.setProgress(50);
				progress.setSecondaryProgress(80);
				break;
			case R.id.btShowDialog:
				prodialog = new ProgressDialog(this);
				//���÷��
				prodialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				//���ñ���
				prodialog.setTitle("����������");
				//������ʾ����
				prodialog.setMessage("����һ������������");
				//����ͼ��
				prodialog.setIcon(R.drawable.ic_launcher);
				//���ý�����������
				prodialog.setMax(100);
				prodialog.incrementProgressBy(50);//��ʼ����ʾ50
				prodialog.setIndeterminate(false);//��ȷ��ʾ����
				
				//�趨һ��ȷ����ť
				prodialog.setButton(DialogInterface.BUTTON_POSITIVE, "ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getApplicationContext(), "�����ȷ��", Toast.LENGTH_SHORT).show();
						
					}
				});
				//�����Ƿ����ͨ�����ؼ��˳��Ի���
				prodialog.setCancelable(true);
				
				//��ʾProgressDialog
				prodialog.show();
				break;

			default:
				break;
			}
			tvShow.setText("��һ���ȣ�"+(int)(progress.getProgress()/(float)progress.getMax()*100)+"%  "+"�ڶ����ȣ�"+(int)(progress.getSecondaryProgress()/(float)progress.getMax()*100)+"%");
		}  
	  
//	    @Override  
//	    public boolean onCreateOptionsMenu(Menu menu) {  
//	        getMenuInflater().inflate(R.menu.main, menu);  
//	        return true;  
//	    }

}
