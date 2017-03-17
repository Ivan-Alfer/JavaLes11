<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert title here</h1>
	 <form action="${pageContext.request.contextPath}/add_mark" method="post">
	<input type="hidden" name="command" value="add_mark" /> 
	Student:<br />
	<c:forEach items="${requestScope.students}" var ="student">
		<input type="radio" name="studentId" value= "${student.id}"><c:out value="${student.firstName}"/><br/><c:out value="${student.lastName}"></c:out><br/>
	</c:forEach>
	Mark:<br />
	<input type="text" name="mark" value="" /><br /> 
		
	<input type="hidden" name="subjectId" value="${param.id}" />
	<input type="submit" value="submit" />
	<br/>
	</form> 
	<br/>
	
	
	
	<a href="${pageContext.request.contextPath}/">Main page</a>
	<br/>
</body>
</html>