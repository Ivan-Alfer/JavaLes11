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
			<td>Subject name</td>
		</tr>
		
		<c:forEach items="${requestScope.subjects}" var = "subject">
			<tr>
				<td>
					<c:out value="${subject.id}"></c:out>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/all_student_on_the_subject?id=${subject.id}">
						<c:out value="${subject.subjectName}"></c:out>
					</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/subject/update?id=${subject.id}&subjectName=${subject.subjectName}">   Update subject</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/delete_subject?id=${subject.id}">   delete subject</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<br/>
	<a href="${pageContext.request.contextPath}/subject/new_subject">Add new subject</a>
	<br/>
	<a href="${pageContext.request.contextPath}/">Main page</a>
</body>
</html>