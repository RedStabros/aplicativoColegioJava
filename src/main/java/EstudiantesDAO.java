import java.sql.*;
//preparedstatement,resulset,sqlexception


public class EstudiantesDAO {
    //objeto conexion
    Conexion c = new Conexion();
    
    public EstudiantesDAO(){
        c.abrirConexion();
    }
    
    public void insertarDatos(String nombre, String apellido, String fechaN, String correoI, String correoP, long celular, long fijo, String programa){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Insert into estudiantes values(?,?,?,?,?,?,?,?)");
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, fechaN);
            pst.setString(4, correoI);
            pst.setString(5, correoP);
            pst.setString(6, String.valueOf(celular));
            pst.setString(7, String.valueOf(fijo));
            pst.setString(8, programa);
            pst.executeUpdate();
            System.out.println("Se agregó el estudiante\n");
            pst.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error: El estudiante ya existe");
        }
    }

 /*   public void buscarDatos(String correoI){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from estudiantes where correoI=?");
            pst.setString(1, correoI);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Información del estudiante");
                System.out.println("Nombre: " + rs.getString("Nombre") + "\n"
                                +"Apellidos: " + rs.getString("Apellido") + "\n"
                                +"Fecha nacimiento: " + rs.getString("fechaN") + "\n"
                                +"Correo institucional: " + rs.getString("correoI") + "\n"
                                +"Correo personal: " + rs.getString("correoP") + "\n"
                                +"Número de teléfono celular: " + rs.getString("celular") + "\n"
                                +"Número de teléfono fijo: " + rs.getString("fijo") + "\n"
                                +"Programa académico: " + rs.getString("programa") + "\n"
                                );
            }else{
                System.out.println("No se encontro información de ese Correo Institucional");
            }
            pst.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }*/
    
    public void actualizarDatos(String correoI, String correoP, long celular, long fijo, String programa){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Update estudiantes set correoP=?, celular=?, fijo=?, programa=? where correoI=?");  
            pst.setString(1, correoP);
            pst.setString(2, String.valueOf(celular));
            pst.setString(3, String.valueOf(fijo));
            pst.setString(4, programa);
            pst.setString(5, correoI);
            pst.executeUpdate();
            System.out.println("Se modificó el estudiante\n");
            pst.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void eliminarDatos(String correoI){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Delete from estudiantes where correoI=?");
            pst.setString(1, correoI);
            pst.executeUpdate();
            System.out.println("Se eliminó el estudiante");
            pst.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
   /* public void mostrarDatos(){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from estudiantes");           
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("El directorio de los estudiantes");
                System.out.println("Nombre: " + rs.getString("Nombre") + "\n"
                                +"Apellidos: " + rs.getString("Apellido") + "\n"
                                +"Fecha nacimiento: " + rs.getString("fechaN") + "\n"
                                +"Correo institucional: " + rs.getString("correoI") + "\n"
                                +"Correo personal: " + rs.getString("correoP") + "\n"
                                +"Número de teléfono celular: " + rs.getString("celular") + "\n"
                                +"Número de teléfono fijo: " + rs.getString("fijo") + "\n"
                                +"Programa académico: " + rs.getString("programa") + "\n"
                                );
                        }
            pst.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }*/
    
    public void finalizar(){
        c.cerrarConexion();
    }
    
    public boolean verificarDatosTablas(String correoI){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from estudiantes where correoI=?");
            pst.setString(1, correoI);
//            pst.setString(2, correoI);
            ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }else{
                    return false;
                }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    //menu consultas
    
 /*   public void consultasDB(int opcion, String dato1, long dato2){
        try {
            switch(opcion){
                case 1://correoI
                    PreparedStatement pst1 = c.conexion.prepareStatement("Select * from estudiantes where correoI=?");
                    pst1.setString(1, dato1);
                    ResultSet rs1 = pst1.executeQuery();
                    while(rs1.next()){
                        System.out.println("Nombre: " + rs1.getString("Nombre") + "\n"
                                +"Apellidos: " + rs1.getString("Apellido") + "\n"
                                +"Fecha nacimiento: " + rs1.getString("fechaN") + "\n"
                                +"Correo institucional: " + rs1.getString("correoI") + "\n"
                                +"Correo personal: " + rs1.getString("correoP") + "\n"
                                +"Número de teléfono celular: " + rs1.getString("celular") + "\n"
                                +"Número de teléfono fijo: " + rs1.getString("fijo") + "\n"
                                +"Programa académico: " + rs1.getString("programa") + "\n"                                                        
                        );
                    }
                    pst1.close();
                    break;
                case 2://apellido
                    PreparedStatement pst2 = c.conexion.prepareStatement("Select * from estudiantes where Apellido like ?");
                    pst2.setString(1, dato1);
                    ResultSet rs2 = pst2.executeQuery();
                    while(rs2.next()){
                        System.out.println("Nombre: " + rs2.getString("Nombre") + "\n"
                                +"Apellidos: " + rs2.getString("Apellido") + "\n"
                                +"Fecha nacimiento: " + rs2.getString("fechaN") + "\n"
                                +"Correo institucional: " + rs2.getString("correoI") + "\n"
                                +"Correo personal: " + rs2.getString("correoP") + "\n"
                                +"Número de teléfono celular: " + rs2.getString("celular") + "\n"
                                +"Número de teléfono fijo: " + rs2.getString("fijo") + "\n"
                                +"Programa académico: " + rs2.getString("programa") + "\n"                       
                        );
                    }
                    pst2.close();
                    break;
                case 3://programa
                    PreparedStatement pst3 = c.conexion.prepareStatement("Select * from estudiantes where programa like ?");
                    pst3.setString(1, dato1);
                    ResultSet rs3 = pst3.executeQuery();
                    while(rs3.next()){
                        System.out.println("Nombres: " + rs3.getString("Nombre") + "\n"
                                        + "Apellidos: " + rs3.getString("Apellido") + "\n"                      
                        );
                    }
                    pst3.close();
                    break;
                case 4://N estudiantes por programa
                    PreparedStatement pst4 = c.conexion.prepareStatement("Select count(*) as cantEstu  from estudiantes where programa like ?");
                    pst4.setString(1, dato1);
                    ResultSet rs4 = pst4.executeQuery();
                    while(rs4.next()){
                        System.out.println("Cantidad de estudiantes del programa " + rs4.getString("cantEstu"));
                    }
                    pst4.close();
                    break;
                case 5://fecha de nacimiento
                    PreparedStatement pst5 = c.conexion.prepareStatement("Select * from estudiantes where fechaN=?");
                    pst5.setString(1, dato1);
                    ResultSet rs5 = pst5.executeQuery();
                    while(rs5.next()){
                        System.out.println("Nombre: " + rs5.getString("Nombre") + "\n"
                                +"Apellidos: " + rs5.getString("Apellido") + "\n"
                                +"Fecha nacimiento: " + rs5.getString("fechaN") + "\n"
                                +"Correo institucional: " + rs5.getString("correoI") + "\n"
                                +"Correo personal: " + rs5.getString("correoP") + "\n"
                                +"Número de teléfono celular: " + rs5.getString("celular") + "\n"
                                +"Número de teléfono fijo: " + rs5.getString("fijo") + "\n"
                                +"Programa académico: " + rs5.getString("programa") + "\n"                       
                        );
                    }
                    pst5.close();
                    break;
                case 6://celular
                    PreparedStatement pst6 = c.conexion.prepareStatement("Select * from estudiantes where celular=?");
                    pst6.setString(1, String.valueOf(dato2));
                    ResultSet rs6 = pst6.executeQuery();
                    while(rs6.next()){
                        System.out.println("Nombre: " + rs6.getString("Nombre") + "\n"
                                        +"Programa académico: " + rs6.getString("programa") + "\n"                        
                        );
                    }
                    pst6.close();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }*/
    
}