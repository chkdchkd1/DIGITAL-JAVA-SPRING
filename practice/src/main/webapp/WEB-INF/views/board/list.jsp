<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br>
<div class="container">
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
        <td>${board.title}</td>
        <td>${board.writer}</td>
        <td>${board.registerDate}</td>
        <td>${board.views}</td>
      </tr>
      </c:forEach>
      
    </tbody>
  </table>
  
</div>


</body>
</html>