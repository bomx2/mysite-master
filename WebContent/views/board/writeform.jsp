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
<link href="/mysite/assets/css/writeform.css" rel="stylesheet"
	type="text/css">
<link href="/mysite/assets/css/buttons.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="board">
				<h2>게시글 작성</h2>
			<form action="/mysite/board" method="post">
			<input type="hidden" name="a" value="insert">
				<input type="hidden" value="${authMember.no}" id="member_no" name="member_no">
				<input type="hidden" value="${authMember.name}"id="member_name" name="member_name"> 
				<input type="hidden" value="${authMember.password}" id="password" name="password">
				<table>
					<tr>
						<th scope="col" width="30%">제&nbsp;&nbsp;&nbsp;목</th>
						<td><input type="text" size="48" id="title" name="title"></td>
					</tr>
					<tbody>
						<tr>
							<th scope="col" width="30%">내&nbsp;&nbsp;&nbsp;용</th>
							<td><textarea cols="50" rows="20" id="content" name="content"></textarea></td>
						</tr>
					</tbody>
				</table>
					<button
						class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
						data-text="Submit" type="submit">
						<span>S</span><span>u</span><span>b</span><span>m</span><span>i</span><span>t</span>
					</button>
				</form>
				<a href="/mysite/board?a=list">
					<button
						class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
						data-text="Cancel">
						<span>C</span><span>a</span><span>n</span><span>c</span><span>e</span><span>l</span>
					</button>
				</a> 
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