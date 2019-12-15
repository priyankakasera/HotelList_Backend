package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.HotelList;
import com.test.service.HotelService;
import com.test.utility.JsonConvert;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	@Autowired
	JsonConvert jsonConverter;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public String getList() {
		List<HotelList> list = this.hotelService.getList();
		String result = jsonConverter.toJson(list);
		System.out.println(result);
		return result;
	}
}
