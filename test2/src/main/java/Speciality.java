package main.java;

import main.java.DAO.DAOFaculty;
import main.java.DAO.DAOSubject;

public class Speciality {
    private long idSpeciality;
    private String name;
    private long idFaculty;
    private long firstSubject;
    private long secondSubject;
    private long thirdSubject;

    private Faculty faculty = null;
    private Subject subject1 = null;
    private Subject subject2 = null;

    public Subject getSubject1() {
        if (subject1 == null) {
            DAOSubject daoSubject = new DAOSubject();
            this.subject1 = daoSubject.getSubjectById(this.getFirstSubject());
        }
        return subject1;
    }

    public void setSubject1(Subject subject1) {
        this.subject1 = subject1;
    }

    public Subject getSubject2() {
        if (subject2 == null) {
            DAOSubject daoSubject = new DAOSubject();
            this.subject2 = daoSubject.getSubjectById(this.getSecondSubject());
        }

        return subject2;
    }

    public void setSubject2(Subject subject2) {
        this.subject2 = subject2;
    }

    public Subject getSubject3() {
        if (subject3 == null) {
            DAOSubject daoSubject = new DAOSubject();
            this.subject3 = daoSubject.getSubjectById(this.getThirdSubject());
        }
        return subject3;
    }

    public void setSubject3(Subject subject3) {
        this.subject3 = subject3;
    }

    private Subject subject3 = null;

    public Faculty getFaculty() {
        if (faculty == null) {
            DAOFaculty daoFaculty = new DAOFaculty();
            faculty = daoFaculty.getFacultyById(this.getIdFaculty());
        }
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(long idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(long idFaculty) {
        this.idFaculty = idFaculty;
    }

    public long getFirstSubject() {
        return firstSubject;
    }

    public void setFirstSubject(long firstSubject) {
        this.firstSubject = firstSubject;
    }

    public long getSecondSubject() {
        return secondSubject;
    }

    public void setSecondSubject(long secondSubject) {
        this.secondSubject = secondSubject;
    }

    public long getThirdSubject() {
        return thirdSubject;
    }

    public void setThirdSubject(long thirdSubject) {
        this.thirdSubject = thirdSubject;
    }
}
