<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <form action="${pageContext.request.contextPath}/all_students" method="post"> 
		<input type="hidden" name="command" value="update_student" />
		<input type="hidden" name="id" value="${student.id}" />
		First Name:<br />
		<input type="text" name="first name" value="${student.firstName}" /><br />
		 Last Name:<br />
		<input type="text" name="last name" value="${student.lastName}" /><br /> 
		<input type="submit" value="sign in" />
	 </form> 

<br/>
	<a href="${pageContext.request.contextPath}/">Main page</a>
</body>
</html>