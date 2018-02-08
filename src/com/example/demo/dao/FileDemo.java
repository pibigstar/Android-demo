package com.example.demo.dao;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;

//将数据写入到文件中
public class FileDemo extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	private void writeToFiles(String fileName,String content,int mod) {
		try {
			FileOutputStream fos = openFileOutput(fileName,mod);
			fos.write(content.getBytes());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private String readFromFiles(String fileName) {
		String content = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			FileInputStream fis = openFileInput(fileName);
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len=fis.read(buff))!=-1) {
				baos.write(buff);
			}
			content = baos.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	
}
