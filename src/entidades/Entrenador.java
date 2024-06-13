package entidades;

/**
 *
 * @author urqui
 */
public class Entrenador {

    private int idEntrenador; //ID_Entrenador (INT PK): Identificador único del entrenador.
    private int dni; //DNI (INT): Documento Nacional de Identidad del entrenador que sea único.
    private String nombre; //Nombre (VARCHAR): Nombre del entrenador.
    private String apellido; //Apellido (VARCHAR): Nombre del entrenador.
    private String especialidad; //Especialidad (VARCHAR): Especialidad del entrenador.
    private boolean estado; //Estado (boolean) para borrado lógico.

    public Entrenador(int idEntrenador, int dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.idEntrenador = idEntrenador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
    public Entrenador(int dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Entrenador() {
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idEntrenador;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entrenador other = (Entrenador) obj;
        return this.idEntrenador == other.idEntrenador;
    }
    
}
