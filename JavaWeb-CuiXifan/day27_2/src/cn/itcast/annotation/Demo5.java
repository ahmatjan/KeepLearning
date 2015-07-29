/**
 * 说明：为注解添加@Target注解，限制注解的使用范围
 */
package cn.itcast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@MyAnno51
public class Demo5 {
	@MyAnno51
	public void fun1() {
	}
}

//为注解标注@Target注解，限定注解只能在以下几个地方使用
@Target(value={ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@interface MyAnno51 {
}