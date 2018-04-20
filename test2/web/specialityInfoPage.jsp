<%@ page import="main.java.Authorisation" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Speciality" %>
<%@ page import="main.java.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Специальность</title>

    <link rel="stylesheet" href="css/tableDrawing.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/dataEditor.js"></script>

    <%out.print(Drawer.drawCommonHeadLinks());%>
</head>
<body>

<%
    out.print(Drawer.drawHeader("Специальность"));
    Speciality speciality = (Speciality) request.getAttribute("currSpecialityInfo");
%>

<div class="mainContainer">
    <div class="menu">
        <%
            Authorisation authorisation = new Authorisation();
            User currUser = authorisation.getAuthorisedUser(request);
            if (currUser.getRole() == 0) {
        %>
        <a class="menuButton" id="editBtn"
           onclick="onEditBtnClick(['ListOfSubjects','ListOfFaculties'])">Редактировать</a>
        <a class="menuButton" id="saveBtn" onclick="onSaveChangesBtnClick('update', 'Speciality')"
           style="display: none">Сохранить
        </a>

        <a class="menuButton" onclick="onDeleteButtonClick('Speciality',<%out.print(speciality.getIdSpeciality());%>)">
            Удалить
        </a>
        <%}%>
    </div>
    <div class="content">
        <%
            if (speciality != null) {
                out.print(Drawer.drawCurrSpeciality(speciality));
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
