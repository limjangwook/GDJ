<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <c:choose> 태그는 if - else 구조를 가진다. --%>
	
	<c:set var="age" value="103" />
	
	<c:choose>
		<c:when test="${age < 0}">아직 아빠쪽</c:when>
		<c:when test="${age <= 7}">유치원</c:when>
		<c:when test="${age <= 13 }">초딩</c:when>
		<c:when test="${age <= 16 }">중딩</c:when>
		<c:when test="${age <= 19 }">고딩</c:when>
		<c:when test="${age <= 100 }">사람</c:when>
		<c:otherwise>장수</c:otherwise>
	</c:choose>

</body>
</html>