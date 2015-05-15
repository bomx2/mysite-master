<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/deleteform.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
		<%--<jsp:include page = "/views/include/header.jsp" flush="false"/> --%>
			<c:import url="/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="board" class="delete-form">
				<h3>정말로 게시글을 삭제하시겠습니까?</h3>
				<form method="post" action="/mysite/board">
					<input type="hidden" name="a" value="delete">
					<input type='hidden' name="no" value="<%=Integer.parseInt(request.getParameter("no")) %>">
					<label>비밀번호</label>
					<input type="password" name="password">
					<input type="submit" value="확인">
				</form>
				<a href="/mysite/board">게시판 리스트</a>
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