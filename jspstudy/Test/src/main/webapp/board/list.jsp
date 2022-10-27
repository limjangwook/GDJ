<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#btn_add').click(function(event){
			location.href = '${contextPath}/board/add.do';
		});
		
</script>
</head>
<body>
	<div>
		<input type="button" value="새글 작성" id="btn_add">
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>작성자</td>
					<td href="${contextPath}/board/detail.do?boardNo=${b.boardNo}">제목</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards}" var="board">
					<tr>
						
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</div>
</body>
</html>