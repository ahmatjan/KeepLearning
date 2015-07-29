/**
 * 说明：为注解添加@Retention注解，设置注解的保留位置
 */
package cn.itcast.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MyAnno61
public class Demo6 {
}

//为注解添加Retention注解，设置注解运行时也可以保留
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno61 {
}
