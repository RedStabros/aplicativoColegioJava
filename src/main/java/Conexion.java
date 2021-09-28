import java.sql.*;
//connection,drivemanager,sqlexception

public class Conexion {
    Connection conexion;
    
    public Conexion(){
        conexion=null;
    }
    
    public void abrirConexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url="jdbc:sqlite:bd_estudiantes.db";
            conexion = DriverManager.getConnection(url);
            if (conexion!=null) {
                System.out.println("Conexion Exitosa");                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void cerrarConexion(){
        try {
            if (!conexion.isClosed()) {
                conexion.close();                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
