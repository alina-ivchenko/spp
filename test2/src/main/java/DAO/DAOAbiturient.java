package main.java.DAO;

import main.java.Abiturient;
import main.java.ProjectFunctions;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOAbiturient extends DAO {

    public Abiturient getAbiturientById(long abiturientId) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT `Id_Abiturient`, `Last_Name`, `First_Name`, `Second_Name`, `Address`, `Passport`, `Birthdate`, `Id_Speciality` FROM `abiturient` WHERE `Id_Abiturient` = ?");
        try {
            preparedQuery.setLong(1, abiturientId);
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

    public boolean updateAbiturient(Abiturient abiturient) {
        if (abiturient == null) return false;
        PreparedStatement preparedStatement = currConnection.prepareStatement(
                "UPDATE `abiturient` SET " +
                        "`Last_Name`=?," +
                        "`First_Name`=?," +
                        "`Second_Name`=?," +
                        "`Address`=?," +
                        "`Passport`=?," +
                        "`Birthdate`=?," +
                        "`Id_Speciality`=? " +
                        "WHERE `Id_Abiturient`=?"
        );

        try {
            preparedStatement.setString(1, abiturient.getLastName());
            preparedStatement.setString(2, abiturient.getFirstName());
            preparedStatement.setString(3, abiturient.getSecondName());
            preparedStatement.setString(4, abiturient.getAddress());
            preparedStatement.setString(5, abiturient.getPassport());
            preparedStatement.setDate(6, abiturient.getBirthDay());
            preparedStatement.setLong(7, abiturient.getIdSpeciality());
            preparedStatement.setLong(8, abiturient.getIdAbiturient());
        } catch (SQLException e) {
            return false;
        }

        return currConnection.queryDataEdit(preparedStatement);
    }
}