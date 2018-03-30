package main.java.DAO;

import main.java.Abiturient;
import main.java.ProjectFunctions;
import main.java.Speciality;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOSpeciality extends DAO {
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

    public Speciality getSpecialityByName(String specialityName){
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
