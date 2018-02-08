package com.example.demo.activity;

import com.example.demo.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class UserLoginActivity extends Activity{
	
	private EditText username;
	private EditText password;
	private CheckBox chk;
	private Button login;
	private SharedPreferences spf;
	private Editor editor;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("ÓÃ»§µÇÂ¼");
		setContentView(R.layout.demo_userlogin);
		init();
		login();
	}

	private void login() {
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String in_username = username.getText().toString().trim();
				String in_password = password.getText().toString().trim();
				if ("admin".equals(in_username)&&"admin".equals(in_password)) {
					Toast.makeText(UserLoginActivity.this, "µÇÂ¼³É¹¦", Toast.LENGTH_SHORT).show();
					if (chk.isChecked()) {
						editor.putString("username", "admin");
						editor.putString("password", "admin");
						editor.commit();
					}else {
						editor.remove("username");
						editor.remove("password");
						editor.commit();
					}
				
				}else {
					Toast.makeText(UserLoginActivity.this, "µÇÂ¼Ê§°Ü", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void init() {
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		chk = (CheckBox) findViewById(R.id.remaber_pass);
		login = (Button) findViewById(R.id.userlogin);
		spf = getSharedPreferences("userInfo",MODE_PRIVATE);
		editor = spf.edit();
		String my_username = spf.getString("username", null);
		String my_password = spf.getString("password", null);
		
		if (my_username!=null&&my_password!=null) {
			chk.setChecked(true);
			username.setText(my_username);
			password.setText(my_password);
		}else {
			chk.setChecked(false);
		}
		
	}

}
