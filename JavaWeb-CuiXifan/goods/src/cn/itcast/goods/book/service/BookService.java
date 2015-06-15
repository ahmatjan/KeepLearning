package cn.itcast.goods.book.service;

import java.sql.SQLException;

import cn.itcast.goods.book.dao.BookDao;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.pager.PageBean;


/**
 * 图书模块业务层
 * @author jason
 *
 */
public class BookService {
	private BookDao bookDao = new BookDao();

	/**
	 * 根据分类查询图书
	 * @param pc
	 * @param cid
	 * @return 
	 */
	public PageBean<Book> findByCategory(int pc, String cid) {
		try {
			return bookDao.findByCategory(pc, cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据书名查询图书
	 * @param pc
	 * @param bname
	 * @return
	 */
	public PageBean<Book> findByBname(int pc, String bname) {
		try {
			return bookDao.findByBname(pc, bname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据作者查询图书
	 * @param pc
	 * @param bname
	 * @return
	 */
	public PageBean<Book> findByAuthor(int pc, String author) {
		try {
			return bookDao.findByAuthor(pc, author);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据出版社查询图书
	 * @param pc
	 * @param bname
	 * @return
	 */
	public PageBean<Book> findByPress(int pc, String press) {
		try {
			return bookDao.findByPress(pc, press);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 组合查询图书
	 * @param pc
	 * @param bname
	 * @return
	 */
	public PageBean<Book> findByCombination(int pc, Book book) {
		try {
			return bookDao.findByCombination(pc, book);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载图书（查看图书详细）
	 * @param bid
	 * @return
	 */
	public Book load(String bid) {
		try {
			return bookDao.findByBid(bid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑图书
	 * @param book
	 */
	public void edit(Book book) {
		try {
			bookDao.edit(book);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加图书
	 * @param book
	 */
	public void add(Book book) {
		try {
			bookDao.add(book);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 删除图书
	 * @param bid
	 */
	public void delete(String bid) {
		try {
			bookDao.delete(bid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
