package com.example.demo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLOpenHelper extends SQLiteOpenHelper{

	public MySQLOpenHelper(Context context, String name) {
		super(context, name, null, 1);
		// TODO Auto-generated constructor stub
	}

	//做初始化，新建数据库和表，一般只会调用一次
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		
	}

	//数据库版本更新后会自动调用
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
