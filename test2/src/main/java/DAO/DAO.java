package main.java.DAO;


/*Классы-наследники этого класса соответствуют
сущностям БД. Суть состоит в том, чтобы абстрагировать
БД от самих объектов, коим и так не будет числа*/
public abstract class DAO {

    //ссылка на используемое подключение
    protected SQLConnector currConnection;

    DAO() {
        setConnectionToUse(SQLConnector.getInstance());
    }

    private Boolean setConnectionToUse(SQLConnector connectionToUse) {
        if (connectionToUse == null) {
            return false;
        } else {
            currConnection = connectionToUse;
            return currConnection.connect();
            //return true;
        }
    }
}
