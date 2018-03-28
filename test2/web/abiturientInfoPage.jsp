<%@ page import="main.java.Abiturient" %>
<%@ page import="main.java.Drawer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студент</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/abiturientsDrawing.css">
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
