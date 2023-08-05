package controlador.dao;

import controlador.adap.AdaptadorDao;
import modelo.Eleccion;

public class EleccionDao extends AdaptadorDao<Eleccion> {
    private Eleccion eleccion;

    public EleccionDao(){
        super(Eleccion.class);
    }

    public Eleccion getEleccion() {
        if(eleccion == null) eleccion = new Eleccion();
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }
}
