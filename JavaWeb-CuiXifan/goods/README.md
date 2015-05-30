
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
	1. 注册表单校验流程分析
		JS校验
			> 检验是否为空
			> 检验长度是否符合要求
			
		AJAX访问服务器校验
			> 用户名是否注册
			> Email是否注册
			> 验证码是否正确

		检验时机：
			> 获得焦点隐藏错误
			> 失去焦点进行校验
			> 进行提交时再次校验

		----------------
		regist.jsp
			> ajax();
		
		UserServlet#ajaxValidateLoginname()
			> 调用UserService#ajaxValidateLoginname()

		UserService#ajaxValidateLoginname()
			> 调用UserDao#ajaxValidateLoginname()

		UserService#ajaxValidateLoginname()
			> 数据库中查询是否存在该用户名
		
	2. 注册流程分析
		regist.jsp
			> 注册表单
			> 把"注册信息"和"method=regist"提交给UserServlet

		msg.jsp
			> 回显注册成功的信息

		UserServlet#regist()
			> 封装表单数据到JavaBean中
			> 校验参数
				* 如果有参数错误，则把map保存到request域中，然后转发到regist.jsp
			> 调用userService完成业务
			> 保存成功信息
			> 转发到msg.jsp

		UserService#regist()
			> 补齐其他数据（uid、状态、激活码）
			> 调用userDao插入数据
			> 发送邮件

		UserDao#add()
			> 数据库中插入用户
	
#### 2.2 用户注册模块
#### 2.2 用户注册模块
#### 2.2 用户注册模块
