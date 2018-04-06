package main.java.DAO;

import main.java.ProjectFunctions;
import main.java.Speciality;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOSpeciality extends DAO {
    public boolean updateSpeciality(Speciality speciality) {
        if (speciality == null)
            return false;
        PreparedStatement preparedStatement = currConnection.prepareStatement("UPDATE `speciality` SET " +
                "`Name`=?," +
                "`Id_Faculty`=?," +
                "`First_Subject`=?," +
                "`Second_Subject`=?," +
                "`Third_Subject`=?" +
                " WHERE `Id_Speciality`=?");
        try {
            preparedStatement.setString(1, speciality.getName());
            preparedStatement.setLong(2, speciality.getIdFaculty());
            preparedStatement.setLong(3, speciality.getFirstSubject());
            preparedStatement.setLong(4, speciality.getSecondSubject());
            preparedStatement.setLong(5, speciality.getThirdSubject());
            preparedStatement.setLong(6, speciality.getIdSpeciality());
        } catch (SQLException e) {
            return false;
        }

        return currConnection.queryDataEdit(preparedStatement);
    }

    public boolean deleteSpecialityById(long id) {
        PreparedStatement preparedStatement = currConnection.prepareStatement("DELETE FROM `speciality` WHERE `Id_Speciality` = ?");
        try {
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            return false;
        }
        return currConnection.queryDataEdit(preparedStatement);
    }

    public Speciality getSpecialityById(long specialityId) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT `Id_Speciality`, `Name`, `Id_Faculty`, `First_Subject`, `Second_Subject`, `Third_Subject` FROM `speciality` WHERE `Id_Speciality` = ?");
        try {
            preparedQuery.setLong(1, specialityId);
        } catch (SQLException e) {
            return null;
        }

        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        if (retArray.isEmpty()) return null;

        Speciality retSpeciality = new Speciality();
        ProjectFunctions.tryFillObjectByDbArray(retSpeciality, retArray.get(0));
        return retSpeciality;
    }

    public Speciality getSpecialityByName(String specialityName) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT `Id_Speciality`, `Name`, `Id_Faculty`, `First_Subject`, `Second_Subject`, `Third_Subject` FROM `speciality` WHERE `Name` = ?");
        try {
            preparedQuery.setString(1, specialityName);
        } catch (SQLException e) {
            return null;
        }

        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        if (retArray.isEmpty()) return null;

        Speciality retSpeciality = new Speciality();
        ProjectFunctions.tryFillObjectByDbArray(retSpeciality, retArray.get(0));
        return retSpeciality;
    }

    public List<Speciality> getAllSpecialities() {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT `Id_Speciality`, `Name`, `Id_Faculty`, `First_Subject`, `Second_Subject`, `Third_Subject` FROM `speciality`");
        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        List<Speciality> specialities = new ArrayList<>();

        if (retArray.isEmpty()) return specialities;

        for (int i = 0; i < retArray.size(); i++) {
            Speciality speciality = new Speciality();
            ProjectFunctions.tryFillObjectByDbArray(speciality, retArray.get(i));
            specialities.add(speciality);
        }

        return specialities;
    }
}
