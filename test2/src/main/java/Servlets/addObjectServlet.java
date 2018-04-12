package main.java.Servlets;

import main.java.ProjectFunctions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addObjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String objectType;
        try {
            objectType = req.getParameter("objectType");
        } catch (Exception e) {
            objectType = null;
        }

        if (ProjectFunctions.isEmptyOrNull(objectType)) {
            req.getRequestDispatcher("/errorOperationPage.jsp").forward(req, resp);
            return;
        }

        if (objectType.equals("Abiturient")) {
            req.getRequestDispatcher("/addAbiturientPage.jsp").forward(req, resp);
            return;
        }

    }
}
