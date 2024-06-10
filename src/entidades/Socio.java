package entidades;

/**
 *
 * @author urqui
 */
public class Socio {
    private int idSocio; //ID_Socio (INT PK):Identificador único del socio.
    private int dni; //DNI (INT): DNI del socio, valor único.
    private String nombre; //Nombre (VARCHAR): Nombre del socio.
    private String apellido; //Apellido (VARCHAR): Apellido del socio.
    private int edad; //Edad (INT): Edad del socio.
    private String correo; //Correo (VARCHAR): Correo electrónico del socio que sea único.
    private String telefono; //Teléfono (VARCHAR): Número de teléfono del socio.
    private boolean estado; //Estado (boolean) para borrado lógico.

    public Socio(int idSocio, int dni, String nombre, String apellido, int edad, String correo, String telefono, boolean estado) {
        this.idSocio = idSocio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Socio(int dni, String nombre, String apellido, int edad, String correo, String telefono, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Socio() {
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return dni + " - " + apellido + ", " + nombre;
    }
    
}
