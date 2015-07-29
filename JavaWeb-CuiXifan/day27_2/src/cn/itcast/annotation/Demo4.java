/**
 * 说明：注解的各种类型的成员变量的定义与赋值。
 */
package cn.itcast.annotation;

//注解的使用
@MyAnno41(
		a=23, 
		b="xx", 
		c=MyEnum.A, 
		d=String.class, 
		e=@MyAnno42(aa=24, bb="yy"),
		f=100				//如果有多个值，则为 f={1,2,3}
		)
public class Demo4 {

}


//注解的定义
@interface MyAnno41 {
	int a();
	String b();
	MyEnum c();
	Class d();
	MyAnno42 e();
	int[] f();
}

enum MyEnum {
	A, B, C
}

@interface MyAnno42 {
	int aa();
	String bb();
}

