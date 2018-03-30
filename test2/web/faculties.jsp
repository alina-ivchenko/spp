<%@ page import="main.java.Abiturient" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Faculty" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультеты</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">

    <script src="js/main.js"></script>
</head>
<body>
<%
    out.print(Drawer.drawHeader("Факультеты"));
%>
<div class="mainContainer">
    <div class="menu">
        <button class="menuButton">Добавить абитуриента</button>
        <button class="menuButton">Добавить абитуриента</button>
        <button class="menuButton">Добавить абитуриента</button>
        <button class="menuButton">Добавить абитуриента</button>
    </div>
    <div class="content">
        <%
            List<Faculty> faculties = null;
            try {
                faculties = (List<Faculty>) request.getAttribute("listOfFaculties");
            } catch (Exception e) {

            }

            if (faculties != null)
                out.println(Drawer.drawShortListOfFaculties(faculties));
        %>
    </div>
    <div style="clear: both"></div>
</div>

</body>
</html>
