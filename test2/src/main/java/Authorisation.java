package main.java;

import main.java.DAO.DAOUser;
import main.java.DAO.SQLConnector;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authorisation {

    /*
    * подгружает с БД авторизованного пользователя,
    * которого он определяет по cookie запроса,
    * который пришёл на сервлет
    * */
    public User getAuthorisedUser(HttpServletRequest req) {

        Cookie[] cookies = req.getCookies();

        if (cookies == null)
            return null;

        String login = "";
        String currSessionHash = "";

        for (int i = 0; i < cookies.length; i++) {
            switch (cookies[i].getName()) {
                case "login":
                    login = cookies[i].getValue();
                    break;
                case "curr_session_hash":
                    currSessionHash = cookies[i].getValue();
                    break;
            }
        }

        if (login.isEmpty() || currSessionHash.isEmpty())
            return null;

        DAOUser daoUser = new DAOUser();

        User user = daoUser.getFullUserInfo(login);
        if (user != null && user.getCurrSessionHash() != null && user.getCurrSessionHash().equals(currSessionHash))
            return user;
        else
            return null;
    }


    /*
    * авторизует пользователя:
    * а) в БД добавляя Curr_session_hash этого пользователя
    * б) в cookie ответа сервера засовывая login/curr_session_hash
    * */
    public boolean authoriseUser(User user, HttpServletResponse resp) {

        DAOUser daoUser = new DAOUser();

        String currSessionHash = generateHash(20);
        user.setCurrSessionHash(currSessionHash);

        if (daoUser.updateUser(user)) {

            resp.addCookie(new Cookie("login", user.getLogin()));
            resp.addCookie(new Cookie("curr_session_hash", user.getCurrSessionHash()));

            return true;
        } else {
            user.setCurrSessionHash(null);
            return false;
        }

    }

    public void logoutUser(User user, HttpServletResponse resp) {
        DAOUser daoUser = new DAOUser();

        user.setCurrSessionHash(null);

        daoUser.updateUser(user);

        Cookie cookie1 = new Cookie("login", "");
        Cookie cookie2 = new Cookie("curr_session_hash", "");

        cookie1.setMaxAge(-100);
        cookie2.setMaxAge(-100);

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }

    private String generateHash(int length) {
        String symbols = "qwerty";
        StringBuilder randString = new StringBuilder();
        for (int i = 0; i < length; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        return randString.toString();
    }
}
