<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.User" %>
<%@ page import="main.java.Authorisation" %><%-- Created by IntelliJ IDEA. --%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
    <%out.print(Drawer.drawCommonHeadLinks());%>
</head>
<body>

<%
    Authorisation authorisation = new Authorisation();
    User currUser = authorisation.getAuthorisedUser(request);
    out.print(Drawer.drawHeader("Главная", currUser));
%>

<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>