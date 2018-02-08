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
				//��ָ����
				case MotionEvent.ACTION_DOWN:
					break;
					//��ָ����
				case MotionEvent.ACTION_MOVE:

					//�жϻ������ڶ���ʱ
					if (scrollView.getScrollY()<=0) {
						Log.i("main", "�ڶ���");
					}
					//�����ײ�ʱ
					//��Ļ�ĸ߶�(getHeight)+�����ľ���(getScrollY) = �ı��ĸ߶�(getMeasuredHeight)
					else if (scrollView.getChildAt(0).getMeasuredHeight()<=scrollView.getHeight()+scrollView.getScrollY()) {
						Log.i("main", "scrollView.getChildAt(0).getMeasuredHeight()="+scrollView.getChildAt(0).getMeasuredHeight()
								+"getHeight()="+scrollView.getHeight()
								+"scrollView.getScrollY()="+scrollView.getScrollY());
						txt.append("���������ӵġ���������������������������������");
					}

					break;
					//��ָ̧��
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

		//�õ�string.xml�ļ��������õ�ֵ
		txt.setText(getResources().getString(R.string.content));

	}

}
