<%@ page import="main.java.Abiturient" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.Drawer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Абитуриенты</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/abiturientsDrawing.css">
    <link rel="stylesheet" href="css/abiturientsPage.css">

    <script src="js/main.js"></script>
</head>
<body>
<header>
    <img src="img/exit_3.png" style="height: 35px" alt="Выйти" onclick="logout()">
</header>
<h2>Список абитурентов:</h2>
<div class="mainContainer">
    <div class="menu">
        <button class="menuButton">Добавить абитуриента</button>
        <button class="menuButton">Добавить абитуриента</button>
        <button class="menuButton">Добавить абитуриента</button>
        <button class="menuButton">Добавить абитуриента</button>
    </div>
    <div class="content">
        <%
            List<Abiturient> abiturients = null;
            try {
                abiturients = (List<Abiturient>) request.getAttribute("listOfAbiturients");
            } catch (Exception e) {

            }

            if (abiturients != null)
                out.println(Drawer.drawShortListOfAbiturents(abiturients));
        %>
    </div>
    <div style="clear: both"></div>
</div>

</body>
</html>
