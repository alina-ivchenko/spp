package main.java.DAO;

import main.java.Abiturient;
import main.java.ProjectFunctions;
import main.java.Speciality;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class DAOSpeciality extends DAO {
    public Speciality getSpecialityById(long specialityId) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT  `Name`, `Id_Faculty`, `First_Subject`, `Second_Subject`, `Third_Subject` FROM `speciality` WHERE `Id_Speciality` = ?");
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
}
