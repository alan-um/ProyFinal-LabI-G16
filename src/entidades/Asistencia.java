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

    public Asistencia(int idAsistencia, Socio socio, Clase clase, LocalDate fAsistencia) {
        this.idAsistencia = idAsistencia;
        this.socio = socio;
        this.clase = clase;
        this.fAsistencia = fAsistencia;
    }
    
    public Asistencia( Socio socio, Clase clase, LocalDate fAsistencia) {
        this.socio = socio;
        this.clase = clase;
        this.fAsistencia = fAsistencia;
    }
    
    public Asistencia() {
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public LocalDate getfAsistencia() {
        return fAsistencia;
    }

    public void setfAsistencia(LocalDate fAsistencia) {
        this.fAsistencia = fAsistencia;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "idAsistencia=" + idAsistencia + ", socio=" + socio + ", clase=" + clase + ", fAsistencia=" + fAsistencia + '}';
    }
    
}
