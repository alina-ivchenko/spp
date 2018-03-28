package main.java;

public class Speciality {
    private long idSpeciality;
    private String name;
    private long idFaculty;
    private long firstSubject;
    private long secondSubject;
    private long thirdSubject;

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
