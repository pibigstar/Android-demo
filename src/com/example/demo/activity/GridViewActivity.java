package com.example.demo.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.R;
import com.example.demo.R.drawable;
import com.example.demo.R.id;
import com.example.demo.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class GridViewActivity extends Activity implements OnItemClickListener{
	
	private GridView gridView;
	private SimpleAdapter adapter;
	private int[] icons = {R.drawable.calendar,
			R.drawable.camera,R.drawable.clock,
			R.drawable.games_control,R.drawable.messenger,
			R.drawable.ringtone,R.drawable.settings,
			R.drawable.speech_balloon,R.drawable.weather,
			R.drawable.world,R.drawable.youtube,R.drawable.address_book};
	private String[] iconNames = {"日历","相机","时钟","游戏","联系人","音乐","设置","信息","天气","浏览器","视频","电子书"};
	
	private List<Map<String, Object>> dataList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("GridView网格显示");
		
		setContentView(R.layout.demo_gridview);
		dataList = new ArrayList<Map<String,Object>>();
		gridView = (GridView) findViewById(R.id.gridView);
		
		adapter = new SimpleAdapter(this,getData(), R.layout.gridview_item, new String[] {"icon","iconName"}, new int[] {R.id.icon,R.id.iconName});
		gridView.setAdapter(adapter);
		
		gridView.setOnItemClickListener(this);
	
	}
	private List<Map<String, Object>> getData(){
		for(int i=0;i<icons.length;i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("icon",icons[i]);
			map.put("iconName", iconNames[i]);
			dataList.add(map);
		}
		return dataList;
	}
	//点击事件
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(this, iconNames[position],Toast.LENGTH_SHORT).show();
	}
}
