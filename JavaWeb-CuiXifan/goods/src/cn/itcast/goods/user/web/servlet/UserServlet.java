package cn.itcast.goods.user.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.user.domain.User;
import cn.itcast.goods.user.service.UserService;
import cn.itcast.servlet.BaseServlet;

/**
 * 用户模块控制层
 * @author jason
 *
 */
public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();

	/**
	 * 校验用户名是否被注册
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateLoginname(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginname = request.getParameter("loginname");
		boolean result = userService.ajaxValidateLoginname(loginname);
		response.getWriter().print(result);		//返回false代表已被注册，返回true代表未被注册
		return null;
	}

	/**
	 * 校验Email是否被注册
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		boolean result = userService.ajaxValidateEmail(email);
		response.getWriter().print(result);		//返回false代表已被注册，返回true代表未被注册
		return null;
	}

	/**
	 * 校验验证码
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateVerifyCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vCode = (String) request.getSession().getAttribute("vCode");
		String verifyCode = request.getParameter("verifyCode");
		response.getWriter().print(vCode.equalsIgnoreCase(verifyCode));
		return null;
	}

	/**
	 * 进行注册
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String regist(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1.封装表单数据到JavaBean中
		 * 2.校验参数
		 *	如果有参数错误，则把map保存到request域中，然后转发到regist.jsp
		 * 3.调用userService完成业务
		 * 4.保存成功信息
		 * 5.转发到msg.jsp
		 */
		User user = CommonUtils.toBean(req.getParameterMap(), User.class);

		Map<String, String> errors = validateParameters(user, req.getSession());
		if (errors.size() > 0) {
			req.setAttribute("user", user);
			req.setAttribute("errors", errors);
			return "f:/jsps/user/regist.jsp";
		}

		userService.regist(user);

		req.setAttribute("code", "success");
		req.setAttribute("msg", "注册成功，请马上到邮箱激活！");

		return "f:/jsps/msg.jsp";
	}

	private Map<String, String> validateParameters(User user, HttpSession session) {
		/*
		 * 1.校验用户名
		 * 2.校验密码
		 * 3.校验确认密码
		 * 4.校验Email
		 * 5.校验验证码
		 */
		Map<String, String> errors = new HashMap<String, String>();

		String loginname = user.getLoginname();
		if (loginname == null || loginname.trim().isEmpty()) {
			errors.put("loginname", "用户名不能为空");
		} else if (loginname.length() < 3 || loginname.length() > 20) {
			errors.put("loginname", "用户名长度必须在3~20之间");
		} else if (!userService.ajaxValidateLoginname(loginname)) {
			errors.put("loginname", "用户名已被注册");
		}

		String loginpass = user.getLoginpass();
		if (loginpass == null || loginpass.trim().isEmpty()) {
			errors.put("loginpass", "密码不能为空");
		} else if (loginpass.length() < 3 || loginpass.length() > 20) {
			errors.put("loginpass", "用户名长度必须在3~20之间");
		}

		String reloginpass = user.getReloginpass();
		if (reloginpass == null || reloginpass.trim().isEmpty()) {
			errors.put("reloginpass", "密码不能为空");
		} else if (reloginpass.length() < 3 || reloginpass.length() > 20) {
			errors.put("reloginpass", "用户名长度必须在3~20之间");
		} else if (!reloginpass.equals(loginpass)) {
			errors.put("reloginpass", "两次密码输入不一致");
		}

		String email = user.getEmail();
		if (email == null || email.trim().isEmpty()) {
			errors.put("email", "Email不能为空");
		} else if (email.length() < 3 || email.length() > 20) {
			errors.put("email", "Email必须在3~20之间");
		} else if (!userService.ajaxValidateEmail(email)) {
			errors.put("email", "Email已被注册");
		}

		String verifyCode = user.getVerifyCode();
		String vCode = (String) session.getAttribute("vCode");
		if (verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空");
		} else if (verifyCode.length() != 4) {
			errors.put("verifyCode", "验证码必须为4");
		} else if (!verifyCode.equalsIgnoreCase(vCode)) {
			errors.put("verifyCode", "验证码错误");
		}

		return errors;
	}
}
