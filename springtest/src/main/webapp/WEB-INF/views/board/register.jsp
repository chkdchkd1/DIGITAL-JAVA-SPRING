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
	<form action="<%=request.getContextPath()%>/board/register" method="Post"  enctype="multipart/form-data">
		<div class="form-group">
		  <label>제목</label>
		  <input type="text" class="form-control" name="title">
		</div>
		<div class="form-group">
	        <label>파일</label>
	        <input type="file" class="form-control" name="file2"/>
	        <!-- boardVo file은 (string)인데 name을 file로 하면 (data) boardVo file에 들어가서 타입미스 매치가 일어나기 때문에 들어가지 않게 하기 위해서 ㅇㅇ   -->
    	</div>
		<div class="form-group">
		  <label>내용</label>
		 <textarea class="form-control" rows="5" name="content"></textarea>
		</div>
		 <button type="submit" class="btn btn-primary">등록</button>
	</form>
</body>
</html>