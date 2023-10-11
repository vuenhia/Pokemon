<%--
  Created by IntelliJ IDEA.
  User: Nhia Vue
  Date: 5/11/2023
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Java Web Programming: Add New Person</title>
  <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">

  <div class="hero-unit">
    <h1>Add New Person</h1>
  </div>

  <%@ include file="includes/navigation.jsp"%>

  <p>${message}</p>

  <div class="container">
    <form action="AddNewPokemon" method="post">
      <label for="boxName">Box Name:</label>
      <input type="text" name="boxName" id="boxName">

      <label for="cardName">Card Name:</label>
      <input type="text" name="cardName" id="cardName">

      <label for="amount">amount:</label>
      <input type="text" name="amount" id="amount">

      <input type="submit">
    </form>
  </div>

  <%@ include file="includes/footer.jsp"%>

</div>
</body>
</html>

