<%@page import="com.training.redbox.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<img alt="" src='<c:url value="/images/logo.jpg"/>' height="50" width="200">
	
	<c:if test="${customer!=null}">

		Welcome <c:out value="${customer.firstName}"></c:out>
		<c:out value="${customer.lastName}"></c:out>
	</c:if>

</body>
</html>