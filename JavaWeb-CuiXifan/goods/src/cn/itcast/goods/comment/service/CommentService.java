package cn.itcast.goods.comment.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.goods.comment.dao.CommentDao;
import cn.itcast.goods.comment.domain.Comment;

/**
 * 评论模块业务层
 * @author jason
 *
 */
public class CommentService {
	private CommentDao commentDao = new CommentDao();

	/**
	 * 获取一本书所有评论
	 * @param bid
	 * @return
	 */
	public List<Comment> load(String bid) {
		try {
			return commentDao.load(bid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加评论
	 * @param comment
	 */
	public void add(Comment comment) {
		try {
			commentDao.add(comment);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据uid和bid查找Comment
	 * @param uid
	 * @param bid
	 * @return
	 */
	public Comment findCommentByUidAndBid(String uid, String bid) {
		try {
			return commentDao.findCommentByUidAndBid(uid, bid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
