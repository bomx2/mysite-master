<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	String result = request.getParameter( "result" );
%>
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
				<form id="login-form" name="loginform" method="post" action="/mysite/member">
					<input type="hidden" name="a" value="login">
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="" size="18">
					<label class="block-label" >비밀번호</label>
					<input name="password" type="password" value="" size="18">
					<c:if test="${param.result == 'fail'}">
						<p>
							<span style="color: red; font-weight:bold;">로그인에 실패 했습니다.</span>
						</p>
					</c:if>
					<input type="submit" value="로그인">
				</form>
			</div>
		</div>
		<div id="navigation">
		<%--<jsp:include page = "/views/include/navigation.jsp" flush = "false"/> --%>
			<c:import url="/views/include/navigation.jsp"></c:import>
		</div>
		<div id="footer">
		<%--<jsp:include page = "/views/include/footer.jsp" flush = "false"/> --%>
			<c:import url="/views/include/footer.jsp"></c:import>
		</div>
	</div>
</body>
</html>