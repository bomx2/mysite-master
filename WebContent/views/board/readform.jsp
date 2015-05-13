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
<link href="/mysite/assets/css/readform.css" rel="stylesheet"
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
			<h2>게시글</h2>
			<div>
			</div>
			<table>
					<tr>
						<th scope="col">No</th>
						<td>데이터</td>
						<th scope="col">작성자</th>
						<td>데이터</td>
					</tr>
					<tr>
						<th scope="col" colspan="1">제&nbsp;&nbsp;&nbsp;목</th>
						<td colspan="3">데이터</td>
					</tr>
				<tbody>
					<tr>
						<th scope="col" colspan="1">내&nbsp;&nbsp;&nbsp;용</th>
						<td colspan="3">데이터</td>
					</tr>
				</tbody>
			</table>
			<a href="/mysite/views/board/boardtable.jsp">
			<button
				class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
				data-text="List">
				<span>L</span><span>i</span><span>s</span><span>t</span>
			</button>
			</a>
			<button
				class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
				data-text="Delete">
				<span>D</span><span>e</span><span>l</span><span>e</span><span>t</span><span>e</span>
			</button>
			<button
				class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
				data-text="Update">
				<span>U</span><span>p</span><span>d</span><span>a</span><span>t</span><span>e</span>
			</button>
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