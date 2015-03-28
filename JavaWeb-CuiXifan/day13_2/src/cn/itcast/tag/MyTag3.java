/*
 * 说明：自定义标签，有标签体的标签。
 */
package cn.itcast.tag;

import java.io.IOException;
import java.io.WriteAbortedException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag3 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		out.print("<br>***************<br>");
		this.getJspBody().invoke(out);
		out.print("<br>***************<br>");
	}
}
