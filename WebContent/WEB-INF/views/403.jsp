<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
  <h1>HTTP Status 403 - Accès non authorisé petit malin !</h1>

  <c:choose>
    <c:when test="${empty username}">
      <h2>Tu n'a pas la permission d'accéder à cette page !</h2>
    </c:when>
    <c:otherwise>
      <h2>Username : ${username} <br/>tu n'a pas la permission d'accéder à cette page  !</h2>
    </c:otherwise>
  </c:choose>

</body>
</html>