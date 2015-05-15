package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.Dao;
import cn.itcast.domain.City;
import cn.itcast.domain.Province;

/*
 * 逻辑层
 */
public class Service {
	private Dao dao = new Dao();

	public List<Province> findAllProvince() {
		return dao.findAllProvince();
	}

	public List<City> findCityByProvince(String pid) {
		return dao.findCityByProvince(pid);
	}

}
