<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- jstl核心标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户列表页面</title>
    
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    
    <!-- 引入jquery文件 -->
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    
  </head>
  
  <body>
  
    <div style="text-align: center; margin-bottom: 20px;">
    	<form action="findAllStudent" method="post">
    		学号：<input type="text" name="code" value="${stu.code}">
    		姓名：<input type="text" name="realName" value="${stu.realName}">
    		性别：<select name="gender">
    				<option value="">请选择</option>
    				<option value="1">男</option>
    				<option value="0">女</option>
    			</select>
    		<input type="submit" value="查询">
    		<input type="button" value="添加" onclick="location.href='toAddStudentPage'">
    		<input type="button" value="退出" onclick="location.href='logout'">
    	</form>
    </div>
    <table border="1px" width="500px" style="border-collapse:collapse; margin: auto;text-align: center;">
    	<tr>
    		<td>学号</td>
    		<td>姓名</td>
    		<td>性别</td>
    		<td>出生日期</td>
    		<td>操作</td>
    	</tr>
    	
		<c:forEach items="${list }" var="stu">
			 <tr>
	    		<td>${stu.code }</td>
	    		<td>${stu.realName }</td>
	    		<td>${stu.gender=='1'?'男':'女' }</td>
	    		<td>${stu.birthday }</td>
	    		<td>
	    			<input type="button" value="修改" onclick="location.href='toUpdateStudentPage?id=${stu.id}'">
	    			<input type="button" value="删除" onclick="del(${stu.id});">
	    		</td>
	    	</tr>
		</c:forEach>
    </table>
    
  </body>
  <script type="text/javascript">
  
  	//获取选择的性别的值
  	var gender = '${stu.gender}';
  	//通过值反向获取option,设置为被选择
  	$("select[name='gender'] option[value="+gender+"]").attr("selected",true);
  	
  	function del(id) {
  		var flag = window.confirm("确定删除此条数据？");
  		if(flag) {
  			location.href = "deleteStudent?id="+id;
  		}
  	}
  	
  </script>
</html>
