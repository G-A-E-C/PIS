package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
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
    
    public Persona buscarPersona(String atributo, Object dato){
        
        var personas = listar();
        
        try {
            personas.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        try {
            return personas.busquedaBinaria(atributo, dato);
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return null;
    }
    
    public ListaEnlazada<Persona> ordenar(String atributo){
        
        var personas = listar();
        
        try {
            personas.mergeSort(atributo, true);
        } catch (ListaVaciaExcepcion | IllegalAccessException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        return personas;
    }

    public Persona getPersona() {
        if(persona == null) persona = new Persona();
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
