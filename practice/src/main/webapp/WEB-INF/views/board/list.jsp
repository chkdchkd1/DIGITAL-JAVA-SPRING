<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<br>
<label class="label-right">${user.id} 회원</label> 
<form>
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>num</th>
        <th>title</th>
        <th>writer</th>
        <th>registerDate</th>
        <th>views</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach var="board" items="${list}">
      <tr>
        <td>${board.num}</td>
        <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}&page=${pm.criteria.page}&type=${pm.criteria.type}&search=${pm.criteria.search}">${board.title}</a></td>
        <td>${board.writer}</td>
        <td>${board.registerDate}</td>
        <td>${board.views}</td>
      </tr>
      </c:forEach>
      
    </tbody>
  </table>
</form>
<br>
 <form action="<%=request.getContextPath()%>/board/list">
	<div class="form-group select-box">
	  <select class="form-control2" name="type">
	    <option value="0" <c:if test="${pm.criteria.type == 0}">selected</c:if>>전체</option>
	    <option value="1" <c:if test="${pm.criteria.type == 1}">selected</c:if>>제목</option>
	    <option value="2" <c:if test="${pm.criteria.type == 2}">selected</c:if>>작성자</option>
	    <option value="3" <c:if test="${pm.criteria.type == 3}">selected</c:if>>내용</option>
	  </select>
	         <input type="text" class="form-group search-box" placeholder="search" name="search" value="${pm.criteria.search}">
	        <button type="submit" class="btn btn-primary search-btn">검색</button>
	</div>
</form>
<br>
 <ul class="pagination justify-content-center">
 	<c:if test="${pm.prev}">
    	<li class="page-item">
    		<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&type=${pm.criteria.type}&search=${pm.criteria.search}"><i class="fas fa-angle-double-left"></i></a></li>
    </c:if>
 	<c:if test = "${pm.criteria.page != 1 }">
		 <li class="page-item">
	 		<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.criteria.page-1}&type=${pm.criteria.type}&search=${pm.criteria.search}"><i class="fas fa-chevron-left"></i></a></li>
	</c:if>
	<c:forEach var="index" begin="${pm.startPage}" end="${pm.endPage}">
	   	  <li class="page-item <c:if test="${index == pm.criteria.page}">active</c:if>">
	   	  	<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&type=${pm.criteria.type}&search=${pm.criteria.search}">${index}</a></li>
	 </c:forEach>
	 <c:if test = "${pm.criteria.page != pm.lastEndPage }">
		 <li class="page-item">
	 		<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.criteria.page+1}&type=${pm.criteria.type}&search=${pm.criteria.search}"><i class="fas fa-chevron-right"></i></a></li>
	</c:if>
 	<c:if test="${pm.next}">
    	<li class="page-item">
    		<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&type=${pm.criteria.type}&search=${pm.criteria.search}"><i class="fas fa-angle-double-right"></i></a></li>
    </c:if>
  </ul>

<c:if test="${user != null}"> 
	<a href="<%=request.getContextPath()%>/board/register"><button type="button" class="btn-right btn btn-dark">글쓰기</button></a>
</c:if>
<br>