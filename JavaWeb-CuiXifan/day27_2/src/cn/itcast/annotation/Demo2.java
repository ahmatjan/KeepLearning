/**
 * 说明：学习定义和使用注解。
 */
package cn.itcast.annotation;


//使用注解
@MyAnno21
public class Demo2 {
	@MyAnno21
	private String name;
	
	@MyAnno21
	public Demo2() {
	}
	
	@MyAnno21
	public void fun1(@MyAnno21 String param) {
		@MyAnno21
		String var;
	}
}


//使用注解
@interface MyAnno21 {
}