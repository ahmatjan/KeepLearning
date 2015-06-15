package cn.itcast.goods.comment.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.comment.domain.Comment;
import cn.itcast.goods.user.domain.User;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 评论模块实体类
 * @author jason
 *
 */
public class CommentDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 获取一本书的所有评论
	 * @param bid
	 * @return
	 * @throws SQLException 
	 */
	public List<Comment> load(String bid) throws SQLException {
		String sql = "SELECT * FROM t_comment c, t_user u WHERE bid=? AND c.uid=u.uid ORDER BY commenttime";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), bid);

		List<Comment> commentList = toCommentList(mapList);

		return commentList;
	}

	/**
	 * mapList转化为commentList
	 * @param mapList
	 * @return
	 */
	private List<Comment> toCommentList(List<Map<String, Object>> mapList) {
		List<Comment> commentList = new ArrayList<Comment>();
		for (Map<String, Object> map : mapList) {
			commentList.add(toComment(map));
		}

		return commentList;
	}

	/**
	 * 把map转化成为Comment
	 * @param map
	 * @return
	 */
	private Comment toComment(Map<String, Object> map) {
		User user = CommonUtils.toBean(map, User.class);
		Comment comment = CommonUtils.toBean(map, Comment.class);
		comment.setUser(user);

		return comment;
	}

	/**
	 * 添加评论
	 * @param comment
	 * @throws SQLException 
	 */
	public void add(Comment comment) throws SQLException {
		String sql = "INSERT INTO t_comment VALUES(?,?,?,?)";
		Object[] params = {comment.getUser().getUid(), comment.getBook().getBid(),
				comment.getContent(), comment.getCommenttime()};
		qr.update(sql, params);
	}

	/**
	 * 根据uid和bid查找评论
	 * @param uid
	 * @param bid
	 * @return
	 * @throws SQLException 
	 */
	public Comment findCommentByUidAndBid(String uid, String bid) throws SQLException {
		String sql = "SELECT * FROM t_comment WHERE uid=? AND bid=?";

		return qr.query(sql, new BeanHandler<Comment>(Comment.class), uid, bid);
	}

}
