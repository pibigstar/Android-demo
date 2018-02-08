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
		setTitle("展示网页");
		
		init();
	}

	private void init() {
		webView = (WebView) findViewById(R.id.webView);
		//加载本地的网页（在文件夹assets里面放着）
		//webView.loadUrl("file:///android_asset/example.html");
		
		//加载网络上的网页
		webView.loadUrl("http://www.baidu.com");
		
		//启用javascrapt
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		//启用缓存，优先从本地缓存中读取
		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		
		//覆盖第三方或本地浏览器加载网页，让webView显示网页
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
				//返回值为true是通过webView打开，false是通过第三方打开网页
				view.loadUrl(url);
				return true;
			}
		});
		
		//设置网页加载进度条
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				//newProgress 1-100
				if (newProgress==100) {
					//加载完成
					closeDialog();
				}else {
					openDialog(newProgress);
				}
				
			}
		});
	}

	/**
	 * 重写物理按键逻辑，点击返回时返回网页的上一页
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode==KeyEvent.KEYCODE_BACK) {
			if (webView.canGoBack()) {
				webView.goBack();
				return true;
			}else {
				System.exit(0);//退出程序
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	

	//打开加载进度条
	private void openDialog(int newProgress) {
		if (dialog==null) {
			dialog = new ProgressDialog(this);
			dialog.setTitle("正在加载");
			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			dialog.setProgress(newProgress);
			dialog.show();
		}else {
			dialog.setProgress(newProgress);
		}
		
	}
	//关闭加载进度条
	private void closeDialog() {
		if (dialog!=null && dialog.isShowing()) {
			dialog.dismiss();//取消进度条对话框
			dialog = null;
		}
	}

}
