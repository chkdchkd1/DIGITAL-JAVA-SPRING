<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <h2>Hover Rows</h2>
  <p>The .table-hover class enables a hover state (grey background on mouse over) on table rows:</p>   
  <br>         
  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성일</th>
	        <th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
	   		<c:forEach var="board" items="${list}">
	    <!-- jsp 태그 c:foreach //var 변수이름, 하나 끄집어낸 이름  -->
		      <tr>
		        <td>${board.num}</td>
		        <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">${board.title}</a></td> 
		        <td>${board.writer}</td>
		        <td>${board.registerDate}</td>
		        <td>${board.views}</td>
		      </tr>
	      </c:forEach>
	    </tbody>
  </table>
  <br>
   <ul class="pagination justify-content-center">
   	  <c:if test = "${pm.prev}">
	 	 <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}">Previous</a></li>
	  </c:if>
	  <c:forEach var="index" begin="${pm.startPage}" end="${pm.endPage}">
	   	  <li class="page-item <c:if test="${index == pm.criteria.page}">active</c:if>">
	   	  <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}">${index}</a></li>
	  </c:forEach>
	   <c:if test = "${pm.next}">
	  	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}">Next</a></li>
	   </c:if>
</ul>