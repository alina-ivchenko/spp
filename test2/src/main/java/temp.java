package main.java;

import main.java.DAO.DAOAbiturient;
import main.java.DAO.DAOUser;
import main.java.DAO.SQLConnector;

import java.util.List;

public class temp {
    public static void main(String[] args) {
        DAOAbiturient daoAbiturient = new DAOAbiturient();
        daoAbiturient.setConnectionToUse(new SQLConnector());

        User tempUser = new User();

        tempUser.setLogin("yarad");
        tempUser.setEmail("yarad@world.com");
        tempUser.setRole(1);
        tempUser.setPasswordHash("password");

        List<Abiturient> abiturients = daoAbiturient.getAbiturients();
    }
}
