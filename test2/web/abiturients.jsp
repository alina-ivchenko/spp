<%@ page import="main.java.Abiturient" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.Drawer" %><%--
  Created by IntelliJ IDEA.
  User: Yarad
  Date: 15.03.2018
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Абитуриенты</title>
    <link rel="stylesheet" href="css/main.css">
    <script src="js/main.js"></script>
</head>
<body>
<header>
    <img src="img/exit_3.png" style="height: 35px" alt="Выйти" onclick="logout()">
</header>
<h2>Список абитурентов:</h2>
    <%
        List<Abiturient> abiturients = null;
        try {
            abiturients = (List<Abiturient>) request.getAttribute("listOfAbiturients");
        } catch (Exception e) {

        }

        if (abiturients != null)
            out.println(Drawer.drawListOfAbiturents(abiturients));
    %>
</body>
</html>
