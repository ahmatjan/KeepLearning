package cn.itcast.goods.book.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.category.domain.Category;
import cn.itcast.goods.pager.Expression;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.goods.pager.PageConstants;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 图书模块持久层
 * @author jason
 *
 */
public class BookDao {
	private QueryRunner qr = new TxQueryRunner();
	/**
	 * 根据分类查询图书
	 * @param pc
	 * @param cid
	 * @return 
	 * @throws SQLException 
	 */
	public PageBean<Book> findByCategory(int pc, String cid) throws SQLException {
		/*
		 * 1.读取配置文件中的ps
		 * 2.配置Expression对象
		 * 3.调用findByCriteria()获得pageBean对象
		 * 4.返回pageBean对象
		 */
		int ps = PageConstants.BOOK_PAGE_SIZE;
		List<Expression> criteria = new ArrayList<Expression>();
		criteria.add(new Expression("cid", "=", cid));
		return findByCriteria(pc, ps, criteria);
	}

	/**
	 * 多条件查询
	 * @param pc
	 * @param ps
	 * @param criteria
	 * @return
	 * @throws SQLException 
	 */
	private PageBean<Book> findByCriteria(int pc, int ps, List<Expression> criteria) throws SQLException {
		/*
		 * 1.根据 pc和criteria 构造SQL语句
		 * 2.SQL查询出tr\beanList
		 * 3.创建pageBean对象，并补充各成员变量
		 * 4.返回pageBean对象
		 */
		//1.
		StringBuilder sqlWhere = new StringBuilder(" WHERE 1=1");
		List<Object> params = new ArrayList<Object>();
		for (Expression criterion : criteria) {
			if (!criterion.getOperator().equalsIgnoreCase("IS NULL")) {
				sqlWhere.append(" AND ").append(criterion.getName()).append(" ")
					.append(criterion.getOperator()).append(" ?");
				params.add(criterion.getValue());
			} else {
				sqlWhere.append(" AND ").append(criterion.getName()).append(" ")
					.append(criterion.getOperator());
			}
		}
		/*
		System.out.println(sqlWhere);
		System.out.println(params);
		*/


		//2.
		String sql = "SELECT COUNT(*) FROM t_book" + sqlWhere;
		Number num = (Number) qr.query(sql, new ScalarHandler(), params.toArray());
		int tr = num.intValue();

		sql = "SELECT * FROM t_book" + sqlWhere + " ORDER BY orderBy LIMIT ?,?";
		params.add((pc - 1) * ps);
		params.add(ps);
		List<Book> beanList = qr.query(sql, new BeanListHandler<Book>(Book.class), params.toArray());

		//3.
		PageBean<Book> pageBean = new PageBean<Book>();
		pageBean.setBeanList(beanList);
		pageBean.setPc(pc);
		pageBean.setTr(tr);
		pageBean.setPs(ps);

		//4.
		return pageBean;
	}

	/**
	 * 进行findByCriteria的测试
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		List<Expression> criteria = new ArrayList<Expression>();
		criteria.add(new Expression("bid", "=", "123"));
		criteria.add(new Expression("bname", "LIKE", "%java%"));
		criteria.add(new Expression("bname", "is null", null));

		BookDao bookDao = new BookDao();;
		bookDao.findByCriteria(2, 5, criteria);

	}

	/**
	 * 根据书名进行查询
	 * @param pc
	 * @param bname
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Book> findByBname(int pc, String bname) throws SQLException {
		/*
		 * 1.读取配置文件中的ps
		 * 2.配置Expression对象
		 * 3.调用findByCriteria()获得pageBean对象
		 * 4.返回pageBean对象
		 */
		int ps = PageConstants.BOOK_PAGE_SIZE;
		List<Expression> criteria = new ArrayList<Expression>();
		criteria.add(new Expression("bname", "LIKE", "%" + bname + "%"));
		return findByCriteria(pc, ps, criteria);
	}

	/**
	 * 根据作者进行查询
	 * @param pc
	 * @param bname
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Book> findByAuthor(int pc, String author) throws SQLException {
		/*
		 * 1.读取配置文件中的ps
		 * 2.配置Expression对象
		 * 3.调用findByCriteria()获得pageBean对象
		 * 4.返回pageBean对象
		 */
		int ps = PageConstants.BOOK_PAGE_SIZE;
		List<Expression> criteria = new ArrayList<Expression>();
		criteria.add(new Expression("author", "=", author));
		return findByCriteria(pc, ps, criteria);
	}

	/**
	 * 根据出版社进行查询
	 * @param pc
	 * @param bname
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Book> findByPress(int pc, String press) throws SQLException {
		/*
		 * 1.读取配置文件中的ps
		 * 2.配置Expression对象
		 * 3.调用findByCriteria()获得pageBean对象
		 * 4.返回pageBean对象
		 */
		int ps = PageConstants.BOOK_PAGE_SIZE;
		List<Expression> criteria = new ArrayList<Expression>();
		criteria.add(new Expression("press", "=", press));
		return findByCriteria(pc, ps, criteria);
	}

	/**
	 * 组合查询
	 * @param pc
	 * @param bname
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Book> findByCombination(int pc, Book book) throws SQLException {
		/*
		 * 1.读取配置文件中的ps
		 * 2.配置Expression对象
		 * 3.调用findByCriteria()获得pageBean对象
		 * 4.返回pageBean对象
		 */
		int ps = PageConstants.BOOK_PAGE_SIZE;
		List<Expression> criteria = new ArrayList<Expression>();
		if (book.getBname() != null && !book.getBname().trim().equals(""))
			criteria.add(new Expression("bname", "LIKE", "%" + book.getBname() + "%"));
		if (book.getAuthor() != null && !book.getAuthor().trim().equals(""))
			criteria.add(new Expression("author", "LIKE", "%" + book.getAuthor() + "%"));
		if (book.getPress() != null && !book.getPress().trim().equals(""))
			criteria.add(new Expression("press", "LIKE", "%" + book.getPress() + "%"));
		if (book.getPriceRangeLeft() != 0)
			criteria.add(new Expression("currPrice", ">=", book.getPriceRangeLeft()+""));
		if (book.getPriceRangeRight() != 0)
			criteria.add(new Expression("currPrice", "<=", book.getPriceRangeRight()+""));

		return findByCriteria(pc, ps, criteria);
	}

	/**
	 * 按id查看图书
	 * @param bid
	 * @return 
	 * @throws SQLException 
	 */
	public Book findByBid(String bid) throws SQLException {
		/*
		 * 根据bid在数据库中查询结果放到map中去
		 * 把map中的数据映射到Book和Category中，并进行组装
		 * 返回Book
		 */
		String sql = "SELECT * FROM t_book b, t_category c WHERE bid=? AND b.cid=c.cid";
		Map map = qr.query(sql, new MapHandler(), bid);
		Book book = CommonUtils.toBean(map, Book.class);
		Category category = CommonUtils.toBean(map, Category.class);

		//为了desc页面加载一级分类
		if (map.get("pid") != null) {
			Category parent = new Category();
			parent.setCid((String) map.get("pid"));
			category.setParent(parent);
		}

		book.setCategory(category);
		return book;
	}

	/**
	 * 编辑图书
	 * @param book
	 * @throws SQLException 
	 */
	public void edit(Book book) throws SQLException {
		String sql = "UPDATE t_book SET bname=?, author=?, price=?, currPrice=?, " 
				+ "discount=?, press=?, publishtime=?, edition=?, pageNum=?, " 
				+ "wordNum=?, printtime=?, booksize=?, paper=?, cid=? WHERE bid=?";
		Object[] params = {book.getBname(), book.getAuthor(), book.getPrice(), 
				book.getCurrPrice(), book.getDiscount(), book.getPress(), 
				book.getPublishtime(), book.getEdition(), book.getPageNum(),
				book.getWordNum(), book.getPrinttime(), book.getBooksize(),
				book.getPaper(), book.getCategory().getCid(), book.getBid()};

		qr.update(sql, params);
	}

	/**
	 * 添加图书
	 * @param book
	 * @throws SQLException 
	 */
	public void add(Book book) throws SQLException {
		String sql = "INSERT INTO t_book(bid,bname,author,price,currPrice,discount,press,publishtime,"
				+ "edition,pageNum,wordNum,printtime,booksize,paper,cid,image_w,image_b) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {book.getBid(), book.getBname(), book.getAuthor(), 
				book.getPrice(), book.getCurrPrice(), book.getDiscount(), 
				book.getPress(), book.getPublishtime(), book.getEdition(), 
				book.getPageNum(), book.getWordNum(), book.getPrinttime(), 
				book.getBooksize(), book.getPaper(), book.getCategory().getCid(), 
				book.getImage_w(), book.getImage_b()};

		qr.update(sql, params);
	}

	/**
	 * 删除图书
	 * @param bid
	 * @throws SQLException 
	 */
	public void delete(String bid) throws SQLException {
		String sql = "DELETE FROM t_book WHERE bid=?";
		qr.update(sql, bid);
	}
}
