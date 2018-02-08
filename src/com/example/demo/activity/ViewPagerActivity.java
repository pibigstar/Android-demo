package com.example.demo.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.R;
import com.example.demo.adapter.MyViewPagerAdapter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.Toast;

public class ViewPagerActivity extends Activity implements OnPageChangeListener{
	
	private ViewPager viewpager;
	private List<View> listView;
	private List<String> listTab;
	private PagerTabStrip pagerTab;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_viewpager);
		setTitle("滑动显示分页数据--防微信");
		
		viewpager = (ViewPager) findViewById(R.id.viewPager);
		listView = new ArrayList<View>();
		
		/**
		 * 将这三个页面作为View对象放到viewPager里面
		 */
		View view1 = View.inflate(this, R.layout.viewpager1, null);
		View view2 = View.inflate(this, R.layout.viewpager2, null);
		View view3 = View.inflate(this, R.layout.viewpager3, null);
		listView.add(view1);
		listView.add(view2);
		listView.add(view3);
		
		
		//为ViewPager选项卡设置标题
		listTab = new ArrayList<String>();
		listTab.add("第一页");
		listTab.add("第二页");
		listTab.add("第三页");
		
		//为PagerTabStrip设置属性
		pagerTab = (PagerTabStrip) findViewById(R.id.pagerTab);
		pagerTab.setBackgroundColor(Color.YELLOW);
		pagerTab.setTextColor(Color.RED);
		pagerTab.setTabIndicatorColor(Color.BLUE);//那个小横线的颜色
		
		/**
		 * 创建一个ViewPager的适配器
		 */
		MyViewPagerAdapter adapter = new MyViewPagerAdapter(listView,listTab);
		
		viewpager.setAdapter(adapter);
		
		viewpager.setOnPageChangeListener(this);
	
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "当前是第"+(arg0+1)+"个页面", Toast.LENGTH_SHORT).show();
	}

}
