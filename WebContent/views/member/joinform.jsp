<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<%-- <jsp:include page="/views/include/header.jsp" flush="false"/> --%>
			<c:import url="/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post" action="/mysite/member">
					<input type="hidden" name="a" value="join">
					<label class="block-label" for="name">이름</label>
					&nbsp;&nbsp;<input id="name" name="name" type="text" value="">

					<label class="block-label" for="email">이메일</label>
					&nbsp;&nbsp;<input id="email" name="email" type="text" value="">
					<input type="button" value="id중복체크">
					
					<label class="block-label">패스워드</label>
					&nbsp;&nbsp;<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend>
						&nbsp;&nbsp;<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						&nbsp;&nbsp;<label>남</label> <input type="radio" name="gender" value="male">
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						&nbsp;&nbsp;<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						&nbsp;<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form>
			</div>
		</div>
		<div id="navigation">
			<%-- <jsp:include page="/views/include/navigation.jsp"/> --%>
			<c:import url="/views/include/navigation.jsp"></c:import>
		</div>
		<div id="footer">
			<%-- <jsp:include page="/views/include/footer.jsp"/> --%>
			<c:import url="/views/include/footer.jsp"></c:import>
		</div>
	</div>
</body>
</html>