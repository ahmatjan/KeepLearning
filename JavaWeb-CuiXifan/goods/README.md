
## 1 功能模块划分

### 1.1 项目前台功能模块
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

### 1.2 项目后台功能模块
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



## 2 前台
### 2.1 前台 —— 用户模块分析
#### 2.1.1 用户注册模块

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
	
#### 2.1.2 用户激活模块
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



#### 2.1.3 用户登陆模块
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


#### 2.1.4 用户修改密码模块

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
		> 如果返回值为false，则抛出异常：当前密码错误
		> 调用userDao#updatePassword来修改密码

	UserDao
		> #validateOldPass(String uid, String oldPass) 校验旧密码是否正确
		> #updatePassword(String uid, String newPass) 修改密码

#### 2.1.5 用户注销模块
	
	top.jsp
		> 退出

	UserServlet
		> 摧毁session
		> 重定向到login.jsp


### 2.2 前台 —— 分类模块分析
#### 2.2.1 显示所有分类
	main.jsp
		> iframe访问CategoryServlet?method=findAll

	CategoryServlet#findAll()
		> 调用categoryService#findAll()
		> 得到的返回值存入request域[parents“所有一级分类”]
		> 转发到left.jsp

	CategoryService#findAll()
		> 调用categoryDao#findAll()，并返回得到的返回值

	CategoryService#findAll()
		> 得到所有一级分类
		> 为每个一级分类添加其所有的二级分类
		> 返回一级分类


### 2.3 前台 —— 图书模块分析

#### 2.3.1 模块划分
	> 按分类查看图书（分页）
	> 按书名查看图书（分页、模糊）
	> 按作者查看图书（分页、模糊）
	> 按出版社查看图书（分页、模糊）
	> 组合查询（分页、模糊）
	> 查看图书详细

#### 2.3.2 JavaBean分析
	JSP页面需要以下信息：
		> pc: PageCode, 当前页码
		> tp: TotalPage, 总页码
		> beanList: BeanList, 图书列表信息
		> url: 查询时所带的条件（请求的url、以及各种参数）

	Servlet需要以下信息：
		> pc: PageCode, 当前页码 —— 默认为1，如果页面传递了数据，以页面数据为准
		> tp: TotalPage, 总页码 —— 由 tr(TotalRecord)和ps(PageSize)计算得来
		> tr: TotalRecord, 总记录数 —— SELECT COUNT(*)获得
		> ps: PageSize, 每页记录书 —— 业务数据，应该来自配置文件
		> beanList: BeanList, 图书列表 —— 通过bookDao的查询得到
		> url：查询时所带的各种条件（req.getRequestURI() + req.getQueryString() - pc参数）

#### 2.3.3 图书模块流程分析
	各种JSP文件
		> BookServlet?method=findByXxx()&yy=yy

	list.jsp
		> 遍历pageBean对象，列出图书
	
	pager.jsp
		> 计算页码的begin和end
			* 如果总页数<=6，
					则begin=1，end=${pb.tp}
			* 否则
					设置begin=${pb.pc-2}, end=${pb.pc+3}
					* 如果 begin<1
						则设置begin=1，end=6
					* 如果 end>${pb.tp}
						则设置begin=${pb.tp-5} end=${pb.tp}

		> 显示页码列表（从begin到end）、当前页高亮显示（pc）
		> 显示上一页（如果begin>1）、显示下一页（如果end<pb.tp）
		> 显示点点点（如果end<pb.tp）
		> 显示共${pb.tp}页
		> 页码跳转：进行输入检查，执行跳转
						

	BookServlet#findByXxx
		> 获取各种参数：pc（默认为1）、yy、url(req.getRequestURI + req.getQuery - pc)
		> 根据参数调用userService#findByXxx获得PageBean
		> 给返回的PageBean设置url
		> 把pageBean存入request域，转发到list.jsp

	BookService#findXxx()
		> 返回调用bookDao#findXxx()所得返回值

	BookDao
		* #findByXxx()
			> 读取配置文件中的ps
			> 配置List<Expression>
			> 调用findByCriteria()获得pageBean对象，并返回

		* #findByCriteria(int pc, int ps, List<Expression> criteria)
			> 根据 pc和criteria 构造SQL语句
			> SQL查询出tr\beanList
			> 查询出 tr\beanList 元素，并构造pageBean对象，并返回

#### 2.3.4 查看图书详细流程分析
  lisp.jsp
		> method=load&bid=xxx
		> 点击“书名”或者“图书图片”

	desc.jsp
		> 显示图书详细信息

	BookServlet#load()
		> 获取bid
		> 调用userService#load()
		> 返回结果存入request，转发到desc.jsp

	BookService#load()
		> 调用userDao#findByBid()
		> 并返回调用结果

	BookDao#findByDao()
		> 根据bid在数据库中查询结果放到map中去
		> 把map中的数据映射到Book和Category中，并进行组装
		> 返回Book

		

### 2.4 前台 —— 购物车分析
	cn.itcast.goods.cart
		.domain.CartItem
		.web.servlet.CartItemServlet
		.service.CartItemService
		.dao.CartItemDao
		
#### 2.4.1 我的购物车

	top.jsp
		> 我的购物车，请求CartItemServlet?method=myCart

	list.jsp
		> 显示购物清单

	CartItemServlet#myCart()
		> 从session中提取uid
		> 调用cartItemService#myCart()来获取CartItemList
		> cartItemList保存到request域中
		> 转发到/jsps/cart/list.jsp

	CartItemService#myCart()
		> 返回CartItemDao#myCart的调用结果

	CartItemDao#myCart()
		> 数据库中查询当前用户对应的 购物车条目列表List<Map>  （注：多表组合查询）
		> 把 购物车条目列表List<Map> 映射成 CartItem\Book\User，并进行组装


#### 2.4.2 添加购物车条目

	/book/desc.jsp#立即购买
		> 把bid、quantity、method=add 传递给Servlet

	list.jsp
		> 显示购物列表

	list.jsp#JavaScript	
		全选复选框#点击
		> 所有购物条目的复选框：和全选复选框 一致
		> 总计重新计算
		> 结算按钮：生效失效和全选复选框 一致

		各购物条目复选框#点击
		> 全选复选框：所有购物条目都被选中，则选中；其他情况下，取消。
		> 总计重新计算
		> 结算按钮：所有购物条目取消选中，则失效；其他情况下，生效。

	list.jsp#HTML
		修改页面相关元素id，使各元素前缀为当前购物条目的cartItemId
		> 复选框的值，carItemId
		> 小计的id，cartItemId+Subtotal
		> 减按钮，cartItemId+Jian
		> 加按钮，cartItemId+Jia
		> 数量显示，cartItemId+Quantity


	CartItemServlet#add()
		> 把quantity、bid、seesionUser.uid封装成一个CartItem
		> 调用cartItemService.add(cartItem)方法完成添加购物条目
		> 调用 myCart(req, resp)后跳转到 list.jsp

	CartItemService#add(CartItem)
		> 调用cartItemDao.findByBidAndUid(bid, uid)查询cartItem是否存在于数据库中
		> 如果返回值不为null，把cartItem中的quantity和新添加的数量相加后，调用cartItemDao.updateQuantity(cartItemId, quantity)修改数据库中该购物车条目的数量。
		> 如果返回值为null，则先给cartItem添加一个cartItemId，然后调用 cartItemDao.addCartItem()在数据库中添加一条购物车条目

	CartItemDao
		> #findByBidAndUid(bid, uid) 根据Bid和Uid查询cartItem是否存在于数据库中
		> #updateQuantity(cartItemId, quantity) 修改数据库中某购物条目的数量
		> #addCartItem(cartItem) 添加购物条目

#### 2.4.3 （批量）删除购物车条目

	list.jsp
		> #删除：/CartItemServlet?method=batchDelete&cartItemIds=xxx
		> #批量删除：/CartItemServlet?method=batchDelete&cartItemIds=xxx   被删除的购物车条目的cartItemId通过“,”连接成字符串，使用JavaScript完成。

	CartItemServlet#batchDelete()
		> 获取cartItemIds参数
		> 调用cartItemService#batchDelete()完成删除功能
		> 返回购物车页面

	CartItemService#batchDelete()
		> 调用cartItemDao#batchDelete()完成删除

	CartItemDao#batchDelete()
		> 把 cartItemIds由字符串划分成数组
		> 生成 whereSql子句
		> 把Delete子句和whereSql子句连接在一起，执行之

#### 2.4.4 修改购物车条目的数量

	list.jsp
		> $.ajax({data: {method: ajaxUpdateQuantity, cartItemId: xxx, quantity:xxx});
		> 调用成功后，根据返回的数量和小计，更改页面

	CartItemServlet#ajaxUpdateQuantity()
		> 获取cartItemId和quantity
		> 调用cartItemService.updateQuantity(cartItemId, quantity)修改数量
		> 把返回值的quantity和subtotal转换成json格式发送给客户端
		> 返回null

	CartItemService#updateQuantity(cartItemId, quantity)
		> 调用cartItemDao.updateQuantity(cartItemId, quantity)修改数量
		> 调用cartItemDao.findByCartItemId查找CartItem
		> 返回CartItem

	CartItemDao#updateQuantity(cartItemId, quantity)
		> #updateQuantity() 修改购物条目数量
		> #findByCartItemId() 查找CartItem


#### 2.4.5 查询被勾选条目
	list.jsp#结算
		> /CartItemServlet?method=loadCartItems&total=xxx&cartItemIds=yyy,zzz   其中xxx是总计金额；yyy,zzz等是被选中的购物车条目，通过JS来添加。

	showitem.jsp
		> 显示被勾选条目，总计
	
	CartItemServlet#loadCartItems()
		> 获取参数cartItemIds、total
		> 调用CartItemService.loadCartItems(cartItemIds)
		> 将返回值 List<CartItem>、total存入request域中
		> 转发到showitem.jsp中

	CartItemService#loadCartItems()
		> 调用cartItemDao.loadCartItem()并把结果返回

	CartItemDao#loadCartItems()
		> 把cartItemIds划分成数组
		> 构造where子句
		> 把select子句和where子句连接后进行查询（多表联合查询）
		> 查询的结果封装成List<CartItem>返回


### 2.5 前台 —— 订单模块

	1. 生成订单
	2. 我的订单（分页）
	3. 查看订单详细信息
	4. 取消订单
	5. 确认收货
	6. 准备支付
	----在线支付介绍
	7. 订单支付（去银行的界面）
	8. 银行回馈（修改状态为已支付）
		
#### 2.5.1 我的订单

	top.jsp
		> 我的订单，请求OrderServlet?method=myOrder

	list.jsp
		> 显示订单
		> 通过pager.jsp显示页码

	OrderServlet#myOrder()
		> 获取参数 pc、url(request.getRequestURI + request.getRequestQueryString - pc)
		> 获取sessionUser.getUid()
		> 调用orderService.myOrder()获得pageBean
		> 为pageBean设置url
		> pageBean存入request域，转发到list.jsp

	OrderService#myOrder()
		> 调用orderDao.myOrder()并返回所得pageBean（以上放在一个事物中）

	OrderDao
		* myOrder(int pc)
			> 获取ps
			> 构造List<Expression>
			> 调用findByCriteria得到pageBean并返回


		* findByCriteria(int pc, int ps, List)
			> 根据pc、ps、criteria构造SQL语句
			> 执行SQL语句，得到tr、beanList
			> 为beanList中每个Order，添加其所拥有的OrderItem
			> 根据pc\ps\tr\beanList 构造PageBean对象，并返回


#### 2.5.2 生成订单

	/cart/showitem.jsp
		> #提交订单： 请求 /OrderServlet?method=createOrder&cartItemIds=xxx,yyy&address=...

	/order/ordersucc.jsp
		> 显示 订单编号、合计金额、收货地址等

	OrderServlet#createOrder()
		> 根据 address\sessionUser等信息创建Order
		> 根据cartItemIds获得List<CartItemOrder>，进而创建List<OrderItem>
		> 把List<OrderItem>添加到CartItemOrder上去
		> 调用OrderService#createOrder()来向数据库中插入数据
		> request域中保存order，转发到 /order/ordersucc.jsp去

	OrderServlet#createOrder()
		> 调用orderDao#add()完成订单的添加（以上需要放到事物中完成）

	OrderServlet#add()
		> 在t_order表中添加数据
		> 在t_orderitem表中添加数据，运用批处理来完成


#### 2.5.3 查看订单详细

	list.jsp
		> #点击订单编号 #查看 #取消 #确认收货    /OrderServlet?method=load&oid=xxx&btn=cancel/confirm

	desc.jsp
		> 显示订单相关的各种信息。
		> 如果状态为1，显示“立即支付”；如果状态为1且btn=cancel，显示取消订单；如果状态为3且btn=confirm，显示确认收货。

	OrderServlet#load()
		> 获取参数oid和btn
		> 调用orderService#load(oid)
		> 把返回的Order和btn存入request域中
		> 转发至desc.jsp

	OrderService#load()
		> 调用orderDao.load()，然后返回结果

	OrderDao#load(oid)
		> 根据oid到数据库中查询Order
		> 为Order填充OrderItem
		> 返回Order

		
#### 2.5.4 取消订单
	desc.jsp
		> 取消订单： /OrderServlet?method=cancel&oid=xxx

	msg.jsp
		> 显示成功或失败信息

	OrderServlet#cancel()
		> 获取参数oid
		> 调用orderService.findStatusByOid() 查看订单状态是否为1：如果不是则request域中存入错误信息后，转发到msg.jsp
		> 调用orderService.updateStatus() 修改订单状态为5
		> request域中存入成功信息后，转发到msg.jsp

	OrderService
		> #findStatusByOid() 查看订单状态
		> #updateStatus() 更改订单状态

	OrderDao
		> #findStatusByOid() 查看订单状态
		> #updateStatus() 更改订单状态

#### 2.5.5 确认收货（和取消订单类似）
	desc.jsp
		> 确认收货： /OrderServlet?method=confirm&oid=xxx

	msg.jsp
		> 显示成功或失败信息

	OrderServlet#confirm()
		> 获取参数oid
		> 调用orderService.findStatusByOid() 查看订单状态是否为3：如果不是则request域中存入错误信息后，转发到msg.jsp
		> 调用orderService.updateStatus() 修改订单状态为4
		> request域中存入成功信息后，转发到msg.jsp

	OrderService
		> #findStatusByOid() 查看订单状态
		> #updateStatus() 更改订单状态

	OrderDao
		> #findStatusByOid() 查看订单状态
		> #updateStatus() 更改订单状态


#### 2.5.6 支付准备
	
	list.jsp#支付 /OrderServlet?method=paymentPrepare&oid=xxx
	desc.jsp#支付
	ordersucc.jsp#支付
	

	pay.jsp
		> 显示支付相关信息

	OrderServlet#paymentPrepare()
		> 获取参数oid
		> 调用orderService.load(oid)
		> 把返回结果存入request域，转发到pay.jsp

	OrderService#load()
		> 调用orderDao.load()并返回结果

	OrderDao#load(oid)
		> 根据oid查询Order并返回结果


#### 2.5.7 支付

	pay.jsp
		> #下一步： /OrderServlet?method=payment&oid=xxx&yh=yyy

	OrderServlet#payment()
		> 获取oid和yh
		> 准备13个参数，生成第14个参数
		> 重定向到易宝（易宝支付url + 14个参数）

	易宝和银行模块
		> 易宝进行一下验证和处理
		> 重定向到银行支付页面
		> 用户输入账号密码校验
		> 银行账号之间进行转账操作
		> 银行返回信息给易宝

	


#### 2.5.8 支付返回

	易宝
		> 用户重定向：引导用户重定向到 /OrderServlet?若干参数
		> 点对点反馈：把信息反馈给 /OrderServlet?若干参数


	OrderServlet#paymentBack()
		> 获取前12个参数
		> 校验第13个参数，如果没有校验通过，保存错误信息到request域，转发到msg.jsp
		> 调用orderService.updateStatus()修改订单状态
		> 检查r9这个参数，
			* 如果是2，返回一个"success"
			* 否则，request域中存入成功信息，转发到msg.jsp中



### 2.6 前台 —— 监听器

	登陆监听器
		1. 购物车
		jsp: /jsps/cart/*
		servlet: CartItemServlet

		2. 订单
		jsp: /jsps/order/*
		servlet: OrderServlet

		LoginFileter
			> 从session中获取User
			> 如果不存在，request域存入错误信息，转发到msg.jsp
			> 如果存在，放行



## 3 后台
	1. 管理员模块
	2. 分类模块
	3. 图书模块
	4. 订单模块
	----------
	JSP位置：			除了login.jsp & msg.jsp放在 /WebRoot/adminjsps 之外，其他放在 /WebRoot/adminjsps/admin

	Servlet位置：	cn.itcast.admin包下
	Servlet命名：	除AdminServlet之外，前面额外添加一个Admin，如 AdminBookServlet、AdminCategoryServlet
	Servlet url：	除AdminServlet之外，都以/admin开头，如 /admin/AdminBookServlet、/admin/AdminCategoryServlet
	
		


### 3.1 后台 —— 管理员模块
	cn.itcast.goods.admin.admin.domain.Admin
	cn.itcast.goods.admin.admin.dao.AdminDao
	cn.itcast.goods.admin.admin.service.AdminService
	cn.itcast.goods.admin.admin.web.servlet.AdminServlet

#### 3.1.1 登陆功能
	login.jsp
		> 登陆： /AdminServlet?method=login&adminname=xx&adminpass=yy

	AdminServlet#login()
		> 获取参数adminname和adminpass
		> 调用AdminService.login()，得到返回对象admin
		> 如果admin为空，则request域中存入错误信息后，转发到 /adminjsps/login.jsp
		> session中存入管理员相关信息
		> 转发到/adminjsps/admin/index.jsp

	AdminService#login()
		> 调用adminDao.findAdminByNameAndPass()

	AdminDao#findAdminByNameAndPass()
		> 数据库中根据帐号名和密码查询管理员，结果封装成Admin返回

#### 3.1.2 退出功能
	top.jsp
		> 退出 /AdminServlet?method=logout

	AdminServlet#logout()
		> 使session失效
		> 重定向到/goods/adminjsps/login.jsp

### 3.2 后台 —— 分类模块

#### 3.2.1 查看所有分类
	top.jsp
		> 分类管理：/admin/AdminCategoryServlet?method=findAll

  list.jsp
    > 显示所有分类

  AdminCategoryServlet?method=findAll
    > 调用categoryService.findAll()获取所有分类
    > 把返回结果保存到request域
    > 转发到/adminjsps/admin/category/list.jsp

  CategoryService && CategoryDao
    > 略


#### 3.2.2 添加一、二级分类

1. 添加一级分类
  add.jsp
    > 添加一级分类：/admin/AdminCategoryServlet?method=addParent&cname=xxx&desc=yyy

  AdminCategoryServlet#addParent()
    > 把参数封装为表单 Category parent
    > 调用categoryServlet.addParent(parent)完成添加功能
    > return findAll();

  CategoryService#addParent()
    > 调用categoryDao.add()完成添加

  CategoryDao#add(category)
    > 构造sql语句
    > 判断category.getParent()是否为空
      * 如果为空，pid设为null
      * 否则设为category.getParent().getPid()
    > 执行sql语句

2.1 添加二级分类 Part 1

  list.jsp
    > 添加二级分类：/admin/AdminCategoryServlet?method=preAddChild&pid=x

  add2.jsp
    > 下拉框显示一级分类，并把pid对应的一级分类选中

  AdminCategoryServlet#preAddChild()
    > 获取参数pid
    > 调用categoryService#findParents()获取所有一级分类 parents
    > 把parents\pid存入request域中，转发到add2.jsp

  CategoryService#findParents()
    > 调用categoryDao.findParent()，并返回结果

  CategoryDao#findParent()
    > 查找所有一级分类并返回


2.2 添加二级分类 Part 2

  add2.jsp
    > 添加二级分类：/admin/AdminCategoryServlet?method=addParent?pid=x&cnam=y&desc=z

  AdminCategoryServlet#add
    > 把参数封装进Category child中；获取pid，封装为一个Category parent；child设置parent
    > 调用categoryService#addChild()完成添加二级分类
    > return findAll();

  CategoryService && CategoryDao
    > 略

#### 3.2.1 编辑一、二级分类

1.1 修改一级分类 Part1
  list.jsp
    > 修改： /admin/AdminCategory?method=preEdiParentt&cid=x

  edit.jsp
    > 显示Category信息

  AdminCategoryServlet#preEditParent()
    > 获取cid
    > 调用categoryService.load()进行加载
    > 返回值category放入request域，转发到edit.jsp中

  CategoryService#load()
    > 略

  CategoryDao#load()
    > 在数据库中查询指定分类，并把查询结果封装封装到一个map中。
    > 把map封装到一个category中。封装时先检测有无父分类，如果有则把pid封装成一个Category，然后赋给前一个category。

1.2 修改一级分类 Part2
  edit.jsp
    > 修改： > /admin/AdminCategory?method=editParent&cid=x&cname=y&desc=z

  AdminCategoryServlet#editParent()
    > 参数封装为Category对象
    > 调用categoryService修改
    > return findAll()

  CategoryService
    > 略

  CategoryDao#update()
    > 修改category，要注意的是要考虑category可能有父分类，也可能没有父分类，因此要加一个if判断一下。

2.1 修改二级分类 Part1
  list.jsp
    > 修改： /admin/AdminCategory?method=preEdiChild&cid=x

  edit2.jsp
    > 显示Category信息

  AdminCategoryServlet#preEditChild()
    > 获取cid
    > 调用categoryService.load()进行加载，调用categoryService.findParents()获取所有一级分类。
    > 返回值category放入request域，转发到edit.jsp中

  CategoryService && CategoryDao
    > 略

2.2 修改二级分类 Part2
  edit2.jsp
    > 修改： > /admin/AdminCategory?method=editParent&cid=x&cname=y&desc=z

  AdminCategoryServlet#editChild()
    > 参数封装为Category对象，注意pid要单独封装成一个Category parent然后赋给前一个Category
    > 调用categoryService.update()修改
    > return findAll()

  CategoryService && CategoryDao
    > 略

#### 3.2.1 删除一、二级分类

1. 删除一级分类
  list.jsp
    > 删除 /admin/AdminCategoryServlet?method=deleteParent&cid=xxx

  msg.jsp
    > 显示错误信息

  AdminCategoryServlet
    > 获取cid
    > 查询该分类下是否有二级分类(categoryService.findChildrenCountByParent(cid))
      * 如果有，request域中保存错误信息，转发到msg.jsp中
      * 如果没有，删除该分类；return findAll()

  CategoryService && CategoryDao #findChildrenCountByParent()

2. 删除二级分类
  list.jsp
    > 删除 /admin/AdminCategoryServlet?method=deleteChild&cid=xxx

  msg.jsp
    > 显示错误信息

  AdminCategoryServlet
    > 获取cid
    > 查询该分类下是否有二级分类(categoryService.findBookCountByCategory(cid))
      * 如果有，request域中保存错误信息，转发到msg.jsp中
      * 如果没有，删除该分类；return findAll();

  CategoryService && CategoryDao #findChildrenCountByParent()
    > 略


### 3.3 后台 —— 图书模块

功能模块：
	1. 显示所有分类（通过手风琴式下拉菜单）
	2. 按分类查询图书
	3. 按作者查询图书
	4. 按出版社查询图书
	5. 组合查询
	6. 查看图书详细
	----以上模块和前台基本一样----
	7. 添加图书
	8. 编辑图书
	9. 删除图书

类的创建：
	1. cn.itcast.goods.admin.book.AdminBookServlet
	2. cn.itcast.goods.admin.book.AdminAddBookServlet
		因为上传表单的enctype="mutipart/formdata"，所以不能使用request.getParameter()，进而也不能使用BaseServlet。
		所以上传功能要单独占用一个Servlet。

#### 3.3.7 添加图书
1. 准备添加图书
	main.jsp
		> 添加图书： /AdminBookServlet?method=preAddBook

	add.jsp
		> 显示所有一级分类信息

	AdminBookServlet#preAddBook
		> 调用categoryService.findParents()的到所有一级分类
		> 把一级分类列表存入request域，转发到 add.jsp

	serivce && dao
		> 略

2. 异步响应二级分类
	add.jsp
		> 一级分类变化，调用AdminBookServlet.ajaxFindChildren()获得获得对应的二级分类，然后添加到二级分类的下拉列表中

	AdminBookServlet#ajaxFindChildren
		> 调用categoryService.findChildren(cid)获取对应的二级分类列表
		> 将二级分类转化成为JSON后，返回到客户端

	service && dao
		> 略

3. 提交表单，进行添加图书
	add.jsp
		> 新书上架 /AdminBookServlet?method=add&各种表单项

	AdminAddBookServlet
		> 使用 commons-fileupload组件完成三步解析，得到List<FileItem>
		> 把 List<FileItem>转换成为一个Map中
		> 使用Map生成一个Book，使用Map生成一个Category，把Category赋给Book
		> 设置book.bid
		> ----
		> 对文件名进行截取（文件名称可能是绝对路径）
		> 对文件拓展名进行校验，如果不是jpg或者png，则保存错误转发到add.jsp
		> 检测图片大小，如果长宽大于 350*350，则保存错误到request域后转发到add.jsp
		> 给文件名加上uuid前缀（保证文件名唯一）
		> 给文件名添加上 book_img路径后保存
		> 文件名赋给book对象
		> 使用ServletContext.getRealPath()获取真实路径
		> 保存文件
		> ----
		> 文件小图的检验同上
		> ----
		> 调用bookService.add(book)添加图书
		> 保存添加成功信息，转发到msg

	bookService && bookDao
		> add(book) 添加图书
	

#### 3.3.8 编辑图书
1. 准备修改图书
	list.jsp
		> 点击书名： /AdminBookServlet?method=load&bid=xxx

	desc.jsp
		> 显示图书详细	

	service && dao
		> bookService.load() 查找图书详细放入request域（其中包括 book.category 以及 book.category.parent）
		> bookService.findParents() 查找所有一级分类放入request域
		> bookService.findChildrenByParent 查找图书当前所属的一级分类的所有二级分类


2. 异步响应二级分类
	desc.jsp
		> 一级分类下拉框改变，ajax请求 /AdminBookServlet?method=findChildren&pid=xxx

	service && dao #findChildren
		> findChildrenByParent() 查找某一父分类的所有子分类

3. 提交表单，编辑图书
	desc.jsp
		> /AdminBookServlet?method=edit&各种 表单信息

	msg.jsp
		> 显示结果信息

	AdminBookServlet#edit()
		> 表单数据封装成Book，封装成Category，然后Category赋给Book
		> 调用service编辑图书

	service && dao #edit()
		> 略
	


#### 3.3.9 删除图书
	desc.jsp
		> /AdminBookServlet?method=delete&bid=xxx

	msg.jsp
		> 显示结果信息

	AdminBookServlet#delete()
		> 根据bid，service加载图书
		> 获取大小图，删除图片
		> service.delete()删除图书
		> 保存信息到msg.jsp

	service && dao #delete()
		> 略



### 3.4 后台 —— 订单模块

	1. 查询所有订单
	2. 按状态查询订单
	3. 查询订单详细，（点击不同的链接，显示不同的按钮）
		> 点击订单号或查看时，没有按钮
		> 点击取消按钮时，有取消按钮
		> 点击发货按钮时，有发货按钮
	4. 取消订单
	5. 发货

#### 3.4.1 查询所有订单
	main.jsp
		> 添加图书：/AdminOrderServlet?method=findAll	

	list.jsp
		> 使用两层嵌套循环来显示订单列表

	AdminOrderServlet#findAll()  （参考前台我的订单来实现）
		> （参考OderServlet#myOrder()来实现findAll()）

	OrderService#findAll()
		> （参考OrderSerivce#myOrder()来实现）

	OrderDao#findAll()
		> （参考OderDao.findByUser()来实现）

#### 3.4.2 按状态查询订单
	list.jsp
		> 未付款、已付款...： /AdminOrderServlet?method=findByStatus&status=xxx

	list.jsp
		> 使用两层嵌套循环来显示订单列表

	AdminOrderServlet#findByStatus()
		> （参考findByUser来实现）

	service && dao
		> 略

#### 3.4.3 查看订单详细
	list.jsp
		> 点击 订单号/查看/取消/发货 ： AdminOrderServlet?method=load&oid=xxx&btn=zz

	desc.jsp
		> 显示订单信息
		> 根据btn参数来显示各种按钮

	AdminOrderServlet#load（）
		> （参考前台查看订单来实现）

	service && dao
		> 略
	
#### 3.4.4 取消订单
	desc.jsp
		> 取消订单： AdminOrderServlet?method=cancel&oid=xx

	msg.jsp
		> 显示取消订单成功

	AdminOrderServlet#cancel()
		> （参考OrderServlet.cancel()来实现）

	service && dao
		> 略
		

#### 3.4.5 发货
	desc.jsp
		> 发货： AdminOrderServlet?method=deliver&oid=xx

	msg.jsp
		> 显示发货成功

	AdminOrderServlet#deliver()
		> （参考OrderServlet.cancel()来实现）

	service && dao
		> 略


### 3.5 过滤器
	AdminLoginFilter
		> 对 /adminjsps/admin/* 和 /admin/* 的内容进行过滤
















