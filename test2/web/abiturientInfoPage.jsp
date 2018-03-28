<%@ page import="main.java.Abiturient" %>
<%@ page import="main.java.Drawer" %><%--
  Created by IntelliJ IDEA.
  User: Yarad
  Date: 16.03.2018
  Time: 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студент</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<h1>Абитуриент</h1>
<%
    Abiturient abiturient = (Abiturient) request.getAttribute("currAbiturientInfo");
    if (abiturient != null) {
        out.print(Drawer.drawCurrAbiturient(abiturient));
    }
%>
</body>
</html>
