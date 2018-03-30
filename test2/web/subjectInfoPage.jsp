<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Subject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Предмет</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tableDrawing.css">
</head>
<body>
<%
    out.print(Drawer.drawHeader("Предмет"));
%>

<div class="mainContainer">
    <div class="menu"></div>
    <div class="content">
        <%
            Subject subject = (Subject) request.getAttribute("currSubjectInfo");
            if (subject != null) {
                out.print(Drawer.drawCurrSubject(subject));
            }
        %>
    </div>
    <div style="clear: both"></div>
</div>

</body>
</html>
