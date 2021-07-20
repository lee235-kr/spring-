<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  <%@include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${memId == null }">
	입력한 정보가 부족한디;;;?글서 아디 못찾아브러~.
</c:if>
<c:if test="${memId != null }">
	오오 그랴그랴 너그 아디는~${memId}
</c:if>
<a href="../">메인페이지가기</a>
</body>
</html>