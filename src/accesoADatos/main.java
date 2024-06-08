package accesoADatos;

import entidades.Asistencia;
import entidades.Clase;
import entidades.Entrenador;
import entidades.Membresia;
import entidades.Socio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author urqui
 */
public class main {

    public static void main(String[] args) {
//
        //Crea instancias de manejo de datos.
        SocioData sData = new SocioData();
        ClaseData cData = new ClaseData();
        EntrenadorData eData = new EntrenadorData();
        MembresiaData mData = new MembresiaData();
        AsistenciaData aData = new AsistenciaData();
//
//
//
/////////////////////////////--PRUEBA DE SOCIODATA--////////////////////////////////        
//        
//Agregar un Socio Nuevo    
//        Socio socio = new Socio(92222228, "Chico", "De Prueba", 33, "correo@mail.com","2646546851", true);
//        sData.guardarSocio(socio);
//
//Buscar Socio por ID 
//        Socio socio = sData.buscarSocio(5);
//        if(socio!=null){
//            System.out.println(socio.toString());
//        }
//
//Buscar Socio por DNI
//        Socio socio = sData.buscarSocioPorDni(34777990);
//        if(socio!=null){
//            System.out.println(socio.toString());
//        }
//
//Modificarle algún dato al Socio
//        Socio socio = sData.buscarSocio(4);
//        if(socio!=null){
//            System.out.println(socio.toString());
//            socio.setNombre("Pibe");
//            sData.modificarSocio(socio);
//        }
//        
//Eliminar (poner estado 0) un Socio
//        sData.eliminarSocio(4);
//
//Listado de Socios       
//        List<Socio> lista = new ArrayList();
//        lista = sData.listarSocios();
//        for (Socio aux:lista) {
//            System.out.println(aux.toString());
//        }
//
//
/////////////////////////////--PRUEBA DE ENTRENADORDATA--////////////////////////////////
//    
////Agregar un Entrenador Nuevo    
//        Entrenador entrenador = new Entrenador(92222228, "Profe", "De Prueba", "Probador", true);
//        eData.guardarEntrenador(entrenador);
//
////Buscar entrenador por ID 
//        Entrenador entrenador = eData.buscarEntrenador(5);
//        if(entrenador!=null){
//            System.out.println(entrenador.toString());
//        }
//
////Buscar entrenador por DNI
//        Entrenador entrenador = eData.buscarEntrenadorPorDni(32999555);
//        if(entrenador!=null){
//            System.out.println(entrenador.toString());
//        }
//
//Modificarle algún dato al entrenador
//        Entrenador entrenador = eData.buscarEntrenador(4);
//        if(entrenador!=null){
//            System.out.println(entrenador.toString());
//            entrenador.setNombre("Gran Profe");
//            eData.modificarEntrenador(entrenador);
//        }
//        
//Eliminar (poner estado 0) un Entrenador
//        eData.eliminarEntrenador(4);
//
//Listado de Entrenadores       
//        List<Entrenador> lista = new ArrayList();
//        lista = eData.listarEntrenadores();
//        for (Entrenador aux:lista) {
//            System.out.println(aux.toString());
//        }
//
/////////////////////////////--PRUEBA DE CLASEDATA--////////////////////////////////
//     
//Agregar una Clase Nueva
//        Entrenador entrenador = eData.buscarEntrenador(3);
//        Clase clase = new Clase("Zumba", entrenador, LocalTime.of(17, 0), 12, true);
//        cData.guardarClase(clase);
//
//Buscar una Clase por ID 
//        Clase clase = cData.buscarClase(14);
//        if(clase!=null){
//            System.out.println(clase.toString());
//        }
//
//Buscar una Clase por Horario 
//        Clase clase = cData.buscarClasePorHorario(LocalTime.of(20, 0, 0));
//        if(clase!=null){
//            System.out.println(clase.toString());
//        }
//
//Modificarle algún dato a la clase
//        Clase clase = cData.buscarClase(4);
//        if(clase!=null){
//            System.out.println(clase.toString());
//            clase.setNombre("Zumba");
//            cData.modificarClase(clase);
//            clase = cData.buscarClase(4);
//            System.out.println(clase.toString());
//        }
//
//Listar los horarios disponibles
//        List<LocalTime> lista = cData.horariosDisponibles();
//        for (LocalTime aux:lista) {
//            System.out.println(aux.toString());
//        }
//
//Listar los nombres de clases disponibles
//        List<String> lista = cData.nombresDeClases();
//        for (String aux:lista) {
//            System.out.println(aux);
//        }
//
//Eliminar (poner estado 0) una Clase
//        cData.eliminarClase(4);
//
//Listado de Clases       
//        List<Clase> lista = new ArrayList();
//        lista = cData.listarClases();
//        for (Clase aux:lista) {
//            System.out.println(aux.toString());
//        }
//
/////////////////////////////--PRUEBA DE MEMBRESIADATA--////////////////////////////////        
//        
//Agregar una Mambresia Nueva    
//        Socio socio = sData.buscarSocio(1);
//        System.out.println(socio.toString());
//        Membresia membr = new Membresia(socio, 8, LocalDate.of(2024, 5, 8), LocalDate.of(2024, 6, 8),1799.99, true);
//        mData.guardaMembresia(membr);
//
//Buscar Membresia por ID 
//        Membresia membr = mData.buscarMembresia(1);
//        if(membr!=null){
//            System.out.println(membr.toString());
//        }
//
//Listado de Membresias       
//        List<Membresia> lista = new ArrayList();
//        lista = mData.listadoMembresia();
//        for (Membresia aux:lista) {
//            System.out.println(aux.toString());
//        }
//
//Listado de Membresias según idSocio 
//        List<Membresia> lista = new ArrayList();
//        lista = mData.membresiasPorSocio(1);
//        for (Membresia aux:lista) {
//            System.out.println(aux.toString());
//        }
//        
//Eliminar (poner estado 0) una Membresia
//        mData.eliminarMembresia(1);
//
//Modificarle algún dato a la Membresia
//        Membresia membr = mData.buscarMembresia(1);
//        if(membr!=null){
//            System.out.println(membr.toString());
//            membr.setCantPases(7);
//            mData.modificarMembresia(membr);
//        }
//
//
/////////////////////////////--PRUEBA DE ASISTENCIADATA--////////////////////////////////        
//        
//Agregar una Asistencia nueva
//        Socio socio = sData.buscarSocio(2);
//        Clase clase = cData.buscarClase(1);
//        Asistencia asistencia = new Asistencia(socio, clase, LocalDate.of(2024, 5, 3));
//        aData.guardarAsistencia(asistencia);
//
//Buscar Asistencia por ID
//        Asistencia asist = aData.buscarAsistencia(1);
//        if(asist!=null){
//            System.out.println(asist.toString());
//        }
//
//Listado de Socios en una clase, una fecha determinada  
//        List<Socio> lista = new ArrayList();
//        lista = aData.socioPorClases(1, LocalDate.of(2024,5,3));
//        for (Socio aux:lista) {
//            System.out.println(aux.toString());
//        }
//
//Listado de Asistencia segun socio
//        List<Asistencia> lista = new ArrayList();
//        lista = aData.asistenciaPorSocio(1);
//        for (Asistencia aux:lista) {
//            System.out.println(aux.toString());
//        }
//
//Modificarle algún dato a la Asistencia
//        Asistencia asist = aData.buscarAsistencia(7);
//        if(asist!=null){
//            System.out.println(asist.toString());
//            asist.setfAsistencia(LocalDate.of(2024,6,7));
//            aData.modificarAsistencia(asist);
//        }
//        
//Eliminar una Asistencia (borrado fisico)
//        aData.eliminarAsistencia(4);
//
    }
}
