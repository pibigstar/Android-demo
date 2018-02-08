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
	          
	        /*启用窗口特征*/  
	        requestWindowFeature(Window.FEATURE_PROGRESS);//在标题栏处启用带进度的进度条  
	        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);//在标题栏处启用不带进度的进度条  
	          
	        setContentView(R.layout.demo_progress);  
	          
	        /*显示两种进度条*/  
	        setProgressBarVisibility(true);//显示带进度的进度条  
	        setProgressBarIndeterminateVisibility(false);//显示不带进度的进度条，true为在标题栏的右方显示圆形进度条  
	          
	        /*标题栏上水平进度条的进度值*/  
	        setProgress(6000);//最大值Max=10000  
	  
	        init();
	    }

		private void init() {
			progress = (ProgressBar)findViewById(R.id.progress);  
	        btAdd = (Button) findViewById(R.id.btAdd);  
	        btReduce = (Button) findViewById(R.id.btReduce);  
	        btReset = (Button) findViewById(R.id.btReset);  
	        btShowDialog=(Button) findViewById(R.id.btShowDialog);  
	        tvShow = (TextView) findViewById(R.id.tvShow);  
	        
	        //获取进度条第一进度
	        int firstPro = progress.getProgress();
	        //获取第二进度
	        int secondPro = progress.getSecondaryProgress();
	        //获取最大进度
	        int max = progress.getMax();
	        tvShow.setText("第一进度："+(int)(firstPro/(float)max*100)+"%  "+"第二进度："+(int)(secondPro/(float)max*100)+"%");
	       
	        btAdd.setOnClickListener(this);
	        btReduce.setOnClickListener(this);
	        btReset.setOnClickListener(this);
	        btShowDialog.setOnClickListener(this);
		}  
	  
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btAdd:
				progress.incrementProgressBy(10);//第一进度条
				progress.incrementSecondaryProgressBy(10);//第二进度条
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
				//设置风格
				prodialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				//设置标题
				prodialog.setTitle("弹窗进度条");
				//设置显示文字
				prodialog.setMessage("这是一个弹出进度条");
				//设置图标
				prodialog.setIcon(R.drawable.ic_launcher);
				//设置进度条的属性
				prodialog.setMax(100);
				prodialog.incrementProgressBy(50);//初始化显示50
				prodialog.setIndeterminate(false);//明确显示进度
				
				//设定一个确定按钮
				prodialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getApplicationContext(), "点击了确定", Toast.LENGTH_SHORT).show();
						
					}
				});
				//设置是否可以通过返回键退出对话框
				prodialog.setCancelable(true);
				
				//显示ProgressDialog
				prodialog.show();
				break;

			default:
				break;
			}
			tvShow.setText("第一进度："+(int)(progress.getProgress()/(float)progress.getMax()*100)+"%  "+"第二进度："+(int)(progress.getSecondaryProgress()/(float)progress.getMax()*100)+"%");
		}  
	  
//	    @Override  
//	    public boolean onCreateOptionsMenu(Menu menu) {  
//	        getMenuInflater().inflate(R.menu.main, menu);  
//	        return true;  
//	    }

}
