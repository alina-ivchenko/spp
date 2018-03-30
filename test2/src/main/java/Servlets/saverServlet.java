package main.java.Servlets;

import com.google.gson.Gson;
import main.java.Abiturient;
import main.java.DAO.DAOAbiturient;
import main.java.ProjectFunctions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class saverServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        PrintWriter out = resp.getWriter();
        String data = req.getParameter("data");
        String task = req.getParameter("task");
        String objectType = req.getParameter("objectType");

        //если данные не пришли
        if (ProjectFunctions.isEmptyOrNull(data) || ProjectFunctions.isEmptyOrNull(task) || ProjectFunctions.isEmptyOrNull(objectType)) {
            out.println("Error: input data wrong");
            return;
        }

        Gson gsonObj = new Gson();
        HashMap<String, Object> dbArray = null;

        try {
            dbArray = gsonObj.fromJson(data, HashMap.class);
        } catch (Exception e) {
            out.println("Error: values parsing wrong");
            return;
        }

        if (objectType.equals("Abiturient")) {
            DAOAbiturient daoAbiturient = new DAOAbiturient();

            Abiturient abiturient = new Abiturient();
            ProjectFunctions.tryFillObjectByDbArray(abiturient, dbArray);

            if (task.equals("update")) {
                if (daoAbiturient.updateAbiturient(abiturient)) {
                    out.println("OK");
                } else {
                    out.println("Error: db array");
                }
            }
        }
    }
}