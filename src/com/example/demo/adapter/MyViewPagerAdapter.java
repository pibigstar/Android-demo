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
	//����view����
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
	
	//ʵ����һ��ҳ��
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		container.addView(listView.get(position));
		return listView.get(position);
	}

	//����һ��View
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(listView.get(position));
	}
	
	//��ʾÿ��ҳ���ı���
	@Override
	public CharSequence getPageTitle(int position) {
		return listTab.get(position);
	}
}
