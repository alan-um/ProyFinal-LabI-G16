package entidades;

/**
 *
 * @author urqui
 */
public class Entrenador {

    private int idEntrenador; //ID_Entrenador (INT PK): Identificador único del entrenador.
    private String dni; //DNI (VARCHAR): Documento Nacional de Identidad del entrenador que sea único.
    private String nombre; //Nombre (VARCHAR): Nombre del entrenador.
    private String apellido; //Apellido (VARCHAR): Nombre del entrenador.
    private String especialidad; //Especialidad (VARCHAR): Especialidad del entrenador.
    private String disponibilidad; //Disponibilidad (VARCHAR): Horarios de disponibilidad del entrenador
    private boolean activo; //Activo (boolean) para borrado lógico.
}
