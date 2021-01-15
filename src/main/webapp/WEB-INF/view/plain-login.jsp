<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<title>Custom Login Page</title>

<!-- Link to outsourced css file -->
<link rel="stylesheet" type="text/css" href="css/demo.css">

</head>


<body>
	<h3>Login</h3>

	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<!-- Check login error -->
		<c:if test="${param.error != null}">
			<i class="failed">Credentials invalid!</i>
		</c:if>


		<!-- IMPORTANT: use "name=username/password" for Spring Security Filters -->
		<p>
			User name: <input type="text" name="username">
		</p>
		<p>
			Password: <input type="password" name="password">
		</p>

		<input type="submit" value="Login" />

	</form:form>

</body>





</html>