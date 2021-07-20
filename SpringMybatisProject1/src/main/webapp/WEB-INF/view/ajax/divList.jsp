<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test="${n==1}">
<div id ="op1">
	<table>
	<tr><th>성별|나이</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
	<tr><th>a1111</th><th>2222</th><th>3333</th><th>4444</th></tr>
	</table>
</div>
</c:if>
<c:if test="${n==2}">
<div id ="op2" >
	<table>
	<tr><th>성별|age</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
	<tr><th>b1111</th><th>2222</th><th>3333</th><th>4444</th></tr>
	</table>
</div>
</c:if>
<c:if test="${n==3}">
<div id ="op3">
	<table>
	<tr><th>성별|age</th><th>이력서제목</th><th>학력</th><th>경력</th></tr>
	<tr><th>c1111</th><th>2222</th><th>3333</th><th>4444</th></tr>
	</table>
</div>
</c:if>
