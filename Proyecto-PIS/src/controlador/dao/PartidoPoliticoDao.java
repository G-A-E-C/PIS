package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.PartidoPolitico;

public class PartidoPoliticoDao extends AdaptadorDao<PartidoPolitico> {
  private PartidoPolitico partidoPolitico;

    public PartidoPoliticoDao(){
        super(PartidoPolitico.class);
    }

    public PartidoPolitico getPartidoPolitico() {
        if(partidoPolitico == null) partidoPolitico = new PartidoPolitico();
        return partidoPolitico;
    }

    public PartidoPolitico buscarPartidoPolitico(String atributo, Object dato){
        
        var partidos = listar();
        
        try {
            partidos.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        try {
            return partidos.busquedaBinaria(atributo, dato);
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return null;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }
    
    public ListaEnlazada<PartidoPolitico> ordenar(String atributo){
        
        var partidos = listar();
        
        try {
            partidos.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return partidos;
    }
}
