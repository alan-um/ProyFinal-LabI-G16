package entidades;

import java.time.LocalTime;

/**
 *
 * @author urqui
 */
public class Clase {

    private int idClase; //ID_Clase (INT PK): Identificador único de la clase.
    private String nombre; //Nombre (VARCHAR): Nombre de la clase.
    private int idEntrenador; //ID_Entrenador (INT FK): Identificador del entrenador asignado.
    private LocalTime horario; //Horario (TIME): Horario de la clase.
    private int capacidad; //Capacidad (INT): Capacidad total de alumnos por clase.
    private boolean activo; //Activo (boolean) para borrado lógico.    
}
