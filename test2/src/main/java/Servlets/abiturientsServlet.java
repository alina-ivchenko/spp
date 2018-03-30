package main.java.Servlets;

import main.java.Abiturient;
import main.java.DAO.DAOAbiturient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class abiturientsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        Integer currAbiturientId = null;
        try {
            currAbiturientId = Integer.parseInt(req.getParameter("currAbiturientId"));
        } catch (Exception e) {
            currAbiturientId = null;
        }

        DAOAbiturient daoAbiturient = new DAOAbiturient();

        if (currAbiturientId == null) {
            List<Abiturient> abiturients = daoAbiturient.getAbiturients();

            req.setAttribute("listOfAbiturients", abiturients);
            req.getRequestDispatcher("abiturients.jsp").forward(req, resp);
        } else {
            Abiturient abiturient = daoAbiturient.getAbiturientById(currAbiturientId);
            req.setAttribute("currAbiturientInfo", abiturient);
            req.getRequestDispatcher("/abiturientInfoPage.jsp").forward(req, resp);
        }
    }
}
