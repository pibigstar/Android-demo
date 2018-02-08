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
		setTitle("������ʾ��ҳ����--��΢��");
		
		viewpager = (ViewPager) findViewById(R.id.viewPager);
		listView = new ArrayList<View>();
		
		/**
		 * ��������ҳ����ΪView����ŵ�viewPager����
		 */
		View view1 = View.inflate(this, R.layout.viewpager1, null);
		View view2 = View.inflate(this, R.layout.viewpager2, null);
		View view3 = View.inflate(this, R.layout.viewpager3, null);
		listView.add(view1);
		listView.add(view2);
		listView.add(view3);
		
		
		//ΪViewPagerѡ����ñ���
		listTab = new ArrayList<String>();
		listTab.add("��һҳ");
		listTab.add("�ڶ�ҳ");
		listTab.add("����ҳ");
		
		//ΪPagerTabStrip��������
		pagerTab = (PagerTabStrip) findViewById(R.id.pagerTab);
		pagerTab.setBackgroundColor(Color.YELLOW);
		pagerTab.setTextColor(Color.RED);
		pagerTab.setTabIndicatorColor(Color.BLUE);//�Ǹ�С���ߵ���ɫ
		
		/**
		 * ����һ��ViewPager��������
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
		Toast.makeText(this, "��ǰ�ǵ�"+(arg0+1)+"��ҳ��", Toast.LENGTH_SHORT).show();
	}

}
