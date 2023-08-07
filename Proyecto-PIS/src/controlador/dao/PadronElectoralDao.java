package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.PadronElectoral;

public class PadronElectoralDao extends AdaptadorDao<PadronElectoral> {
    private PadronElectoral padronElectoral;

    public PadronElectoralDao(){
        super(PadronElectoral.class);
    }

    public PadronElectoral getPadronElectoral() {
        if(padronElectoral == null) padronElectoral = new PadronElectoral();
        return padronElectoral;
    }

    public void setPadronElectoral(PadronElectoral padronElectoral) {
        this.padronElectoral = padronElectoral;
    }
    
    public PadronElectoral buscarPadronElectoral(String atributo, Object dato){
        
        var padrones = listar();
        
        try {
            padrones.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        try {
            return padrones.busquedaBinaria(atributo, dato);
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return null;
    }
    
    public ListaEnlazada<PadronElectoral> ordenar(String atributo){
        
        var padrones = listar();
        
        try {
            padrones.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return padrones;
    }
}