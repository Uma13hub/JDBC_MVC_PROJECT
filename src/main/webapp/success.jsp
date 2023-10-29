<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import=" jakarta.servlet.http.* "%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HELLO </h1>
<br/>
<br/>
<c:set var=result value="${applicationScope.insert} "/>
	<c:choose>
		<c:when test="${ result eq 'success'}">
		<h1 style="color:green; text-align: center;"> Successed</h1>
		</c:when>
		<c:when test="${ result eq 'failure'}">
		<h1 style="color:green; text-align: center;"> Failed</h1>
		</c:when>
	</c:choose>
		
</body>
</html>