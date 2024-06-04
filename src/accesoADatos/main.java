package accesoADatos;

import entidades.Clase;
import entidades.Entrenador;
import entidades.Socio;
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
////Agregar un Socio Nuevo    
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
////Agregar una Clase Nueva
//        Entrenador entrenador = eData.buscarEntrenador(3);
//        Clase clase = new Clase("Zumba", entrenador, LocalTime.of(17, 0), 12, true);
//        cData.guardarClase(clase);
//
////Buscar entrenador por ID 
//        Clase clase = cData.buscarClase(14);
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
    }
}
