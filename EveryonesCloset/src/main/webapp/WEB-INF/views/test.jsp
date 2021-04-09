<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	<c:forEach items="${list}" var="test">
	int = ${test.test_INT }<br>
	test = ${test.test_TEXT}<br>
	date = ${test.test_DATE }<br>
	double = ${test.test_DOUBLE }<br>
	</c:forEach>
</body>
</html>