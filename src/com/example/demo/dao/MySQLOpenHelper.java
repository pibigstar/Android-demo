package com.example.demo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLOpenHelper extends SQLiteOpenHelper{

	public MySQLOpenHelper(Context context, String name) {
		super(context, name, null, 1);
		// TODO Auto-generated constructor stub
	}

	//����ʼ�����½����ݿ�ͱ�һ��ֻ�����һ��
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		
	}

	//���ݿ�汾���º���Զ�����
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
