package cn.itcast.goods.comment.domain;

import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.user.domain.User;

/**
 * 图书评价实体类
 * @author jason
 *
 */
public class Comment {
	private User user;		//评价用户
	private Book book;		//图书
	private String content; //评价内容
	private String commenttime; //评价时间
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(User user, Book book, String content, String commenttime) {
		super();
		this.user = user;
		this.book = book;
		this.content = content;
		this.commenttime = commenttime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}
	@Override
	public String toString() {
		return "Comment [user=" + user + ", book=" + book + ", comment="
				+ content + ", commenttime=" + commenttime + "]";
	}

	

}
