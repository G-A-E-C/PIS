package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.Dignidad;

public class DaoDignidad extends AdaptadorDao<Dignidad>{
    private Dignidad dignidad;
    
    public DaoDignidad(){
        super(Dignidad.class);
    }

    public Dignidad buscar(String atributo, Object dato){
        
        var aux = listar();
        
        try {
            aux.mergeSort(atributo, true);
            
            dignidad = aux.busquedaBinaria(atributo, dato);
            
            return dignidad;
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        crear();
        
        return dignidad;
    }

    public ListaEnlazada<Dignidad> busqueda(String atributo, Object data){
        var resultado = new ListaEnlazada<Dignidad>();

        var aux = listar();

        try {
            resultado = aux.busqueda(atributo, data);
        } catch (IllegalAccessException | ListaVaciaExcepcion | ListaPosicionExcepcion e) {
            System.out.println(e.getMessage());
        }

        return resultado;
    }
    
    private void crear(){
        dignidad = new Dignidad();
    }
    
}
