package main.java;

public class User {
    private long idUser = -1;
    private String login = "login";
    private String passwordHash = "password";
    private long role = -1;
    private String email = "noemail";
    private String currSessionHash = null;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getCurrSessionHash() {
        return currSessionHash;
    }

    public void setCurrSessionHash(String currSessionHash) {
        this.currSessionHash = currSessionHash;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
