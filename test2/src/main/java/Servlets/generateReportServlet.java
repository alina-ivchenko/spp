package main.java.Servlets;

import main.java.DAO.DAOAbiturient;
import main.java.DAO.DAOSpeciality;
import main.java.DAO.DAOSubject;
import main.java.View.CSVView;
import main.java.View.IReportView;
import main.java.View.PDFView;
import main.java.View.XLSXView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class generateReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reportTask = null;
        String format = null;
        try {
            reportTask = req.getParameter("reportTask");
            format = req.getParameter("format");
        } catch (Exception e) {
            req.getRequestDispatcher("/errorOperationPage.jsp").forward(req, resp);
            return;
        }

        IReportView reportView = null;
        if (format.equals("csv"))
            reportView = new CSVView();
        if (format.equals("pdf"))
            reportView = new PDFView();
        if (format.equals("xlsx"))
            reportView = new XLSXView();

        if (reportView == null) {
            req.getRequestDispatcher("/errorOperationPage.jsp").forward(req, resp);
            return;
        }

        byte[] file = null;

        if (reportTask.equals("abiturients")) {
            DAOAbiturient daoAbiturient = new DAOAbiturient();
            file = reportView.generateReportByAbiturients(daoAbiturient.getAbiturients());
        } else if (reportTask.equals("specialities")) {
            DAOSpeciality daoSpeciality = new DAOSpeciality();
            file = reportView.generateReportBySpecialities(daoSpeciality.getAllSpecialities());
        } else if (reportTask.equals("subjects")) {
            DAOSubject daoSubject = new DAOSubject();
            file = reportView.generateReportBySubjects(daoSubject.getAllSubjects());
        }

        //TODO: другие отчёты

        if (file == null || file.length == 0)
            req.getRequestDispatcher("/errorOperationPage.jsp").forward(req, resp);
        else {
            resp.setHeader("Content-Disposition", "attachment;filename=report." + format);
            resp.setContentType("text/" + format + "; charset=UTF-8");
            OutputStream writer = resp.getOutputStream();

            writer.write(file, 0, file.length); //OK: file was sended
        }
    }
}
