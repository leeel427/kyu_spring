<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>otherURLPage.jsp</title>
</head>
<body>
	<h4>otherURLPage.jsp</h4>
	<ul>
		<li>저장된 값 : </li>
		<li>매개변수1 : ${param.userParam1 }</li>
		<li>매개변수1 : ${param.userParam2 }</li>
	</ul>
</body>
</html>