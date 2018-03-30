package main.java.Servlets;

import main.java.DAO.DAOSpeciality;
import main.java.Speciality;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class specialitiesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        Integer currSpecialityId = null;
        try {
            currSpecialityId = Integer.parseInt(req.getParameter("currSpecialityId"));
        } catch (Exception e) {
            currSpecialityId = null;
        }

        DAOSpeciality daoSpeciality = new DAOSpeciality();

        if (currSpecialityId == null) {
            List<Speciality> specialities = daoSpeciality.getAllSpecialities();

            req.setAttribute("listOfSpecialities", specialities);
            req.getRequestDispatcher("specialities.jsp").forward(req, resp);
        } else {
            Speciality speciality = daoSpeciality.getSpecialityById(currSpecialityId);

            req.setAttribute("currSpecialityInfo", speciality);
            req.getRequestDispatcher("/specialityInfoPage.jsp").forward(req, resp);
        }
    }
}
