<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<ul>
	<c:choose>
		<c:when test="${empty authMember  }">
			<li class="selected">게스트</li>
		</c:when>
		<c:otherwise>
			<li class="selected">${authMember.name}님</li>
		</c:otherwise>
	</c:choose>
	
	<li><a href="/mysite/guestbook?a=list">방명록</a></li>
	<li><a href="">게시판</a></li>
</ul>