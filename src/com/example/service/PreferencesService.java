package com.example.service;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferencesService {
	private Context context;
	public PreferencesService(Context context){
		this.context = context;
	}
	/**
	 * 保存参数
	 * @param name	姓名
	 * @param age	年龄
	 */
	public void save(String name, Integer age) {
		// 第一个参数itcast是一个xml文件名
		SharedPreferences preferences = context.getSharedPreferences("itcast", Context.MODE_PRIVATE);
		Editor editor = preferences.edit();	// 取得编辑器对象
		editor.putString("name", name);	// 用这个方法数据是保存在内存中的
		editor.putInt("age", age);
		editor.commit();	// 把数据从内存中提交到文件中
	}
	
	/**
	 * 获取各项配置参数
	 * @return
	 */
	public Map<String, String> getPreferences() {
		Map<String, String> params = new HashMap<String, String>();
		SharedPreferences preferences = context.getSharedPreferences("itcast", Context.MODE_PRIVATE);
		params.put("name", preferences.getString("name", ""));	// 后一个参数：如果文件中不存在第一个参数，则使用第二个参数的值
		params.put("age", String.valueOf(preferences.getInt("age", 0)));
		
		return params;
	}

}
