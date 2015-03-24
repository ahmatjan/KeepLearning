## Day11
#### 11_1. JSP
```
/WebRoot
    |-- jsp1
    |   |-- a.jsp
    |   |-- b.jsp
    |-- jsp2
    |   |--form.jsp
    |   |--result.jsp
/src
    |-- cn.itcast.servlet
    |   |--AServlet.java
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
/src
    |-- cn.itcast.servlet
    |   |--LoginServlet.java
    |-- cn.itcast.uuid
    |   |--UUIDTest.java
    |-- cn.itcast.commons
    |   |--CommonUtils.java
```
* `session1/*`
    * Session域 数据的存取。
* `session2/*` `cn.itcast.servlet.LoginServlet.java`
    * 一个利用Session的 Login模块。
* `session3/*`
    * Session的URL重写。
* `cn.itcast.uuid` `cn.itcast.commons.CommonUtils.java`
    * 学习使用UUID：生成一个永不重复的32位随机数。
