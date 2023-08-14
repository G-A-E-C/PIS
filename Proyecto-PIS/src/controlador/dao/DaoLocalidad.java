package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.Eleccion;
import modelo.Localidad;

public class DaoLocalidad extends AdaptadorDao<Localidad> {

    private Localidad localidad;

    public DaoLocalidad() {
        super(Localidad.class);
    }

    public Localidad buscar(String atributo, Object dato) {

        var aux = listar();

        try {
            aux.mergeSort(atributo, true);

            localidad = aux.busquedaBinaria(atributo, dato);

            return localidad;
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion
                | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }

        crear();

        return localidad;
    }

    public ListaEnlazada<Localidad> busqueda(String atributo, Object dato) {
        var resultado = new ListaEnlazada<Localidad>();

        var aux = listar();

        try {
            resultado = aux.busqueda(atributo, dato);
        } catch (ListaVaciaExcepcion | ListaPosicionExcepcion | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }

        return resultado;
    }

    public ListaEnlazada<Localidad> buscarLocalidadEleccion(ListaEnlazada<Eleccion> elecciones) {
        var resultado = new ListaEnlazada<Localidad>();

        var arrEleccion = elecciones.toArray();

        var votantes = listar();

        try {
            votantes.mergeSort("idEleccion", true);

            for (int i = 0; i < arrEleccion.length; i++) {
                var v = votantes.busquedaLineal("idEleccion", arrEleccion[i].getId());

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

    public void crearLocalidad(String nombre, int eleccion) {
        crear();

        localidad.setNombre(nombre);

        localidad.setIdEleccion(eleccion);

        try {
            guardar(localidad);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void crear() {
        localidad = new Localidad();
    }

}
