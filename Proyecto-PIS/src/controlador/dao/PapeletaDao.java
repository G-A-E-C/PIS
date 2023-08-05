package controlador.dao;

import controlador.adap.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import modelo.Papeleta;

public class PapeletaDao extends AdaptadorDao<Papeleta> {
    private Papeleta papeleta;

    public PapeletaDao(){
        super(Papeleta.class);
    }

    public void presentarPapeleta(int padronElectoral) throws ListaVaciaExcepcion, IllegalAccessException, ListaPosicionExcepcion, ListaElementoNoExisteExcepcion {
        var papeletas = listar();

        papeletas.mergeSort("id_padron_electoral", true);

        var papeletasPadron = papeletas.busquedaLineal("id_padron_electoral", padronElectoral);

        papeleta = papeletasPadron.busquedaLineal("id_voto", 0).obtener(0);

    }
    public Papeleta getPapeleta() {
        if(papeleta == null) papeleta = new Papeleta();
        return papeleta;
    }

    public void setPapeleta(Papeleta papeleta) {
        this.papeleta = papeleta;
    }
}
