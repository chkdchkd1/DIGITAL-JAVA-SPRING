<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<br>
<br>
 <form method="post" action="<%=request.getContextPath()%>/signup">
	<div class="container-body">
        <div class="container-id">
            <div class="text-id">아이디</div>
            <div class="box-id">
                <input type="text" name="id" id="id">
            </div>
            <label id ="id-error" class="error" for="id"></label>
            <div class="dup-fail-msg display-none">이미 사용중이거나 탈퇴한 아이디입니다.</div>
            <div class="dup-suc-msg display-none">멋진 아이디네요!!</div>
            
        </div>
        <div class="container-pw">
            <div class="text-pw">비밀번호</div>  
            <div class="box-pw">
                <input type="password" name="pw" id="pw">
            </div>
             <label id ="pw-error" class="error" for="pw"></label>
        </div>
           <div class="container-email">
            <div class="text-bold">이메일</div>
            <div class="box-email">
                <input type="text" name="email" id="email">
            </div>
             <label id ="email-error" class="error" for="email"></label>
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
			$('#id').keyup(function(){
				// change 와 keyup (change는 tap을 할 때 반응하고 keyup은 key를 누를때 반응하는 것 이기 때문에 keyup이 반응이 더빠르다 )
				var id = $(this).val();
				if(id.length >= 4)
					// ajax와 유효성 검사가 둘다 각자 반응하는것을 막아주기 위해 (4자 미만일때도 ajax는 좋은 아이디어라고 뜸ㅇㅇ..)
				$.ajax({
			        async:true,
			        // 동기 : 앞작업이 끝날 때까지 기다리고 다음 작업을 하는것 (아이디중복검사) , 비동기 : 기다리지 않고 바로 맡기는것,  서로 다른 작업을 동시에 실행할 때 (댓글창) 
			        type:'POST',
			        data:id,
			        // 전송할 데이터
			        url:"<%=request.getContextPath()%>/idCheck",
			        dataType:"json",
			        contentType:"application/json; charset=UTF-8",
			        success : function(data){
			        	  // 요청이 성공 했을 때 호출할 콜백 함수 
			           if(data['check']){
				           $('.dup-suc-msg').removeClass('display-none')
				           $('.dup-fail-msg').addClass('display-none')
				        }else{
				           $('.dup-suc-msg').addClass('display-none')
				           $('.dup-fail-msg').removeClass('display-none')
				        }
			            
			        }
			    });

				else {

			           $('.dup-suc-msg').addClass('display-none')
			           $('.dup-fail-msg').addClass('display-none')

					}
			    
				
				})

				$("form").validate({
			        rules: {
			            id: {
			                required : true,
			                //필수조건
			                minlength : 4
			            },
			            pw: {
			                required : true,
			                minlength : 8,
			                maxlength : 20,
			                regex: /^\w*(\d[A-z]|[A-z]\d)\w*$/
				                //글자가 8 ~ 20 자 (?=\w{8,20}$) = 정규 표현식 
			            },
			  /*   
			            age: {
			                digits : true
			                //digits = 숫자만 와야한다 
			            }, */
			            
			            email: {
			                required : true,
			                email : true
			                // email 유효성 미리 설정 되어있다 
			            },
			            gender : {
			                required : true
			            }
			        },
			        //규칙체크 실패시 출력될 메시지
			        messages : {
			            id: {
			                required : "필수로입력하세요",
			                minlength : "최소 {0}글자이상이어야 합니다"
			            },
			            pw: {
			                required : "필수로입력하세요",
			                minlength : "최소 {0}글자이상이어야 합니다",
			                maxlength : "최소 {0}글자이하이어야 합니다",
			                regex : "영문자, 숫자로 이루어져있으며 최소 하나이상 포함"
			            },
			     
			            email: {
			                required : "필수로 입력하세요",
			                email : "메일규칙에 어긋납니다"
			            },
			            gender: {
			                reqired : "필수로 입력하세요 "
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
			// https://maengdev.tistory.com/162 (ajax참고)
			// AJAX는 AJAX 자체가 브라우저라고 생각하면 된다.

			/* URL을 받고, AJAX 내부에서 XMLHttpRequest 통신을 해서 URL(서버)로 연결시켜준다.
			서버에서 받아온 데이터들을 AJAX가 받는다.*/
			//https://velog.io/@surim014/AJAX%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80 (ajax 참고)

      </script>
     

    
    