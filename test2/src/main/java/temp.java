package main.java;

import main.java.DAO.DAOAbiturient;
import main.java.DAO.DAOSpeciality;
import main.java.DAO.DAOUser;
import main.java.DAO.SQLConnector;

import java.util.List;

public class temp {
    public static void main(String[] args) {
        DAOAbiturient daoAbiturient = new DAOAbiturient();
        DAOSpeciality daoSpeciality = new DAOSpeciality();

        daoAbiturient.setConnectionToUse(new SQLConnector());
        daoSpeciality.setConnectionToUse(new SQLConnector());

        Abiturient abiturient = daoAbiturient.getAbiturientById(1);
        abiturient.setSpeciality(daoSpeciality.getSpecialityById(abiturient.getIdSpeciality()));

        List<Abiturient> abiturients = daoAbiturient.getAbiturients();
    }
}
