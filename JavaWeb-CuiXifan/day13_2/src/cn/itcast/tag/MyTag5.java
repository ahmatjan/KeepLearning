/*
 * 说明：带属性的自定义标签，如果test属性为true则执行标签体内容。
 */
package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag5 extends SimpleTagSupport {
	private boolean test;

	@Override
	public void doTag() throws JspException, IOException {
		if (test) {
			this.getJspBody().invoke(null);
		}
	}

	public void setTest(boolean test) {
		this.test = test;
	}
}
