<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${row==1 }">
	<script>
		alert("등록완료")
		location.href = "board_list";
	</script>
	</c:if>
	<c:if test="${row==0 }">
	<script>
		alert("등록실패")
		history.back()
	</script>
	</c:if>
</body>
</html>