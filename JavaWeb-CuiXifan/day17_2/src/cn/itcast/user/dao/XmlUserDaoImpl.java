package cn.itcast.user.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.itcast.user.domain.User;

/*
 * 数据类
 */
public class XmlUserDaoImpl implements UserDao {
	private String path = "/tmp/users.xml";

	/*
	 * 根据用户名查找User 
	 * 
	 * 1. 得到Document 
	 * 2. xpath查询 
	 * 		2.1 查询结果如果为null，返回null
	 * 		2.2 查询结果不为null，转换为User后返回
	 */
	public User findByUsername(String username) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			Element ele = (Element) doc.selectSingleNode("//user[@username='" + username + "']");

			//如果返回值为空
			if (ele == null)
				return null;

			//如果返回值不为空
			User user = new User();
			user.setUsername(ele.attributeValue("username"));
			user.setPassword(ele.attributeValue("password"));
			return user;
				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 添加User
	 * 
	 * 1. 获得Document
	 * 2. 获得根元素
	 * 3. 为根元素添加子元素
	 * 4. 为该子元素添加属性
	 * 5. 创建格式化输出器，把xml输出到文件中
	 * 
	 */
	public void addUser(User user) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			Element root = doc.getRootElement();
			Element userEle = root.addElement("user");
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());

			OutputFormat format = new OutputFormat("\t", true);
			format.setTrimText(true);

			XMLWriter writer = new XMLWriter(
					new OutputStreamWriter(new FileOutputStream(path), "UTF-8"), format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
