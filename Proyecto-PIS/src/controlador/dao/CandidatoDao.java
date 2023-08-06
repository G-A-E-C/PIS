package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.Candidato;

public class CandidatoDao extends AdaptadorDao<Candidato> {

    private Candidato candidato;

    public CandidatoDao() {
        super(Candidato.class);
    }

    public Candidato getCandidato() {
        if (candidato == null) {
            candidato = new Candidato();
        }
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Candidato buscarCandidato(String atributo, Object dato) throws ListaElementoNoExisteExcepcion, ListaPosicionExcepcion {

        var candidatos = listar();

        try {
            candidatos.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        try {
            return candidatos.busquedaBinaria(atributo, dato);
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return null;
    }

    public ListaEnlazada<Candidato> ordenar(String atributo) {

        var candidatos = listar();

        try {
            candidatos.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return candidatos;
    }
}
