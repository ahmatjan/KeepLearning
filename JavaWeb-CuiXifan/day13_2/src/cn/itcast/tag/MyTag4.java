package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag4 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("Hello Tag4!<br>");
		this.getJspContext().getOut().print("只能看到我，下面什么也没有～！");
		throw new SkipPageException();
	}
}
