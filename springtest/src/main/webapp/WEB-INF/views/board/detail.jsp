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
			  <label>추천수</label>
			  <input type="text" class="form-control" name="likenum" value="${board.up}" readonly>
			  <button type="button" class ="btn btn-outline-success col-12" id="like">추천하기 </button>
			</div>
			<div class="form-group">
			  <label>내용</label>
			 <textarea class="form-control" rows="5" name="content" readonly >${board.content}</textarea>
			</div>
		</form>
	</c:if>
</c:if>
  <a href="<%=request.getContextPath()%>/board/list?page=${cri.page}&type=${cri.type}&search=${cri.search}">
  <button type="submit" class="btn btn-primary">목록</button></a>
<c:if test = "${user != null }">
  <a href="<%=request.getContextPath()%>/board/register">
  <button type="submit" class="btn btn-primary">글쓰기</button></a>
	<c:if test = "${user.id == board.writer}">
		<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}">
		<button type="submit" class="btn btn-primary">수정</button></a>
		<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}">
		<button type="submit" class="btn btn-primary">삭제</button></a>
	 </c:if>
 </c:if>
 
 
 <script>

 $(function(){
		$('#like').click(function(){
			var num = $('input[name=num]').val();
			
			$.ajax({
		        async:true,
		 	    // 동기 : 앞작업이 끝날 때까지 기다리고 다음 작업을 하는것 (아이디중복검사) , 비동기 : 기다리지 않고 바로 맡기는것,  서로 다른 작업을 동시에 실행할 때 (댓글창) 
		        type:'POST',
		        data:num,
		        // 요청과 함께 서버로 데이터를 전송 할 string 또는 map 
		        url:"<%=request.getContextPath()%>/board/up",
		        dataType:"json",
		        contentType:"application/json; charset=UTF-8",
		        success : function(data){
		        	  // 요청이 성공 했을 때 호출할 콜백 함수 
			        if(!data['usercheck'])
						alert('추천은 로그인한 회원만 할 수 있습니다.')
					else {
						if(data['upcount'] <0)
							alert('이미 추천한 게시물입니다.')
							else {
								
								$('input[name=likenum]').val(data['upcount']);
								
								}
						}
			
		        }
	        
		    });
		})
	})
	
 </script>
 
 </body>
</html>