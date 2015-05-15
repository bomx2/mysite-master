<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/mysite/assets/css/boardtable.css" rel="stylesheet"
	type="text/css">
<link href="/mysite/assets/css/buttons.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<%-- <jsp:include page="/views/include/header.jsp" flush="false"/> --%>
			<c:import url="/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="board">
			<h2>게시판</h2>
			<div>
				<a href="/mysite/views/board/writeform.jsp"><button
					class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
					data-text="Write">
					<span>W</span><span>r</span><span>i</span><span>t</span><span>e</span>
				</button>
				</a>
			</div>
			<table>
				<thead>
					<tr>
						<th scope="col" width="10%">No</th>
						<th scope="col" width="40%">제&nbsp;&nbsp;&nbsp;목</th>
						<th scope="col" width="30%">작성자</th>
						<th scope="col" width="30%">작성일</th>
					</tr>
				</thead>
				<tbody>
			<c:forEach items="${requestScope.boardList}" var="vo">
					<tr>
						<td>${vo.no}</td>
						<td style="text-align: left;"><a href="/mysite/board?a=read&no=${vo.no}">${vo.title}</a></td>
						<td>${vo.member_name}</td>
						<td>${vo.date}</td>
					</tr>
			</c:forEach>
				</tbody>
			</table>
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