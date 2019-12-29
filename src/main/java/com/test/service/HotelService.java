package com.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.test.dao.HotelDao;
import com.test.dto.HotelList;
import com.test.dto.StatusResponse;

@Service
public class HotelService {
	
	@Autowired
	private HotelDao hotelDao;
	
	public List<HotelList> getList() {
		return this.hotelDao.getList();
	}
	
	@Transactional
	public Object addVehicle(HotelList list) {
		StatusResponse sr = new StatusResponse();
		this.hotelDao.addVehicle(list);
		sr.setMessage("Success");
		sr.setStatus(200);
		return sr;
		
	}
	
}
