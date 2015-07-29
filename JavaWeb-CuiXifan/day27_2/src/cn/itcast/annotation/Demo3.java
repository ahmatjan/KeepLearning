/**
 * 说明：注解的成员变量声明与赋值。
 */
package cn.itcast.annotation;

//注解成员变量的赋值
@MyAnno31(name="zhangsan", age=23)
@MyAnno32(name="lisi")
@MyAnno33(20)				//value赋值，可以省略等号左侧的部分
public class Demo3 {
}

//注解声明成员变量
@interface MyAnno31 {
	String name();
	int age();
}

//注解成员变量设置默认值
@interface MyAnno32 {
	String name();
	int age() default 100;
}

//注解成员变量设置设置value成员变量
@interface MyAnno33 {
	int value();
	String name() default "zhangsan";
	int age() default 100;
}