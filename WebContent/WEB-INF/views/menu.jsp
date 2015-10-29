<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Commande de burger</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Application de commande de burger
</h1>
 
<c:url var="addAction" value="/menu/add" ></c:url>
 
<form:form action="${addAction}" commandName="menu">

<fieldset>
<legend>Formulaire de saisie</legend>
<table>
	<!-- La premiere colonne de la table ne s'affiche que quand il trouve 1 name  -->
    <c:if test="${!empty menu.nom}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    
    <tr>
        <td>
            <form:label path="nom">
                <spring:message text="Nom"/><!-- affiche "Nom" dans la page -->
            </form:label>
        </td>
        <td>
            <form:input path="nom" /><!-- affiche un input text avec la valeur de name -->
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="burger">
                <spring:message text="Burger"/><!-- affiche "Burger" dans la page -->
            </form:label>
        </td>
        <td>
            <form:select path="burger.nom">
	            <form:option value="NONE" label="--- Selectionner le burger ---"/>
	            <form:options items="${listeDesNomsDeBurger}"/>
	            <%-- <form:options items="${listBurgers}" itemLabel="nom" itemValue="id"/> --%>
            </form:select>

           <!--  <form:input path="burger" />affiche un input text avec la valeur de burger -->
        </td>
        <td><a href="http://krysburgers.fr/burgers">lien vers la description du burger (pour Floriane, un peu casse couille quand même)</a></td>
    </tr>
    <tr>
        <td>
            <form:label path="boisson">
                <spring:message text="Boisson"/><!-- affiche "Boisson" dans la page -->
            </form:label>
        </td>
        <td>
        <form:select path="boisson">
            <form:option value="NONE" label="--- Selectionner la boisson ---"/>
            <form:options items="${listeDesBoissons}"/>
            </form:select>
            <%-- <form:input path="boisson" /><!-- affiche un input text avec la valeur de boisson --> --%>
        </td>
    </tr>
    <tr>
    <!-- bouton d'ajout du menu -->
        <td colspan="2">
            <c:if test="${!empty menu.nom}">
                <input type="submit" value="<spring:message text="Edit menu"/>" />
            </c:if>
            <c:if test="${empty menu.nom}">
                <input type="submit" value="<spring:message text="Passer la commande"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</fieldset>
</form:form>
<br>
<h3>Liste des menu déjà choisis </h3>
<c:if test="${!empty listMenus}">
    <table class="tg">
    <tr>
        <th width="80">Menu ID</th>
        <th width="120">Nom</th>
        <th width="120">Burger</th>
        <th width="120">Boisson</th>
        <th width="120">Date de commande</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listMenus}" var="menu">
        <tr>
            <td>${menu.id}</td>
            <td>${menu.nom}</td>
            <td>${menu.burgerName}</td>
            <td>${menu.boisson}</td>
            <td><fmt:formatDate value="${menu.dateDeCommande}" var="dateString" pattern="dd/MM/yyyy" />${dateString}</td>
            <td><a href="<c:url value='/edit/${menu.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${menu.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>