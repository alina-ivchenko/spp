package main.java.DAO;

import main.java.ProjectFunctions;
import main.java.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class DAOUser extends DAO {

    /*
    * добавляет пользователя в БД.
    * после добавления в поле userToAdd.idUser
    * устанавливается id, с которым БД
    * поместила запись к себе в таблицы
    * */
    public boolean addUser(User userToAdd) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("INSERT INTO `user`(`Login`, `Password_Hash`, `Role`, `Email`,`curr_session_hash`) VALUES (?,?,?,?,?)");

        try {
            preparedQuery.setString(1, userToAdd.getLogin());
            preparedQuery.setString(2, userToAdd.getPasswordHash());
            preparedQuery.setLong(3, userToAdd.getRole());
            preparedQuery.setString(4, userToAdd.getEmail());
            if (userToAdd.getCurrSessionHash() == null)
                preparedQuery.setNull(5, 0);
            else
                preparedQuery.setString(5, userToAdd.getCurrSessionHash());

        } catch (SQLException e) {
            return false;
        }

        boolean queryIsOk = currConnection.queryDataEdit(preparedQuery);
        if (queryIsOk) {
            userToAdd.setIdUser(currConnection.getLastAddedId(preparedQuery));
        }
        return queryIsOk;
    }


    /*
    * обновляет все поля данного user-а
    * !!ищет в БД по ID, который у userToUpdate
    * должен быть установлен
    * */
    public boolean updateUser(User userToUpdate) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("UPDATE `user` SET `Login`=?,`Password_Hash`=?,`Role`=?,`Email`=?,`curr_session_hash`=? WHERE `Id_User`=?");

        try {
            preparedQuery.setString(1, userToUpdate.getLogin());
            preparedQuery.setString(2, userToUpdate.getPasswordHash());
            preparedQuery.setLong(3, userToUpdate.getRole());
            preparedQuery.setString(4, userToUpdate.getEmail());
            if (userToUpdate.getCurrSessionHash() == null)
                preparedQuery.setNull(5, 0);
            else
                preparedQuery.setString(5, userToUpdate.getCurrSessionHash());
            preparedQuery.setLong(6, userToUpdate.getIdUser());
        } catch (SQLException e) {
            return false;
        }

        return currConnection.queryDataEdit(preparedQuery);
    }

    /*
    * получает полную информацию о User
    * по логину
    * */
    public User getFullUserInfo(String login) {
        PreparedStatement preparedQuery = currConnection.prepareStatement("SELECT * FROM mydb.user WHERE `login` = ?");
        try {
            preparedQuery.setString(1, login);
        } catch (SQLException e) {
            return null;
        }

        List<HashMap<String, Object>> retArray = currConnection.queryFind(preparedQuery);

        if (retArray.isEmpty()) return null;

        User retUser = new User();
        ProjectFunctions.tryFillObjectByDbArray(retUser, retArray.get(0));
        return retUser;
    }
}