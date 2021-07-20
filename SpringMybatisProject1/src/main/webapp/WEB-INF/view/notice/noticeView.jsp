<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글 번호: ${dto.noticeNo }<br/>
글 제목:${dto.noticeSub }<br/>
글 내용:${dto.noticeCon }<br/>
등록일:${dto.noticeDate }<br/>
종류:${dto.noticeKind }<br/>
읽은귀염둥이들~:${dto.noticeCount }<br/>
등록한 사원변호:${dto.employeeId }<br/>
<br/>
<a href="noticeUpdate?noticeNo=${ dto.noticeNo}">수정</a> 
</body>
</html>