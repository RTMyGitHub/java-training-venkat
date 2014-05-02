<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.errorMessgae
{
color:red;
}
</style>

</head>
<body>

<sf:form method="POST" modelAttribute="customer" action="/springmvcform/customer/signup.do">

<sf:errors path="*" cssClass="errorMessgae"/>

<h2>Please enter the customer details and press Submit</h2>

First Name 	: <sf:input path="firstName"/> <sf:errors path="firstName"/> <br/><br/>
Last Name 	: <sf:input path="lastName"/> <sf:errors path="lastName"/> <br/><br/>
Age 	   	:<sf:input path="age"/> <sf:errors path="age"/> <br/><br/>

<br/> <br/>

<input type="submit">

</sf:form>


</body>
</html>