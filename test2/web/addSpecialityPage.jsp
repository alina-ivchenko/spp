<%@ page import="main.java.DAO.DAOFaculty" %>
<%@ page import="main.java.DAO.DAOSubject" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Специальность</title>
    <%out.print(Drawer.drawCommonHeadLinks());%>
    <link rel="stylesheet" href="css/addPage.css">
</head>
<body>

<%
    Authorisation authorisation = new Authorisation();
    User currUser = authorisation.getAuthorisedUser(request);
    out.print(Drawer.drawHeader("Добавить специальность", currUser));
%>
<form action="/saver" method="post">
    <!-- вспомогательные -->
    <input type="text" name="task" value="add" style="display: none">
    <input type="text" name="objectType" value="Speciality" style="display: none">

    <span>Введите название:</span>
    <input type="text" name='Name'>

    <span>Выберите факультет:</span>
    <select name='IdFaculty'>
        <%
            DAOFaculty daoFaculty = new DAOFaculty();
            List<Faculty> faculties = daoFaculty.getAllFaculties();
            for (int i = 0; i < faculties.size(); i++)
                out.print("<option value='" + faculties.get(i).getIdFaculty() + "'>" + faculties.get(i).getName() + "</option>");
        %>
    </select>


    <%
        DAOSubject daoSubject = new DAOSubject();
        List<Subject> subjects = daoSubject.getAllSubjects();
    %>
    <span>Выберите предметы изучаемые:</span>
    <select name='FirstSubject'>
        <%
            for (int i = 0; i < subjects.size(); i++)
                out.print("<option value='" + subjects.get(i).getIdSubject() + "'>" + subjects.get(i).getName() + "</option>");
        %>
    </select>

    <select name='SecondSubject'>
        <%
            for (int i = 0; i < subjects.size(); i++)
                out.print("<option value='" + subjects.get(i).getIdSubject() + "'>" + subjects.get(i).getName() + "</option>");
        %>
    </select>

    <select name='ThirdSubject'>
        <%
            for (int i = 0; i < subjects.size(); i++)
                out.print("<option value='" + subjects.get(i).getIdSubject() + "'>" + subjects.get(i).getName() + "</option>");
        %>
    </select>

    <button type="submit">Добавить</button>
</form>
<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
