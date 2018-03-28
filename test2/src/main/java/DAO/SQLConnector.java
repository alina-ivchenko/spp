package main.java.DAO;

import additional.dataBaseConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class SQLConnector {

    private String url = dataBaseConstants.getDataBaseUrl();
    private String user = dataBaseConstants.getDataBaseLogin();
    private String password = dataBaseConstants.getDataBasePassword();

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    private static SQLConnector instance = null;

    private SQLConnector() {
        Properties properties = new Properties();
        properties.setProperty("characterEncoding", "utf8");
        /*оставлю пустой конструктор, дабы можно было оставить изначально инициализированные значения*/
    }

    public static SQLConnector getInstance() {
        if (instance == null)
            instance = new SQLConnector();
        return instance;
    }

    public SQLConnector(String url, String userName, String password) {
        this.url = url;
        this.user = userName;
        this.password = password;
    }

    public List<HashMap<String, Object>> queryFind(PreparedStatement queryPrepared) {

        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        try {
            // opening database connection to MySQL server

            // executing SELECT query
            rs = queryPrepared.executeQuery();

            int amountOfColumns = rs.getMetaData().getColumnCount();
            String currColumnName;

            while (rs.next()) {
                HashMap<String, Object> columnList = new HashMap<String, Object>();
                for (int i = 1; i <= amountOfColumns; i++) {
                    currColumnName = rs.getMetaData().getColumnName(i);
                    columnList.put(currColumnName, rs.getObject(i));
                }
                list.add(columnList);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything  */}
        }
        return list;
    }

    public boolean queryDataEdit(PreparedStatement queryPrepared) {
        boolean retValue = false;
        try {
            // opening database connection to MySQL server

            // executing SELECT query
            //retValue = stmt.execute(queryString);
            //Statement.RETURN_GENERATED_KEYS задётся в preparStatement
            retValue = queryPrepared.executeUpdate() != 0;


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
        }
        return retValue;
    }

    public int getLastAddedId(PreparedStatement preparedStatement) {
        int ret = -1;
        try {
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next())
                ret = rs.getInt(1);
        } catch (Exception e) {

        }
        return ret;
    }

    public boolean connect() {
        boolean retValue = true;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.toString());
            retValue = false;
        }
        return retValue;
    }

    public void disconnect() {
        //close connection ,stmt and resultset here
        try {
            con.close();
        } catch (Exception se) {
        }
        try {
            stmt.close();
        } catch (Exception se) {
        }
    }

    public PreparedStatement prepareStatement(String sql) {
        PreparedStatement retValue = null;
        try {
            //в этом месте я немножко схалявилa
            //по-хорошему Statement.RETURN_GENERATED_KEYS должен быть вариативным
            //но примем, будто он нужен всегда
            retValue = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {

        }

        return retValue;
    }
}