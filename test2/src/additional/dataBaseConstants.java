package additional;



public enum dataBaseConstants {

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
}
