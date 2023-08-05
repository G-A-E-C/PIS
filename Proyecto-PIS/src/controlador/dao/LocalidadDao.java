package controlador.dao;

import controlador.adap.AdaptadorDao;
import modelo.Localidad;

public class LocalidadDao extends AdaptadorDao<Localidad> {
    private Localidad localidad;

    public LocalidadDao(){
        super(Localidad.class);
    }

    public Localidad getLocalidad() {
        if(localidad == null) localidad = new Localidad();
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
