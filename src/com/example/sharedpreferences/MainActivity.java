package com.example.sharedpreferences;

import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.service.PreferencesService;

public class MainActivity extends Activity {
	private EditText nameText;
	private EditText ageText;
	private PreferencesService service ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nameText = (EditText) findViewById(R.id.edt_name);
		ageText = (EditText) findViewById(R.id.edt_age);
		service = new PreferencesService(this);
		
		Map<String, String> params = service.getPreferences();
		nameText.setText(params.get("name"));
		ageText.setText(params.get("age"));
	}
	// 点击按钮触发的保存方法，该方法把数据存储在xml文件中
	public void save(View v){
		String name = nameText.getText().toString();
		String age = ageText.getText().toString();
		// 把一个String的数据类型转换为一个int类型
		service.save(name, Integer.valueOf(age));
		Toast.makeText(getApplicationContext(), "保存成功", 1).show();
	}

}
