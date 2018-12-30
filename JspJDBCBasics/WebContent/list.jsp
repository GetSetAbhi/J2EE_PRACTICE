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
try {
	String query = "SELECT * FROM student_details";
	con = DatabaseUtil.getConnection();
	stmt = con.createStatement();
	rs = stmt.executeQuery(query);
	
	if (rs != null) {
%>
		<h1>Student Details</h1>
		<table><tr><th><font color='green'>Student Id</font></th><th><font color='green'>Student Name</font></th></tr>
	<%
		if(rs.next()) {
			String fn = rs.getString(1);
			String ln = rs.getString(2);
	%>		
			<tr><td><%=fn%></td><td><%=ln%></td></tr>
	<%
		} else {
	%>
			</table>
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