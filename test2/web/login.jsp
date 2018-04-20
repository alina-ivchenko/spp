<%@ page import="main.java.Drawer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/common.css">
</head>
<body>

<%
    out.print(Drawer.drawHeader("Главная"));
%>

<form method="post" action='login'>
    <input type='text' name='login'/>
    <input type='text' name='password'/>
    <input type='submit' value='login'/>
</form>
<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
