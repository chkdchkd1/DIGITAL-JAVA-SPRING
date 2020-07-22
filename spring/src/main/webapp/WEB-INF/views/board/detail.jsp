<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <br>
    <h2>게시글</h2>
    <br>
  <form>
   <div class="form-group">
      <label>게시글 번호</label>
      <input type="text" class="form-control"  name="num" value="${board.num}" readonly >
    </div>
    <div class="form-group">
      <label>제목</label>
      <input type="text" class="form-control"  name="title" value="${board.title}" readonly>
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
      <label>추천수</label>
      <input type="text" class="form-control"  name="like" value="${board.like}" readonly>
      <button type= "button" class= "btn btn-outline-success col-12" id="like">추천</button>
    </div>
    
    <div class="form-group">
  <label>내용:</label>
  <textarea class="form-control" rows="5" name="content" readonly >${board.content}</textarea>
</div>

<c:if test = "${board.file !=null}">
 <div class="form-group">
  <a href ="<%=request.getContextPath()%>/board/download?fileName=${board.file}">${board.oriFile}</a>
</div>
</c:if>
  </form>


  <a href="<%=request.getContextPath()%>/board/list?&page=${cri.page}&type=${cri.type}&search=${cri.search}">
  <button type="submit" class="btn btn-primary">목록</button></a>
  <c:if test="${user != null }">
  <a href="<%=request.getContextPath()%>/board/register">
  <button type="submit" class="btn btn-primary">글쓰기</button></a>
  </c:if>
  <c:if test="${user != null && user.id == board.writer}">
   <a href="<%=request.getContextPath()%>/board/modify?num=${board.num}">
  <button type="submit" class="btn btn-primary">수정</button></a>
  <a href="<%=request.getContextPath()%>/board/delete?num=${board.num}">
  <button type="submit" class="btn btn-primary">삭제</button></a>
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
		        url:"<%=request.getContextPath()%>/board/like",
		        dataType:"json",
		        contentType:"application/json; charset=UTF-8",
		        success : function(data){
		        	  // 요청이 성공 했을 때 호출할 콜백 함수 
			        console.log(data)
			         if(!data['isUser']) {
						alert("로그인한 회원만 추천할 수 있습니다.")
				        } else {
					        	 if(data['like']<0){
						     		alert("추천은 1번만 가능합니다.")
					      	  }	else{
								 $('input[name=like]').val(data['like'])
						      }
		        }
		        }
	        
		    });
		})
	})
	
	
  	 	
 	 	</script>


 
