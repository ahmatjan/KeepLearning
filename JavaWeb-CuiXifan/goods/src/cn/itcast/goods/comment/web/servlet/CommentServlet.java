package cn.itcast.goods.comment.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.comment.domain.Comment;
import cn.itcast.goods.comment.service.CommentService;
import cn.itcast.goods.user.domain.User;
import cn.itcast.servlet.BaseServlet;

/**
 * 评论模块WEB层
 * @author jason
 *
 */
public class CommentServlet extends BaseServlet {
	private CommentService commentService = new CommentService();

	/**
	 * 获取某本书的全部评论
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String load(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String bid = req.getParameter("bid");

		List<Comment> commentList = commentService.load(bid);
		req.setAttribute("commentList", commentList);
		req.setAttribute("bid", bid);

		User sessionUser = (User) (req.getSession().getAttribute("sessionUser"));
		req.setAttribute("user", sessionUser);

		return "f:/jsps/comment/comment.jsp";
	}

	/**
	 * 添加评论
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Comment comment = CommonUtils.toBean(req.getParameterMap(), Comment.class);

		User sessionUser = (User) (req.getSession().getAttribute("sessionUser"));
		if (sessionUser == null) {
			req.setAttribute("code", "error");
			req.setAttribute("msg", "您尚未登陆，请登录后评论～");
			return "f:/jsps/msg.jsp";
		}
		String uid = sessionUser.getUid();

		comment.setUser(sessionUser);
		Book book = new Book();
		String bid = req.getParameter("bid");
		book.setBid(bid);
		comment.setBook(book);

		if (commentService.findCommentByUidAndBid(uid, bid) != null) {
			req.setAttribute("code", "error");
			req.setAttribute("msg", "您已评论过此书，不能再次评论该图书～！");
			return "f:/jsps/msg.jsp";
		}

		String commenttime = String.format("%tF %<tT", new Date());
		comment.setCommenttime(commenttime);

		req.setAttribute("user", sessionUser);

		commentService.add(comment);

		return load(req, resp);
	}


}

