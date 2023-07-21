<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />   
<form class="main" method="POST" action="${rootPath}/update">
	<div class="main book msg">${ERROR}</div>
	<table class="main book">
		<tr>
			<td>도서등록</td>
			<td><input id="b_code" name="b_code" placeholder="도서코드" value="${BOOK.b_code}"/></td>
			<td><input id="b_name" name="b_name" placeholder="도서명" value="${BOOK.b_name}"/></td>
			<td><input id="b_auther" name="b_auther" placeholder="저자" value="${BOOK.b_auther}"/></td>
			<td><input id="b_comp" name="b_comp" placeholder="출판사" value="${BOOK.b_comp}"/></td>
		</tr>
		<tr>
			<td><input id="sort" name="sort" value="${SORT}" hidden/></td>
			<td><input id="b_year" name="b_year" placeholder="구입연도" value="${BOOK.b_year}"/></td>
			<td><input id="b_iprice" name="b_iprice" placeholder="구입가격" value="${BOOK.b_iprice}"/></td>
			<td>
				<input id="b_rprice" name="b_rprice" placeholder="대여비용" value="${BOOK.b_rprice}"/>
			</td>
			<td><button id="btn_save" class="main save" type="button" >저장</button></td>
		</tr>
	</table>
</form>
	
<form class="search_form book_search" method="POST" action="${rootPath}/search">
	<input id="search" name="search" placeholder="검색" value="${BOOK_SEARCH}"/>
	<button id="book_btn" class="main search" type="button" >검색</button>
</form>

	<table class="main list">
		<tr>
			<th>도서코드</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>구입연도</th>
			<th>구입가격</th>
			<th>대여가격</th>
			<th></th>
		</tr>
		<c:forEach items="${BOOKS}" var="BOOK">
			<tr data-id="${BOOK.b_code}" >
				<td>${BOOK.b_code}</td>
				<td>${BOOK.b_name}</td>
				<td>${BOOK.b_auther}</td>
				<td>${BOOK.b_comp}</td>
				<td>${BOOK.b_year}</td>
				<td>${BOOK.b_iprice}</td>
				<td>${BOOK.b_rprice}</td>
				<td><a class="a_update">수정</a></td>
			</tr>
		</c:forEach>
	</table>