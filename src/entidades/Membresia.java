package entidades;

import java.time.LocalDate;

/**
 *
 * @author urqui
 */
public class Membresia {

    private int idMembresia; //ID_Membresía (INT PK): Identificador único de la membresía.
    private int idSocio; //ID_Socio (INT FK): Identificador del socio que tiene la membresía.
    private String tipo;//Tipo (VARCHAR): Tipo de membresía (mensual, anual, etc.).
    private LocalDate fInicio;//Fecha_Inicio (DATE): Fecha de inicio de la membresía.
    private LocalDate fFin;//Fecha_Fin (DATE): Fecha de fin de la membresía. 
    private boolean activo; //Activo (boolean) para borrado lógico.
}
