package main.java;

import main.java.DAO.DAOAbiturient;
import main.java.View.CSVView;
import main.java.View.IReportView;
import main.java.View.PDFView;

public class temp {
    public static void main(String[] args) {
        DAOAbiturient daoAbiturient = new DAOAbiturient();
        PDFView view = new PDFView();
        try {
            //byte[] str = view.generateFileReportByAbiturients(daoAbiturient.getAbiturients());
            //byte[] str2 = view.generateFileReportByAbiturients(daoAbiturient.getAbiturients());
           // String str2 = csvView.generateReportByAbiturients(daoAbiturient.getAbiturients());
        } catch (Exception e) {

        }
    }
}
