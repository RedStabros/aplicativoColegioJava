public class Estudiantes {
    private String nombre;
    private String apellido;
    private String fechaN;
    private String correoI;
    private String correoP;
    private long celular;
    private long fijo;
    private String programa;
    
    //constructor vacio
    
    public Estudiantes(){
        
    }
    
    //constructor con parametros
    
    public Estudiantes(String nombre, String apellido, String fechaN, String correoI, String correoP, long celular, long fijo, String programa){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaN = fechaN;
        this.correoI = correoI;
        this.correoP = correoP;
        this.celular = celular;
        this.fijo = fijo;
        this.programa = programa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getCorreoI() {
        return correoI;
    }

    public void setCorreoI(String correoI) {
        this.correoI = correoI;
    }

    public String getCorreoP() {
        return correoP;
    }

    public void setCorreoP(String correoP) {
        this.correoP = correoP;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public long getFijo() {
        return fijo;
    }

    public void setFijo(long fijo) {
        this.fijo = fijo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
       
}
