package cn.itcast.domain;

public class Province {
	private String pid;
	private String name;
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Province(String pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Province [pid=" + pid + ", name=" + name + "]";
	}
}
