<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - URL</title>
</head>
<body>
	<h4>URL 태크로 링크 걸기</h4>
	<c:url value="otherURLPage.jsp" var="URL">
		<c:param name="userParam1" value="ezen" />
		<c:param name="userParam2">ITAcademy</c:param>
	</c:url>
	<a href="${URL}">otherURLPage.jsp 바로가기</a>
</body>
</html>