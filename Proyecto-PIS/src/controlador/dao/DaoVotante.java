package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.PadronElectoral;
import modelo.Persona;
import modelo.Votante;

public class DaoVotante extends AdaptadorDao<Votante> {

    private Votante votante;

    public DaoVotante() {
        super(Votante.class);
    }

    public Votante buscar(String atributo, Object dato){
        var aux = listar();
        
        try {
            aux.mergeSort(atributo, true);
            
            votante = aux.busquedaBinaria(atributo, dato);
            
            return votante;
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        crear();
        
        return votante;
    }
    
    // metodo para buscar a un votante con los atributos propios del votante
    // como dniPersona, haVotado, padron Electoral
    public ListaEnlazada<Votante> busqueda(String atributo, Object dato) {
        var resultado = new ListaEnlazada<Votante>();

        var votantes = listar();

        try {
            resultado = votantes.busqueda(atributo, dato);
        } catch (IllegalAccessException | ListaVaciaExcepcion | ListaPosicionExcepcion e) {
            System.out.println(e.getMessage());
        }

        return resultado;
    }

    // metodo para bucar a un vatante que no tiene los atributos de la persona
    // en este caso solo se hara busquedas de Nombre, Apellido
    public ListaEnlazada<Votante> buscarVotantePersona(ListaEnlazada<Persona> personas) {
        var resultado = new ListaEnlazada<Votante>();

        var arrPersonas = personas.toArray();

        var votantes = listar();

        try {
            votantes.mergeSort("dniPersona", true);

            for (int i = 0; i < arrPersonas.length; i++) {
                var v = votantes.busquedaBinaria("dniPersona", arrPersonas[i].getDni());

                if (v != null)
                    resultado.insertar(v);
            }

        } catch (IllegalAccessException | ListaVaciaExcepcion | ListaElementoNoExisteExcepcion
                | ListaPosicionExcepcion e) {
            System.out.println(e.getMessage());
        }

        return resultado;
    }

    // metodo para bucar a un votante repescto al padron Electoral
    // en este caso solo se hara busqueda del nombre
    public ListaEnlazada<Votante> buscarVotantePadron(ListaEnlazada<PadronElectoral> padron) {
        var resultado = new ListaEnlazada<Votante>();

        var arrPadron = padron.toArray();

        var votantes = listar();

        try {
            votantes.mergeSort("idPadronElectoral", true);

            for (int i = 0; i < arrPadron.length; i++) {
                var v = votantes.busquedaLineal("idPadronElectoral", arrPadron[i].getId());

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

    public void registrarVotante(String dni, int padronElectoral) {
        crear();

        votante.setDniPersona(dni);

        votante.setIdPadronElectoral(padronElectoral);

        try {
            guardar(votante);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void crear() {
        votante = new Votante();
    }

    public Votante getVotante() {
        return votante;
    }

    public void setVotante(Votante votante) {
        this.votante = votante;
    }

    
}
