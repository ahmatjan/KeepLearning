package cn.itcast.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.itcast.domain.City;
import cn.itcast.domain.Province;
import cn.itcast.service.Service;

/*
 * Servlet层
 */
public class ProvinceCityServlet extends HttpServlet {
	private Service service = new Service();

	//省下拉菜单
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		List<Province> provinceList = service.findAllProvince();
		String json =  JSONArray.fromObject(provinceList).toString();
		response.getWriter().print(json);
	}

	//市下拉菜单
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		String pid = request.getParameter("pid");
		List<City> cityList = service.findCityByProvince(pid);
		String json = JSONArray.fromObject(cityList).toString();
		response.getWriter().print(json);
	}
}
