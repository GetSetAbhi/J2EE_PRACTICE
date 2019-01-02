<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Details</h1>
	<c:if test="${not empty message}">
		<p><font color='red'>${message}</font></p>
	</c:if>
	<c:choose>
		<c:when test="${empty studentList}">
			<h1><font color='red'>NO STUDENT RECORD AVAILABLE</font></h1>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th><font color='green'>Student Id</font></th>
					<th><font color='green'>Student Name</font></th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${studentList}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>
						<form action="delete" method="post">
							<input type="hidden" name="studentId" value="${student.id}"/>
							<input type="submit" value="Delete Record"/>
						</form>
					</td>
					<td>
						<form action="update" method="get">
							<input type="hidden" name="studentId" value="${student.id}"/>
							<input type="submit" value="Update Record"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<ol>
		<li><a href="insert">Insert a record</a></li>
		<li><a href="index.jsp">Go To Index</a></li>
	</ol>
</body>
</html>