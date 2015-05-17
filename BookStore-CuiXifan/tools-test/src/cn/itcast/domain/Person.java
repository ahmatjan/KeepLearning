package cn.itcast.domain;

public class Person {
	private String id;
	private String name;
	private int age;
	private String gender;
	private String yyy;

	private Address address;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String id, String name, int age, String gender, String yyy) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.yyy = yyy;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getYyy() {
		return yyy;
	}
	public void setYyy(String yyy) {
		this.yyy = yyy;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", yyy=" + yyy + ", address="
				+ address + "]";
	}
	
}
