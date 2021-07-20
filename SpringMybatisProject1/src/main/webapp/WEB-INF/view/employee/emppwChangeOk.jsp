<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btn").click(function() {
		if($($("#empoldPw")).val() == "") {
			alert("현재 비밀번호를 입력하세요.");
			$("#empoldPw").focus();
			return false;
		}
		if($($("#empPw")).val() == "") {
			alert("새로운 비밀번호를 입력하세요.");
			$("#empPw").focus();
			return false;
		} 
		if($($("#empPwCon")).val() == "") {
			alert("새로운 비밀번호를 한번 더 입력하세요.");
			$("#empPwCon").focus();
			return false;
		} else {
			if($("#empPw").val() != $("#empPwCon").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#empPw").val("");
				$("#empPwCon").val("");
				$("#empPw").focus();
				return false;
			}
		}
		$("#frm").submit();
	});
});
</script>
</head>
<body>
<form:form action="empChangePw" name="frm" method="post" id="frm" modelAttribute="employeeCommand">
현재 비밀번호 : <form:password path="empoldPw" />
			<form:errors path="empoldPw"/><br />
새 비밀번호 : <input type="password" name="empPw"/> 
			<form:errors path="empPw"/>
<br />
새 비밀번호 확인 : <input type="password" name="empPwCon" />
				<form:errors path="empPwCon"/><br />
<br />
		
<input type="button" value="비밀번호 변경" id="btn" />
</form:form>
</body>
</html>