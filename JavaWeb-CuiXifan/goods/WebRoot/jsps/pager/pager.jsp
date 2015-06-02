<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function _go() {
		var pc = $("#pageCode").val();//获取文本框中的当前页码

		//对当前页码进行整数校验
		if(!/^[1-9]\d*$/.test(pc)) {
			alert('请输入正确的页码！');
			return;
		}

		//判断当前页码是否大于最大页
		if(pc > ${pb.tp}) {
			alert('请输入正确的页码！');
			return;
		}
		location = "${pb.url}&pc=" + pc;
	}
</script>


<div class="divBody">
  <div class="divContent">
<%--     
* 计算页码的begin和end
  * 如果总页数<=6，
    则begin=1，end=${pb.tp}
  * 否则
    设置begin=${pb.pc-2}, end=${pb.pc+3}
    * 如果 begin<1
      则设置begin=1，end=6
    * 如果 end>${pb.tp}
      则设置begin=${pb.tp-5} end=${pb.tp}
 --%>
  <c:choose>
  	<c:when test="${pb.tp<=6}">
  		<c:set var="begin" value="1"></c:set>
  		<c:set var="end" value="${pb.tp}"></c:set>
  	</c:when>
  	<c:otherwise>
  		<c:set var="begin" value="${pb.pc-2}"></c:set>
  		<c:set var="end" value="${pb.pc+3}"></c:set>
  		<c:if test="${begin < 1}">
  			<c:set var="begin" value="1"></c:set>
  			<c:set var="end" value="6"></c:set>
  		</c:if>
  		<c:if test="${end > pb.tp}">
  			<c:set var="begin" value="${pb.tp-5}"></c:set>
  			<c:set var="end" value="${pb.tp}"></c:set>
  		</c:if>
  	</c:otherwise>
  </c:choose>



  <!--上一页 -->
  <c:choose>
  	<c:when test="${pb.pc==1}"><span class="spanBtnDisabled">上一页</span></c:when>
  	<c:otherwise><a href="${pb.url}&pc=${pb.pc-1}" class="aBtn bold">上一页</a></c:otherwise>
  </c:choose>
  
  <!--显示页码列表 -->
  <c:forEach var="i" begin="${begin}" end="${end}">
  	<c:choose>
  	  <c:when test="${i==pb.pc}"><span class="spanBtnSelect">${i}</span></c:when>
  	  <c:otherwise><a href="${pb.url}&pc=${i}" class="aBtn">${i}</a></c:otherwise>
  	</c:choose>
  </c:forEach>

    
  <!--显示点点点 -->
  <c:if test="${end<pb.tp}">
  	<span class="spanApostrophe">...</span>
  </c:if>
   

    
  <!--下一页 -->
  <c:choose>
  	<c:when test="${pb.pc==pb.tp}"><span class="spanBtnDisabled">下一页</span></c:when>
  	<c:otherwise><a href="${pb.url}&pc=${pb.pc+1}" class="aBtn bold">下一页</a></c:otherwise>
  </c:choose>
    
  <!--共N页 到M页 -->
  <span>共${pb.tp}页</span>
  <span>到</span>
  <input type="text" class="inputPageCode" id="pageCode" value="1"/>
  <span>页</span>
  <a href="javascript:_go();" class="aSubmit">确定</a>
  </div>
</div>