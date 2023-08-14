package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import modelo.Cuenta;

public class DaoCuenta extends AdaptadorDao<Cuenta>{
    private Cuenta cuenta;
    
    public DaoCuenta(){
        super(Cuenta.class);
    }
    
    public Cuenta buscar(String atributo, Object data){
        crear();
        
        var aux = listar();
        
        try {
            
            aux.mergeSort(atributo, true);
            
            cuenta = aux.busquedaBinaria(atributo, data);
            
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return cuenta;
    }
    
    public boolean verificarCuenta(String dni, String clave) {

        var cuentas = listar();

        if(cuentas.isEmpty()) return false;

        try {
            
            cuentas.mergeSort("dniPersona", true);
            
            cuenta = cuentas.busquedaBinaria("dniPersona", dni);
            
            if(cuenta == null) return false;
        
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }

        return cuenta.getClave().equals(clave);

    }
    
    public void registrarCuenta(String dni, String clave){
        crear();
        
        cuenta.setDniPersona(dni);
        
        cuenta.setClave(clave);
        
        cuenta.setIdRol(1);
        
        try {
            guardar(cuenta);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void crear(){
        cuenta = new Cuenta();
    }
}
