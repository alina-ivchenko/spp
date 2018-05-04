package main.java.DAO;

import main.java.Abiturient;
import main.java.ProjectFunctions;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOAbiturient extends DAO {

    public Integer getAmountOfAbiturientsOnSpeciality(long specialityId) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("select count(1)\n" +
                "from abiturient a" +
                "where a.Id_Speciality = 5" +
                "group by a.Id_Speciality;");
        try {
            preparedQuery.setLong(1, specialityId);
        } catch (SQLException e) {
            return null;
        }
        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);
        if (retArray.isEmpty()) return null;

        return Integer.parseInt(retArray.get(0).get("count").toString());
    }

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

    public boolean deleteAbiturientById(long id) {
        PreparedStatement preparedStatement = currConnection.prepareStatement("DELETE FROM `abiturient` WHERE `Id_Abiturient` = ?");
        try {
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            return false;
        }
        return currConnection.queryDataEdit(preparedStatement);
    }

    public boolean addAbiturient(Abiturient abiturient) {
        if (abiturient == null) return false;
        PreparedStatement preparedStatement = currConnection.prepareStatement(
                "INSERT INTO `abiturient`(`Last_Name`, `First_Name`, `Second_Name`, `Address`, `Passport`, `Birthdate`, `Id_Speciality`) VALUES (?,?,?,?,?,?,?)"
        );

        try {
            preparedStatement.setString(1, abiturient.getLastName());
            preparedStatement.setString(2, abiturient.getFirstName());
            preparedStatement.setString(3, abiturient.getSecondName());
            preparedStatement.setString(4, abiturient.getAddress());
            preparedStatement.setString(5, abiturient.getPassport());
            preparedStatement.setDate(6, abiturient.getBirthDay());
            preparedStatement.setLong(7, abiturient.getIdSpeciality());
        } catch (SQLException e) {
            return false;
        }

        boolean queryIsOk = currConnection.queryDataEdit(preparedStatement);
        if (queryIsOk) {
            abiturient.setIdAbiturient(currConnection.getLastAddedId(preparedStatement));
        }
        return queryIsOk;
    }
}