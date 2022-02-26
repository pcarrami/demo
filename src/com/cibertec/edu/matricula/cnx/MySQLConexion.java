package com.cibertec.edu.matricula.cnx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {

    
    
    private static String url="jdbc:mysql://localhost:3306/cibertec";
    private static String usuario="root";
    private static String clave="123456";
    private static String driver="com.mysql.cj.jdbc.Driver";
    
    Connection conn = null;
    
    static{
        try {
            Class.forName(driver);
            //Class.forName(driverSQL);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error clase Driver: " +  ex);
        }
    }
    
    public Connection getConn(){
        
        try {
            
            
            conn= DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex);
        }
        return conn;
    }
	
}
