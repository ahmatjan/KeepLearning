package cn.itcast.goods.category.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.goods.category.dao.CategoryDao;
import cn.itcast.goods.category.domain.Category;

/**
 * 分类模块业务层
 * @author jason
 *
 */
public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();

	/**
	 * 查询显示所有分类
	 * @return
	 */
	public List<Category> findAll() {
		try {
			return categoryDao.findAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加一级分类
	 * @param parent
	 */
	public void add(Category category) {
		try {
			categoryDao.add(category);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查找所有一级分类
	 * @return
	 */
	public List<Category> findParents() {
		try {
			return categoryDao.findParents();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载单个Category
	 * @param cid
	 * @return
	 */
	public Category load(String cid) {
		try {
			return categoryDao.load(cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改Category信息
	 * @param category
	 */
	public void update(Category category) {
		try {
			categoryDao.update(category);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查找一级分类的子分类数据
	 * @param cid
	 * @return
	 */
	public int findChilrenCountByParent(String cid) {
		try {
			return categoryDao.findChildrenCountByParent(cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除分类
	 * @param cid
	 */
	public void delete(String cid) {
		try {
			categoryDao.delete(cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询二级分类下的图书数量
	 * @param cid
	 * @return
	 */
	public int findBookCountByCategory(String pid) {
		try {
			return categoryDao.findBookCountByCategory(pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查找某一父分类的子分类
	 * @param cid
	 * @return
	 */
	public List<Category> findChildrenByParent(String cid) {
		try {
			return categoryDao.findChildrenByParent(cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
