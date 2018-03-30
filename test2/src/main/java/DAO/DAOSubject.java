package main.java.DAO;

import main.java.ProjectFunctions;
import main.java.Subject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOSubject extends DAO {

    public Subject getSubjectById(long subjectId) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT * FROM `subject` WHERE `Id_Subject` = ?");
        try {
            preparedQuery.setLong(1, subjectId);
        } catch (SQLException e) {
            return null;
        }

        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        if (retArray.isEmpty()) return null;

        Subject retSubject = new Subject();
        ProjectFunctions.tryFillObjectByDbArray(retSubject, retArray.get(0));
        return retSubject;
    }

    public List<Subject> getAllSubjects() {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT * FROM `subject`");
        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        List<Subject> subjects = new ArrayList<>();

        if (retArray.isEmpty()) return subjects;

        for (int i = 0; i < retArray.size(); i++) {
            Subject retObj = new Subject();
            ProjectFunctions.tryFillObjectByDbArray(retObj, retArray.get(i));
            subjects.add(retObj);
        }

        return subjects;
    }
}
