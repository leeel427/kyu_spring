<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		<!-- jstl -->

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 창</title>
	<script type="text/javascript">
		function fnValidate() {
//			alert("!!");			// 버튼 눌렀을시 경고창 확인
			let frmLogin = document.frmLogin
			let userID = frmLogin.userID.value
			let username = frmLogin.username.value
			
			if ((userID.length == 0 || userID == "")||(username.length == 0 || username == "")) {
				alert("아이디와 이름은 필수입니다.")
			}
			else {
				frmLogin.method = "post"
				frmLogin.action = "${contextPath}/req/login.do"
				frmLogin.submit()
			}
		} 
	</script>
</head>
<body>
	<form name= "frmLogin" action="${contextPath}/req/login.do" method="post">
		<table width="400">
			<tr>
				<td>아이디<input type="text" name="userID" size="10" /></td>
				<td>이름<input type="text" name="username" size="10" /></td>
			</tr>
			<tr>
				<td>
					<input type="button" value="로그인" onclick="fnValidate()"/>
					<input type="reset" value="다시입력" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>