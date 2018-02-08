package com.example.demo.activity;

import com.example.demo.R;
import com.example.demo.R.id;
import com.example.demo.R.layout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity{
	
	private WebView webView;
	private String url = "http://www.baidu.com";
	private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_webview);
		setTitle("չʾ��ҳ");
		
		init();
	}

	private void init() {
		webView = (WebView) findViewById(R.id.webView);
		//���ر��ص���ҳ�����ļ���assets������ţ�
		//webView.loadUrl("file:///android_asset/example.html");
		
		//���������ϵ���ҳ
		webView.loadUrl("http://www.baidu.com");
		
		//����javascrapt
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		//���û��棬���ȴӱ��ػ����ж�ȡ
		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		
		//���ǵ������򱾵������������ҳ����webView��ʾ��ҳ
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
				//����ֵΪtrue��ͨ��webView�򿪣�false��ͨ������������ҳ
				view.loadUrl(url);
				return true;
			}
		});
		
		//������ҳ���ؽ�����
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				//newProgress 1-100
				if (newProgress==100) {
					//�������
					closeDialog();
				}else {
					openDialog(newProgress);
				}
				
			}
		});
	}

	/**
	 * ��д�������߼����������ʱ������ҳ����һҳ
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode==KeyEvent.KEYCODE_BACK) {
			if (webView.canGoBack()) {
				webView.goBack();
				return true;
			}else {
				System.exit(0);//�˳�����
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	

	//�򿪼��ؽ�����
	private void openDialog(int newProgress) {
		if (dialog==null) {
			dialog = new ProgressDialog(this);
			dialog.setTitle("���ڼ���");
			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			dialog.setProgress(newProgress);
			dialog.show();
		}else {
			dialog.setProgress(newProgress);
		}
		
	}
	//�رռ��ؽ�����
	private void closeDialog() {
		if (dialog!=null && dialog.isShowing()) {
			dialog.dismiss();//ȡ���������Ի���
			dialog = null;
		}
	}

}
