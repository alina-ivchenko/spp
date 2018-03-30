package main.java;

import main.java.DAO.DAOSpeciality;

import java.sql.Date;

public class Abiturient {
    private long idAbiturient = -1;
    private String lastName = "";
    private String firstName = "";
    private String secondName = "";
    private String address = "";
    private String passport = "";
    private Date birthDay = Date.valueOf("2012-12-12");

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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Speciality getSpeciality() {
        if (speciality == null) {
            DAOSpeciality daoSpeciality = new DAOSpeciality();
            speciality = daoSpeciality.getSpecialityById(this.getIdSpeciality());
        }
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    //	Id_Abiturient	Last_Name	First_Name	Second_Name	Address	Passport	Birthdate	Id_Speciality
}
