package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import java.util.Date;
import modelo.Eleccion;

public class DaoEleccion extends AdaptadorDao<Eleccion>{
    private Eleccion eleccion;
    
    public DaoEleccion(){
        super(Eleccion.class);
    }
    
    public void cargarEleccion(){
        eleccion = listar().toArray()[0];
    }

    public Eleccion buscar(String atributo, Object dato){
        var aux = listar();
        
        try {
            aux.mergeSort(atributo, true);
            
            eleccion = aux.busquedaBinaria(atributo, dato);
            
            return eleccion;
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        crear();
        
        return eleccion;
    }
    
    public ListaEnlazada<Eleccion> busqueda(String atributo, Object dato){
        var resultado = new ListaEnlazada<Eleccion>();
        
        var aux = listar();
        
        try {
            resultado = aux.busqueda(atributo, dato);
        } catch (ListaVaciaExcepcion | ListaPosicionExcepcion | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    public void crearEleccion(String nombre, Date fechaInicio, Date fechaFinal, String periodo){
        crear();
        
        eleccion.setNombre(nombre);
        eleccion.setPeriodo(periodo);
        eleccion.setFechaInicio(fechaInicio);
        eleccion.setFechaFinal(fechaFinal);
        
        try {
            guardar(eleccion);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void crear(){
        this.eleccion = new Eleccion();
    }

    public Eleccion getEleccion() {
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }
    
}
