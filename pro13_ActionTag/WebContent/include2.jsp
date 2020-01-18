<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="joke.jsp" flush="true">
		<jsp:param value="nongdam2" name="name"/>
		<jsp:param name="imgName" value="nong3.jpeg" />
	</jsp:include>
</body>
</html>