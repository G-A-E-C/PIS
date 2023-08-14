package controlador;

import controlador.dao.DaoCandidato;
import controlador.dao.DaoDignidad;
import controlador.dao.DaoEleccion;
import controlador.dao.DaoLocalidad;
import controlador.dao.DaoPadronElectoral;
import controlador.dao.DaoPapeleta;
import controlador.dao.DaoPartidoPolitico;
import controlador.dao.DaoPersona;
import controlador.dao.DaoVotante;
import controlador.lista.ListaEnlazada;
import java.util.Date;
import modelo.Candidato;
import modelo.Eleccion;
import modelo.Localidad;
import modelo.PadronElectoral;
import modelo.PartidoPolitico;
import modelo.Votante;

public class ControladorAdministrador {

    private final DaoEleccion daoEleccion;
    private final DaoLocalidad daoLocalidad;
    private final DaoPadronElectoral daoPadron;
    private final DaoPartidoPolitico daoPartido;
    private final DaoPersona daoPersona;
    private final DaoCandidato daoCandidato;
    private final DaoVotante daoVotante;
    private DaoPapeleta daoPapeleta;

    public ControladorAdministrador() {
        daoEleccion = new DaoEleccion();
        daoLocalidad = new DaoLocalidad();
        daoPadron = new DaoPadronElectoral();
        daoPartido = new DaoPartidoPolitico();
        daoPersona = new DaoPersona();
        daoCandidato = new DaoCandidato();
        daoVotante = new DaoVotante();
        daoPapeleta = new DaoPapeleta();
    }

    // Elecciones
    public ListaEnlazada<Eleccion> buscarEleccion(String atributo, Object dato) {
        return daoEleccion.busqueda(atributo.toLowerCase(null), dato);
    }

    // Localidades
    public ListaEnlazada<Localidad> buscarLocalidad(String atributo, Object dato) {

        if (atributo.equals("Eleccion")) {
            return daoLocalidad.buscarLocalidadEleccion(daoEleccion.busqueda("nombre", dato));
        }

        return daoLocalidad.busqueda(atributo.toLowerCase(), dato);
    }

    // Padron Electoral
    public ListaEnlazada<PadronElectoral> buscarPadronElectoral(String atributo, Object dato) {

        if (atributo.equals("Localidad")) {
            return daoPadron.buscarPadronLocalidad(daoLocalidad.busqueda("nombre", dato));
        }

        return daoPadron.busqueda(atributo.toLowerCase(), dato);
    }

    public void crearPapeletas() {

        var padrones = daoPadron.listar().toArray();
        var votantes = daoVotante.listar().toArray();

        for (int i = 0; i < padrones.length; i++) {

            for (int j = 0; j < votantes.length; j++) {
                if (padrones[i].getId() == votantes[j].getIdPadronElectoral()) {
                    daoPapeleta.generarPapeleta(padrones[i].getId());
                }
            }
            
        }

    }

    // Partido Politico
    public ListaEnlazada<PartidoPolitico> buscarPartidoPolitico(String atributo, Object dato) {
        atributo = atributo.equals("Lista") ? "numeroLista" : atributo.toLowerCase();
        return daoPartido.busqueda(atributo, dato);
    }

    // votante
    public void registrarVotante(String dni, String pNombre, String sNombre, String pApellido, String sApellido,
            Date fechaNacimiento, int padronElectoral) {
        daoPersona.registrarPersona(dni, pNombre, sNombre, pApellido, sApellido, fechaNacimiento);
        daoVotante.registrarVotante(dni, padronElectoral);
    }

    public ListaEnlazada<Votante> buscarVoatante(String atributo, Object data) {
        if (atributo.equals("Estado")) {
            return daoVotante.busqueda("haVotado", data);
        }

        if (atributo.equals("Padron Electoral")) {
            return daoVotante.buscarVotantePadron(daoPadron.busqueda("nombre", data));
        }

        if (atributo.equals("Nombre")) {
            return daoVotante.buscarVotantePersona(daoPersona.buscarNombre((String) data));
        }

        return daoVotante.buscarVotantePersona(daoPersona.buscarApellido((String) data));
    }

    // Candidato
    public void registrarCandidato(String dni, int dignidad, int partidoPolitico) {
        daoCandidato.registrarCandidato(dni, dignidad, partidoPolitico);
    }

    public ListaEnlazada<Candidato> buscarCanditato(String atributo, Object data) {
        if (atributo.equals("Dignidad")) {
            return daoCandidato.buscarCandidatoDignidad(new DaoDignidad().busqueda("nombre", data));
        }

        if (atributo.equals("Partido Politico")) {
            return daoCandidato.buscarCandidatoPartido(daoPartido.busqueda("nombre", data));
        }

        if (atributo.equals("Nombre")) {
            return daoCandidato.buscarCandidatoPersona(daoPersona.buscarNombre((String) data));
        }

        return daoCandidato.buscarCandidatoPersona(daoPersona.buscarApellido((String) data));
    }

    //////////////////////////////////////////
    public ListaEnlazada<Votante> listarVotantes() {
        return daoVotante.listar();
    }

    public ListaEnlazada<Candidato> listarCandidatos() {
        return daoCandidato.listar();
    }

    public ListaEnlazada<Eleccion> listarElecciones() {
        return daoEleccion.listar();
    }

    public ListaEnlazada<Localidad> listarLocalidades() {
        return daoLocalidad.listar();
    }

    public ListaEnlazada<PadronElectoral> listarPadrones() {
        return daoPadron.listar();
    }

    public ListaEnlazada<PartidoPolitico> listarPartidos() {
        return daoPartido.listar();
    }

}
