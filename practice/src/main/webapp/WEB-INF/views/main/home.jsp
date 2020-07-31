<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="height: 800px">
<br>



<c:if test ="${user == null}">
<br>
<div class="container">
  <h2>로그인</h2>
  <form action="<%=request.getContextPath()%>/" method="Post">
    <div class="form-group">
      <label>아이디:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    <div class="form-group">
      <label>비밀번호:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
    </div>
   
    <button type="submit" name="login" class="btn btn-primary">로그인</button>
  </form>
</div>
</div>
</c:if>


<script>
	$(function(){
		$('button[name=login]').click(function(){
			if($('#id').val() == "" || $('#id').val() == null )
				alert('아이디를 입력하세요.')
				else if ($('#pw').val() == "" || $('#pw').val() == null )
					alert('비밀번호를 입력하세요.')
			})	
		})
		
</script>