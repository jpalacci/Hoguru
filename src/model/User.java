package model;

public class User extends Person{

    private String userName;
    private String password;

    public User(String email, String password, String userName, String name, String surname, String document) {
        super(email, name, surname, document);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
