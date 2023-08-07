package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.Localidad;

public class LocalidadDao extends AdaptadorDao<Localidad> {
    private Localidad localidad;

    public LocalidadDao(){
        super(Localidad.class);
    }

    public Localidad getLocalidad() {
        if(localidad == null) localidad = new Localidad();
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    public Localidad buscarLocalidad(String atributo, Object dato){
        
        var localidades = listar();
        
        try {
            localidades.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        try {
            return localidades.busquedaBinaria(atributo, dato);
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return null;
    }
    
    public ListaEnlazada<Localidad> ordenar(String atributo){
        
        var localidades = listar();
        
        try {
            localidades.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return localidades;
    }
}
