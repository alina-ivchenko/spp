<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.User" %>
<%@ page import="main.java.Authorisation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/registrationPageStyles.css">
    <%out.print(Drawer.drawCommonHeadLinks());%>
</head>
<body>

<%
    Authorisation authorisation = new Authorisation();
    User currUser = authorisation.getAuthorisedUser(request);
    out.print(Drawer.drawHeader("Главная", currUser));
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
