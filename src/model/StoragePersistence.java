package model;

import java.sql.*;

public class StoragePersistence {
        Connection con;
		// Para Oracle
        //String connect_string = "jdbc:oracle:thin:artbd";
		//String driver_class = "oracle.jdbc.driver.OracleDriver";
 		// Para Access
       // String connect_string = "jdbc:odbc:CafeJava";
		//String driver_class = "sun.jdbc.odbc.JdbcOdbcDriver";

		// Para Postgress
		String connect_string = "jdbc:postgresql://localhost:9999/u2017b-1";
		String driver_class = "org.postgresql.Driver";	
		
       Statement stmt;
 	   ResultSet rs;
       StoragePersistence (){
        }
       public boolean conectar(String cUsuario, String cPassword) {

   		try {
			 Class.forName(driver_class); //Esto chequea que el driver se encuentre instalado
		} catch(java.lang.ClassNotFoundException e) {  //Captura el error
			System.err.print("Oracle Class no found exception: ");
			System.err.println(e.getMessage());
			return false;
		}

		try {
		con = DriverManager.getConnection(connect_string, cUsuario,  cPassword); //Hace la conexion
        } catch(SQLException ex) {
			System.err.println("Error de Conexion: "  + ex.getMessage());
			return false;
		}  return true;
        }

        public boolean desconectar() {
        try {
		      con.close(); //Cierre la conexion
        } catch(SQLException ex) {
			System.err.println("Error de desconexion: "  + ex.getMessage());
			return false;
		}
        return true;
        }

        public boolean ejecutasql(String cSql){
   		try {
           stmt = con.createStatement();
	       stmt.executeUpdate(cSql);
 		   stmt.close();
        } catch(SQLException ex) {
			System.err.println("Error de Sql (DML): "  + ex.getMessage());
			return false;
		}
		return true;
        }

        public ResultSet gXrGenerico(String cSql) {
		try {
           stmt = con.createStatement();
           //stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           rs = stmt.executeQuery(cSql);
           //System.out.println(rs.getString(1));
        } catch(SQLException ex) {
			System.err.println("Error de Sql (query): "  + ex.getMessage());
		}

        return rs;

        }




}