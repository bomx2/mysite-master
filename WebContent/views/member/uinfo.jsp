<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="user">
			
			<h3>${sessionScope.authMember.name}님의 회원정보</h3><p>
				<table>
					<tr>
						<td><label class="block-label" for="name">이름 : </label></td>
						<td>${authMember.name}</td>
					</tr>
					<tr>
						<td><label class="block-label" for="email">이메일 : </label></td>
						<td>${authMember.email}</td>
					</tr>
					<tr>
						<td><label class="block-label">패스워드 : </label></td>
						<td>${authMember.password}</td>
					</tr>
					<tr>
						<td><label class="block-label">성별 : </label></td>
						<td>${authMember.gender}</td>
					</tr>
				</table>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation.jsp"></c:import>
		</div>
		<div id="footer">
			<c:import url="/views/include/footer.jsp"></c:import>
		</div>
	</div>
</body>
</html>