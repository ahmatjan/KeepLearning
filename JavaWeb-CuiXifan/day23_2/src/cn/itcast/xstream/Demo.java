package cn.itcast.xstream;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

/*
 * 学习XStream
 */
public class Demo {
	public List<Province> getProvinceList() {
		List<Province> provinceList = new ArrayList<Province>();

		Province p1 = new Province();
		p1.setName("山东");
		p1.addCity(new City("济南", "JiNan"));
		p1.addCity(new City("青岛", "QingDao"));

		Province p2 = new Province();
		p2.setName("北京");
		p2.addCity(new City("昌平", "ChangPing"));
		p2.addCity(new City("海淀", "HaiDian"));

		provinceList.add(p1);
		provinceList.add(p2);

		return provinceList;
	}

	/*	直接使用XStream效果：
        <list>
          <cn.itcast.xstream.Province>
            <name>山东</name>
            <cities>
              <cn.itcast.xstream.City>
                <name>济南</name>
                <description>JiNan</description>
              </cn.itcast.xstream.City>
              <cn.itcast.xstream.City>
                <name>青岛</name>
                <description>QingDao</description>
              </cn.itcast.xstream.City>
            </cities>
          </cn.itcast.xstream.Province>
        </list>
	 */
	@Test
	public void fun1() {
		List<Province> provinceList = getProvinceList();
		XStream xstream = new XStream();
		System.out.println(xstream.toXML(provinceList));
	}

	/* 别名(Alias):
	 * 		1. 希望把List对应的<list>改为<china>
	 * 		2. 希望把Province对应的<cn.itcast.xstream.Province>改为<province>
	 * 		3. 希望把City对应的<cn.itcast.xstream.City>改为<city>
        <china>
          <province>
            <name>山东</name>
            <cities>
              <city>
                <name>济南</name>
                <description>JiNan</description>
              </city>
              <city>
                <name>青岛</name>
                <description>QingDao</description>
              </city>
            </cities>
          </province>
        </china>
	 */
	@Test
	public void fun2() {
		List<Province> provinceList = getProvinceList();
		XStream xstream = new XStream();

		//起别名
		xstream.alias("china", List.class);
		xstream.alias("province", Province.class);
		xstream.alias("city", City.class);

		System.out.println(xstream.toXML(provinceList));
	}


	/*
	 * 用作属性：
	 * 		希望把Province的name属性，用作<province>元素的属性。
        <china>
          <province name="山东">
            <cities>
              <city>
                <name>济南</name>
                <description>JiNan</description>
              </city>
              <city>
                <name>青岛</name>
                <description>QingDao</description>
              </city>
            </cities>
          </province>
        </china>
	 */
	@Test
	public void fun3() {
		List<Province> provinceList = getProvinceList();
		XStream xstream = new XStream();
		xstream.alias("china", List.class);
		xstream.alias("province", Province.class);
		xstream.alias("city", City.class);

		//用作属性
		xstream.useAttributeFor(Province.class, "name");

		System.out.println(xstream.toXML(provinceList));
	}

	/* 添加隐式集合：
	 * 		希望把cities这一标签去掉，把cities标签内的子标签放在外面。
        <china>
          <province name="山东">
            <city>
              <name>济南</name>
              <description>JiNan</description>
            </city>
            <city>
              <name>青岛</name>
              <description>QingDao</description>
            </city>
          </province>
        </china>
	 */
	@Test
	public void fun4() {
		List<Province> provinceList = getProvinceList();
		XStream xstream = new XStream();
		xstream.alias("china", List.class);
		xstream.alias("province", Province.class);
		xstream.alias("city", City.class);
		xstream.useAttributeFor(Province.class, "name");

		//添加隐式集合
		xstream.addImplicitCollection(Province.class, "cities");

		System.out.println(xstream.toXML(provinceList));
	}

	/*
	 * 忽略属性：
	 * 		希望不要显示<description>标签。
        <china>
          <province name="山东">
            <city>
              <name>济南</name>
            </city>
            <city>
              <name>青岛</name>
            </city>
          </province>
        </china>
	 */
	@Test
	public void fun5() {
		List<Province> provinceList = getProvinceList();
		XStream xstream = new XStream();
		xstream.alias("china", List.class);
		xstream.alias("province", Province.class);
		xstream.alias("city", City.class);
		xstream.useAttributeFor(Province.class, "name");
		xstream.addImplicitCollection(Province.class, "cities");

		//忽略属性
		xstream.omitField(City.class, "description");

		System.out.println(xstream.toXML(provinceList));
	}
}