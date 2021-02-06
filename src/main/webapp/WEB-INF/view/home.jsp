<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<html>
<head>
	<title>Title of Demo Page</title>
</head>

<body>
<h2>Heading of Demo Page</h2>


<hr>

<p>Hello guys and girls</p>

<hr>

<p>
	<!-- Display user name and role -->
	User: <security:authentication property="principal.username"/>
	<br> <br>
	Roles: <security:authentication property="principal.authorities"/>
</p>

<hr>

<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Manager Area</a>
		Managers only.
	</p>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/systems">Admin Area</a>
		Admins only.
	</p>
</security:authorize>

<hr>

<!-- Add form for logout button -->
<form:form action="${pageContext.request.contextPath}/logout"
		   method="POST">

	<input type="submit" value="Logout">

</form:form>
</body>

</html>