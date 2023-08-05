package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
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

    public Votante getVotante() {
        if(votante == null) votante = new Votante();
        return votante;
    }

    public void setVotante(Votante votante) {
        this.votante = votante;
    }
}
