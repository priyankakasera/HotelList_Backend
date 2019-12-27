package com.test.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.dao.HotelDao;
import com.test.dto.HotelList;

@Repository
public class HotelDaoImpl implements HotelDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<HotelList> getList() {
		 List<HotelList> list=new ArrayList<HotelList>();  
		 list=hibernateTemplate.loadAll(HotelList.class);  
		 return list;  
	}
	
	public void addVehicle(HotelList list) {
		hibernateTemplate.save(list);
	}
}
