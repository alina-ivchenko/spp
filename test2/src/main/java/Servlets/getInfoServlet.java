package main.java.Servlets;

import com.google.gson.Gson;
import main.java.DAO.DAOFaculty;
import main.java.DAO.DAOSpeciality;
import main.java.DAO.DAOSubject;
import main.java.Faculty;
import main.java.Speciality;
import main.java.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class getInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Gson gson = new Gson();
        List<String> tasks = new ArrayList<>();
        try {
            tasks = gson.fromJson(req.getParameter("tasks"), List.class);
        } catch (Exception e) {

        }

        if (tasks.size() == 0) {
            out.print("Error");
            return;
        }

        Map<String, Object> retMap = new HashMap<>();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equals("ListOfSpecialities")) {
                DAOSpeciality daoSpeciality = new DAOSpeciality();
                List<Speciality> specialities = daoSpeciality.getAllSpecialities();

                HashMap<Long, String> sendValues = new HashMap<>();
                //String retStr = gson.toJson(getHashMapOfSpecialities(specialities), HashMap.class);
                retMap.put(tasks.get(i), getHashMapOfSpecialities(specialities));
            }

            if (tasks.get(i).equals("ListOfFaculties")) {
                DAOFaculty daoFaculty = new DAOFaculty();
                List<Faculty> faculties = daoFaculty.getAllFaculties();
                //String retStr = gson.toJson(getHashMapOfSpecialities(specialities), HashMap.class);
                retMap.put(tasks.get(i), getHashMapOfFaculties(faculties));
            }

            if (tasks.get(i).equals("ListOfSubjects")) {
                DAOSubject daoSubject = new DAOSubject();
                List<Subject> subjects = daoSubject.getAllSubjects();

                //String retStr = gson.toJson(getHashMapOfSpecialities(specialities), HashMap.class);
                retMap.put(tasks.get(i), getHashMapOfSubjects(subjects));
            }
        }
        String str = gson.toJson(retMap);
        out.print(str);
    }

    private HashMap<Long, String> getHashMapOfSubjects(List<Subject> subjects) {
        HashMap<Long, String> values = new HashMap<>();
        if (subjects == null)
            return values;

        for (int i = 0; i < subjects.size(); i++)
            values.put(subjects.get(i).getIdSubject(), subjects.get(i).getName());

        return values;
    }

    private HashMap<Long, String> getHashMapOfSpecialities(List<Speciality> specialities) {
        HashMap<Long, String> values = new HashMap<>();
        if (specialities == null)
            return values;

        for (int i = 0; i < specialities.size(); i++)
            values.put(specialities.get(i).getIdSpeciality(), specialities.get(i).getName());

        return values;
    }

    private HashMap<Long, String> getHashMapOfFaculties(List<Faculty> faculties) {
        HashMap<Long, String> values = new HashMap<>();
        if (faculties == null)
            return values;

        for (int i = 0; i < faculties.size(); i++)
            values.put(faculties.get(i).getIdFaculty(), faculties.get(i).getName());

        return values;
    }
}
