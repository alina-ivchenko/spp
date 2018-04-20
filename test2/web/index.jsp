<%@ page import="main.java.Drawer" %><%-- Created by IntelliJ IDEA. --%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
    <%out.print(Drawer.drawCommonHeadLinks());%>
</head>
<body>

<%
    out.print(Drawer.drawHeader("Главная"));
%>

<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>