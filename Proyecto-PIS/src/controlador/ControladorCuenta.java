package controlador;

import controlador.dao.CuentaDao;
import controlador.dao.PersonaDao;
import controlador.dao.VotanteDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;

public class ControladorCuenta {
    private PersonaDao personaDao;
    private VotanteDao votanteDao;
    private CuentaDao cuentaDao;

    public ControladorCuenta(){
        this.personaDao = new PersonaDao();
        this.cuentaDao = new CuentaDao();
        this.votanteDao = new VotanteDao();
    }

    // llama a la funcion verificarPersona() de personaDao
    // verifica el dni le pertence a una persona en el sistema
    // en el caso de que exista la persona, se le permitira registrar
    public boolean registrar(String dni, String clave, String telefono, String email) throws Exception {

        cuentaDao.getCuenta().setDniPersona(dni);
        
        cuentaDao.getCuenta().setClave(clave);
        
        cuentaDao.getCuenta().setIdRol(1);

        cuentaDao.guardar(cuentaDao.getCuenta());
        
        System.out.println("Update");
        
        personaDao.cargarPersona(dni, telefono, email);
        
        personaDao.registrarDatosAdicionales();
        
        return true;
    }
    
    public boolean esApto(String dni) throws ListaVaciaExcepcion, IllegalAccessException, ListaPosicionExcepcion, ListaElementoNoExisteExcepcion{
        return personaDao.verificarPersona(dni);
    }

    public boolean existeCuenta(String dni) throws ListaPosicionExcepcion, ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion{
        return cuentaDao.existeCuenta(dni);
    }
    
    // llama a la funcion verificarCuenta() de cuentaDao
    // para verificar si los datos pertenecen a una cuenta
    public boolean login(String dni, String clave) throws ListaPosicionExcepcion, ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion {
        return cuentaDao.verificarCuenta(dni, clave);
    }

    public void cargarVotante(String dni) throws ListaPosicionExcepcion, ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion {
        votanteDao.buscarVotante(dni);
    }

    public void actualizarDatosVotante(char haVotado) throws Exception {
        votanteDao.getVotante().setHaVotado(haVotado);
        votanteDao.actualizar(votanteDao.getVotante(), "dni");
    }

    public int votantePadronElectoral(){
        return votanteDao.getVotante().getIdPadronElectoral();
    }

}
