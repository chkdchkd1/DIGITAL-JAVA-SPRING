<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <br>
 <br>
 <form action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">

<input type="hidden" class="form-control"  name="num" value="${board.num}" readonly >
<div class="form-group">
  <label>제목</label>
  <input type="text" class="form-control" name="title" value="${board.title}">
</div>
<div class="form-group">
  <label>작성자</label>
  <input type="text" class="form-control" name="writer" value="${board.writer}" readonly> 
</div>

<div class="form-group">
  <label >글내용:</label>
  <textarea class="form-control" rows="5" name="content"> ${board.content}</textarea>
</div>

<c:if test = "${board.file !=null}">
<div class="file-box">
<span>${board.oriFile}</span>
 <button type="button" id="btn-file-close"><i class="fas fa-times"></i></button>
</div>
 <input type="hidden" name="file" value="${board.file}">
</c:if>

 <div class="form-group">
      <input type="file" class="form-control border" name="file2">
  </div>


<button type="submit" class="btn-right btn btn-dark">수정</button>
</form>

  
 <script>
	$(function(){
			$('#btn-file-close').click(function(){
					$('.file-box').addClass('display-none');
					$('input[name=file]').val('');
				})
				
			$('input[name=file2]').change(function(){
					if( $('input[name=file]').val() == '' || $('input[name=file]').val() == null )
						return ; 
					$(this).val('');
					alert('기존파일을 삭제한 후에 새로 첨부 할 수 있습니다.')
					//!=이 안먹히면 if문을 반대로 ㅇㅇ ㅆ ㅓ본당...
				})
		})
 </script>