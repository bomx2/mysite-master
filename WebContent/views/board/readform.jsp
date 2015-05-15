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
			<c:import url="/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="board">
			<h2>게시글 조회</h2>
			<h4>|수정, 삭제는 로그인한 사용자에게만 지원됩니다.</h4>
			<div>
			</div>
			<table>
					<tr>
						<th scope="col">No</th>
						<td>${reading.no}</td>
						<th scope="col">작성자</th>
						<td>${reading.member_name}</td>
					</tr>
					<tr>
						<th scope="col" colspan="1">제&nbsp;&nbsp;&nbsp;목</th>
						<td colspan="3">${reading.title}</td>
					</tr>
					<tr>
						<th scope="col" colspan="1">내&nbsp;&nbsp;&nbsp;용</th>
						<td colspan="3">${reading.content}</td>
					</tr>
			</table>
			
			
			<c:choose>
			<c:when test="${empty authMember  }">
				<a href="/mysite/board?a=list">
				<button
					class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
					data-text="List">
					<span>L</span><span>i</span><span>s</span><span>t</span>
				</button>
			</a>
			</c:when>	
			<c:otherwise>
				<a href="/mysite/board?a=list">
				<button
					class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
					data-text="List">
					<span>L</span><span>i</span><span>s</span><span>t</span>
				</button>
				</a>
				<a href="/mysite/board?a=deleteform&no=${reading.no}">
					<button
						class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
						data-text="Delete">
						<span>D</span><span>e</span><span>l</span><span>e</span><span>t</span><span>e</span>
					</button>
				</a>
				<a href="/mysite/board?a=updateform&no=${reading.no}">
				<button
					class="button button--nina button--round-s button--text-thick button--inverted button--border-thin "
					data-text="Update">
					<span>U</span><span>p</span><span>d</span><span>a</span><span>t</span><span>e</span>
				</button>
				</a>
			</c:otherwise>
		</c:choose>
			
			
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