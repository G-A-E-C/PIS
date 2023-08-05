package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import modelo.Cuenta;

public class CuentaDao extends AdaptadorDao<Cuenta> {
    private Cuenta cuenta;

    public CuentaDao(){
        super(Cuenta.class);
    }

    public boolean verificarCuenta(String dni, String clave) throws ListaVaciaExcepcion, IllegalAccessException, ListaPosicionExcepcion, ListaElementoNoExisteExcepcion {

        var cuentas = listar();

        if(cuentas.isEmpty()) return false;

        cuentas.mergeSort("dniPersona", true);

        var cuenta = cuentas.busquedaBinaria("dniPersona", dni);

        if(cuenta == null) return false;

        return cuenta.getClave().equals(clave);

    }

    public boolean existeCuenta(String dni) throws ListaPosicionExcepcion, ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion {

        var cuentas = listar();

        if(cuentas.isEmpty()) return false;

        cuentas.mergeSort("dni", true);

        var cuenta = cuentas.busquedaBinaria("dni", dni);

        return cuenta != null;
    }

    public Cuenta getCuenta() {
        if(cuenta == null) cuenta = new Cuenta();
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
