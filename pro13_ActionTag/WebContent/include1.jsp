<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
안녕하세요
<jsp:include page="joke.jsp" flush="true">
	<jsp:param value="농담곰" name="name"/>
	<jsp:param value="nong1.gif" name="imgName"/>
</jsp:include>
</body>
</html>