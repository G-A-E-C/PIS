package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import modelo.PartidoPolitico;

public class PartidoPoliticoDao extends AdaptadorDao<PartidoPolitico> {
    private PartidoPolitico partidoPolitico;

    public PartidoPoliticoDao(){
        super(PartidoPolitico.class);
    }

    public PartidoPolitico getPartidoPolitico() {
        if(partidoPolitico == null) partidoPolitico = new PartidoPolitico();
        return partidoPolitico;
    }

    public PartidoPolitico buscarPartido(int id) throws ListaPosicionExcepcion, ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion {

        var listaPartido = listar();

        listaPartido.mergeSort("id", true);

        return listaPartido.busquedaBinaria("id", id);
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }
}
