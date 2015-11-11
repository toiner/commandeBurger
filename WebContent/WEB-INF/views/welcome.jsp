<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Page de bienvenue</title>
	<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<c:if test="${!empty user}">
<div style="text-align:right;color: white;margin-right:5%;">Username : <sec:authentication property="principal.username" /></div>
</c:if>
	<div class="success">
		Bienvenue : ${greeting}<br>
		<a href="<c:url value="/admin" />">page administrateur</a><br>
		<a href="<c:url value="/login" />">page de login</a><br>
		<a href="<c:url value="/logout" />">Logout</a>
	</div>
	<p style="color: white; margin-left: auto; margin-right: auto; text-align: center; margin-top: 5%;">Cliquer sur l'image pour commander</p>
	<div class="logo_burger">
    <a href="<c:url value="/menus" />"><img alt="image du logo kry's burger" src="/commandeBurger/resources/img/logo.png"></a>
  </div>
</body>
</html>