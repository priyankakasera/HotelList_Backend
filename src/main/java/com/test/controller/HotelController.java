package com.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.test.dto.HotelList;
import com.test.dto.StatusResponse;
import com.test.service.HotelService;
import com.test.utility.JsonConvert;


@Controller
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	@Autowired
	JsonConvert jsonConverter;
	
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getList() {
		List<HotelList> list = this.hotelService.getList();
		String result = this.jsonConverter.toJson(list);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public String addVehicle(@RequestBody String request) {
		System.out.println(request);
		HotelList list = (HotelList) JsonConvert.deserializeToJson(request, HotelList.class);
		StatusResponse sr = (StatusResponse) this.hotelService.addVehicle(list);
		Gson gson = new Gson();
		String json = gson.toJson(sr);
		System.out.println(json);
		return "{\"answer\":"+json+"}";
	}
	
	
}
