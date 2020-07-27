<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
		<form action="<%=request.getContextPath()%>/board/modify" method="Post" enctype="multipart/form-data"> \
	<!--  사진을 전송할 때 enctype 잊즤 말긔 -->
			<div class="form-group">
			  <input type="hidden" class="form-control" name="num" value="${board.num}" readonly>
			</div>
			<div class="form-group">
			  <label>제목</label>
			  <input type="text" class="form-control" name="title" value="${board.title}"  >
			</div>
			<div class="form-group">
			  <label>작성자</label>
			  <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
			</div>
			<div class="form-group">
			  <input type="hidden" class="form-control" name="views" value="${board.views}" readonly>
			</div>
			<div class="form-group">
			  <input type="hidden" class="form-control" name="registerDate" value="${board.registerDate}" readonly>
			</div>
			<div class="form-group">
			  <label>내용</label>
			 <textarea class="form-control" rows="5" name="content">${board.content}</textarea>
			</div>
			
			<div class="box-file">
	        <label>파일</label><br>
	        <c:if test = "${board.file != null}">
	        <span>${board.oriFile}</span>
	        <button type="button" id="btn-file-close"><i class="fas fa-times"></i></button>
	        </c:if>
	          <input type="hidden" name="file" value="${board.file}">
	          <!-- 	// 이때 현재 파일 값을 가진 input이 있어야함 -> 그리고 이걸 비워야   -->
	        </div>
	        
	        <div class="form-group">
	        <input type = "file" name = "file2">
    		</div>
			
			  <a href="<%=request.getContextPath()%>/board/list">
			  <button type="submit" class="btn btn-primary">목록</button></a>
			  <button type="submit" class="btn btn-primary">수정</button>
				</form>
	</c:if>
</c:if>

<script>
	$(function(){
			$('#btn-file-close').click(function(){
					$('.box-file').css('display','none');
					$('input[name=file]').val('');
					//$('.box-file').empty()
					
				})
				
			$('input[name=file2]').change(function(){
				if($('input[name=file]').val() != ''){
					$(this).val('');
					alert('파일은 하나만 첨부 할 수 있습니다.')
					}

				/* if($('input[name=file]').val() == '' || 
				   $('input[name=file]').val() == null ||
				   	typeof($('input[name=file]').val()) == 'undefined')
				   	//typeof : 변수의 데이터 타입을 반환하는 연산자 -> undefined : 변수가 정의되지 않거나 값이 없을 때
				   	return ;
				$(this).val('');
				alert('파일은 하나만 첨부 할 수 있습니다.')
				*/
					})
				 
		})
</script>


