<%@ page import="main.java.Drawer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/registrationPageStyles.css">
    <script src="js/main.js"></script>
</head>
<body>

<%
    out.print(Drawer.drawHeader("Главная"));
%>

<form method="post"
      action='login'
      id="mainSendForm">
    <input type='text' name='login'/>
    <input type='password' name='password'/>
    <input type='submit' value='login'/>
</form>
<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
