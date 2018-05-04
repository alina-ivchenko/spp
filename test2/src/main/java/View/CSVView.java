package main.java.View;

import main.java.Abiturient;
import main.java.ProjectFunctions;
import main.java.Speciality;
import main.java.Subject;

import java.nio.charset.Charset;
import java.util.List;

public class CSVView implements IReportView {
    private static char delimiter = ';';
    private static char newLine = '\n';
    private static String defaultNullStr = "неизвестно";

    public byte[] generateReportByAbiturients(List<Abiturient> abiturients) {
        StringBuilder writer = new StringBuilder();
        writer.append('\uFEFF');
        writer.append(getAbiturientHeader() + newLine);
        for (int i = 0; i < abiturients.size(); i++)
            writer.append(getCsvStringOfAbiturientObject(abiturients.get(i)) + newLine);
        return writer.toString().getBytes(Charset.forName("UTF8"));
    }

    @Override
    public byte[] generateReportBySpecialities(List<Speciality> specialities) {
        StringBuilder writer = new StringBuilder();
        writer.append('\uFEFF');
        writer.append(getSpecialityHeader() + newLine);
        for (int i = 0; i < specialities.size(); i++)
            writer.append(getCsvStringOfSpecialityObject(specialities.get(i)) + newLine);
        return writer.toString().getBytes(Charset.forName("UTF8"));
    }

    @Override
    public byte[] generateReportBySubjects(List<Subject> subjects) {
        StringBuilder writer = new StringBuilder();
        writer.append('\uFEFF');
        writer.append(getSubjectHeader() + newLine);
        for (int i = 0; i < subjects.size(); i++)
            writer.append(getCsvStringOfSubjectObject(subjects.get(i)) + newLine);
        return writer.toString().getBytes(Charset.forName("UTF8"));
    }

    private String getCsvStringOfAbiturientObject(Abiturient abiturient) {
        return
                ProjectFunctions.escapeNullException(abiturient.getFirstName(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(abiturient.getSecondName(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(abiturient.getLastName(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(abiturient.getAddress(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(abiturient.getPassport(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(abiturient.getBirthDay(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(abiturient.getSpeciality().getName(), defaultNullStr);
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

    private String getSubjectHeader() {
        return
                "Название";
    }

    private String getCsvStringOfSubjectObject(Subject subject) {
        return
                ProjectFunctions.escapeNullException(subject.getName(), null);
    }

    private String getSpecialityHeader() {
        return
                "Название" + delimiter +
                        "Факультет" + delimiter +
                        "Предмет 1" + delimiter +
                        "Предмет 2" + delimiter +
                        "Предмет 3" + delimiter +
                        "Кол-во студентов";
    }

    private String getCsvStringOfSpecialityObject(Speciality speciality) {
        return
                ProjectFunctions.escapeNullException(speciality.getName(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(speciality.getFaculty().getName(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(speciality.getSubject1().getName(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(speciality.getSubject2().getName(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(speciality.getSubject3().getName(), defaultNullStr) + delimiter +
                        ProjectFunctions.escapeNullException(speciality.getAmountOfAbiturients(), defaultNullStr);
    }
}