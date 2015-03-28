/*
 * 说明：通过继承SimpleTagSupport来实现自定义标签，更加的方便。
 */
package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//SimpleTagSupport已经实现了大部分接口函数，子类只需重写doTag()即可
public class MyTag2 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("Hello Tag2!");
	}
}
