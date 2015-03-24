package cn.itcast.servlet.uuid;

import java.util.UUID;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;

public class Demo {
	//生成一个不重复的32位随机数
	@Test
	public void func() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		str = str.replace("-", "");
		str = str.toUpperCase();
		System.out.println(str);
	}


	//生成一个不重复的32位随机数，并把功能封装在CommonUtils中
	@Test
	public void func2() {
		System.out.println(CommonUtils.uuid());
	}

}
