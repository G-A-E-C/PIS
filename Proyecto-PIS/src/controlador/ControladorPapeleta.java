package controlador;

import controlador.dao.PapeletaDao;
import controlador.dao.SufragioDao;
import controlador.dao.VotoDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;

public class ControladorPapeleta {
    private PapeletaDao papeletaDao;
    private VotoDao votoDao;
    private SufragioDao sufragioDao;

    public ControladorPapeleta() {
        papeletaDao = new PapeletaDao();
        votoDao = new VotoDao();
        sufragioDao = new SufragioDao();
    }


    // va ha presentar una papeleta vacia al usuario
    public void presentarPapeleta(int padronElectoral) throws ListaPosicionExcepcion, ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion {
        papeletaDao.presentarPapeleta(padronElectoral);
    }

    // modificara la papeleta con el voto del usuario
    // solo se setea el id del de la papeleta que hace referencia al voto
    public void llenarPapeleta(int idVoto) throws Exception {
        papeletaDao.getPapeleta().setIdVoto(idVoto);
        papeletaDao.actualizar(papeletaDao.getPapeleta(), "id");
    }

    // guarda todas las elecciones que realiza el usuario
    // tambien devuelve el id del voto
    public int votar(ListaEnlazada<String> candidatos) throws Exception {

        int idVoto = votoDao.listar().size() + 1;

        for (int i = 0; i < candidatos.size(); i++) {
            sufragioDao.getSufragio().setIdVoto(idVoto);
            sufragioDao.getSufragio().setDniCandidato(candidatos.obtener(i));
            sufragioDao.guardar(sufragioDao.getSufragio());
        }

        votoDao.getVoto().setId(idVoto);

        votoDao.guardar(votoDao.getVoto());

        return idVoto;
    }
}
