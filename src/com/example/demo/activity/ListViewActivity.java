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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListViewActivity extends Activity{
	
	private List<Map<String, Object>> dataList;
	
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.demo_listview);
		setTitle("列表显示");
		
		dataList = new ArrayList();
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(), R.layout.listview_item, new String[] {"listViewPic","listViewTxt"}, new int[] {R.id.listViewPic,R.id.listViewTxt});
		
		listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(simpleAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String txt = listView.getItemAtPosition(position).toString();
				Toast.makeText(ListViewActivity.this, txt, Toast.LENGTH_LONG).show();
			}
		});
		
	}
	
	private List<Map<String, Object>> getData(){
		
		for (int i = 0; i < 10; i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("listViewPic", R.drawable.ic_launcher);
			map.put("listViewTxt", "列表" + i);
			dataList.add(map);
		}
		
		
		return dataList;
	}

}
