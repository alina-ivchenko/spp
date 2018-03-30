<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Speciality" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Специальность</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">
</head>
<body>

<%
    out.print(Drawer.drawHeader("Специальность"));
%>

<div class="mainContainer">
    <div class="menu"></div>
    <div class="content">
        <%
            Speciality speciality = (Speciality) request.getAttribute("currSpecialityInfo");
            if (speciality != null) {
                out.print(Drawer.drawCurrSpeciality(speciality));
            }
        %>
    </div>
    <div style="clear: both"></div>
</div>

</body>
</html>
