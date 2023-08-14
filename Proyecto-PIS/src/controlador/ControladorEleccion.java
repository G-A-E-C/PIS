package controlador;

import controlador.dao.DaoEleccion;
import java.util.Date;

public class ControladorEleccion {
    private DaoEleccion daoEleccion;
    
    public ControladorEleccion(){
        daoEleccion = new DaoEleccion();
        daoEleccion.cargarEleccion();
    }

    public DaoEleccion getDaoEleccion() {
        return daoEleccion;
    }
    
    public Date fechaEleccion(){
        return daoEleccion.getEleccion().getFecha();
    }
    
    public int inicial(){
        return daoEleccion.getEleccion().getHoraInicio();
    }
    
    public int fin(){
        return daoEleccion.getEleccion().getHoraFinal();
    }
}
