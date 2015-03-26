/*
 * 说明：JavaBean的使用说明。
 * 		1. 必须要有无参构造器。
 * 		2. 必须为参数提供 get/set 方法，只提供get方法也可以。
 * 		3. 属性：提供 get/set 方法的称之为属性，不一定为成员变量。名称为get/set后的字符(第一个字母改为小写)。
 */
package cn.itcast.domain;

public class Person {
	private String name;
	private int age;
	private String gender;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender
				+ "]";
	}

	

}
