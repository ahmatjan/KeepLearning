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

## Day15&&Day16
    > 学习MySql相关知识

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

## day26 goods 网上书城

### 前台销售功能模块
	  > 用户模块
	  > 分类模块
	  > 图书模块
	  > 购物车模块
	  > 订单模块

### 后台管理功能模块
	  > 管理员模块
	  > 分类模块
	  > 图书模块
	  > 订单模块

## day27
    > day27_1: 通配符
    > day27_2: 注解的使用与定义
    > day27_3: 反射泛型和反射注解，用反射泛型、注解和反射注解实现Hibernate原型。
    > day27_4: 学了BeanFactory以及面向接口编程。
