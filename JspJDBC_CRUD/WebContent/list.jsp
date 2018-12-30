<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="com.abhishek.database.DatabaseUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Connection con = null;
Statement stmt = null;
ResultSet rs = null;

String message = "";

if (session.getAttribute("insertMessage") != null) {
	message = String.valueOf(session.getAttribute("insertMessage"));
	session.removeAttribute("insertMessage");
}
if (session.getAttribute("deleteMessage") != null) {
	message = String.valueOf(session.getAttribute("deleteMessage"));
	session.removeAttribute("deleteMessage");
}
if (session.getAttribute("updateMessage") != null) {
	message = String.valueOf(session.getAttribute("updateMessage"));
	session.removeAttribute("updateMessage");
}
try {
	String query = "SELECT * FROM student_details";
	con = DatabaseUtil.getConnection();
	stmt = con.createStatement();
	rs = stmt.executeQuery(query);
	rs.last();
	int resultCount = rs.getRow();
	System.out.println("Number of records = " + resultCount);
	rs.first();
	
	if (rs != null) {
		if (resultCount != 0) {
			
%>
			<p><font color='red'><%=message%></font></p>
			<h1>Student Details</h1>
			<table>
				<tr>
					<th><font color='green'>Student Id</font></th>
					<th><font color='green'>Student Name</font></th>
					<th></th>
					<th></th>
				</tr>
		<%
			do {
				String id = rs.getString(1);
				String name = rs.getString(2);
		%>		
				<tr>
					<td><%=id%></td>
					<td><%=name%></td>
					<td>
						<form action="delete" method="post">
							<input type="hidden" name="studentId" value="<%=id%>"/>
							<input type="submit" value="Delete Record"/>
						</form>
					</td>
					<td>
						<form action="update.jsp" method="post">
							<input type="hidden" name="studentId" value="<%=id%>"/>
							<input type="submit" value="Update Record"/>
						</form>
					</td>
				</tr>
		<%
			}while(rs.next());
		%>
			</table>
			<ol>
				<li><a href="insert.html">Insert a record</a></li>
				<li><a href="index.html">Go To Index</a></li>
			</ol>	
<%
		} else {
%>
			<h1><font color='red'>NO STUDENT RECORD AVAILABLE</font></h1>
			<ol>
				<li><a href="insert.html">Insert a record</a></li>
				<li><a href="index.html">Go To Index</a></li>
			</ol>	
<%			
		}
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally {
	DatabaseUtil.closeConnections(rs, stmt, con);
}
%>
</body>
</html>