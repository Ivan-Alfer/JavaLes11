<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>asdf</title>
</head>
<body>
	<table>
		<tr>
			<td>ID</td>
			<td>First Name</td>
			<td>Last Name</td>
		</tr>
		
		<c:forEach items="${requestScope.students}" var = "student">
			<tr>
				<td>
					<c:out value="${student.id}"></c:out>
				</td>
				
				<td>
					<a href="${pageContext.request.contextPath}/student?id=${student.id}">
						<c:out value="${student.firstName}"></c:out>
					</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/student?id=${student.id}">
						<c:out value="${student.lastName}"></c:out>
					</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/student/update?id=${student.id}&firstName=${student.firstName}&lastName=${student.lastName}">   Update student</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/delete_student?id=${student.id}">   delete student</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<br/>
	<a href="${pageContext.request.contextPath}/student/new_student">Add new student</a>
	<br/>
	<a href="${pageContext.request.contextPath}/">Main page</a>
</body>
</html>