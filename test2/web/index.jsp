<%@ page import="main.java.Drawer" %><%-- Created by IntelliJ IDEA. --%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Главная</title>
    <link rel="stylesheet" href="css/common.css">
</head>
<body>

<%
    out.print(Drawer.drawHeader("Главная"));
%>

<p>
    <a href="/login">Войти</a>
</p>

<p>
    <a href="/abiturients">Список абитуриентов</a>
</p>

<p>
    <a href="/specialities">Список специальностей</a>
</p>

<p>
    <a href="/faculties">Список Факультетов</a>
</p>

<p>
    <a href="/subjects">Список предметов</a>
</p>
</body>
</html>