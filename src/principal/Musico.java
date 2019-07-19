package principal;

/**
 *
 * @author ivi
 */
public class Musico {
    private int idMusico;
    private String nombre;
    private String apellidos;
    private String direccion;

    public Musico() {
    }

    public Musico(int idMusico, String nombre, String apellidos, String direccion) {
        this.idMusico = idMusico;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public int getIdMusico() {
        return idMusico;
    }

    public void setIdMusico(int idMusico) {
        this.idMusico = idMusico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
