<%--
  Created by IntelliJ IDEA.
  User: Nhia Vue
  Date: 5/11/2023
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Populate Database</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">

    <div class="hero-unit">
        <h1>Populate the Database</h1>
    </div>

    <%@ include file="includes/navigation.jsp"%>
    <p>WARNING: This action will over-write the existing database.</p>
    <div class="container">
        <form action="Populate" method="post">
            <input type="submit" value="Populate Db">

        </form>

    </div>
    <p>${message}</p>

    <%@ include file="includes/footer.jsp"%>

</div>
</body>
</html>