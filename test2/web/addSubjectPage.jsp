<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.User" %>
<%@ page import="main.java.Authorisation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Предмет</title>
    <%out.print(Drawer.drawCommonHeadLinks());%>
    <link rel="stylesheet" href="css/addPage.css">
</head>

<body>

<%
    Authorisation authorisation = new Authorisation();
    User currUser = authorisation.getAuthorisedUser(request);
    out.print(Drawer.drawHeader("Добавить предмет", currUser));
%>

<form action="/saver" method="post">
    <!-- вспомогательные -->
    <input type="text" name="task" value="add" style="display: none">
    <input type="text" name="objectType" value="Subject" style="display: none">

    <span>Введите название:</span>
    <input type="text" name='Name'>

    <button type="submit">Добавить</button>
</form>

<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
