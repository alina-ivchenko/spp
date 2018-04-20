<%@ page import="main.java.Authorisation" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Faculty" %>
<%@ page import="main.java.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультеты</title>
    <link rel="stylesheet" href="css/tableDrawing.css">

    <%out.print(Drawer.drawCommonHeadLinks());%>
</head>
<body>

<%
    out.print(Drawer.drawHeader("Факультеты"));
%>

<div class="mainContainer">

    <div class="menu">
        <%
            Authorisation authorisation = new Authorisation();
            User currUser = authorisation.getAuthorisedUser(request);
            if (currUser.getRole() == 0) {
        %>
        <a href="/add?objectType=Faculty" class="menuButton">Добавить факультет</a>
        <%}%>
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
<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
