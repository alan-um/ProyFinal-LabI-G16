package entidades;

/**
 *
 * @author urqui
 */
public class Inscripcion {

    private int idInscripcion; //ID_Inscripcion (INT PK): Identificador único de la clase.
    private int idClase; //ID_Clase (INT FK): Identificador de la clase a la que se inscripbe el socio.
    private int idSocio; //ID_Socio (INT FK): Identificador del socio que tiene se inscribe a la clase.
    private boolean activo; //Activo (boolean) para borrado lógico.
}
