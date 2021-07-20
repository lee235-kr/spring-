<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이상오company 직원상세정보<br/>
사원번호:${employeeCommand.employeeId }<br/>
사원아이디:${employeeCommand.empUserId }<br/>
사원이름:${employeeCommand.empName }<br/>
입사일:<fmt:formatDate value="${employeeCommand.hireDate}" type="date" pattern="yyyy-MM-dd"></fmt:formatDate> <br/>
직무:${employeeCommand.jobId }<br/>
핸드폰번호:${employeeCommand.phNumber }<br/>
사무실번호:${employeeCommand.officeNumber }<br/>
이메일:${employeeCommand.email }<br/>
직무주소:${employeeCommand.empAddress }<br/>

<a href="empSujung">수정</a>



</body>
</html>