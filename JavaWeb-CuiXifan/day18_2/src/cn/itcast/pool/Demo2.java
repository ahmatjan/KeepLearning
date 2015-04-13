/*
 * 说明：学习装饰设计模式，配合ConnectionWrapper \ MyConnection.
 */
package cn.itcast.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class Demo2 {
	/*
	 * 这个方法和Demo的func方法基本一致，除了对Connection进行一个封装。
	 */
	@Test
	public void func() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/exam");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		dataSource.setMaxActive(20);
		dataSource.setMinIdle(3);
		dataSource.setMinIdle(1000);

		Connection con = new MyConnection(dataSource.getConnection());
		System.out.println(con.getClass().getName());
		
		//MyConnection对close方法进行了修饰
		con.close();
	}
}


/*
 * 对Connection进行修饰，在close()调用前打印“哈哈”
 */
class MyConnection extends ConnectionWrapper {
	public MyConnection(Connection con) {
		super(con);
	}

	public void close() throws SQLException {
		System.out.println("哈哈");
		super.close();
	}
}


/*
 * 对InputStream进行修饰
 */
class MyInputStream extends InputStream {
	private InputStream in;
	private int key;

	public MyInputStream(InputStream in, int key) {
		this.in = in;
		this.key = key;
	}

	@Override
	public int read() throws IOException {
		return (in.read() - key);
	}
	
}
