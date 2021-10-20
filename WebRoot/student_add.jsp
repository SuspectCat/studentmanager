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

  </head>
  
  <body>
 
   	<form action="addStudent" method="post">
   		学号：<input type="text" name="code">  		<br>
   		密码：<input type="password" name="password">  		<br>
   		姓名： <input type="text" name="realName">   			<br>
   		性别： <input type="radio" name="gender" value="1">男 	
   			  <input type="radio" name="gender" value="0">女		<br>
		出生日期： <input type="date" name="birthday">   			<br>
   			  <input type="submit" value="添加">
   	</form>
  </body>
  
</html>


