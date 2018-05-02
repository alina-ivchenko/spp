package main.java.View;

import main.java.Abiturient;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

public class CSVView implements IReportView {
    private static char delimiter = ';';
    private static char newLine = '\n';
    private static String deaultNullStr = "неизвестно";

    public byte[] generateReportByAbiturients(List<Abiturient> abiturients) {
        StringBuilder writer = new StringBuilder();
        writer.append('\uFEFF');
        writer.append(getAbiturientHeader() + newLine);
        for (int i = 0; i < abiturients.size(); i++)
            writer.append(getCsvStringOfAbiturientObject(abiturients.get(i)) + newLine);
        return writer.toString().getBytes(Charset.forName("UTF8"));
    }

    private String getCsvStringOfAbiturientObject(Abiturient abiturient) {
        return
                escapeNullException(abiturient.getFirstName()) + delimiter +
                        escapeNullException(abiturient.getSecondName()) + delimiter +
                        escapeNullException(abiturient.getLastName()) + delimiter +
                        escapeNullException(abiturient.getAddress()) + delimiter +
                        escapeNullException(abiturient.getPassport()) + delimiter +
                        escapeNullException(abiturient.getBirthDay().toString()) + delimiter +
                        escapeNullException(abiturient.getSpeciality().getName());
    }

    private String getAbiturientHeader() {
        return
                "Фамилия" + delimiter +
                        "Имя" + delimiter +
                        "Отчество" + delimiter +
                        "Адрес" + delimiter +
                        "Паспорт" + delimiter +
                        "Дата рождения" + delimiter +
                        "Специальность";
    }

    private String escapeNullException(Object inputObj) {
        return inputObj != null && !inputObj.toString().equals("") ? inputObj.toString() : deaultNullStr;
    }
}