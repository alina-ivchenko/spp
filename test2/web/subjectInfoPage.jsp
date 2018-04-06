<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Subject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Предмет</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/dataEditor.js"></script>
</head>
<body>
<%
    out.print(Drawer.drawHeader("Предмет"));
    Subject subject = (Subject) request.getAttribute("currSubjectInfo");
%>

<div class="mainContainer">
    <div class="menu">
        <button id="editBtn" onclick="onEditBtnClick()">Редактировать</button>
        <button id="saveBtn" onclick="onSaveChangesBtnClick('update', 'Subject')" style="display: none">Сохранить
        </button>

        <button onclick="onDeleteButtonClick('Subject',<%out.print(subject.getIdSubject());%>)">
            Удалить
        </button>
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

</body>
</html>
