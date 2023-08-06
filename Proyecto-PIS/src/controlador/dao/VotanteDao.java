package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.Votante;

public class VotanteDao extends AdaptadorDao<Votante> {
    private Votante votante;

    public VotanteDao(){
        super(Votante.class);
    }

    public void buscarVotante(String dni) throws ListaPosicionExcepcion, ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion {

        var votantes = listar();

        votantes.mergeSort("dni", true);

        votante = votantes.busquedaBinaria("dni", dni);
    }
    
    public Votante buscarVotante(String atributo, Object dato){
        
        var votantes = listar();
        
        try {
            votantes.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        try {
            return votantes.busquedaBinaria(atributo, dato);
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return null;
    }
    
    public ListaEnlazada<Votante> ordenar(String atributo){
        
        var votantes = listar();
        
        try {
            votantes.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return votantes;
    }

    public Votante getVotante() {
        if(votante == null) votante = new Votante();
        return votante;
    }

    public void setVotante(Votante votante) {
        this.votante = votante;
    }
}
