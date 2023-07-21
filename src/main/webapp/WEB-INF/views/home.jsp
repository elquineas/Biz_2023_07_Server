<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />   
<c:set value="ver042" var="ver" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빛고을 Book Rent Management System 2023</title>
<link href="${rootPath}/res/css/main.css?${ver}"  rel="stylesheet">
<link href="${rootPath}/res/css/book.css?${ver}"  rel="stylesheet">
<link href="${rootPath}/res/css/user.css?${ver}"  rel="stylesheet">
<script>
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/res/js/main.js"></script>
<script src="${rootPath}/res/js/book.js"></script>
<script src="${rootPath}/res/js/user.js"></script>
<script src="${rootPath}/res/js/nav.js"></script>
</head>
<body>
	<header class="main">
		<h1>빛고을 Book Rent Management System 2023</h1>
	</header>
	<nav class="main">
		<ul>
			<li class="book">도서등록</li>
			<li class="user">회원등록</li>
			<li class="rent">도서대출</li>		
		</ul>
	</nav>
	<section class="main">
		<c:if test="${MAIN == 'BOOK'}">
			<%@ include file="/WEB-INF/views/book.jsp" %>
		</c:if>
		<c:if test="${MAIN == 'USER'}">
			<%@ include file="/WEB-INF/views/user.jsp" %>
		</c:if>
	</section>
</body>
</html>