
### 1 网上书城功能模块划分

#### 1.1 项目前台功能模块
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

#### 1.2 项目后台功能模块
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




### 2 用户模块分析
#### 2.1 用户注册模块

	1. AJAX异步请求
	regist.jsp
		* AJAX访问服务器校验
		> 用户名是否注册
		> Email是否注册
		> 验证码是否正确

	UserServlet#ajaxValidateLoginname()
		> 调用UserService#ajaxValidateLoginname()

	UserService#ajaxValidateLoginname()
		> 调用UserDao#ajaxValidateLoginname()

	UserService#ajaxValidateLoginname()
		> 数据库中查询是否存在该用户名
		
	2. 注册流程分析
	regist.jsp
		> JS校验：检验是否为空、检验长度是否符合要求
		> 注册表单
		> 把"注册信息"和"method=regist"提交给UserServlet

	msg.jsp
		> 回显注册成功的信息

	UserServlet#regist()
		> 封装表单数据到JavaBean中
		> 校验参数。如果有参数错误，则把map保存到request域中，然后转发到regist.jsp ----over
		> 调用userService完成业务
		> ----
		> 保存成功信息
		> 转发到msg.jsp

	UserService#regist()
		> 补齐其他数据（uid、状态、激活码）
		> 调用userDao插入数据
		> 发送邮件

	UserDao#add()
		> 数据库中插入用户
	
#### 2.3 用户激活模块
	激活邮件
		> 激活链接

	msg.jsp
		> 回显激活的结果

	UserServlet#activate()
		> 获取激活码
		> 调用userService#activate()完成激活
		> ----
		> 获取异常。如果有异常，则把异常存放到request域中，然后转发到msg.jsp中。----over
		> 转发到msg.jsp中提示激活成功

	UserService#activate()
		> 调用userDao#findUserByActivationCode根据激活码查找用户，如果找到的是null，抛出异常：无效的激活码 ----over
		> 查看返回的User状态是否为true，如果为true，抛出异常：该用户已激活 ----over
		> 调用userDao#updateStatus()把更改用户的状态为true

	UserDao
		> #findUserByActivationCode() 根据激活码返回用户
		> #updateStatus() 更改用户激活状态



#### 2.3 用户登陆模块
	1. AJAX异步请求
	login.jsp
		> 验证码是否正确

	其他模块
		> 略

	2. 登陆流程分析

	login.jsp
		> JS校验：登陆名是否为空、长度3~20。（校验时机	> 得到光标隐藏	> 失去光标校验	> 提交时再次校验）
		> 登陆表单和"method=login"
		> ----
		> 出错信息、登录名、密码、验证码进行回显
		> ----
		> cookie中的数据自动填充到登录名这一栏

	index.jsp
		> 根据session中的用户名进行显示

	UserServlet#login()
		> 获取表单数据
		> 进行表单数据校验，如果errors的size()>0，则request域中存入数据[errors“对应的错误信息”][user“表单信息”]，转发到regist.jsp ----over
		> 调用userService#login()方法
		> 得到的返回值如果是null，request域中存入数据[msg“用户名/密码错误”][user“用户名、密码、注册码”]，转发到regist.jsp ----over
		> 得到的返回值user的状态如果是false，则request域中存入数据[msg“用户尚未激活请立即激活”]，转发到regist.jsp ----over
		> 得到的返回值user存入session中，loginname的url编码存入cookie中

	User UserService#login(User)
		> 直接返回userDao#login(User)的返回值

	UserDao#login(User)
		> 根据user的用户名密码进行查询，返回结果


#### 2.4 用户修改密码模块

	1. AJAX异步请求
	pwd.jsp
		> 校验验证码是否正确

	其他模块
		> 略

	2. 提交
	pwd.jsp
		> JS自身进行校验：是否为空、长度校验
		> method=updatePassword
		> 各种表单

	msg.jsp
		> 显示

	UserServlet#updatePassword()
		> 封装表单数据为JavaBean	
		> 表单数据校验
		> 调用userService修改密码
		> 如果捕获了异常，则request域中存入数据[msg e.getMessage()][user“表单信息”]，转发到pwd.jsp ----over
		> 保存成功信息，转发msg.jsp

	UserService#updatePassword(User)
		> 调用userDao#validateOldPass来校验旧密码是否正确
		> 如果返回值为false，则抛出异常：密码错误
		> 调用userDao#updatePassword来修改密码

	UserDao
		> #validateOldPass(String uid, String oldPass) 校验旧密码是否正确
		> #updatePassword(String uid, String newPass) 修改密码






















