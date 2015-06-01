package cn.itcast.goods.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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

		String sql = "SELECT * FROM t_category WHERE pid IS NULL";
		List<Category> parents = qr.query(sql, new BeanListHandler<Category>(Category.class));

		for (Category parent : parents) {
			//查找一级分类
			sql = "SELECT * FROM t_category WHERE pid=?";
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

}
