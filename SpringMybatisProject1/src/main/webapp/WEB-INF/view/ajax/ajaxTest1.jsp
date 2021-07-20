<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn3").click(function(){
	//$("#frm").submit();
	$("#frm").ajaxSubmit({
		type :"post",
		url: "ajaxTest1",
		dataType:"html",
		success: function(aaaa){
			$("#notice_content").html(aaaa);
		},
		error:function(){
			alert('어류당오류!!!!');
			return;
		}
	});
});
	$("#btn4").click(function(){
		//$("#frm").submit();
		var aaa={
				type :"post",
				url: "ajaxTest1",
				dataType:"html",
				success: function(aaaa){
					$("#notice_content").html(aaaa);
				},
				error:function(){
					alert('어류당오류!!!!');
					return;
				}
			}
		$("#frm").ajaxSubmit(aaa);
});	
$("#btn5").click(function(){
	//$("#frm").submit();
	var aaa= 	{
			type :"post",
			url: "ajaxTest1",
			dataType:"html",
			beforeSubmit : beforeTest ,
			success: okTest,
			error:err
		}
	$("#frm").ajaxSubmit(aaa);
	});
	
});
function err(){
	alert("에라다 시발진짜 ");
	return false;
}
function okTest(responseText,statusText,xhr,$form) {
	if(statusText == "success"){
		$("#notice_content").html(responseText);
		$form.css('background','red');
	}
}
function beforeTest() {
	if($("#n").val()==""){
		alert("값을입력해주세ㅐ요.");
		$("#n").focus();
		return false;
	}else{
		alert("ajax가 submit 하기전에 실행되는 함수");
	}
}
function testDiv(num) {//$.ajax에이작스 사용시 요로케 사영해야하대여 ㅋ
   // location.href="ajaxTest1?n="+num   //동기식 둘다결과값만 보여주는 패이지를 만들어 줘야함 

	$.ajax({//비동기식
		type :"post",
		url: "ajaxTest1",
		dataType:"html",
		data:"n="+num,
		success: function(aaaa){
			$("#notice_content").html(aaaa);
		},
		error:function(){
			alert('어류당오류!!!!');
			return;
		}
	});

}
</script>
</head>
<body>

<ul>
		<li onclick="testDiv(1)">경력3년이상</li>
		<li onclick="testDiv(2)">석박사급</li>
		<li onclick="testDiv(3)">IT개발자</li>
	</ul>
	<div id="notice_content"></div>
	<form name="frm" id="frm" action="ajaxTest1" >
		<input type="text"id="n" name="n">
	</form>
	<button id="btn3">버튼2</button>
	<button id="btn4">버튼3</button>
	<button id="btn5">버튼4</button>
	
</body>
</html>