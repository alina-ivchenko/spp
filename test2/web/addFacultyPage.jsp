<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.User" %>
<%@ page import="main.java.Authorisation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультет</title>
    <%out.print(Drawer.drawCommonHeadLinks());%>
    <link rel="stylesheet" href="css/addPage.css">
</head>
<body>
<%
    Authorisation authorisation = new Authorisation();
    User currUser = authorisation.getAuthorisedUser(request);
    out.print(Drawer.drawHeader("Добавить факультет", currUser));
%>

<form action="/saver" method="post">
    <!-- вспомогательные -->
    <input type="text" name="task" value="add" class="hide">
    <input type="text" name="objectType" value="Faculty" class="hide">

    <span>Введите название:</span>
    <input type="text" name='Name'>

    <button type="submit">Добавить</button>
</form>
<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
