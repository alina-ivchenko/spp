package main.java;

import java.util.List;

public class Drawer {
    /*
    public static String drawAdminLeftBarFunctionality(String jspPageName) {

        if (jspPageName.equals("/abiturients.jsp"))
            return "<button class='menuButton'>Добавить абитуриента</button>";

        if (jspPageName.equals("/facultyInfoPage.jsp"))
            return "<button id='editBtn' onclick=\"onEditBtnClick()\">Редактировать</button>\n" +
                    "<button id='saveBtn' onclick=\"onSaveChangesBtnClick('update', 'Faculty')\" style='display: none'>Сохранить</button>\n" +
                    "<button onclick=\"onDeleteButtonClick('Faculty',<%out.print(faculty.getIdFaculty());%>)\"> Удалить</button>";

        if(jspPageName.equals("/abiturienInfoPage.jsp"))
            return "<button id='editBtn' onclick=\"onEditBtnClick(['ListOfSpecialities','ListOfFaculties'])\">Редактировать</button>\n" +
                    "        <button id='saveBtn' onclick=\"onSaveChangesBtnClick('update', 'Abiturient')\" style='display: none'>Сохранить</button>\n" +
                    "        <button onclick=\"onDeleteButtonClick('Abiturient',<%out.print(abiturient.getIdAbiturient());%>)\"> Удалить</button>";
        
        return "";
    }
*/
    public static String drawMainSaveForm() {
        return "<form style=\"display: none\"\n" +
                "      method=\"post\"\n" +
                "      id=\"mainSendForm\"\n" +
                "      name=\"mainSendForm\"\n" +
                "      action=\"/saver\">\n" +
                "</form>";
    }

    public static String drawHeader(String title) {
        return "<header>\n" +
                "    <h2>" + title + "</h2>\n" +
                "    <div class='rightPanel'>" +
                "        <a class=\"gotoMainPage\" href=\"/\">На главную</a>\n" +
                "        <img src=\"img/exit.png\" style=\"height: 60px; width: 60px;\" alt=\"Выйти\" onclick=\"logout()\">\n" +
                "    </div>" +
                "</header>";
    }

    public static String drawShortListOfSubjects(List<Subject> subjects) {

        StringBuilder stringBuilder = new StringBuilder("<table class='infoTable tableWithClickableTrs'>");
        stringBuilder.append("<tr><th>Название</th></tr>");

        if (subjects != null)
            for (int i = 0; i < subjects.size(); i++)
                stringBuilder.append("<tr onclick = 'showInfoAboutSubject(" + subjects.get(i).getIdSubject() + ")'>" +
                        "<td>" + subjects.get(i).getName() + "</td>" +
                        "</tr>");
        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    public static String drawCurrSubject(Subject subject) {
        StringBuilder stringBuilder = new StringBuilder("<table class='infoTable'>");

        stringBuilder.append("<tr><td>ID</td>      <td class='send non-editable' id='IdSubject'>" + subject.getIdSubject() + "</td></tr>");
        stringBuilder.append("<tr><td>Название</td><td class='send editable'     id='Name'     >" + subject.getName() + "</td></tr>");

        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    public static String drawShortListOfFaculties(List<Faculty> faculties) {

        StringBuilder stringBuilder = new StringBuilder("<table class='infoTable tableWithClickableTrs'>");
        stringBuilder.append("<tr><th>Название</th></tr>");

        for (int i = 0; i < faculties.size(); i++)
            stringBuilder.append("<tr onclick = 'showInfoAboutFaculty(" + faculties.get(i).getIdFaculty() + ")'>" +
                    "<td>" + faculties.get(i).getName() + "</td>" +
                    "</tr>");
        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    public static String drawCurrFaculty(Faculty faculty) {
        StringBuilder stringBuilder = new StringBuilder("<table class='infoTable'>");

        stringBuilder.append("<tr><td>ID</td>      <td class = 'send non-editable' id='IdFaculty'>" + faculty.getIdFaculty() + "</td></tr>");
        stringBuilder.append("<tr><td>Название</td><td class = 'send editable'     id='Name'>" + faculty.getName() + "</td></tr>");

        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    public static String drawShortListOfAbiturients(List<Abiturient> abiturients) {

        StringBuilder stringBuilder = new StringBuilder("<table class='infoTable tableWithClickableTrs'>");
        stringBuilder.append("<tr><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Факультет</th><th>Специальность</th></tr>");

        for (int i = 0; i < abiturients.size(); i++)
            stringBuilder.append("<tr onclick = 'showInfoAboutAbiturient(" + abiturients.get(i).getIdAbiturient() + ")'>" +
                    "<td>" + abiturients.get(i).getLastName() + "</td>" +
                    "<td>" + abiturients.get(i).getFirstName() + "</td>" +
                    "<td>" + abiturients.get(i).getSecondName() + "</td>" +
                    "<td><a href='/faculties?currFacultyId=" + abiturients.get(i).getSpeciality().getIdFaculty() + "'>" + abiturients.get(i).getSpeciality().getFaculty().getName() + "</a></td>" +
                    "<td><a href='/specialities?currSpecialityId=" + abiturients.get(i).getIdSpeciality() + "'>" + abiturients.get(i).getSpeciality().getName() + "</a></td>"
                    + "</tr>");
        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    public static String drawCurrAbiturient(Abiturient abiturient) {

        StringBuilder stringBuilder = new StringBuilder("<table class='infoTable'>");

        stringBuilder.append("<tr><td>ID</td>             <td class='send non-editable' id='IdAbiturient'>" + abiturient.getIdAbiturient() + "</td></tr>");
        stringBuilder.append("<tr><td>Фамилия</td>        <td class='send editable'     id='LastName'>" + abiturient.getLastName() + "</td></tr>");
        stringBuilder.append("<tr><td>Имя</td>            <td class='send editable'     id='FirstName'>" + abiturient.getFirstName() + "</td></tr>");
        stringBuilder.append("<tr><td>Отчество</td>       <td class='send editable'     id='SecondName'>" + abiturient.getSecondName() + "</td></tr>");
        stringBuilder.append("<tr><td>Дата рождения</td>  <td class='send editable'     id='BirthDay'>" + abiturient.getBirthDay().toString() + "</td></tr>");
        stringBuilder.append("<tr><td>Адрес</td>          <td class='send editable'     id='Address'>" + abiturient.getAddress() + "</td></tr>");
        stringBuilder.append("<tr><td>Номер паспорта</td> <td class='send editable'     id='Passport'>" + abiturient.getPassport() + "</td></tr>");
        stringBuilder.append("<tr><td>Факультет</td>      <td class='send         '     id='IdFaculty'><a href='/faculties?currFacultyId=" + abiturient.getSpeciality().getIdFaculty() + "'>" + abiturient.getSpeciality().getFaculty().getName() + "</a></td></tr>");
        stringBuilder.append("<tr><td>Специальность</td>  <td class='send selectable'   id='IdSpeciality' value='" + abiturient.getIdSpeciality() + "'><a href='/specialities?currSpecialityId=" + abiturient.getIdSpeciality() + "'>" + abiturient.getSpeciality().getName() + "</a></td></tr>");

        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    public static String drawShortListOfSpecialities(List<Speciality> specialities) {
        StringBuilder stringBuilder = new StringBuilder("<table class='infoTable tableWithClickableTrs'>");
        stringBuilder.append("<tr><th>Название</th><th>Факультет</th></tr>");

        if (specialities != null)
            for (int i = 0; i < specialities.size(); i++)
                stringBuilder.append("<tr onclick = 'showInfoAboutSpeciality(" + specialities.get(i).getIdSpeciality() + ")'>" +
                        "<td>" + specialities.get(i).getName() + "</td>" +
                        "<td><a href='/faculties?currFacultyId=" + specialities.get(i).getIdFaculty() + "'>" + specialities.get(i).getFaculty().getName() + "</a></td>"
                        + "</tr>");
        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    public static String drawCurrSpeciality(Speciality speciality) {

        StringBuilder stringBuilder = new StringBuilder("<table class='infoTable'>");

        stringBuilder.append("<tr><td>ID</td>       <td class = 'send non-editable ' id = 'IdSpeciality'>" + speciality.getIdSpeciality() + "</td></tr>");
        stringBuilder.append("<tr><td>Название</td> <td class = 'send editable     ' id = 'Name'>" + speciality.getName() + "</td></tr>");
        stringBuilder.append("<tr><td>Факультет</td><td class = 'send selectable   ' id = 'IdFaculty' value='" + speciality.getIdFaculty() + "'><a href='/faculties?currFacultyId=" + speciality.getIdFaculty() + "'>" + speciality.getFaculty().getName() + "</a></td></tr>");
        stringBuilder.append("<tr><td>Предмет 1</td><td class = 'send selectable   ' id = 'FirstSubject' value='" + speciality.getFirstSubject() + "'><a href='/subjects?currSubjectId=" + speciality.getFirstSubject() + "'>" + speciality.getSubject1().getName() + "</a></td></tr>");
        stringBuilder.append("<tr><td>Предмет 2</td><td class = 'send selectable   ' id = 'SecondSubject' value='" + speciality.getSecondSubject() + "'><a href='/subjects?currSubjectId=" + speciality.getSecondSubject() + "'>" + speciality.getSubject2().getName() + "</a></td></tr>");
        stringBuilder.append("<tr><td>Предмет 3</td><td class = 'send selectable   ' id = 'ThirdSubject' value='" + speciality.getThirdSubject() + "'><a href='/subjects?currSubjectId=" + speciality.getThirdSubject() + "'>" + speciality.getSubject3().getName() + "</a></td></tr>");

        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    //отжило своё
    public static String drawListOfAbiturents(List<Abiturient> abiturients) {

        StringBuilder stringBuilder = new StringBuilder("<table class='infoTable'>");
        stringBuilder.append("<tr><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Адрес</th><th>Номер паспорта</th><th>Дата рождения</th><th>Специальность</th></tr>");

        for (int i = 0; i < abiturients.size(); i++)
            stringBuilder.append("<tr onclick = 'showInfoAboutAbiturient(" + abiturients.get(i).getIdAbiturient() + ")'>" +
                    "<td>" + abiturients.get(i).getLastName() + "</td>" +
                    "<td>" + abiturients.get(i).getFirstName() + "</td>" +
                    "<td>" + abiturients.get(i).getSecondName() + "</td>" +
                    "<td>" + abiturients.get(i).getAddress() + "</td>" +
                    "<td>" + abiturients.get(i).getPassport() + "</td>" +
                    "<td>" + abiturients.get(i).getBirthDay().toString() + "</td>" +
                    "<td><a href='/specialities?nothing_has_sense'>" + abiturients.get(i).getSpeciality().getName() + "</a></td>"
                    + "</tr>");
        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }
}