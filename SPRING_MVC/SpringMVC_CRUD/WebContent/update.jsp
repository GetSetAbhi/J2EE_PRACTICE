<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Details for ${studentForm.name}</h1>
	<table>
		<tr>
			<th><font color='green'>Student Id</font></th>
			<th><font color='green'>Student Name</font></th>
		</tr>
		<tr>
			<td>${studentForm.id}</td>
			<td>
				<form:form method="POST" action="updateStudent" modelAttribute="studentForm">
			    	<form:input path="id" type="hidden"/>
					<form:label path="name"></form:label>
			    	<form:input path="name" value="${studentForm.name}"/>
			    	<input type="submit" value="Update Record" />
				</form:form>
			</td>
		</tr>
	</table>
	<ol>
		<li><a href="insert">Insert a record</a></li>
		<li><a href="index.jsp">Go To Index</a></li>
	</ol>
</body>
</html>