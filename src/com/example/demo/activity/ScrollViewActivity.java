package com.example.demo.activity;

import com.example.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;

public class ScrollViewActivity extends Activity{


	private ScrollView scrollView;
	private TextView txt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_scrollview);
		init();

		scrollView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()) {
				//手指按下
				case MotionEvent.ACTION_DOWN:
					break;
					//手指滑动
				case MotionEvent.ACTION_MOVE:

					//判断滑动条在顶部时
					if (scrollView.getScrollY()<=0) {
						Log.i("main", "在顶部");
					}
					//滑到底部时
					//屏幕的高度(getHeight)+滑动的距离(getScrollY) = 文本的高度(getMeasuredHeight)
					else if (scrollView.getChildAt(0).getMeasuredHeight()<=scrollView.getHeight()+scrollView.getScrollY()) {
						Log.i("main", "scrollView.getChildAt(0).getMeasuredHeight()="+scrollView.getChildAt(0).getMeasuredHeight()
								+"getHeight()="+scrollView.getHeight()
								+"scrollView.getScrollY()="+scrollView.getScrollY());
						txt.append("我是新增加的。。。。。。。。。。。。。。。。。");
					}

					break;
					//手指抬起
				case MotionEvent.ACTION_UP:
					break;
				}

				return false;
			}
		});

	}

	private void init() {
		scrollView = (ScrollView) findViewById(R.id.scrollView);
		txt = (TextView) findViewById(R.id.scrollview_txt);

		//得到string.xml文件里面配置的值
		txt.setText(getResources().getString(R.string.content));

	}

}
