package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import java.util.Date;
import modelo.Persona;

public class DaoPersona extends AdaptadorDao<Persona>{
    private Persona persona;
    
    public DaoPersona(){
        super(Persona.class);
    }
    
    public void registroCompleto(String dni, String telefono, String emial){
        crear();
        
        persona.setDni(dni);
        
        persona.setEmail(emial);
        
        persona.setTelefono(telefono);
        
        try {
            actualizar(persona, "dni");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Persona buscar(String atributo, Object dato){
        
        var aux = listar();
        
        try {
            aux.mergeSort(atributo, true);
            
            persona = aux.busquedaBinaria(atributo, dato);
            
            return persona;
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        crear();
        
        return persona;
    }

    public ListaEnlazada<Persona> buscarNombre(String nombre){
        var resultado = new ListaEnlazada<Persona>();

        var personas = listar().toArray();

        for(int i = 0; i < personas.length ; i ++){
            var nombres = personas[i].getPrimerNombre() + personas[i].getSegundoNombre();
            if(nombres.startsWith(nombre)) resultado.insertar(personas[i]);
        }

        return resultado;
    }
    
    
    public ListaEnlazada<Persona> buscarApellido(String apellido){
        var resultado = new ListaEnlazada<Persona>();

        var personas = listar().toArray();

        for(int i = 0; i < personas.length ; i ++){
            var apellidos = personas[i].getPrimerApellido() + personas[i].getSegundoApellido();
            if(apellidos.startsWith(apellido)) resultado.insertar(personas[i]);
        }

        return resultado;
    }

    public void registrarPersona(String dni, String pNombre, String sNombre, String pApellido, String sApellido, Date fechaNacimiento){
        crear();
        
        persona.setDni(dni);
        
        persona.setPrimerNombre(pNombre);
        
        persona.setSegundoNombre(sNombre);
        
        persona.setPrimerApellido(pApellido);
        
        persona.setSegundoApellido(sApellido);
        
        persona.setFechaNacimiento(fechaNacimiento);
        
        try {
            guardar(persona);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void crear(){
        persona = new Persona();
    }

    public Persona getPersona() {
        if(persona == null) persona = new Persona();
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
}
