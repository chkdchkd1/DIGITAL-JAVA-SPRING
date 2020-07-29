<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<br>
<br>
<form>
<div class="form-group">
  <label>글번호</label>
  <input type="text" class="form-control" name="num" value="${board.num}" readonly>
</div>
<div class="form-group">
  <label>제목</label>
  <input type="text" class="form-control" name="title" value="${board.title}" readonly>
</div>
<div class="form-group">
  <label>작성자</label>
  <input type="text" class="form-control" name="writer" value="${board.writer}" readonly> 
</div>
<div class="form-group">
  <label>작성일자</label>
  <input type="text" class="form-control" name="registerDate" value="${board.registerDate}" readonly>
</div>
<div class="form-group">
  <label>조회수</label>
  <input type="text" class="form-control" name="views" value="${board.views}" readonly>
</div>
<div class="form-group">
  <label >글내용:</label>
  <textarea class="form-control" rows="5" name="content" readonly>${board.content}</textarea>
</div>
<c:if test = "${board.file !=null}">
 <div class="form-group">
  <a href ="<%=request.getContextPath()%>/board/download?fileName=${board.file}">${board.oriFile}</a>
</div>
</c:if>
</form>

<a href="<%=request.getContextPath()%>/board/list?&page=${cri.page}&type=${cri.type}&search=${cri.search}"><button type="button" class="btn-right btn btn-dark">목록</button></a>
<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}"><button type="button" class="btn-right btn btn-dark">삭제</button></a>
<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}"><button type="button" class="btn-right btn btn-dark">수정</button></a>

<br>
<br>
<Br>