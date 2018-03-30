package additional;

public class dataBaseConstants {

    /*
    DataBaseLogin("root"),
    DataBasePassword("1111"),
    DataBaseURL("jdbc:mysql://localhost:3306/mydb");

    private String name;
    private dataBaseConstants(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    */
    private static final String dataBaseLogin = "root";
    private static final String dataBasePassword = "1111";
    private static final String dataBaseUrl = "jdbc:mysql://localhost:3306/mydb";

    public static String getDataBasePassword() {
        return dataBasePassword;
    }

    public static String getDataBaseUrl() {
        return dataBaseUrl;
    }

    public static String getDataBaseLogin() {
        return dataBaseLogin;
    }
}
