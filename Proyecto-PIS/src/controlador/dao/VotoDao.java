package controlador.dao;

import controlador.adap.AdaptadorDao;
import modelo.Voto;

public class VotoDao extends AdaptadorDao<Voto> {
    private Voto voto;

    public VotoDao(){
        super(Voto.class);
    }

    public Voto getVoto() {
        if(voto == null) voto = new Voto();
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }
}
