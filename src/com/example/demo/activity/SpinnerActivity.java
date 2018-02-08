package com.example.demo.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.R;
import com.example.demo.R.id;
import com.example.demo.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * 下拉列表框
 * @author pibigstar
 *
 */
public class SpinnerActivity extends Activity{
	private Spinner spinner;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("下拉列表框");
		setContentView(R.layout.demo_spinner);
		
		spinner = (Spinner) findViewById(R.id.spinner);
		
		List<String> list = new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("深圳");
		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(SpinnerActivity.this,adapter.getItem(position), Toast.LENGTH_SHORT).show();
			}
		});
			
	}
}
