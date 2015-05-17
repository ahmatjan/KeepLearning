package cn.itcast.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;
import cn.itcast.domain.Person;

/*
 * 测试CommonUtils
 *	> 依赖 commons-beanutils.jar、commons-logging.jar
 */
public class CommonUtilsTest {

	//uuid(): 生成随机32位长字符串，可以用作数据库主键
	@Test
	public void testUuid() {
		String s = CommonUtils.uuid();
		System.out.println(s);
	}

	//toBean(): 由map生成JavaBean对象
	@Test
	public void testToBean() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "ZhangSan");
		map.put("age", 23);
		map.put("gender", "male");
		map.put("xxx", "XXX");

		Person p = CommonUtils.toBean(map, Person.class);
		System.out.println(p);
	}

}
