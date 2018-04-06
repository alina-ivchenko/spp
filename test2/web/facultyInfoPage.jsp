<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Faculty" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Факультет</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/dataEditor.js"></script>
</head>
<body>

<%
    out.print(Drawer.drawHeader("Факультет"));
    Faculty faculty = (Faculty) request.getAttribute("currFacultyInfo");
%>

<div class="mainContainer">
    <div class="menu">
        <button id="editBtn" onclick="onEditBtnClick()">Редактировать</button>
        <button id="saveBtn" onclick="onSaveChangesBtnClick('update', 'Faculty')" style="display: none">Сохранить
        </button>

        <button onclick="onDeleteButtonClick('Faculty',<%out.print(faculty.getIdFaculty());%>)">
            Удалить
        </button>
    </div>
    <div class="content">
        <%
            if (faculty != null) {
                out.print(Drawer.drawCurrFaculty(faculty));
            }
        %>
    </div>
    <div style="clear: both"></div>
</div>

<%out.print(Drawer.drawMainSaveForm());%>

</body>
</html>
