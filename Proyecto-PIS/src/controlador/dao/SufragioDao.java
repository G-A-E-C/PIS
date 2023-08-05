package controlador.dao;

import controlador.adap.AdaptadorDao;
import modelo.VotoCandidato;

public class SufragioDao extends AdaptadorDao<VotoCandidato> {
    private VotoCandidato sufragio;

    public SufragioDao(){
        super(VotoCandidato.class);
    }

    public VotoCandidato getSufragio() {
        if(sufragio == null) sufragio = new VotoCandidato();
        return sufragio;
    }

    public void setSufragio(VotoCandidato sufragio) {
        this.sufragio = sufragio;
    }
}
