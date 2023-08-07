package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.Eleccion;

public class EleccionDao extends AdaptadorDao<Eleccion> {
    private Eleccion eleccion;

    public EleccionDao(){
        super(Eleccion.class);
    }

    public Eleccion getEleccion() {
        if(eleccion == null) eleccion = new Eleccion();
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }
    
    public Eleccion buscarEleccion(String atributo, Object dato){
        
        var elecciones = listar();
        
        try {
            elecciones.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        try {
            return elecciones.busquedaBinaria(atributo, dato);
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return null;
    }
    
    public ListaEnlazada<Eleccion> ordenar(String atributo){
        
        var elecciones = listar();
        
        try {
            elecciones.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return elecciones;
    }
}
