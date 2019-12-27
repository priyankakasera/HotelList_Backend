package com.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.HotelDao;
import com.test.dto.HotelList;

@Service
public class HotelService {
	
	@Autowired
	private HotelDao hotelDao;
	
	public List<HotelList> getList() {
		return this.hotelDao.getList();
	}
	
	@Transactional
	public void addVehicle(HotelList list) {
		this.hotelDao.addVehicle(list);
	}
}
