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
<c:if test ="${board eq null }">
	<h1>해당 게시물은 없는 게시물입니다.1</h1>
</c:if>
<c:if test ="${board ne null }">
	<c:if test ="${board.isDel == 'Y'.charAt(0)}">
	<!-- 'Y'를 문자열로 인식하기때문에 char로 바꾸주어야 isDel이 char이기에   -->
		<h1>해당 게시물은 삭제된 게시물 입니다. </h1>
	</c:if>
	<c:if test ="${board.isDel == 'N'.charAt(0)}">
		<form>
			<div class="form-group">
			  <label>글번호</label>
			  <input type="text" class="form-control" name="num" value="${board.num}" readonly>
			</div>
			<div class="form-group">
			  <label>제목</label>
			  <input type="text" class="form-control" name="title" value="${board.title}" readonly >
			</div>
			<div class="form-group">
			  <label>작성자</label>
			  <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
			</div>
			<div class="form-group">
			  <label>조회수</label>
			  <input type="text" class="form-control" name="views" value="${board.views}" readonly>
			</div>
			<div class="form-group">
			  <label>작성일</label>
			  <input type="text" class="form-control" name="registerDate" value="${board.registerDate}" readonly>
			</div>
			<div class="form-group">
			  <label>내용</label>
			 <textarea class="form-control" rows="5" name="content" readonly >${board.content}</textarea>
			</div>
		</form>
	</c:if>
</c:if>
  <a href="<%=request.getContextPath()%>/board/list">
  <button type="submit" class="btn btn-primary">목록</button></a>
  <a href="<%=request.getContextPath()%>/board/register">
  <button type="submit" class="btn btn-primary">글쓰기</button></a>
  <a href="<%=request.getContextPath()%>/board/modify?num=${board.num}">
  <button type="submit" class="btn btn-primary">수정</button></a>
</body>
</html>