<%@ page import="main.java.Abiturient" %>
<%@ page import="main.java.Authorisation" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студент</title>
    <link rel="stylesheet" href="css/tableDrawing.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/dataEditor.js"></script>
    <%out.print(Drawer.drawCommonHeadLinks());%>
</head>
<body>

<%
    out.print(Drawer.drawHeader("Студент"));
    Abiturient abiturient = (Abiturient) request.getAttribute("currAbiturientInfo");
%>

<div class="mainContainer">
    <div class="menu">
        <%
            Authorisation authorisation = new Authorisation();
            User currUser = authorisation.getAuthorisedUser(request);
            if (currUser.getRole() == 0) {
        %>

        <a class="menuButton" id="editBtn" onclick="onEditBtnClick(['ListOfSpecialities','ListOfFaculties'])">Редактировать</a>
        <a class="menuButton" id="saveBtn" onclick="onSaveChangesBtnClick('update', 'Abiturient')" style="display: none">Сохранить
        </a>

        <a class="menuButton" onclick="onDeleteButtonClick('Abiturient',<%out.print(abiturient.getIdAbiturient());%>)"> Удалить
        </a>
        <%
            }
        %>
    </div>
    <div class="content">
        <%
            if (abiturient != null) {
                out.print(Drawer.drawCurrAbiturient(abiturient));
            }
        %>
    </div>
    <div style="clear: both"></div>
</div>

<%out.print(Drawer.drawMainSaveForm());%>
<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
