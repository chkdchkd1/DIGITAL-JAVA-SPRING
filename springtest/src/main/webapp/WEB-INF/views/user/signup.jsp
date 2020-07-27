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
        <label id="id-error" class="error" for=""></label>
        
 <!--        <div class="fail-msg display-none">이미 사용중이거나 탈퇴한 아이디입니다.</div>
        <div class="succ-msg display-none">멋진 아이디네요!!</div> -->
        <div class="container-pw">
            <div class="text-pw">비밀번호</div>  
            <div class="box-pw">
                <input type="password" name="pw" id="pw">
            </div>
        </div>
        <label id="pw-error" class="error" for="pw"></label>
           <div class="container-email">
            <div class="text-bold">이메일</div>
            <div class="box-email">
                <input type="text" name="email" id="email">
            </div>
        </div>
        <label id="email-error" class="error" for="email"></label>
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
		$('#id').keyup(function(){
			var id = $(this).val();
			if(id.length >= 4) {
				//자바스크립트에서 문자열 길이는 length() 가 아니라 length
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

					$('#id-error').html(str);
					// html은 선택자 태그 안의 태그를 읽어온다  .
					
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

			}

			else {
				if(id.length == 0)
					$('#id-error').html('필수항목입니다.');
				else
					$('#id-error').html('아이디는 세글자 이상이어야 합니다. ');
				}

			})


			  $("form").validate({
			        rules: {
			            
			            pw: {
			            	// name="" 과 일치 해야한다 
			                required : true,
			                minlength : 8,
			                maxnlength : 20,
			                regex: /^(?=\w{8,20}$)\w*(\d[A-z]|[A-z]\d)\w*$/
			            },
		
			            email: {
			                required : true,
			                email : true
			            }
			        },
			        //규칙체크 실패시 출력될 메시지
			        messages : {
			        
			            pw: {
			                required : "필수로입력하세요",
			                minlength : "최소 {0}글자이상이어야 합니다",
			                maxlength : "최대 {0}글자이하이어야 합니다",
			                regex : "영문자, 숫자로 이루어져있으며 최소 하나이상 포함"
			            },
			      
			            email: {
			                required : "필수로입력하세요",
			                minlength : "최소 {0}글자이상이어야 합니다",
			                email : "메일규칙에 어긋납니다"
			            }
			        }
			    });

		$.validator.addMethod(
			    "regex",
			    function(value, element, regexp) {
			        var re = new RegExp(regexp);
			        return this.optional(element) || re.test(value);
			    },
			    "Please check your input."
			);
	
 })
 </script>