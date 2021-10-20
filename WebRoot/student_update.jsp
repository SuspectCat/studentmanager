<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_add.jsp' starting page</title>
     <meta http-equiv="content-type" content="text/html;charset=utf-8">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	    <!-- 引入jquery文件 -->
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

  </head>

  <body>
   	<form action="updateStudent" method="post">
   		<!-- type="hidden"  当前输入框隐藏，但是还在，只是不显示而已 -->
   		<input type="hidden" name="id" value="${stu.id }">  		
   		学号：<input type="text" name="code" value="${stu.code }">  		<br>
   		密码：<input type="password" name="password" value="${stu.password }">  		<br>
   		姓名： <input type="text" name="realName" value="${stu.realName }">   			<br>
   		性别： <input type="radio" name="gender" value="1">男 	
   			  <input type="radio" name="gender" value="0">女		<br>
		出生日期： <input type="date" name="birthday" value="${stu.birthday }">   			<br>
   			  <input type="submit" value="修改">
   	</form>
  </body>
   <script type="text/javascript">
  
  	//获取选择的性别的值
  	var gender = '${stu.gender}';
  	//通过值反向获取option,设置为被选择
  	$(":radio[name='gender'][value="+gender+"]").attr("checked",true);
  	
  </script>
</html>