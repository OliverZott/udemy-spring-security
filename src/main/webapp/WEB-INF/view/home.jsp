<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<title>Title of Demo Page</title>
</head>

<body>
	<h2>Heading of Demo Page</h2>


	<hr>

	<p>Hello guys and girls</p>

	<!-- Add form for logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout">

	</form:form>
</body>

</html>