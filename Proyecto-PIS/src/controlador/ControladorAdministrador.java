package controlador;

import controlador.dao.*;

import java.util.Date;

public class ControladorAdministrador {
    private final EleccionDao eleccionDao;
    private final LocalidadDao localidadDao;
    private final PadronElectoralDao padronElectoralDao;
    private final PersonaDao personaDao;
    private final VotanteDao votanteDao;
    private final CandidatoDao candidatoDao;
    private final PartidoPoliticoDao partidoPoliticoDao;
    private final PapeletaDao papeletaDao;

    public ControladorAdministrador(){
        this.personaDao = new PersonaDao();
        this.partidoPoliticoDao = new PartidoPoliticoDao();
        this.padronElectoralDao = new PadronElectoralDao();
        this.candidatoDao = new CandidatoDao();
        this.eleccionDao = new EleccionDao();
        this.papeletaDao = new PapeletaDao();
        this.localidadDao = new LocalidadDao();
        this.votanteDao = new VotanteDao();
    }

    //
    public void crearEleccion(String nombre, Date fecha, String periodo) throws Exception {

        eleccionDao.getEleccion().setNombre(nombre);
        eleccionDao.getEleccion().setFecha(fecha);
        eleccionDao.getEleccion().setPeriodo(periodo);

        eleccionDao.guardar(eleccionDao.getEleccion());

    }

    // implementar el resto de metodos y ya seria todo,
    // solo faltaria implementar las interfaces graficas y
    // la parte de las estadisticas de los votos, y de los votantes

    public void crearLocalidad(String nombre, int eleccion) throws Exception {

        localidadDao.getLocalidad().setNombre(nombre);
        localidadDao.getLocalidad().setIdEleccion(eleccion);

        localidadDao.guardar(localidadDao.getLocalidad());

    }

    public void crearPadronElectoral(String nombre, int localidad) throws Exception {

        padronElectoralDao.getPadronElectoral().setNombre(nombre);
        padronElectoralDao.getPadronElectoral().setIdLocalidad(localidad);

        padronElectoralDao.guardar(padronElectoralDao.getPadronElectoral());

    }

    public void registrarPartidoPolitico(String nombre, int numLista, String ideologia) throws Exception {

        partidoPoliticoDao.getPartidoPolitico().setNombre(nombre);
        partidoPoliticoDao.getPartidoPolitico().setNumeroLista(numLista);
        partidoPoliticoDao.getPartidoPolitico().setIdeologia(ideologia);

        partidoPoliticoDao.guardar(partidoPoliticoDao.getPartidoPolitico());

    }

    // llama a la funcion guardar() de personaDao
    // permite guardar todos los datos de una persona en el sistema
    public void registrarPersona(String dni, String pNombre, String sNombre, String pApellido, String sApellido, Date fechaNacimiento, String telefono, String email){

        personaDao.getPersona().setDni(dni);
        personaDao.getPersona().setPrimerNombre(pNombre);
        personaDao.getPersona().setSegundoNombre(sNombre);
        personaDao.getPersona().setPrimerApellido(pApellido);
        personaDao.getPersona().setSegundoApellido(sApellido);
        personaDao.getPersona().setFechaNacimiento(fechaNacimiento);
        personaDao.getPersona().setTelefono(telefono);
        personaDao.getPersona().setEmail(email);

        try {
            personaDao.guardar(personaDao.getPersona());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void registrarVotante(String dni, int padronElectoral) throws Exception {

        votanteDao.getVotante().setDniPersona(dni);
        votanteDao.getVotante().setIdPadronElectoral(padronElectoral);

        votanteDao.guardar(votanteDao.getVotante());

    }

    public void registrarCandidatos(String dni, int dignidad, int partidoPolitico) throws Exception {

        candidatoDao.getCandidato().setDniPersona(dni);
        candidatoDao.getCandidato().setIdDignidad(dignidad);
        candidatoDao.getCandidato().setIdPartidoPolitico(partidoPolitico);

        candidatoDao.guardar(candidatoDao.getCandidato());

    }

    public void generarPapeletas(int padronElectoral, int cantidad) throws Exception {

        for (int i = 0; i < cantidad; i++) {
            papeletaDao.getPapeleta().setIdPadronElectoral(padronElectoral);
            papeletaDao.guardar(papeletaDao.getPapeleta());
        }

    }
    
    
    public static void main(String[] args) throws Exception {
        ControladorAdministrador admin = new ControladorAdministrador();
        
        admin.personaDao.getPersona().setDni("1105156739");
        admin.personaDao.getPersona().setPrimerNombre("Miguel");
        admin.personaDao.getPersona().setSegundoNombre("Angel");
        admin.personaDao.getPersona().setPrimerApellido("Apolo");
        admin.personaDao.getPersona().setSegundoApellido("Cabrera");
        admin.personaDao.getPersona().setFechaNacimiento(new Date(2001 - 1900, 3, 20));
        
        admin.personaDao.guardar(admin.personaDao.getPersona());
        
    }
}
