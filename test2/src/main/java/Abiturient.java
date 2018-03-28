package main.java;

import java.time.LocalDate;

public class Abiturient {
    private long idAbiturient = -1;
    private String lastName = "";
    private String firstName = "";
    private String secondName = "";
    private String address = "";
    private String passport = "";
    private LocalDate birthDay = LocalDate.now();

    //пока что не подгружается
    private long idSpeciality = -1;
    private Speciality speciality = null;

    public long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(long idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public long getIdAbiturient() {
        return idAbiturient;
    }

    public void setIdAbiturient(long idAbiturient) {
        this.idAbiturient = idAbiturient;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    //	Id_Abiturient	Last_Name	First_Name	Second_Name	Address	Passport	Birthdate	Id_Speciality
}
