package entidades;

import java.time.LocalDate;

/**
 *
 * @author urqui
 */
public class Asistencia {

    private int idAsistencia; //ID_Inscripcion (INT PK): Identificador único de la clase.
    private Socio socio; //ID_Socio (INT FK): Identificador del socio que tiene se inscribe a la clase.
    private Clase clase; //ID_Clase (INT FK): Identificador de la clase a la que se inscripbe el socio.    
    private LocalDate fAsistencia;//Fecha_Asistencia: (DATE): Fecha de fin de la inscripción.
}
