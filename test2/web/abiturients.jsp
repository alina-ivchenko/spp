<%@ page import="main.java.Abiturient" %>
<%@ page import="main.java.Authorisation" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Абитуриенты</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">
    <link rel="stylesheet" href="css/abiturientsPage.css">

    <script src="js/main.js"></script>
</head>
<body>
<%
    out.print(Drawer.drawHeader("Абитуриенты"));
%>
<div class="mainContainer">
    <div class="menu">

        <%
            Authorisation authorisation = new Authorisation();
            User currUser = authorisation.getAuthorisedUser(request);
            if (currUser.getRole() == 0) {
        %>
        <button class='menuButton'>Добавить абитуриента</button>
        <%
            }
        %>
    </div>
    <div class="content">
        <%
            List<Abiturient> abiturients = null;
            try {
                abiturients = (List<Abiturient>) request.getAttribute("listOfAbiturients");
            } catch (Exception e) {

            }

            if (abiturients != null)
                out.println(Drawer.drawShortListOfAbiturients(abiturients));
        %>
    </div>
    <div style="clear: both"></div>
</div>

</body>
</html>