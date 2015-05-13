package cn.itcast.xstream;

import java.util.ArrayList;
import java.util.List;

public class Province {
	private String name;
	private List<City> cities = new ArrayList<City>();

	public Province() {
		super();
	}
	public Province(String name, List<City> cities) {
		super();
		this.name = name;
		this.cities = cities;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public void addCity(City city) {
		this.cities.add(city);
	}
	@Override
	public String toString() {
		return "Province [name=" + name + ", cities=" + cities + "]";
	}
}
