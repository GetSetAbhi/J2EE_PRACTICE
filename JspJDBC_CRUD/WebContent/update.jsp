<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.abhishek.database.DatabaseUtil"%>
<%@ page import="com.abhishek.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String studentId = request.getParameter("studentId");
	int id = Integer.parseInt(studentId);
	Student student = DatabaseUtil.getStudent(id);
	System.out.println("Number of records = " + student.getName());
%>
<h1>Details for <%=student.getName()%></h1>
<table>
	<tr>
		<th><font color='green'>Student Id</font></th>
		<th><font color='green'>Student Name</font></th>
	</tr>
	<tr>
		<td><%=student.getId()%></td>
		<td>
			<form action="update" method="post">
				<input type="hidden" name="studentId" value="<%=student.getId()%>"/>
				<input type="text" name="studentName" value="<%=student.getName()%>"/> 
				<input type="submit" value="Update Record" />
			</form>
		</td>
	</tr>
</table>

</body>
</html>