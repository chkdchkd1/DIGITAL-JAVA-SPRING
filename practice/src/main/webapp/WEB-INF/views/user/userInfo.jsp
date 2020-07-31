<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="post" action="<%=request.getContextPath()%>/userInfo">
  <div class="container3">
        <div class="container-id">
            <div class="text-id">아이디</div>
            <div class="box-id">
                <input type="text" name="id" id="id" value = "${user.id}" readonly>
            </div>
        </div>
        <div class="container-pw">
            <div class="text-pw">비밀번호</div>  
            <div class="box-pw">
                <input type="password" name="pw" id="pw">
                <button type="button" name="check">확인</button>
            </div>
                    <label id="pw-error" class="error" for="pw"></label>               
        </div>
        <div class="container-pw">
            <div class="text-pw">비밀번호 재확인</div>
            <div class="box-pw">
                <input type="password" name="pw2" id="pw2">
            </div>
                    <label id="pw2-error" class="error" for="pw2"></label>                
        </div>
        <div class="container-email">
            <div class="text-bold">이메일</div>
            <div class="box-email">
                <input type="text" name="email" id="email" value = "${userInfo.email}">
            </div>
                <label id="email-error" class="error" for="email"></label>           
        </div>
        <button class="btn-submit" name="submit">수정</button>
    </div>
 </form>
    <script>
    $(function(){

    	$('button[name=check]').click(function(){
			var id = $('input[name=id]').val();
			var pw = $('input[name=pw]').val();
			
					$.ajax({
						async:true,
						type:'POST',
						data:JSON.stringify({"id" : id, "pw": pw}),
						url:"<%=request.getContextPath()%>/pwCheck",
						dataType:"json",
						contentType:"application/json; charset=UTF-8",
						success : function(data){

							if(data['isCheck'] && pw.length >= 8){
								alert('확인되었습니다.')
							}
							 else if(!data['isCheck'] || pw.length < 8){
									alert('기존의 비밀번호와 같은 비밀번호거나 잘못된 비밀번호 입니다.')
									$('input[name=pw]').val('');
								  }
									
							
						}
					});
	})
	

		$("form").validate({
	        rules: {
	            
	            pw: {
	            	  // name="" 과 일치 해야한다 
	                required : true,
	                minlength : 8,
	                regex: /^(?=\w{8,20}$)\w*(\d[A-z]|[A-z]\d)\w*$/
	            },
	            pw2: {
	                required : true,
	                minlength : 8,
	                equalTo : pw
	            },
	       
	            email: {
	                required : true,
	                email : true
	            }
	        },
	        //규칙체크 실패시 출력될 메시지
	        messages : {
	            pw: {
	                required : "필수 항목입니다",
	                minlength : "최소 {0}글자이상이어야 합니다",
	                regex : "영문자, 숫자로 이루어져있으며 최소 하나이상 포함"
	            },
	            pw2: {
	                required : "필수 항목입니다",
	                minlength : "최소 {0}글자이상이어야 합니다",
	                equalTo : "비밀번호가 일치하지 않습니다."
	            },
	            email: {
	                required : "필수 항목입니다",
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