<%@ page import="main.java.Abiturient" %>
<%@ page import="main.java.Drawer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студент</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/dataEditor.js"></script>
</head>
<body>

<%
    out.print(Drawer.drawHeader("Студент"));
    Abiturient abiturient = (Abiturient) request.getAttribute("currAbiturientInfo");
%>

<div class="mainContainer">
    <div class="menu">
        <button id="editBtn" onclick="onEditBtnClick(['ListOfSpecialities','ListOfFaculties'])">Редактировать</button>
        <button id="saveBtn" onclick="onSaveChangesBtnClick('update', 'Abiturient')" style="display: none">Сохранить
        </button>

        <button onclick="onDeleteButtonClick('Abiturient',<%out.print(abiturient.getIdAbiturient());%>)">
            Удалить
        </button>
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

</body>
</html>
