<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/order/list.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>" />

  </head>
  
  <body>
<p class="pLink">
  <c:choose>
  	<c:when test="${status==0}"> 所有订单 </c:when>
  	<c:otherwise> <a href="<c:url value='/admin/AdminOrderServlet?method=findAll'/>">所有订单</a> </c:otherwise>
  </c:choose>
  | 
  <c:choose>
  	<c:when test="${status==1}"> 未付款 </c:when>
  	<c:otherwise> <a href="<c:url value='/admin/AdminOrderServlet?method=findByStatus&status=1'/>">未付款</a> </c:otherwise>
  </c:choose>
  | 
  <c:choose>
  	<c:when test="${status==2}"> 已付款 </c:when>
  	<c:otherwise> <a href="<c:url value='/admin/AdminOrderServlet?method=findByStatus&status=2'/>">已付款</a> </c:otherwise>
  </c:choose>
  | 
  <c:choose>
  	<c:when test="${status==3}"> 已发货 </c:when>
  	<c:otherwise> <a href="<c:url value='/admin/AdminOrderServlet?method=findByStatus&status=3'/>">已发货</a> </c:otherwise>
  </c:choose>
  | 
  <c:choose>
  	<c:when test="${status==4}"> 交易成功 </c:when>
  	<c:otherwise> <a href="<c:url value='/admin/AdminOrderServlet?method=findByStatus&status=4'/>">交易成功</a> </c:otherwise>
  </c:choose>
  | 
  <c:choose>
  	<c:when test="${status==5}"> 已取消 </c:when>
  	<c:otherwise> <a href="<c:url value='/admin/AdminOrderServlet?method=findByStatus&status=5'/>">已取消</a> </c:otherwise>
  </c:choose>
  
  </p>
<div class="divMain">
	<div class="title">
		<div style="margin-top:7px;">
			<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
			<span style="margin-left: 40px;margin-right: 100px;">金额</span>
			<span style="margin-left: 50px;margin-right: 53px;">订单状态</span>
			<span style="margin-left: 100px;">操作</span>
		</div>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">
	
	
	
	
		<c:forEach var="order" items="${pb.beanList}">
		<tr class="tt">
			<td width="320px">订单号：<a  href="<c:url value='/admin/AdminOrderServlet?method=load&oid=${order.oid}'/>">E3A1EB6D0543489F9729B2B5BC5DB365</a></td>
			<td width="200px">下单时间：${order.ordertime}</td>
			<td width="178px">&nbsp;</td>
			<td width="205px">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">

			<c:forEach var="orderItem" items="${order.orderItemList}">
			<img border="0" width="70" src="<c:url value='/${orderItem.book.image_b}'/>"/>
			</c:forEach>

			</td>
			<td style="padding-left: 0">
				<span class="price_t">&yen;${order.total}</span>
			</td>
			<td>
				<c:if test="${order.status==1}">等待付款</c:if>
				<c:if test="${order.status==2}">准备发货</c:if>
				<c:if test="${order.status==3}">等待确认</c:if>
				<c:if test="${order.status==4}">交易成功</c:if>
				<c:if test="${order.status==5}">已取消</c:if>
				
			</td>
			<td>
				<a href="<c:url value='/admin/AdminOrderServlet?method=load&oid=${order.oid}'/>">查看</a><br/>
				<c:if test="${order.status==1}">
				<a href="<c:url value='/admin/AdminOrderServlet?method=load&oid=${order.oid}&btn=cancel'/>">取消</a><br/>
				</c:if>
				<c:if test="${order.status==2}">
				<a href="<c:url value='/admin/AdminOrderServlet?method=load&oid=${order.oid}&btn=deliver'/>">发货</a>
				</c:if>
			</td>
		</tr>
		</c:forEach>


	</table>
	<br/>
	<%@include file="/jsps/pager/pager.jsp" %>
</div>
  </body>
</html>
