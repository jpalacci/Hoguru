package model;

//Generamos una abstraccion sobre la conexion con la base de datos aplicando el patron de Facade

public   class DataBaseInterface {

    StoragePersistence r;

    public DataBaseInterface() {
        this.r = new StoragePersistence();
    }

    //Add new user to DB

    public boolean addUser( User  u ){

        return true;
    }
}
