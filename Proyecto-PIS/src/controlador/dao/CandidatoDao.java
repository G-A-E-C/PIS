package controlador.dao;

import controlador.adap.AdaptadorDao;
import modelo.Candidato;

public class CandidatoDao extends AdaptadorDao<Candidato> {
    private Candidato candidato;

    public CandidatoDao(){
        super(Candidato.class);
    }

    public Candidato getCandidato() {
        if(candidato == null) candidato = new Candidato();
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
}
