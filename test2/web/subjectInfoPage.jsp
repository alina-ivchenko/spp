<%@ page import="main.java.Authorisation" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Subject" %>
<%@ page import="main.java.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Предмет</title>
    <link rel="stylesheet" href="css/tableDrawing.css">

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/dataEditor.js"></script>

    <%out.print(Drawer.drawCommonHeadLinks());%>
</head>
<body>
<%
    Authorisation authorisation = new Authorisation();
    User currUser = authorisation.getAuthorisedUser(request);
    out.print(Drawer.drawHeader("Предмет", currUser));
    Subject subject = (Subject) request.getAttribute("currSubjectInfo");
%>

<div class="mainContainer">
    <div class="menu">
        <%
            if (currUser.getRole() == 0) {
        %>
        <a class="menuButton" id="editBtn" onclick="onEditBtnClick()">Редактировать</a>
        <a class="menuButton" id="saveBtn" onclick="onSaveChangesBtnClick('update', 'Subject')" style="display: none">Сохранить
        </a>

        <a class="menuButton" onclick="onDeleteButtonClick('Subject',<%out.print(subject.getIdSubject());%>)">
            Удалить
        </a>
        <%}%>
    </div>
    <div class="content">
        <%
            if (subject != null) {
                out.print(Drawer.drawCurrSubject(subject));
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
