package main.java.Servlets;

import main.java.Abiturient;
import main.java.DAO.DAOAbiturient;
import main.java.DAO.DAOSpeciality;
import main.java.ProjectFunctions;
import main.java.Speciality;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class saverServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        HashMap<String, Object> parameters = rebasePostParamsIntoArrayOfValues(req.getParameterMap());

        String task = req.getParameter("task");
        String objectType = req.getParameter("objectType");

        //если данные не пришли
        if (ProjectFunctions.isEmptyOrNull(objectType) || ProjectFunctions.isEmptyOrNull(task)) {
            out.println("Error: input data wrong");
            return;
        }

        if (objectType.equals("Abiturient")) {
            DAOAbiturient daoAbiturient = new DAOAbiturient();

            if (task.equals("update")) {
                Abiturient abiturient = new Abiturient();
                ProjectFunctions.tryFillObjectByDbArray(abiturient, parameters);

                if (daoAbiturient.updateAbiturient(abiturient)) {
                    out.println("OK");
                } else {
                    out.println("Error: db array");
                }
            }

            if (task.equals("delete")) {
                if (daoAbiturient.deleteAbiturientById(Long.parseLong(parameters.get("id").toString()))) {
                    out.println("OK");
                } else {
                    out.println("Error: db array");
                }
            }
        }

        if (objectType.equals("Speciality")) {
            DAOSpeciality daoSpeciality = new DAOSpeciality();

            if (task.equals("update")) {
                Speciality speciality = new Speciality();
                ProjectFunctions.tryFillObjectByDbArray(speciality, parameters);

                if (daoSpeciality.updateSpeciality(speciality)) {
                    out.println("OK");
                } else {
                    out.println("Error: db array");
                }
            }

            if (task.equals("delete")) {
                if (daoSpeciality.deleteSpecialityById(Long.parseLong(parameters.get("id").toString()))) {
                    out.println("OK");
                } else {
                    out.println("Error: db array");
                }
            }
        }
    }

    private HashMap<String, Object> rebasePostParamsIntoArrayOfValues(Map<String, String[]> postParametersMap) {
        HashMap<String, Object> parameters = new HashMap<>();

        //rebase postParametersMap to dbArray
        Set keys = postParametersMap.keySet();
        for (Object key : keys) {
            if (postParametersMap.get(key).length == 1)
                parameters.put(key.toString(), postParametersMap.get(key)[0]);
            else
                parameters.put(key.toString(), postParametersMap.get(key));
        }

        return parameters;
    }
}