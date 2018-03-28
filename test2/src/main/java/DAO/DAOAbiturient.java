package main.java.DAO;

import main.java.Abiturient;
import main.java.ProjectFunctions;
import main.java.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOAbiturient extends DAO {

    public Abiturient getAbiturientById(int abiturientId) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT `Id_Abiturient`, `Last_Name`, `First_Name`, `Second_Name`, `Address`, `Passport`, `Birthdate`, `Id_Speciality` FROM `abiturient` WHERE `Id_Abiturient` = ?");
        try {
            preparedQuery.setInt(1, abiturientId);
        } catch (SQLException e) {
            return null;
        }

        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        if (retArray.isEmpty()) return null;

        Abiturient retAbiturient = new Abiturient();
        ProjectFunctions.tryFillObjectByDbArray(retAbiturient, retArray.get(0));
        return retAbiturient;
    }

    public List<Abiturient> getAbiturients() {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT `Id_Abiturient`, `Last_Name`, `First_Name`, `Second_Name`, `Address`, `Passport`, `Birthdate`, `Id_Speciality` FROM `abiturient`");
        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        List<Abiturient> abiturients = new ArrayList<Abiturient>();

        if (retArray.isEmpty()) return abiturients;

        for (int i = 0; i < retArray.size(); i++) {
            Abiturient retAbiturient = new Abiturient();
            ProjectFunctions.tryFillObjectByDbArray(retAbiturient, retArray.get(i));
            abiturients.add(retAbiturient);
        }

        return abiturients;
    }
}