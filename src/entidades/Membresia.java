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

    public Membresia(int idMembresia, Socio socio, int cantPases, LocalDate fInicio, LocalDate fFin, double costo, boolean estado) {
        this.idMembresia = idMembresia;
        this.socio = socio;
        this.cantPases = cantPases;
        this.fInicio = fInicio;
        this.fFin = fFin;
        this.costo = costo;
        this.estado = estado;
    }
    
    public Membresia(Socio socio, int cantPases, LocalDate fInicio, LocalDate fFin, double costo, boolean estado) {
        this.socio = socio;
        this.cantPases = cantPases;
        this.fInicio = fInicio;
        this.fFin = fFin;
        this.costo = costo;
        this.estado = estado;
    }

    public Membresia() {
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public int getCantPases() {
        return cantPases;
    }

    public void setCantPases(int cantPases) {
        this.cantPases = cantPases;
    }

    public LocalDate getfInicio() {
        return fInicio;
    }

    public void setfInicio(LocalDate fInicio) {
        this.fInicio = fInicio;
    }

    public LocalDate getfFin() {
        return fFin;
    }

    public void setfFin(LocalDate fFin) {
        this.fFin = fFin;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
