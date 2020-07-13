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
<form>
	<div class="form-group">
	  <label>글번호</label>
	  <input type="text" class="form-control" name="num" value="${detail.num}" readonly>
	</div>
	<div class="form-group">
	  <label>제목</label>
	  <input type="text" class="form-control" name="title" value="${detail.title}" readonly >
	</div>
	<div class="form-group">
	  <label>작성자</label>
	  <input type="text" class="form-control" name="writer" value="${detail.writer}" readonly>
	</div>
	<div class="form-group">
	  <label>조회수</label>
	  <input type="text" class="form-control" name="views" value="${detail.views}" readonly>
	</div>
	<div class="form-group">
	  <label>작성일</label>
	  <input type="text" class="form-control" name="registerDate" value="${detail.registerDate}" readonly>
	</div>
	<div class="form-group">
	  <label>내용</label>
	 <textarea class="form-control" rows="5" name="content" readonly >${detail.content}</textarea>
	</div>
</form>
  <a href="<%=request.getContextPath()%>/board/list">
  <button type="submit" class="btn btn-primary">목록</button></a>
</body>
</html>