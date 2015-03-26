/*
 * 说明：BeanUtils的使用示例。
 * 		1. BeanUtils可以方便的操作javaBean。
 * 		2. BeanUtils基于内省，内省基于反射。
 * 		3. 使用前要导两个包。
 */
package cn.itcast.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import cn.itcast.utils.CommonUtils;

public class Demo {
	//通过 BeanUtils 设置、获得 Bean 属性。
	@Test
	public void func() throws Exception {
		//先通过反射获取类的对象
		String className = "cn.itcast.domain.Person";
		Class clazz = Class.forName(className);
		Object bean = clazz.newInstance();

		//用BeanUtils设置属性
		BeanUtils.setProperty(bean, "name", "ZhangSan");
		BeanUtils.setProperty(bean, "age", "19");
	//	BeanUtils.setProperty(bean, "gender", "male");//遗漏设置属性
		BeanUtils.setProperty(bean, "xxx", "XXX");			//设置不存在的属性
		System.out.println(bean);

		//用BeanUtils获取属性
		System.out.println(BeanUtils.getProperty(bean, "name"));
	}

	//把map中的属性直接封装到一个对象中。
	@Test
	public void func2() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "ZhangSan");
		map.put("age", "18");
		map.put("gender", "male");

		//利用反射创建对象
		String className = "cn.itcast.domain.Person";
		Class clazz = Class.forName(className);
		Object bean = clazz.newInstance();

		//用BeanUtils把map中的属性封装到对象中
		BeanUtils.populate(bean, map);

		System.out.println(bean);
	}

	//封装一个静态方法，比func2更简单一点。
	@Test
	public void func3() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "ZhangSan");
		map.put("age", "18");
		map.put("gender", "male");
		
		Person person = CommonUtils.toBean(map, Person.class);
		System.out.println(person);
	}

}
