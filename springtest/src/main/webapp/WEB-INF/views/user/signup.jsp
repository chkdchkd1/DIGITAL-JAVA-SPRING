<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  
<br>
<br>
 <form method="post" action="<%=request.getContextPath()%>/user/signup">
	<div class="container-body">
        <div class="container-id">
            <div class="text-id">아이디</div>
            <div class="box-id">
                <input type="text" name="id" id="id" > 
            </div>
        </div>
        <div class="id-msg"></div>
 <!--        <div class="fail-msg display-none">이미 사용중이거나 탈퇴한 아이디입니다.</div>
        <div class="succ-msg display-none">멋진 아이디네요!!</div> -->
        <div class="container-pw">
            <div class="text-pw">비밀번호</div>  
            <div class="box-pw">
                <input type="password" name="pw" id="pw">
            </div>
        </div>
           <div class="container-email">
            <div class="text-bold">이메일</div>
            <div class="box-email">
                <input type="text" name="email" id="email">
            </div>
        </div>
        <div class="container-gender">
            <div class="text-gender">성별</div>
            <div class="box-gender">
                <select name="gender" id="gender">
                    <option value="non-set">선택안함</option>
                    <option value="female">여성</option>
                    <option value="male">남성</option>
                </select>
            </div>
        </div>
           <button class="btn-submit">가입하기</button>
      </div>
      </form>
      
 <script>
 	$(function(){
		$('#id').change(function(){
			var id = $(this).val();
			$.ajax({
				async:true,
				type:'POST',
				data:id,
				url:"<%=request.getContextPath()%>/idCheck",
				dataType:"json",
				contentType:"application/json; charset=UTF-8",
				success : function(data){
					var str;
					if(data['isUser']){
						str =
							'<p style="color:green">사용 가능한 아이디입니다. </p>' 
					} else {
						str = 
							'<p style="color:red">이미 가입 되어있거나 탈퇴한 아이디입니다. </p>' 
							
						}

					$('.id-msg').html(str);
					
			 	/* if(data['isUser']){
						$('.succ-msg').removeClass('display-none')
						$('.fail-msg').addClass('display-none')
						} else {
							$('.succ-msg').addClass('display-none')
							$('.fail-msg').removeClass('display-none')
							}
						*/	 
				}
			});

			})
 })
 </script>