package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.PartidoPolitico;

public class DaoPartidoPolitico extends AdaptadorDao<PartidoPolitico>{
    private PartidoPolitico partidoPolitico;
    
    public DaoPartidoPolitico(){
        super(PartidoPolitico.class);
    }
    
    public PartidoPolitico buscar(String atributo, Object dato){
        
        var aux = listar();
        
        try {
            aux.mergeSort(atributo, true);
            
            partidoPolitico = aux.busquedaBinaria(atributo, dato);
            
            return partidoPolitico;
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        crear();
        
        return partidoPolitico;
    }
    
    public ListaEnlazada<PartidoPolitico> busqueda(String atributo, Object dato){
        var resultado = new ListaEnlazada<PartidoPolitico>();
        
        var aux = listar();
        
        try {
            resultado = aux.busqueda(atributo, dato);
        } catch (ListaVaciaExcepcion | ListaPosicionExcepcion | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    
    public void registrarPartidoPolitico(String nombre, int numLista, String ideologia){
        crear();
        
        partidoPolitico.setNombre(nombre);
        
        partidoPolitico.setNumeroLista(numLista);
        
        partidoPolitico.setIdeologia(ideologia);
        
        try {
            guardar(partidoPolitico);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void crear(){
        partidoPolitico = new PartidoPolitico();
    }

    public PartidoPolitico getPartidoPolitico() {
        if(partidoPolitico == null) partidoPolitico = new PartidoPolitico();
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }
    
}
