<%--
  Created by IntelliJ IDEA.
  User: Nhia Vue
  Date: 5/11/2023
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pokemon Cards</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <h1>Pokemon Cards</h1>
    </div>

    <%@ include file="includes/navigation.jsp"%>
    <div class="container">
         <c:choose>
             <c:when test="${empty pokemonList}">
                 <p>Sorry, this list is empty</p>
             </c:when>
             <c:otherwise>
                 <c:forEach var="pokemon" items="${pokemonList}">
                     <h2>${pokemon.boxName}</h2>
                     <p>${pokemon.cardName} and amount owned: ${pokemon.amount}</p>
                 </c:forEach>
             </c:otherwise>
         </c:choose>

    </div>
    <%@ include file="includes/footer.jsp"%>


</div>
</body>
</html>
