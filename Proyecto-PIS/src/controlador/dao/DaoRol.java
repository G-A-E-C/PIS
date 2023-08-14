package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.lista.ListaEnlazada;
import modelo.Rol;

public class DaoRol extends AdaptadorDao<Rol>{
    private Rol rol;
    
    public DaoRol(){
        super(Rol.class);
    }
    
    public ListaEnlazada<Rol> buscar(){
        var resultado = new ListaEnlazada<Rol>();
        return resultado;
    }
    
    private void crear(){
        rol = new Rol();
    }
    
}
