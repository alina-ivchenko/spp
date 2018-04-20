<%@ page import="main.java.Authorisation" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Speciality" %>
<%@ page import="main.java.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Специальность</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/dataEditor.js"></script>
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
        <button id="editBtn" onclick="onEditBtnClick(['ListOfSubjects','ListOfFaculties'])">Редактировать</button>
        <button id="saveBtn" onclick="onSaveChangesBtnClick('update', 'Speciality')" style="display: none">Сохранить
        </button>

        <button onclick="onDeleteButtonClick('Speciality',<%out.print(speciality.getIdSpeciality());%>)">
            Удалить
        </button>
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
