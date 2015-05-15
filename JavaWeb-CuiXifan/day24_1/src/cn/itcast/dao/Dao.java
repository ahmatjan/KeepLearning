package cn.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.util.NewBeanInstanceStrategy;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.City;
import cn.itcast.domain.Province;
import cn.itcast.jdbc.TxQueryRunner;

/*
 * Dao层
 */
public class Dao {
	private QueryRunner qr = new TxQueryRunner();

	//返回所有省的名称
	public List<Province> findAllProvince() {
		try {
			String sql = "SELECT * FROM t_province";
			return qr.query(sql, new BeanListHandler<Province>(Province.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//返回指定省的所有市名称
	public List<City> findCityByProvince(String pid) {
		try {
			String sql = "SELECT * FROM t_city WHERE pid=?";
			return qr.query(sql, new BeanListHandler<City>(City.class), pid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
