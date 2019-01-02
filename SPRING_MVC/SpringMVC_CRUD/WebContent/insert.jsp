<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>CREATE NEW STUDENT</h1>
	
	<form:form method="POST" action="addStudent" modelAttribute="studentForm">
		<form:label path="id">Id</form:label>
    	<form:input path="id" placeholder="Enter Id"/>
		<form:label path="name">Name</form:label>
    	<form:input path="name" placeholder="Enter Name"/>
    	<input type="submit" value="INSERT RECORD" />
	</form:form>
	
	<p><a href="index.jsp">Go To Index</a></p>
</body>
</html>