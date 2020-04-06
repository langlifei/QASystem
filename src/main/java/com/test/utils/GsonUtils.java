package com.test.utils;

import java.lang.reflect.Type;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//gson的工具类
public class GsonUtils {
	//线程安全的
	private static final Gson GSON;
	static{
		GSON = new GsonBuilder()     
	            .setDateFormat("yyyy-MM-dd HH:mm:ss")//序列化日期格式  "yyyy-MM-dd"
	            .create();
	}
	
	//获取gson解析器
	public static Gson getGson(){
		return GSON;
	}
	
	//对象转换为json
	public static String toJson(Object object){
		return GSON.toJson(object);
	}
	
	//反序列化
	//JSON转换为对象1--普通类型
	public static <T> T fromJson(String json, Class<T> classOfT){
		return GSON.fromJson(json, classOfT);
	}
	//JSON转换为对象-针对泛型的类型
	public static <T> T fromJson(String json, Type typeOfT){
		return GSON.fromJson(json, typeOfT);
	}
}
