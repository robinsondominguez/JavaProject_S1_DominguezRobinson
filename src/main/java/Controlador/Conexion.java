package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection conectar(){
       Connection c = null;
       try  {
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TecnoStore","Robinson Dominguez Ulloa","200715991");
           System.out.println("Conexion Exitosa");
       } catch(SQLException e){
           System.out.println(e.getMessage());
       }
       return c;
    }
}
