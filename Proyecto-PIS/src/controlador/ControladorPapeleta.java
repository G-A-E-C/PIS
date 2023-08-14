package controlador;

import controlador.dao.DaoCandidato;
import controlador.dao.DaoDignidad;
import controlador.dao.DaoPapeleta;
import controlador.dao.DaoPartidoPolitico;
import controlador.dao.DaoPersona;
import controlador.dao.DaoSufragio;
import controlador.dao.DaoVoto;
import controlador.lista.ListaEnlazada;
import modelo.Candidato;

public class ControladorPapeleta {

    private DaoPersona daoPersona;
    private DaoCandidato daoCandidato;
    private DaoPartidoPolitico daoPartido;
    private DaoPapeleta papeletaDao;
    

    public ControladorPapeleta() {
        daoPersona = new DaoPersona();
        daoCandidato = new DaoCandidato();
        daoPartido = new DaoPartidoPolitico();
        papeletaDao = new DaoPapeleta();
    }
    
    public void presentarPapeleta(int padronElectoral){
        papeletaDao.presentarPapeleta(padronElectoral);
    }
    
    public void votar(ListaEnlazada<String> votos){
        
        var voto = new DaoVoto().guardarVoto();
        
        var aux = votos.toArray();
        
        for(var v : aux){
            new DaoSufragio().guardarSufragio(voto, v);
        }
        
        papeletaDao.getPapeleta().setIdVoto(voto);
        
        try {
            papeletaDao.actualizar(papeletaDao.getPapeleta(), "id");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public void buscarInformacion(int pos, String dignidad) {

        daoPartido.setPartidoPolitico(daoPartido.listar().toArray()[pos]);

        int id = new DaoDignidad().buscar("nombre", dignidad).getId();

        var candidatos = daoCandidato.buscar("idPartidoPolitico", daoPartido.getPartidoPolitico().getId()).toArray();

        if (candidatos == null) {
            return;
        }

        for (Candidato candidato : candidatos) {
            if (candidato.getIdDignidad() == id) {
                daoCandidato.setCandidato(candidato);
                break;
            }
        }

        daoPersona.setPersona(daoPersona.buscar("dni", daoCandidato.getCandidato().getDniPersona()));
    }

    public void buscarOtros(int pos, String dignidad, int posC) {
        daoPartido.setPartidoPolitico(daoPartido.listar().toArray()[pos]);

        int id = new DaoDignidad().buscar("nombre", dignidad).getId();

        var candidatos = daoCandidato.buscar("idPartidoPolitico", daoPartido.getPartidoPolitico().getId()).toArray();

        if (candidatos == null) {
            return;
        }

        var otros = new ListaEnlazada<Candidato>();

        for (var c : candidatos) {
            if (c.getIdDignidad() == id) {
                otros.insertar(c);
            }
        }

        daoCandidato.setCandidato(otros.toArray()[posC]);

        daoPersona.setPersona(daoPersona.buscar("dni", daoCandidato.getCandidato().getDniPersona()));

    }

    public DaoPersona getDaoPersona() {
        return daoPersona;
    }

    public void setDaoPersona(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public DaoCandidato getDaoCandidato() {
        return daoCandidato;
    }

    public void setDaoCandidato(DaoCandidato daoCandidato) {
        this.daoCandidato = daoCandidato;
    }

    public DaoPartidoPolitico getDaoPartido() {
        return daoPartido;
    }

    public void setDaoPartido(DaoPartidoPolitico daoPartido) {
        this.daoPartido = daoPartido;
    }

}
