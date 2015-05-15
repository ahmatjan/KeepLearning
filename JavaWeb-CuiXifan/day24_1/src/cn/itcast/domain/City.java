package cn.itcast.domain;

public class City {
	private String cid;
	private String name;
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(String cid, String name) {
		super();
		this.cid = cid;
		this.name = name;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "City [cid=" + cid + ", name=" + name + "]";
	}
}
