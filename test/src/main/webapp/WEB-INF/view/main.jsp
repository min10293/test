<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<title>Home</title>	
</head>

<body>
		<h2>로그인 성공 </h2>
		이름 : ${sessionScope.userLoginInfo.username} 
		<a href="logout">로그아웃</a>
</body>
</html>