<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>AccessDenied page</title>
	<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<br/>
	<br/>
	<h1 class="titre-acces-denied">Cher <strong>${user}</strong>, Tu n'est pas authorisé à accéder à cette page.</h1>
	<br/>
	<div class="liens-retour">
		<a href="<c:url value="/home" />">Retour acceuil</a>  
		<sec:authorize access="hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')">
	           OR  <a href="<c:url value="/logout" />">Logout</a>
	  </sec:authorize>
	</div>
</body>
</html>