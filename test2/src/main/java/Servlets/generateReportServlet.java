package main.java.Servlets;

import main.java.DAO.DAOAbiturient;
import main.java.View.CSVView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class generateReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        resp.setHeader("Content-Disposition", "attachment;filename=fileNameShowed.csv");
        resp.setContentType("text/csv; charset=UTF-8");

        OutputStream writer = resp.getOutputStream();

        DAOAbiturient daoAbiturient = new DAOAbiturient();
        CSVView csvView = new CSVView();

        byte[] file = csvView.generateReportByAbiturients(daoAbiturient.getAbiturients());
        writer.write(file, 0, file.length);
    }
}
