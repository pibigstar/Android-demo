package com.example.demo.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyViewPagerAdapter extends PagerAdapter{

	private List<View> listView;
	private List<String> listTab;
	public MyViewPagerAdapter(List<View> listView, List<String> listTab) {
		this.listView = listView;
		this.listTab = listTab;
	}
	//返回view数量
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listView.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}
	
	//实例化一个页卡
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		container.addView(listView.get(position));
		return listView.get(position);
	}

	//销毁一个View
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(listView.get(position));
	}
	
	//显示每个页卡的标题
	@Override
	public CharSequence getPageTitle(int position) {
		return listTab.get(position);
	}
}
