package cn.itcast.goods.category.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.category.domain.Category;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 分类模块的持久层
 * @author jason
 *
 */
public class CategoryDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 查询显示所有分类
	 * @return
	 * @throws SQLException 
	 */
	public List<Category> findAll() throws SQLException {
		/*
		 * 1.得到所有一级分类
		 * 2.为每个一级分类添加其所有的二级分类
		 * 3.返回一级分类
		 */

		String sql = "SELECT * FROM t_category WHERE pid IS NULL ORDER BY orderBy";
		List<Category> parents = qr.query(sql, new BeanListHandler<Category>(Category.class));

		for (Category parent : parents) {
			//查找一级分类
			sql = "SELECT * FROM t_category WHERE pid=? ORDER BY orderBy";
			List<Category> children = qr.query(sql, new BeanListHandler<Category>(Category.class), parent.getCid());

			//为每个一级分类添加其所有的二级分类
			Category tempParent = new Category();
			tempParent.setCid(parent.getCid());
			for (Category child : children)
				child.setParent(tempParent);
			parent.setChildren(children);
		}


		return parents;
	}

	/**
	 * 添加一级分类和二级分类
	 * @param parent
	 * @throws SQLException 
	 */
	public void add(Category category) throws SQLException {
		String sql = "INSERT INTO t_category(cid,cname,pid,`desc`) VALUES (?,?,?,?)";

		//指定父分类id：如果是一级分类，父分类id设为null
		String pid;
		Category parent = category.getParent();
		if (parent == null)
			pid = null;
		else
			pid = parent.getCid();

		qr.update(sql, category.getCid(), category.getCname(), pid, category.getDesc());
	}

	/**
	 * 查找所有一级分类
	 * @return
	 * @throws SQLException 
	 */
	public List<Category> findParents() throws SQLException {
		String sql = "SELECT * FROM t_category WHERE pid is NULL";
		List<Category> parents = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return parents;
	}

	/**
	 * 加载单个类
	 * @param cid
	 * @return 
	 * @throws SQLException 
	 */
	public Category load(String cid) throws SQLException {
		String sql = "SELECT * FROM t_category WHERE cid=?";
		Category category = toCategory(qr.query(sql, new MapHandler(), cid));

		return category;
	}

	/**
	 * 把一个Map转换成为一个Category
	 * @param map
	 * @return
	 */
	private Category toCategory(Map<String, Object> map) {
		Category category = CommonUtils.toBean(map, Category.class);

		//检测有无父分类，如果有则设置父分类
		String pid = (String)map.get("pid");
		if (pid != null) {
			Category parent = new Category();
			parent.setCid(pid);
			category.setParent(parent);
		}

		return category;
	}

	/**
	 * 修改单个Category信息
	 * @param category
	 * @throws SQLException 
	 */
	public void update(Category category) throws SQLException {
		String sql = "UPDATE t_category SET cname=?, pid=?, `desc`=? WHERE cid=?";

		//指定父分类id：如果是一级分类，父分类id为null
		String pid = null;
		Category parent = category.getParent();
		if (parent != null)
			pid = parent.getCid();

		qr.update(sql, category.getCname(), pid, category.getDesc(), category.getCid());
	}

	/**
	 * 查询一级分类的子分类数目
	 * @param cid
	 * @return
	 * @throws SQLException 
	 */
	public int findChildrenCountByParent(String cid) throws SQLException {
		String sql = "SELECT COUNT(*) FROM t_category WHERE pid=?";
		Number num = (Number)qr.query(sql, new ScalarHandler(), cid);

		return num.intValue();
	}

	/**
	 * 删除分类
	 * @param cid
	 * @return
	 * @throws SQLException 
	 */
	public void delete(String cid) throws SQLException {
		String sql = "DELETE FROM t_category WHERE cid=?";
		qr.update(sql, cid);
	}

	/**
	 * 查询二级分类下的图书数量
	 * @param cid
	 * @return
	 * @throws SQLException 
	 */
	public int findBookCountByCategory(String cid) throws SQLException {
		String sql = "SELECT COUNT(*) FROM t_book WHERE cid=?";
		Number num = (Number)qr.query(sql, new ScalarHandler(), cid);

		return num.intValue();
	}

}
