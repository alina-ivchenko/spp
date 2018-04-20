<%@ page import="main.java.Authorisation" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Speciality" %>
<%@ page import="main.java.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Специальности</title>
    <link rel="stylesheet" href="css/tableDrawing.css">

    <%out.print(Drawer.drawCommonHeadLinks());%>
</head>
<body>
<%
    out.print(Drawer.drawHeader("Специальности"));
%>

<div class="mainContainer">
    <div class="menu">
        <%
            Authorisation authorisation = new Authorisation();
            User currUser = authorisation.getAuthorisedUser(request);
            if (currUser.getRole() == 0) {
        %>
        <a href="/add?objectType=Speciality" class="menuButton">Добавить специальность</a>
        <%}%>
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
        <%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
