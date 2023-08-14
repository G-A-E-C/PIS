package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import modelo.Persona;

public class PersonaDao extends AdaptadorDao<Persona> {
    private Persona persona;

    public PersonaDao(){
        super(Persona.class);
    }

    public boolean registrarDatosAdicionales() throws Exception{
        
        actualizar(persona, "dni");
        
        return true;
    }
    
    public void cargarPersona(String dni, String telefono, String email){
        persona = new Persona();
        persona.setDni(dni);
        persona.setEmail(email);
        persona.setTelefono(telefono);
    }
    
    public boolean verificarPersona(String dni) throws ListaVaciaExcepcion, IllegalAccessException, ListaPosicionExcepcion, ListaElementoNoExisteExcepcion {

        var personas = listar();

        personas.mergeSort("dni", true);

        return personas.busquedaBinaria("dni", dni) != null;

    }

    public Persona personasCandidatas(String dni) throws ListaVaciaExcepcion, IllegalAccessException, ListaPosicionExcepcion, ListaElementoNoExisteExcepcion {

        var personas = listar();

        personas.mergeSort("dni", true);

        return personas.busquedaBinaria("dni", dni);
    }

    public Persona getPersona() {
        if(persona == null) persona = new Persona();
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
