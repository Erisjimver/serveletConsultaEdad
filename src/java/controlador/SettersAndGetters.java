package controlador;
public class SettersAndGetters {
 
    
    
///////////////////////////    variables    ///////////////////////////////////
    
    
    //datos de tabla persona
    private String cedula,nombre,apellido,fechaactual,edad;

    public SettersAndGetters(){
    }
    
    public SettersAndGetters(String cedula, String nombre, String apellido, String fechaactual, String edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaactual = fechaactual;
        this.edad = edad;
    }

    
/////////////////////////////SETTERS AND GETTERS //////////////////////////////
    
    //tabla persona

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getFechaactual() {
        return fechaactual;
    }

    public void setFechaactual(String fechaactual) {
        this.fechaactual = fechaactual;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }


    


    
}
