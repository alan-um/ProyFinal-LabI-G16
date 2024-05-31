package entidades;

/**
 *
 * @author urqui
 */
public class Socio {
    private int idSocio; //ID_Socio (INT PK):Identificador único del socio.
    private String dni; //DNI (VARCHAR): DNI del socio, valor único.
    private String nombre; //Nombre (VARCHAR): Nombre del socio.
    private String apellido; //Apellido (VARCHAR): Apellido del socio.
    private int edad; //Edad (INT): Edad del socio.
    private String correo; //Correo (VARCHAR): Correo electrónico del socio que sea único.
    private String telefono; //Teléfono (VARCHAR): Número de teléfono del socio.
    private boolean activo; //Activo (boolean) para borrado lógico.
}
