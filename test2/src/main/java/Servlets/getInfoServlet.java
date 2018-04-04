package main.java.Servlets;

import com.google.gson.Gson;
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
import java.util.List;

public class getInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Gson gson = new Gson();

        String task = req.getParameter("task");
        if (ProjectFunctions.isEmptyOrNull(task)) {
            out.println("");
            return;
        }

        if (task.equals("ListOfSpecialities")) {
            DAOSpeciality daoSpeciality = new DAOSpeciality();
            List<Speciality> specialities = daoSpeciality.getAllSpecialities();

            HashMap<Long, String> sendValues = new HashMap<>();
            String retStr = gson.toJson(getHashMapOfSpecialities(specialities), HashMap.class);

            out.println(retStr);
        }
    }

    private HashMap<Long, String> getHashMapOfSpecialities(List<Speciality> specialities) {
        HashMap<Long, String> values = new HashMap<>();
        if (specialities == null)
            return values;

        for (int i = 0; i < specialities.size(); i++)
            values.put(specialities.get(i).getIdSpeciality(), specialities.get(i).getName());

        return values;
    }
}
