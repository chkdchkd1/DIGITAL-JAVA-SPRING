<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <br>
 <br>
 <form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">

<div class="form-group">
  <label>제목</label>
  <input type="text" class="form-control" name="title">
</div>

<div class="form-group">
  <label >글내용:</label>
  <textarea class="form-control" rows="5" name="content"></textarea>
</div>

 <div class="form-group">
      <input type="file" class="form-control border" name="file2">
  </div>

<button type="submit" class="btn-right btn btn-dark">등록</button>
</form>

