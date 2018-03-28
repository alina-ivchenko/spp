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
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/abiturients.css">
</head>
<body>
<h1>Абитуриент</h1>
<div class="mainContent">
    <div class="menu"></div>
    <div class="content">
        <%
            Abiturient abiturient = (Abiturient) request.getAttribute("currAbiturientInfo");
            if (abiturient != null) {
                out.print(Drawer.drawCurrAbiturient(abiturient));
            }
        %>
    </div>
</div>

</body>
</html>
