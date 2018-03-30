package main.java;

import main.java.DAO.DAOAbiturient;
import main.java.DAO.DAOSpeciality;
import main.java.DAO.DAOUser;
import main.java.DAO.SQLConnector;

import java.util.List;

public class temp {
    public static void main(String[] args) {
        DAOSpeciality daoSpeciality = new DAOSpeciality();
        List<Speciality> specialities = daoSpeciality.getAllSpecialities();
        List<Speciality> specialities2 = daoSpeciality.getAllSpecialities();
    }
}
