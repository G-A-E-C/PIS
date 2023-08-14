package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.Localidad;
import modelo.PadronElectoral;

public class DaoPadronElectoral extends AdaptadorDao<PadronElectoral> {
    private PadronElectoral padronElectoral;

    public DaoPadronElectoral() {
        super(PadronElectoral.class);
    }

    public PadronElectoral buscar(String atributo, Object info) {
        
        var padrones = listar();
        
        try {
            padrones.mergeSort(atributo, true);
            
            padronElectoral = padrones.busquedaBinaria(atributo, info);
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        return padronElectoral;
    }

    public ListaEnlazada<PadronElectoral> busqueda(String atributo, Object dato) {
        var resultado = new ListaEnlazada<PadronElectoral>();

        var aux = listar();

        try {
            resultado = aux.busqueda(atributo, dato);
        } catch (ListaVaciaExcepcion | ListaPosicionExcepcion | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }

        return resultado;
    }

    public ListaEnlazada<PadronElectoral> buscarPadronLocalidad(ListaEnlazada<Localidad> localidades) {
        var resultado = new ListaEnlazada<PadronElectoral>();

        var arrLocalidades = localidades.toArray();

        var padrones = listar();

        try {
            padrones.mergeSort("idLocalidad", true);

            for (int i = 0; i < arrLocalidades.length; i++) {
                var v = padrones.busquedaBinaria("idLocalidad", arrLocalidades[i].getId());

                if (v != null)
                    resultado.insertar(v);
            }

        } catch (IllegalAccessException | ListaVaciaExcepcion | ListaElementoNoExisteExcepcion
                | ListaPosicionExcepcion e) {
            System.out.println(e.getMessage());
        }

        return resultado;
    }

    public void crearPadronElectoral(String nombre, int localidad) {
        crear();

        padronElectoral.setNombre(nombre);

        padronElectoral.setIdLocalidad(localidad);

        try {
            guardar(padronElectoral);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void crear() {
        padronElectoral = new PadronElectoral();
    }

}
