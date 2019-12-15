package com.test.utility;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import com.test.dto.HotelList;

@Component
public class JsonConvert {
	
	public String toJson(List<HotelList> emp) {
		Gson gson = new Gson();
		String json = gson.toJson(emp);
		System.out.println(json);
		return "{\"answer\":"+json+"}";
	}
	
	public static Object deserializeToJson(String object,Class<?> clazz){
		Gson gson = new Gson();
		return gson.fromJson(object, clazz);
	}
}
