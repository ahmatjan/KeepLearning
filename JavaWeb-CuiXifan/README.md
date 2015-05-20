## Day11
    > day11_1: JSP
    * `jsp1/*`
        * 学习JSP基本格式语法
        * 学习如何动态生成页面
    * `jsp2/*` `AddServlet.java`
        * 学习JSP和Servlet的交互，完成一个加法功能。

    > day11_2: Cookie
    * `cookie1/*`
        * 学习添加Cookie
        * Cookie的遍历
    * `cookie2/*`
        * 学习设置Cookie的Age
        * 删除Cookie

    > day11_3. Session
    * `session1/*`
        * Session域 数据的存取。
    * `session2/*` `cn.itcast.servlet*`
        * 一个利用Session的 Login模块。
    * `session3/*`
        * Session的URL重写。
    * `/WebRoot/WEB-INF/web.xml`
        * 设置Session超时时间。
    * `cn.itcast.uuid` `cn.itcast.commons.CommonUtils.java`
        * 学习使用UUID：生成一个永不重复的32位随机数。

##Day12
    > day12_1: JSP指令、JSP动作标签
    * `directives/*`
        * JSP三大指令：<%@ page %> <%@ include %> <%@ tablib %>
    * `actions/*`
        * JSP动作标签：<jsp:include /> <jsp:forward /> <jsp:param />
    * `object/*`
        * 九大内置对象之 pageContext

    > day12_2: JavaBean
    * `cn.itcast.domain/*` `cn.itcast.utils/*`
        * 一个JavaBean实例，以及用BeanUtils 来操作JavaBean。
    * `a.jsp`
        * 学习jsp动作标签，<jsp:useBean /> <jsp:setProperty /> <jsp:getProperty />


    > day12_3: EL、EL函数库
    * `el/*`
        * el表达式的使用
    * `el-function/a.jsp`
        * el函数库的使用
    * `el-function/b.jsp` `WEB-INF/tlds/itcast.tld` `cn.itcast.fn.MyFunction.java`
        * 自定义el函数

## Day13
    > 13_1 JSTL标签库
    > 13_2 自定义标签
    > 13_3 MVC结构的Hello World程序

## Day14

* MVC结构的注册登陆程序
    > JavaWeb经典三层结构来实现
    > XML做数据库
    > 注册时有验证码
    > 服务器端有表单输入校验

## Day15

## Day16

## Day17 JDBC第一天
    > JDBC原理
    > 通过JDBC进行增删改查
    > JDBC的代码规范
    > ResultSet的相关特性
    > PreparedStatement用法
    > JdbcUtils小工具
    > 面向接口编程
    > 修改day14，改变dao层
    > mysql存放大文件
    > mysql进行批处理


## Day18 JDBC第二天
    > 事物
    > 连接池
    > 装饰设计模式
    > ThreadLocal
    > JNDI
    > DBUtils

## Day19 JDBC第三天
    > day19_1: BaseServlet，一个Servlet响应多个请求
    > day19_2: JdbcUtils第3次改写，支持事物和多线程并发
    > day19_2: 封装QueryRunner类，把对Connection的处理封装进去
    > day19_3: 客户关系管理系统：增删改查用户、多条件组合模糊查询用户

## Day20 JDBC分页 && 监听器 && 国际化
    > 客户关系管理系统：添加了对分页的支持
    > 学习了八大监听器
    > 学习了页面的国际化（使用ResourceBundle来实现）


## Day21 过滤器
    > day21_1: 过滤器的基本用法
    > day21_2: 过滤器的生效顺序
    > day21_3: 分IP统计访问次数
    > day21_4: 粗力度权限管理
    > day21_5: 全站编码问题
    > day21_6: 页面静态化

## Day22 上传下载 JavaMail
    > day22_1: 上传
    > day22_2: 下载
    > day22_3: JavaMail

## Day23 AJAX
    > day23_1: AJAX学习，与服务器通过text、XML进行通信;通过XML方式实现省市联动。
    > day23_2: XStream, 把JavaBean转换为XML
    > day23_3: AJAX学习，与服务器通过JSON进行通信
    > day23_4: JSON-LIB, 把JavaBean转换为JSON

## Day24
    > day24_1: AJAX通过JSON来实现省市联动。


## day25 tool-test
  > CommonUtils: 生成uuid、Map转换成JavaBean
  > JdbcUtils: 获取Connection、事物管理
  > TxQueryRunner: JdbcUtils和dbUtils整合在一起，进行增删改查，多表联合查询结果集映射
  > log4j: 配置c3p0日志信息
  > MailUtils: 发送邮件
  > BaseServlet: 一个Servlet响应多种请求
  > EncodingFilter: 对客户端请求进行编码处理
  > VerifyCodeServlet: 生成验证码图片返回给客户端，以及进行验证码的比对

## goods 网上书城

### 网上书城功能模块划分

#### 项目前台功能模块
	* User 用户模块
		> 用户注册
		> 用户登陆
		> 用户激活
		> 用户修改密码
		> 用户退出

	* Category 分类模块
		> 展示一级分类和二级分类

	* Book 图书模块
		> 按分类查看图书（分页）
		> 按书名查看图书（模糊、分页）
		> 按作者查看图书（模糊、分页）
		> 按出版社查看出书（模糊、分页）
		> 高级查询（模糊、分页）
		> 查看图书详细

	* Cart 购物车模块
		> 我的购物车（查看购物车）
		> 添加购物条目
		> 删除单本图书、批量删除图书
		> 修改图书数量
		> 确认购物清单（查看勾选订单）

	* Order 订单模块
		> 生成订单（提交订单）
		> 我的订单
		> 查看订单详细
		> 订单支付（发送请求）
		> 订单支付（银行回馈处理）修改订单状态为“支付成功”
		> 取消订单
		> 确认收货

#### 项目后台功能模块
	* 管理员模块
		> 管理员登陆
		> 管理员退出
	* 分类模块
		> 增删改查一级分类
		> 增删改查二级分类

	* 图书模块
		> ---------以下和前台图书模块相同----------
		> 按分类查看图书（分页）
		> 按书名查看图书（模糊、分页）
		> 按作者查看图书（模糊、分页）
		> 按出版社查看出书（模糊、分页）
		> 高级查询（模糊、分页）
		> 查看图书详细
		> ---------以上和前台图书模块相同----------
		> 编辑图书
		> 删除图书
		> 添加图书

	* 订单模块
		> 按状态查看订单
		> 查看订单详细
		> 发货
		> 取消订单


