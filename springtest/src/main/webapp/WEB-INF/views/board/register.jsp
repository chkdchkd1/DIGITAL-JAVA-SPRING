<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<br>
	<form action="<%=request.getContextPath()%>/board/register" method="Post">
		<div class="form-group">
		  <label>제목</label>
		  <input type="text" class="form-control" name="title">
		</div>
		<div class="form-group">
		  <label>내용</label>
		 <textarea class="form-control" rows="5" name="content"></textarea>
		</div>
		 <button type="submit" class="btn btn-primary">등록</button>
	</form>
</body>
</html>