<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Subject</td>
			<td>Mark</td>
		</tr>

		<c:forEach items="${requestScope.marks}" var="mark">
			<tr>
				<td><c:out value="${mark.studentId}"></c:out></td>
				<td><c:out value="${mark.studentFirstName}"></c:out></td>
				<td><c:out value="${mark.studentLastName}"></c:out></td>
				<td><c:out value="${mark.subjectName}"></c:out></td>
				<td><c:out value="${mark.mark}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>