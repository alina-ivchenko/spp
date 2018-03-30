<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Faculty" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультет</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">
</head>
<body>

<%
    out.print(Drawer.drawHeader("Факультет"));
%>

<div class="mainContainer">
    <div class="menu"></div>
    <div class="content">
        <%
            Faculty faculty = (Faculty) request.getAttribute("currFacultyInfo");
            if (faculty != null) {
                out.print(Drawer.drawCurrFaculty(faculty));
            }
        %>
    </div>
    <div style="clear: both"></div>
</div>

</body>
</html>
