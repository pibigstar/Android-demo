package com.example.demo.dao;

import com.example.demo.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class SQLiteDemo extends Activity{
	
	private ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_sqlite);
		setTitle("数据库操作");
		list = (ListView) findViewById(R.id.dblist);
		
		SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_APPEND, null);
		db.execSQL("create table if not exists user(_id integer primary key autoincrement,name text not null,age integer not null)");
		
		ContentValues values = new ContentValues();
		values.put("name", "李白");
		values.put("age", 18);
		db.insert("user", null, values);
		values.clear();//清除之前的值，方便下一次继续存值
		values.put("name", "杜甫");
		values.put("age", 22);
		db.insert("user", null, values);
		
		//查询
		Cursor cursor = db.query("user", new String[] {"name","age" }, "_id>?", new String[] {"0"}, null, null, "age");
		if (cursor!=null) {
			String[] columns = cursor.getColumnNames();
			while (cursor.moveToNext()) {
				for (String columnName : columns) {
					Log.i("main", cursor.getString(cursor.getColumnIndex(columnName)));
				}
				
			}
		}
//		通过自定义helper来初始化表操作
//		MySQLOpenHelper helper = new MySQLOpenHelper(this, "info.db");
//		SQLiteDatabase db = helper.getWritableDatabase();
		
	}
	

}
