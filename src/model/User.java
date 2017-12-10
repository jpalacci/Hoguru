package model;

public class User extends Person{

    private String userName;
    private String password;
    private final static String ADMIN_PASSWORD = "admin";
    private final static String ADMIN_USER = "admin";

    public User(String email, String password, String userName, String name, String surname, String document) {
        super(email, name, surname, document);
        this.userName = userName;
        this.password = password;
    }

    public User(String userName , String password ,String email, String name, String surname, DOCUMENT_TYPE docType, String document, Address adress, String phoneNumber, PHONE_TYPE phoneType ){
        super(email,name, surname, docType, document, adress, phoneNumber,  phoneType);
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

    public boolean addUser(){
        DataBaseFacade db = DataBaseFacade.getInstance();
        return db.addUser(this);
    }

    public static boolean isAdmin(String userName , String password){
        if(userName.equals(ADMIN_USER)) {

            if (password.equals(ADMIN_PASSWORD)) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public static User getUser(String userName , String password){
        DataBaseFacade db = DataBaseFacade.getInstance();
        User u  = db.getUser(userName);
        if( u != null){
            if(u.password.equals(password)){
                return u;
            }else{
                return null;
            }
        }
        return u;
    }

    public boolean removeUser(){
        DataBaseFacade db = DataBaseFacade.getInstance();
        return db.deleteUser(this.userName);
    }

    public boolean editUser(){
        DataBaseFacade db = DataBaseFacade.getInstance();
        return db.editUser(this);
    }
}
