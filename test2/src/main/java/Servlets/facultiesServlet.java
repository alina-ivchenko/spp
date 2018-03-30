package main.java.Servlets;

import main.java.DAO.DAOFaculty;
import main.java.Faculty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class facultiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        Integer currFacultyId = null;
        try {
            currFacultyId = Integer.parseInt(req.getParameter("currFacultyId"));
        } catch (Exception e) {
            currFacultyId = null;
        }

        DAOFaculty daoFaculty = new DAOFaculty();

        if (currFacultyId == null) {
            List<Faculty> faculties = daoFaculty.getAllFaculties();

            req.setAttribute("listOfFaculties", faculties);
            req.getRequestDispatcher("faculties.jsp").forward(req, resp);
        } else {
            Faculty faculty = daoFaculty.getFacultyById(currFacultyId);

            req.setAttribute("currFacultyInfo", faculty);
            req.getRequestDispatcher("/facultyInfoPage.jsp").forward(req, resp);
        }
    }
}