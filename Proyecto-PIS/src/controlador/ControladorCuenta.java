package controlador;

import controlador.dao.DaoCuenta;
import controlador.dao.DaoPersona;
import controlador.dao.DaoVotante;

public class ControladorCuenta {

    private DaoPersona personaDao;
    private DaoVotante votanteDao;
    private DaoCuenta cuentaDao;

    public ControladorCuenta() {
        this.personaDao = new DaoPersona();
        this.cuentaDao = new DaoCuenta();
        this.votanteDao = new DaoVotante();
    }

    // llama a la funcion verificarPersona() de personaDao
    // verifica el dni le pertence a una persona en el sistema
    // en el caso de que exista la persona, se le permitira registrar
    public boolean registrar(String dni, String clave, String telefono, String email) {

        cuentaDao.registrarCuenta(dni, clave);

        System.out.println("Update");

        personaDao.registroCompleto(dni, telefono, email);

        return true;
    }

    public boolean esApto(String dni) {
        return personaDao.buscar("dni", dni).getDni() != null;
    }

    public boolean existeCuenta(String dni) {
        return cuentaDao.buscar("dniPersona", dni).getDniPersona() != null;
    }

    // llama a la funcion verificarCuenta() de cuentaDao
    // para verificar si los datos pertenecen a una cuenta
    public boolean login(String dni, String clave) {
        return cuentaDao.verificarCuenta(dni, clave);
    }
    
    public int rol(String dni){
        return cuentaDao.buscar("dniPersona", dni).getIdRol();
    }

    public void cargarVotante(String dni) {
        votanteDao.setVotante(votanteDao.buscar("dniPersona", dni));
    }

    public void actualizarDatosVotante(String haVotado){
        votanteDao.getVotante().setHaVotado(haVotado);
        
        System.out.println("dni -> "+ votanteDao.getVotante().getDniPersona());
        System.out.println("estado -> "+ votanteDao.getVotante().getHaVotado());
        System.out.println("votante -> "+ votanteDao.getVotante());
        try {
            votanteDao.actualizar(votanteDao.getVotante(), "dniPersona");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int votantePadronElectoral() {
        return votanteDao.getVotante().getIdPadronElectoral();
    }

    public boolean estadoVotante(){
        return votanteDao.getVotante().getHaVotado().equals("s");
    }
}
