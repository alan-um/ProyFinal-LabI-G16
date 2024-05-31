package entidades;

import java.time.LocalTime;

/**
 *
 * @author urqui
 */
public class Clase {

    private int idClase; //ID_Clase (INT PK): Identificador único de la clase.
    private String nombre; //Nombre (VARCHAR): Nombre de la clase.
    private Entrenador entrenador; //ID_Entrenador (INT FK): Identificador del entrenador asignado.
    private LocalTime horario; //Horario (TIME): Horario de la clase.
    private int capacidad; //Capacidad (INT): Capacidad total de alumnos por clase.
    private boolean estado; //Estado (boolean) para borrado lógico.    

    public Clase(int idClase, String nombre, Entrenador entrenador, LocalTime horario, int capacidad, boolean estado) {
        this.idClase = idClase;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }
    
    public Clase(String nombre, Entrenador entrenador, LocalTime horario, int capacidad, boolean estado) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }
    
    public Clase() {     
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
