package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.dto.HotelList;

public interface HotelDao {
	public List<HotelList> getList();
	public void addVehicle(HotelList list);
	
}
