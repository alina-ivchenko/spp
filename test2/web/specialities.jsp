<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Speciality" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Специальности</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">

    <script src="js/main.js"></script>
</head>
<body>
<%
    out.print(Drawer.drawHeader("Специальности"));
%>

<div class="mainContainer">
    <div class="menu">
    </div>
    <div class="content">
        <%
            List<Speciality> specialities = null;
            try {
                specialities = (List<Speciality>) request.getAttribute("listOfSpecialities");
            } catch (Exception e) {

            }

            if (specialities != null)
                out.println(Drawer.drawShortListOfSpecialities(specialities));
        %>
    </div>
    <div style="clear: both"></div>
</body>
</html>
