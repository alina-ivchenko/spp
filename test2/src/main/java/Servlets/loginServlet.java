package main.java.Servlets;

import main.java.Authorisation;
import main.java.DAO.DAOUser;
import main.java.DAO.SQLConnector;
import main.java.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class loginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        DAOUser daoUser = new DAOUser();

        //TODO возвращает false, если пароль указан неправильно
        daoUser.setConnectionToUse(new SQLConnector());

        boolean auth = false;
        User currUser = daoUser.getFullUserInfo(login);
        if (currUser != null && currUser.getPasswordHash().equals(password)) {
            Authorisation authorisation = new Authorisation();
            auth = (authorisation.authoriseUser(currUser, resp));

        }

        if(!auth)
            out.println("OOPS");
        else
            out.println("OK");
    }
}
