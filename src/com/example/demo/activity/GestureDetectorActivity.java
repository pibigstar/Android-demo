package com.example.demo.activity;

import com.example.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class GestureDetectorActivity extends Activity{
	private ImageView img;
	private GestureDetector detector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_gesture);
		setTitle("手势识别");
		img = (ImageView) findViewById(R.id.gesture_img);
		detector = new GestureDetector(this, new MyGesture());
		img.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				detector.onTouchEvent(event);//将触摸事件转发到detector接口
				return true;
			}
		});
	}
	
	class MyGesture extends SimpleOnGestureListener{
		//监控滑动
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			//手指按下时的x坐标大于手机抬起时的x坐标，从右向左滑
			if (e1.getX()-e2.getX()>50) {
				Toast.makeText(GestureDetectorActivity.this, "从右向左滑动", 1000).show();
			}else if (e2.getX()-e1.getX()>50){
				Toast.makeText(GestureDetectorActivity.this, "从左向右滑动", 1000).show();
			}
			return super.onFling(e1, e2, velocityX, velocityY);
		}
	}

}
