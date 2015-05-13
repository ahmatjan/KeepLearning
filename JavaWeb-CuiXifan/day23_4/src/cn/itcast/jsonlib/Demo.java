package cn.itcast.jsonlib;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

/*
 * 学习使用JSON-LIB小工具
 */
public class Demo {
	//JSONObject: 当map来用
	@Test
	public void fun1() {
		JSONObject map = new JSONObject();
		map.put("name", "ZhangSan");
		map.put("Age", 23);
		map.put("sex", "male");

		System.out.println(map.toString());
	}

	//JSONObject: 可以把一个JavaBean转换成JSONObject
	@Test
	public void fun2() {
		Person p = new Person("ZhangSan", 23, "male");
		JSONObject map = JSONObject.fromObject(p);

		System.out.println(map);
	}

	//JSONArray: 当list来用
	@Test
	public void fun3() {
		JSONArray list = new JSONArray();
		list.add(new Person("ZhangSan", 23, "male"));
		list.add(new Person("LiSi", 32, "female"));

		System.out.println(list.toString());
	}

	//JSONArray: 可以把一个List转换成JSONArray
	@Test
	public void fun4() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("ZhangSan", 23, "male"));
		personList.add(new Person("LiSi", 32, "female"));
		JSONArray list = JSONArray.fromObject(personList);

		System.out.println(list);
	}

}
