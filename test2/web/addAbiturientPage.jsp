<%@ page import="main.java.DAO.DAOSpeciality" %>
<%@ page import="main.java.Drawer" %>
<%@ page import="main.java.Speciality" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Абитуриентишко</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/addPage.css">
</head>

<body>

<%
    out.print(Drawer.drawHeader("Абитуриентишко свежий"));
%>

<form action="/saver" method="post">
    <!-- вспомогательные -->
    <input type="text" name="task" value="add" style="display: none">
    <input type="text" name="objectType" value="Abiturient" style="display: none">

    <span>Введите имя:</span>
    <input type="text" name='LastName'>

    <span>Введите фамилию:</span>
    <input type="text" name='FirstName'>

    <span>Введите отчество:</span>
    <input type="text" name='SecondName'>

    <span>Введите дату рождения:</span>
    <input type="date" name='BirthDay'>

    <span>Введите адрес:</span>
    <input type="text" name='Address'>

    <span>Введите номер паспорта:</span>
    <input type="text" name='Passport'>

    <select name='IdSpeciality'>
        <%
            DAOSpeciality daoSpeciality = new DAOSpeciality();
            List<Speciality> specialities = daoSpeciality.getAllSpecialities();
            for (int i = 0; i < specialities.size(); i++)
                out.print("<option value='" + specialities.get(i).getIdSpeciality() + "'>" + specialities.get(i).getName() + "</option>");
        %>
    </select>
    <button type="submit">Добавить</button>
</form>
<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
