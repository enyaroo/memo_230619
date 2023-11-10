<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="d-flex justify-content-center">
	<div class="w-50">
		<h1>글 목록</h1>
		
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>제목</th>
					<th>작성날짜</th>
					<th>수정날짜</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${postList}" var="post">
				<tr>
					<td>${post.id}</td>
					<td><a href=""></a></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<%-- paging --%>
		<div class="text-center">
			<c:if test="${prevId ne 0}">
				<a href="/post/post-list-view?prevId=${prevId}">이전</a>
			</c:if>
			<c:if test="${nextId ne 0}">
				<a href="/post/post-list-view?nextId=${nextId}">다음</a>
			</c:if>
		</div>
		
		<div>
		</div>
	</div>
</div>