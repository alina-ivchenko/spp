package main.java.View;

import main.java.Abiturient;
import main.java.Speciality;
import main.java.Subject;

import java.util.List;

public interface IReportView {
    byte[] generateReportByAbiturients(List<Abiturient> abiturients);

    byte[] generateReportBySpecialities(List<Speciality> specialities);

    byte[] generateReportBySubjects(List<Subject> subjects);
}
