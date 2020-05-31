
package models;

/**
 *
 * @author Gustavo Rivero
 */
public class Persona {
    private String
            nombre,
            apellido,
            cedula,
            telefono,
            direccion,
            fechaNacimiento;
    
    public Persona(String nombre,String apellido,String cedula,
            String telefono,String direccion,String fechaNacimiento){
        
        super();
        
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
        this.telefono=telefono;
        this.direccion=direccion;
        this.fechaNacimiento=fechaNacimiento;
        
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    

}

