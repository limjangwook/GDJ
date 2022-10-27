<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.board_no}번 게시글</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
		
		$('#btn_edit').click(function(event){
			location.href = '${contextPath}/board/edit.do?board_no=${board.board_no}';
		});
		
		$('#btn_remove').click(function(event){
			if(confirm('정말로 삭제하시겠습니까?')){
				location.href = '${contextPath}/board/remove.do?board_no=${board.board_no}';
			}
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/board/list.do';
		});
		
	});

</script>
</head>
<body>

	<div>
		순번 : ${board.board_no}
	</div>
	<div>
		작성자 : ${board.name}
	</div>
	<div>
		제목 : ${board.title}
	</div>
	<div>
		<pre>${board.content}</pre>
	</div>
	<div>
		<input type="button" value="수정" id="btn_edit">
		<input type="button" value="목록" id="btn_list">
		<input type="button" value="삭제" id="btn_remove">
	</div>

</body>
</html>