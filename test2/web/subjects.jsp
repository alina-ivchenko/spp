<%@ page import="main.java.Authorisation" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Subject" %>
<%@ page import="main.java.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Предметы</title>
    <link rel="stylesheet" href="css/tableDrawing.css">
    <%out.print(Drawer.drawCommonHeadLinks());%>

</head>
<body>
<%
    Authorisation authorisation = new Authorisation();
    User currUser = authorisation.getAuthorisedUser(request);
    out.print(Drawer.drawHeader("Предметы", currUser));
    out.print(Drawer.drawReportsPannel("subjects"));
%>
<div class="mainContainer">
    <div class="menu">
        <%
            if (currUser.getRole() == 0) {
        %>
        <a href="/add?objectType=Subject" class="menuButton">Добавить предмет</a>
        <%}%>
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

<%
    out.print(Drawer.drawFooter());
%>

</body>
</html>
