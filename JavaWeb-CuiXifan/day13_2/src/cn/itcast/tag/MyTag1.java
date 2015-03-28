/*
 * 说明：自定义标签，实现SimpleTag接口。
 */
package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyTag1 implements SimpleTag {
	private PageContext pageContext;
	private JspFragment body;

	//所有set方法会在doTag方法前被tomcat调用！
	public void doTag() throws JspException, IOException {
		pageContext.getOut().println("Hello Tag1!");
	}

	public JspTag getParent() {
		return null;
	}

	public void setJspBody(JspFragment body) {
		this.body = body;
	}

	public void setJspContext(JspContext context) {
		this.pageContext = (PageContext)context;
	}

	//暂时用不到
	public void setParent(JspTag arg0) { }

}
