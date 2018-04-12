<%@ page import="main.java.Drawer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультет</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/addPage.css">
</head>
<body>
<%
    out.print(Drawer.drawHeader("Абитуриентишко свежий"));
%>


<form action="/saver" method="post">
    <!-- вспомогательные -->
    <input type="text" name="task" value="add" class="hide">
    <input type="text" name="objectType" value="Faculty" class="hide">

    <span>Введите название:</span>
    <input type="text" name='Name'>

    <button type="submit">Добавить</button>
</form>

</body>
</html>
