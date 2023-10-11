<%--
  Created by IntelliJ IDEA.
  User: Nhia Vue
  Date: 5/11/2023
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search For Box or Card Name</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">

    <div class="hero-unit">
        <h1>Search</h1>
    </div>

    <%@ include file="includes/navigation.jsp"%>

    <div class="container">
        <form action="Search" method="get">
            <label for="boxName">Search by Box Name:</label>
            <input type="text" name="boxName" id="boxName">
            <input type="submit">
        </form>


    </div>

    <div class="container">
        <form action="Search" method="get">
            <label for="cardName">Search by Card Name:</label>
            <input type="text" name="cardName" id="cardName">
            <input type="submit">
        </form>
    </div>


    <%@ include file="includes/footer.jsp"%>

</div>
</body>
</html>