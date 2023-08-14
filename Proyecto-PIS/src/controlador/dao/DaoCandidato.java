package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.Candidato;
import modelo.Dignidad;
import modelo.PartidoPolitico;
import modelo.Persona;

public class DaoCandidato extends AdaptadorDao<Candidato> {
    private Candidato candidato;

    public DaoCandidato() {
        super(Candidato.class);
    }
    
    public void cargarCandidato(String atributo, Object dato){
        
        var candidatos = listar();
        
        try {
            candidatos.mergeSort(atributo, true);
            
            candidato = candidatos.busquedaBinaria(atributo, dato);
            
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ListaEnlazada<Candidato> buscar(String atributo, Object dato) {
        var resultado = new ListaEnlazada<Candidato>();
        
        var candidatos = listar();
        
        try {
            candidatos.mergeSort(atributo, true);
            
            resultado = candidatos.busqueda(atributo, dato);
            
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }

    public ListaEnlazada<Candidato> buscarCandidatoPartido(ListaEnlazada<PartidoPolitico> partidos) {
        var resultado = new ListaEnlazada<Candidato>();

        var arrPartidos = partidos.toArray();

        var candidatos = listar();

        try {
            candidatos.mergeSort("idPartidoPolitico", true);

            for (int i = 0; i < arrPartidos.length; i++) {
                var v = candidatos.busquedaLineal("idPartidoPolitico", arrPartidos[i].getId());

                if (v != null) {
                    for (int j = 0; j < v.size(); j++) {
                        resultado.insertar(v.obtener(i));
                    }
                }
            }

        } catch (IllegalAccessException | ListaVaciaExcepcion | ListaElementoNoExisteExcepcion
                | ListaPosicionExcepcion e) {
            System.out.println(e.getMessage());
        }

        return resultado;
    }

    public ListaEnlazada<Candidato> buscarCandidatoDignidad(ListaEnlazada<Dignidad> dignidades) {
        var resultado = new ListaEnlazada<Candidato>();

        var arrDignidades = dignidades.toArray();

        var candidatos = listar();

        try {
            candidatos.mergeSort("idDignidad", true);

            for (int i = 0; i < arrDignidades.length; i++) {
                var v = candidatos.busquedaLineal("idDignidad", arrDignidades[i].getId());

                if (v != null) {
                    for (int j = 0; j < v.size(); j++) {
                        resultado.insertar(v.obtener(i));
                    }
                }
            }

        } catch (IllegalAccessException | ListaVaciaExcepcion | ListaElementoNoExisteExcepcion
                | ListaPosicionExcepcion e) {
            System.out.println(e.getMessage());
        }

        return resultado;
    }

    // atributos de la persona
    public ListaEnlazada<Candidato> buscarCandidatoPersona(ListaEnlazada<Persona> personas) {
        var result = new ListaEnlazada<Candidato>();

        var arrPersonas = personas.toArray();

        var candidatos = listar();

        try {
            candidatos.mergeSort("dniPersona", true);

            for (int i = 0; i < arrPersonas.length; i++) {
                var v = candidatos.busquedaBinaria("dniPersona", arrPersonas[i].getDni());

                if (v != null)
                    result.insertar(v);
            }

        } catch (IllegalAccessException | ListaVaciaExcepcion | ListaElementoNoExisteExcepcion
                | ListaPosicionExcepcion e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public void registrarCandidato(String dni, int dignidad, int partidoPolitico) {
        crear();

        candidato.setDniPersona(dni);

        candidato.setIdDignidad(dignidad);

        candidato.setIdPartidoPolitico(partidoPolitico);

        try {
            guardar(candidato);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void crear() {
        candidato = new Candidato();
    }

    public Candidato getCandidato() {
        if(candidato == null) candidato = new Candidato();
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

}
