package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.lista.ListaEnlazada;
import modelo.Voto;

public class DaoVoto extends AdaptadorDao<Voto>{
    private Voto voto;
    
    public DaoVoto(){
        super(Voto.class);
    }
    
    public ListaEnlazada<Voto> buscar(){
        var resultado = new ListaEnlazada<Voto>();
        return resultado;
    }
    
    public int guardarVoto(){
        crear();
        
        try {
            var id = guardar(voto);
            
            return id;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return -1;
    }
    
    private void crear(){
        voto = new Voto();
    }
}
