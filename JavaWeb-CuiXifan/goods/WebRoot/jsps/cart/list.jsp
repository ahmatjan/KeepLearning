<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>cartlist.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script src="<c:url value='/js/round.js'/>"></script>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/cart/list.css'/>">
<script type="text/javascript">
		
	$(function () {
		showTotal();

		//全选复选框
		$('#selectAll').click(function () {
			var bool = $('#selectAll').attr('checked');
			setCartItemCheckBox(bool);
			showTotal();
			setJiesuan(bool);
		});

		//购物车条目复选框
		$(':checkbox[name=checkboxBtn]').click(function () {
			var all = $(':checkbox[name=checkboxBtn]').length;
			var checked = $(':checkbox[name=checkboxBtn][checked=true]').length;
			console.log(all, checked);

			if (all == checked) {
				$('#selectAll').attr('checked', true);			
				showTotal();
				setJiesuan(true);
			} else if (checked == 0) {
				$('#selectAll').attr('checked', false);
				showTotal();
				setJiesuan(false);
			} else {
				$('#selectAll').attr('checked', false);
				showTotal();
				setJiesuan(true);
			}
		});

		//减按钮
		$('.jian').click(function () {
			var cartItemId = $(this).attr('id').substring(0, 32);
			var quantity = $('#'+cartItemId+'Quantity').val();
			if (quantity == 1) {
				if (confirm('您是否真的要删除该条目?')) {
					location = '/goods/CartItemServlet?method=batchDelete&cartItemIds=' + cartItemId;
				}
			} else {
				sendUpdateQuantity(cartItemId, Number(quantity) - 1);
				showTotal();
			}

		});

		//加按钮
		$('.jia').click(function () {
			var cartItemId = $(this).attr('id').substring(0, 32);
			var quantity = $('#'+cartItemId+'Quantity').val();
			sendUpdateQuantity(cartItemId, Number(quantity) + 1);
			showTotal();
		});

	});

	//发送修改购物车条目数量的请求
	function sendUpdateQuantity(cartItemId, quantity) {
		$.ajax({
			async: false,
			cache: false,
			url: "/goods/CartItemServlet",
			data: {method: "ajaxUpdateQuantity", cartItemId: cartItemId, quantity: quantity},
			type: "POST",
			dataType: "json",
			success: function (result) {
				$('#'+cartItemId+'Quantity').val(result.quantity);
				$('#'+cartItemId+'Subtotal').text(result.subtotal);
			}
		});
	}

	//设置所有购物条目的复选框
	function setCartItemCheckBox(bool) {
		$(':checkbox[name=checkboxBtn]').attr('checked', bool);
	}

	//显示总计
	function showTotal() {
		/*
		1. 获取所有选中的复选框
		2. 找到对应的小计
		3. 把所有对应的小计进行相加
		4. 显示总计
		*/
		var total = 0;
		$(':checkbox[name=checkboxBtn][checked=true]').each(function () {
			var text = $('#' + $(this).val() + 'Subtotal').text();
			total += Number(text);
		});
		$('#total').text(round(total,2));
	}
	
	//设置结算按钮
	function setJiesuan(bool) {
		if (bool) {
			$('#jiesuan').removeClass('kill').addClass('jiesuan');
			$('#jiesuan').unbind('onclick');
		} else {
			$('#jiesuan').removeClass('jiesuan').addClass('kill');
			$('#jiesuan').click(function() { return false; });
		}
	}

	//批量删除功能
	function batchDelete() {
		var cartItemIds = new Array();
		$(':checkbox[name=checkboxBtn][checked=true]').each(function () {
			cartItemIds.push($(this).val());
		});
		location = '/goods/CartItemServlet?method=batchDelete&cartItemIds=' + cartItemIds;
	}

	//结算，查询被勾选条目
	function jiesuan() {
		var cartItemIds = new Array();
		$(':checkbox[name=checkboxBtn][checked=true]').each(function () {
			cartItemIds.push($(this).val());
		});
		$('#hiddenCartItemIds').val(cartItemIds);
		$('#hiddenTotal').val($('#total').text());

		$('#jiesuanForm').submit();
	}

</script>
  </head>
  <body>


	<c:choose>
	<c:when test="${empty cartItemList}">

	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				<img align="top" src="<c:url value='/images/icon_empty.png'/>"/>
			</td>
			<td>
				<span class="spanEmpty">您的购物车中暂时没有商品</span>
			</td>
		</tr>
	</table>  

	</c:when>
	<c:otherwise>

<table width="95%" align="center" cellpadding="0" cellspacing="0">
	<tr align="center" bgcolor="#efeae5">
		<td align="left" width="50px">
			<input type="checkbox" id="selectAll" checked="checked"/><label for="selectAll">全选</label>
		</td>
		<td colspan="2">商品名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
		<td>操作</td>
	</tr>




	<c:forEach var="cartItem" items="${cartItemList}" >
	<tr align="center">
		<td align="left">
			<input value="${cartItem.cartItemId}" type="checkbox" name="checkboxBtn" checked="checked"/>
		</td>
		<td align="left" width="70px">
			<a class="linkImage" href="<c:url value='/BookServlet?method=load&bid=${cartItem.book.bid}'/>"><img border="0" width="54" align="top" src="<c:url value='/${cartItem.book.image_b}'/>"/></a>
		</td>
		<td align="left" width="400px">
		    <a href="<c:url value='/BookServlet?method=load&bid=${cartItem.book.bid}'/>"><span>${cartItem.book.bname}</span></a>
		</td>
		<td><span>&yen;<span class="currPrice" id="12345CurrPrice">${cartItem.book.currPrice}</span></span></td>
		<td>
			<a class="jian" id="${cartItem.cartItemId}Jian"></a><input class="quantity" readonly="readonly" id="${cartItem.cartItemId}Quantity" type="text" value="${cartItem.quantity}"/><a class="jia" id="${cartItem.cartItemId}Jia"></a>
		</td>
		<td width="100px">
			<span class="price_n">&yen;<span class="subTotal" id="${cartItem.cartItemId}Subtotal">${cartItem.subtotal}</span></span>
		</td>
		<td>
			<a href="<c:url value='/CartItemServlet?method=batchDelete&cartItemIds=${cartItem.cartItemId}'/>">删除</a>
		</td>
	</tr>


	</c:forEach>

	
	<tr>
		<td colspan="4" class="tdBatchDelete">
			<a href="javascript:batchDelete()">批量删除</a>
		</td>
		<td colspan="3" align="right" class="tdTotal">
			<span>总计：</span><span class="price_t">&yen;<span id="total"></span></span>
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right">
			<a href="javascript:jiesuan()" id="jiesuan" class="jiesuan"></a>
		</td>
	</tr>
</table>
	<form id="jiesuanForm" action="<c:url value='/CartItemServlet'/>" method="post">
		<input type="hidden" name="method" value="loadCartItems"/>
		<input type="hidden" name="cartItemIds" id="hiddenCartItemIds"/>
		<input type="hidden" name="total" id="hiddenTotal"/>
	</form>

	</c:otherwise>
	</c:choose>


  </body>
</html>
