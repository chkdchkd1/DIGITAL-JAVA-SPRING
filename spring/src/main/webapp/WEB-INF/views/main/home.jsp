<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test = "${user == null}">
<div style="height: 800px">
	<h1>
	로그인  
	</h1>
	<form action="<%=request.getContextPath()%>/" method="post">
		<input type="text" name ="id" placeholder="아이디">
		<input type="password" name ="pw" placeholder="비밀번호">
		<button>로그인</button>
	</form>
</div>
</c:if>

<button id="ajax">버튼</button>
<script>
	$(function(){
		$('#ajax').click(function(){

			$.ajax({
		        async:true,
		        // 동기 : 앞작업이 끝날 때까지 기다리고 다음 작업을 하는것 (아이디중복검사) , 비동기 : 기다리지 않고 바로 맡기는것,  서로 다른 작업을 동시에 실행할 때 (댓글창) 
		        type:'POST',
		        data:JSON.stringify({"id" : "123", "num": "456"}),
		        // 전송할 데이터
		        //()안에 있는 객체(object)를 json의 문자열로 바꿔주는 것 , 콤마 실수 주의,,!
		        // 여러개의 데이터를 보낼 때 
		        url:"<%=request.getContextPath()%>/test2",
		        dataType:"json",
		        contentType:"application/json; charset=UTF-8",
		        success : function(data){
		        	  // 요청이 성공 했을 때 호출할 콜백 함수 
					console.log(data['res']);
		        }
		            
		        });

			    })

			
			})
			

	</script>