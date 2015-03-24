package cn.itcast.commons;

import java.util.UUID;

public class CommonUtils {

	//生成一个不重复的32位随机数
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
