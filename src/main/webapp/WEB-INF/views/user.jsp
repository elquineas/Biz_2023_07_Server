<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />   
<form class="main" method="POST" action="${rootPath}/user/update">
	<div class="main user msg">${ERROR}</div>
	<table class="main user">
		<tr>
			<td>유저등록</td>
			<td><input id="u_code" name="u_code" placeholder="유저코드" value="${USER.u_code}"/></td>
			<td><input id="u_name" name="u_name" placeholder="유저이름" value="${USER.u_name}"/></td>
			<td colspan="2"><input id="u_tel" name="u_tel" placeholder="전화번호" value="${USER.u_tel}"/></td>
		</tr>
		<tr>
			<td><input id="user_sort" name="user_sort" value="${SORT}" hidden/></td>
			<td colspan="3"><input id="u_addr" name="u_addr" placeholder="주소" value="${USER.u_addr}"/></td>
			<td><button id="user_save" class="main save user" type="button" >저장</button></td>
		</tr>
	</table>
</form>


<form class="search_form user_search" method="POST" action="${rootPath}/user/search">
	<input id="search" name="search" placeholder="검색"  value="${USER_SEARCH}"/>
	<button id="user_btn" class="main search" type="button" >검색</button>
</form>

	<table class="main list">
		<tr>
			<th>유저코드</th>
			<th>유저이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th></th>
		</tr>
		<c:forEach items="${USERS}" var="USER">
			<tr data-id="${USER.u_code}" >
				<td>${USER.u_code}</td>
				<td>${USER.u_name}</td>
				<td>${USER.u_tel}</td>
				<td>${USER.u_addr}</td>
				<td><a class="a_update">수정</a></td>
			</tr>
		</c:forEach>
	</table>