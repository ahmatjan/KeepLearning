package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 省市联动
 */
public class EServlet extends HttpServlet {

	//省下拉菜单
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			//解析得到document对象
			SAXReader reader = new SAXReader();
			InputStream input = this.getClass().getResourceAsStream("/china.xml");
			Document doc = (Document) reader.read(input);

			//进行查询
			List<Attribute> provinceList = doc.selectNodes("//province/@name");

			//发送结果
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < provinceList.size(); i++) {
				sb.append(provinceList.get(i).getValue());
				if (i < provinceList.size() - 1)
					sb.append(",");
			}
			response.getWriter().print(sb);
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

	//市下拉菜单
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");

		try {
			//获得Document
			SAXReader reader = new SAXReader();
			InputStream input = this.getClass().getResourceAsStream("/china.xml");
			Document doc = reader.read(input);

			//解析结果
			String province = request.getParameter("province");
			Element provinceElement = (Element) doc.selectSingleNode("//province[@name='" + province + "']");
			String xml = provinceElement.asXML();

			//返回XML
			response.getWriter().print(xml);

		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
}
