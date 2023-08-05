package controlador.adap;

import controlador.lista.ListaEnlazada;

public interface InterfazDao<T> {

    public int guardar(T obj) throws Exception;

    public void actualizar(T obj, String id) throws Exception;

    public ListaEnlazada<T> listar();
    public T obtener(Object value, String id);

}
