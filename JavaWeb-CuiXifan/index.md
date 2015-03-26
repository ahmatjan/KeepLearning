## Day11
#### 11_1. JSP
```
/WebRoot
    |-- jsp-diractives
    |   |-- a.jsp
    |   |-- b.jsp
    |-- jsp-action
    |   |--form.jsp
    |   |--result.jsp
```
* `jsp1/*`
    * 学习JSP基本格式语法
    * 学习如何动态生成页面
* `jsp2/*` `AddServlet.java`
    * 学习JSP和Servlet的交互，完成一个加法功能。

#### 11_2. Cookie
```
/WebRoot
    |-- cookie1
    |   |-- a.jsp
    |   |-- b.jsp
    |-- cookie2
    |   |-- a.jsp
    |   |-- b.jsp
```
* `cookie1/*`
    * 学习添加Cookie
    * Cookie的遍历
* `cookie2/*`
    * 学习设置Cookie的Age
    * 删除Cookie

#### 11_3. Session
```
/WebRoot
    |-- session1
    |   |-- a.jsp
    |   |-- b.jsp
    |-- session2
    |   |-- login.jsp
    |   |-- succ1.jsp
    |   |-- succ2.jsp
    |-- session3
    |   |-- a.jsp
    |-- WEB-INF
    |   |-- web.xml
/src
    |-- cn.itcast.servlet
    |   |--LoginServlet.java
    |   |--VerifyCodeServlet.java
    |-- cn.itcast.uuid
    |   |--UUIDTest.java
    |-- cn.itcast.commons
    |   |--CommonUtils.java
```
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
#### 12_1. JSP指令、JSP动作标签
```
day12_1
├── src
└── WebRoot
    ├── actions
    │   ├── a.jsp
    │   ├── b.jsp
    │   ├── c.jsp
    │   └── d.jsp
    ├── directives
    │   ├── a.jsp
    │   ├── b.jsp
    │   ├── c.jsp
    │   └── d.jsp
    └── object
        └── a.jsp
```
* `directives/*`
    * JSP三大指令：<%@ page %> <%@ include %> <%@ tablib %>
* `actions/*`
    * JSP动作标签：<jsp:include /> <jsp:forward /> <jsp:param />
* `object/*`
    * 九大内置对象之 pageContext

#### 12_2. JavaBean
```
day12_2
├── src
│   └── cn
│       └── itcast
│           ├── domain
│           │   ├── Demo.java
│           │   └── Person.java
│           └── utils
│               └── CommonUtils.java
└── WebRoot
    └── bean
        └── a.jsp
```
* `cn.itcast.domain/*` `cn.itcast.utils/*`
    * 一个JavaBean实例，以及用BeanUtils 来操作JavaBean。
* `a.jsp`
    * 学习jsp动作标签，<jsp:useBean /> <jsp:setProperty /> <jsp:getProperty />


#### 12_3. EL、EL函数库
```
day12_3
├── src
│   └── cn
│       └── itcast
│           ├── domain
│           │   └── Person.java
│           └── fn
│               └── MyFunction.java
└── WebRoot
    ├── el
    │   ├── a.jsp
    │   ├── b.jsp
    │   └── c.jsp
    ├── el-function
    │   ├── a.jsp
    │   └── b.jsp
    └── WEB-INF
        └── tlds
            └── itcast.tld

```
* `el/*`
    * el表达式的使用
* `el-function/a.jsp`
    * el函数库的使用
* `el-function/b.jsp` `WEB-INF/tlds/itcast.tld` `cn.itcast.fn.MyFunction.java`
    * 自定义el函数
