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
        Authorisation authorisation = new Authorisation();
        User currUser = authorisation.getAuthorisedUser((HttpServletRequest) req);

        //если пришел запрос /login?logout=true
        if (currUser != null && req.getParameter("logout") != null) {
            authorisation.logoutUser(currUser, resp);
        }

        //если пользователь уже авторизован, то перекинуть по адресу
        if (currUser != null) {
            resp.sendRedirect("/abiturients");
            return;
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * Код, отвечающий за проверку логина/пароля, которые
        * из формочки приходят в POST запросе на /login
        * */

        PrintWriter out = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        DAOUser daoUser = new DAOUser();

        //TODO возвращает false, если пароль от БД указан неправильно
        daoUser.setConnectionToUse(SQLConnector.getInstance());

        boolean auth = false;
        User currUser = daoUser.getFullUserInfo(login);

        if (currUser != null && currUser.getPasswordHash().equals(password)) {
            Authorisation authorisation = new Authorisation();
            auth = (authorisation.authoriseUser(currUser, resp));
        }

        if (!auth)
            out.println("OOPS. Access Denied!!!");
        else
            resp.sendRedirect("/abiturients");
    }
}
