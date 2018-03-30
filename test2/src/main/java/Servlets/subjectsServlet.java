package main.java.Servlets;

import main.java.DAO.DAOSubject;
import main.java.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class subjectsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        Integer currSubjectId = null;
        try {
            currSubjectId = Integer.parseInt(req.getParameter("currSubjectId"));
        } catch (Exception e) {
            currSubjectId = null;
        }

        DAOSubject daoSubject = new DAOSubject();

        if (currSubjectId == null) {
            List<Subject> subjects = daoSubject.getAllSubjects();

            req.setAttribute("listOfSubjects", subjects);
            req.getRequestDispatcher("subjects.jsp").forward(req, resp);
        } else {
            Subject subject = daoSubject.getSubjectById(currSubjectId);

            req.setAttribute("currSubjectInfo", subject);
            req.getRequestDispatcher("/subjectInfoPage.jsp").forward(req, resp);
        }
    }
}
