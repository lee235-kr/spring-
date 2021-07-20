 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function testDiv(num) {
		if(num==1){
			op1.style.display="";
			op2.style.display="none";
			op3.style.display="none";
			
		}
		else if(num==2){
			op1.style.display="none";
			op2.style.display="";
			op3.style.display="none";
			
		}
		else if(num==3){
			op1.style.display="none";
			op2.style.display="none";
			op3.style.display="";
			
		}
	}
</script>
</head>
<body>
	<ul>
		<li onclick="testDiv(1)">경력3년이상임니당!</li>
		<li onclick="testDiv(2)">석박사급</li>
		<li onclick="testDiv(3)">IT개발자!</li>
	</ul>
<div id ="op1">
	<table>
	<tr><th>성별|나이</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
	<tr><th>a1111</th><th>2222</th><th>3333</th><th>4444</th></tr>
	</table>
</div>
<div id ="op2" Style="display:none">
	<table>
	<tr><th>성별|age</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
	<tr><th>b1111</th><th>2222</th><th>3333</th><th>4444</th></tr>
	</table>
</div>
<div id ="op3" Style="display:none">
	<table>
	<tr><th>성별|몇살이냐고</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
	<tr><th>c1111</th><th>2222</th><th>3333</th><th>4444</th></tr>
	</table>
</div>


</body>
</html>