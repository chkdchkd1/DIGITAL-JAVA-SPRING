<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <br>
    <h2>게시글</h2>
    <br>
    
  <form method="Post" action="<%=request.getContextPath()%>/board/modify" >
  <!-- 내가 데이터를 보낼 때 어디로 보낼지 알려주는게 action , method를 post로 쓰는 이유는 전달할 데이터양이 많기 때문-->
   <div class="form-group">
      <label>게시글 번호</label>
      <input type="text" class="form-control"  name="num" value="${board.num}" readonly >
    </div>
    <div class="form-group">
      <label>제목</label>
      <input type="text" class="form-control"  name="title" value="${board.title}">
    </div>
    <div class="form-group">
      <label>작성자</label>
      <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
    </div>
     <div class="form-group">
      <label>작성일</label>
      <input type="text" class="form-control" name="registerDate" value="${board.registerDate}" readonly >
    </div>
    <div class="form-group">
      <label>조회수</label>
      <input type="text" class="form-control"  name="views" value="${board.views}" readonly>
    </div>
    <div class="form-group">
  <label>내용:</label>
  <textarea class="form-control" rows="5" name="content">${board.content}</textarea>
</div>
	 <button type="submit" class="btn btn-primary">수정하기</button>
  </form>

  <a href="<%=request.getContextPath()%>/board/register">
  <button type="submit" class="btn btn-primary">글쓰기</button></a>
  
  
  