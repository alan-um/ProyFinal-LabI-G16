package entidades;

import java.time.LocalDate;

/**
 *
 * @author urqui
 */
public class Membresia {

    private int idMembresia; //ID_Membresía (INT PK): Identificador único de la membresía.
    private Socio socio; //ID_Socio (INT FK): Identificador del socio que tiene la membresía.
    private int cantPases; //cantPases (INT): 8, 12 o 20, se debe decrementar cada vez que el alumno consume una inscripción a una clase
    private LocalDate fInicio;//Fecha_Inicio (DATE): Fecha de inicio de la membresía.
    private LocalDate fFin;//Fecha_Fin (DATE): Fecha de fin de la membresía 30 días a partir de la fecha de inicio. 
    private double costo;//Costo (DECIMAL): Precio de membresía mensual.
    private boolean estado; //Estado (boolean) para borrado lógico.
}
