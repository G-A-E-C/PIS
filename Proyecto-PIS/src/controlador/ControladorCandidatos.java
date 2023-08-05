package controlador;

import controlador.dao.CandidatoDao;
import controlador.dao.PartidoPoliticoDao;
import controlador.dao.PersonaDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import modelo.Dignidad;
import modelo.PartidoPolitico;
import modelo.Persona;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class ControladorCandidatos {
    private final CandidatoDao candidatoDao;
    private final PersonaDao personaDao;
    private final PartidoPoliticoDao partidoPoliticoDao;
    public ControladorCandidatos(){
        this.candidatoDao = new CandidatoDao();
        this.personaDao = new PersonaDao();
        this.partidoPoliticoDao = new PartidoPoliticoDao();
    }

    public void presentarCandidatos() throws ListaPosicionExcepcion, ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion {

        var listaCandidatos = candidatoDao.listar();

        for(int i = 0 ; i < listaCandidatos.size() ; i++){

            Persona persona = personaDao.personasCandidatas(listaCandidatos.obtener(i).getDniPersona());

            PartidoPolitico partido = partidoPoliticoDao.buscarPartido(listaCandidatos.obtener(i).getIdPartidoPolitico());

            String dignidad = verificarDignidad(listaCandidatos.obtener(i).getIdDignidad());

            System.out.println(dignidad);
            System.out.println("Nombre: "+ persona.getPrimerNombre() +" "+ persona.getPrimerApellido());
            System.out.println("Edad: "+ edad(persona.getFechaNacimiento(), new Date()));
            System.out.println("Partido Politico: "+ partido.getNombre() +" "+ partido.getNumeroLista());

        }

    }

    private String verificarDignidad(int id){

        for(var dig : Dignidad.values()){
            if(dig.id == id) return dig.name();
        }

        return null;
    }

    private int edad(Date fechaNacimiento, Date fechaActual){

        LocalDate fechaNacimientoLocal = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActualLocal = fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return Period.between(fechaNacimientoLocal, fechaActualLocal).getYears();
    }

}
