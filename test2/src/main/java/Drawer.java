package main.java;

import java.util.List;

public class Drawer {

    public static String drawShortListOfAbiturents(List<Abiturient> abiturients) {

        StringBuilder stringBuilder = new StringBuilder("<table id='abiturientsTable'>");
        stringBuilder.append("<tr><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Факультет</th><th>Специальность</th></tr>");

        for (int i = 0; i < abiturients.size(); i++)
            stringBuilder.append("<tr onclick = 'showInfoAboutAbiturient(" + abiturients.get(i).getIdAbiturient() + ")'>" +
                    "<td>" + abiturients.get(i).getLastName() + "</td>" +
                    "<td>" + abiturients.get(i).getFirstName() + "</td>" +
                    "<td>" + abiturients.get(i).getSecondName() + "</td>" +
                    "<td>" + "Пока что без названия" + "</td>" +
                    "<td><a href='/specialities?nothing_has_sense'>" + abiturients.get(i).getSpeciality().getName() + "</a></td>"
                    + "</tr>");
        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    public static String drawCurrAbiturient(Abiturient abiturient) {

        StringBuilder stringBuilder = new StringBuilder("<table id='oneAbiturient'>");

        stringBuilder.append("<tr><td>ID</td><td>" + abiturient.getIdAbiturient() + "</td></tr>");
        stringBuilder.append("<tr><td>Фамилия</td><td>" + abiturient.getLastName() + "</td></tr>");
        stringBuilder.append("<tr><td>Имя</td><td>" + abiturient.getFirstName() + "</td></tr>");
        stringBuilder.append("<tr><td>Отчество</td><td>" + abiturient.getSecondName() + "</td></tr>");
        stringBuilder.append("<tr><td>Дата рождения</td><td>" + abiturient.getBirthDay().toString() + "</td></tr>");
        stringBuilder.append("<tr><td>Адрес</td><td>" + abiturient.getAddress() + "</td></tr>");
        stringBuilder.append("<tr><td>Номер паспорта</td><td>" + abiturient.getPassport() + "</td></tr>");

        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

    public static String drawListOfAbiturents(List<Abiturient> abiturients) {

        StringBuilder stringBuilder = new StringBuilder("<table id='abiturientsTable'>");
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
