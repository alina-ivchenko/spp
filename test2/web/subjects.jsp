<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Предметы</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">

    <script src="js/main.js"></script>
</head>
<body>
<%
    out.print(Drawer.drawHeader("Предметы"));
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
            List<Subject> subjects = null;
            try {
                subjects = (List<Subject>) request.getAttribute("listOfSubjects");
            } catch (Exception e) {

            }

            if (subjects != null)
                out.println(Drawer.drawShortListOfSubjects(subjects));
        %>
    </div>
    <div style="clear: both"></div>
</div>

</body>
</html>
