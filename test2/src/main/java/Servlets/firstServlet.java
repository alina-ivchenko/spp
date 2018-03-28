package main.java.Servlets;

import main.java.DAO.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

public class firstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");


        PrintWriter out = resp.getWriter(); //pishet
        SQLConnector mySqlConnection = SQLConnector.getInstance();
        mySqlConnection.connect();

        PreparedStatement preparedStatement = mySqlConnection.prepareStatement("SELECT * FROM `Subject`");
        /*try {
            preparedStatement.setInt(1, 4);
        } catch (Exception e) {

        }*/

        List<HashMap<String, Object>> o = mySqlConnection.queryFind(preparedStatement);
        //System.out.println(o.toString());
        //out.println(o.toString().concat("<br>"));
        for (int i = 0; i < o.size(); i++)
            out.println(o.get(i).get("Id_Subject").toString() + " " + o.get(i).get("Name").toString() +"<br>" );

        mySqlConnection.disconnect();
        out.print("<h1></h1>");

    }
}