package main.java.DAO;

import main.java.Faculty;
import main.java.ProjectFunctions;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOFaculty extends DAO {
    public Faculty getFacultyById(long facultyId) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT `Id_Faculty`, `Name` FROM `faculty` WHERE `Id_Faculty` = ?");
        try {
            preparedQuery.setLong(1, facultyId);
        } catch (SQLException e) {
            return null;
        }

        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        if (retArray.isEmpty()) return null;

        Faculty retFaculty = new Faculty();
        ProjectFunctions.tryFillObjectByDbArray(retFaculty, retArray.get(0));
        return retFaculty;
    }

    public List<Faculty> getAllFaculties() {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT * FROM `faculty`");
        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        List<Faculty> faculties = new ArrayList<>();

        if (retArray.isEmpty()) return faculties;

        for (int i = 0; i < retArray.size(); i++) {
            Faculty obj = new Faculty();
            ProjectFunctions.tryFillObjectByDbArray(obj, retArray.get(i));
            faculties.add(obj);
        }

        return faculties;
    }

    public boolean updateFaculty(Faculty faculty) {
        if (faculty == null)
            return false;

        PreparedStatement preparedStatement = currConnection.prepareStatement("UPDATE `faculty` SET `Name`=? WHERE `Id_Faculty`=?");
        try {
            preparedStatement.setString(1, faculty.getName());
            preparedStatement.setLong(2, faculty.getIdFaculty());
        } catch (SQLException e) {
            return false;
        }

        return currConnection.queryDataEdit(preparedStatement);
    }

    public boolean deleteFacultyById(long id) {
        PreparedStatement preparedStatement = currConnection.prepareStatement("DELETE FROM `faculty` WHERE `Id_Faculty` = ?");
        try {
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            return false;
        }

        return currConnection.queryDataEdit(preparedStatement);
    }
}
