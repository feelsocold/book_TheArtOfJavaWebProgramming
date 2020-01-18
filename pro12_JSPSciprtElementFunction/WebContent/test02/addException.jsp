<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>
	=====toString() 내용===== <br>
	<h1><%=exception.toString() %></h1>
	=====getMessage() 내용==== <br>
	<h1><%=exception.getMessage() %></h1>
	=====printStackTrace()==== <br>
	<h1><%exception.printStackTrace(); %></h1>		<!-- 이클립스 콘솔로 예외 메시지출력 -->
	<h3>숫자만 입력 가능합니다.</h3>
	<a href="add.html">다시하기</a>
</body>
</html>