package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.lista.ListaEnlazada;
import modelo.VotoCandidato;

public class DaoSufragio extends AdaptadorDao<VotoCandidato> {

    private VotoCandidato sufragio;

    public DaoSufragio() {
        super(VotoCandidato.class);
    }

    public ListaEnlazada<VotoCandidato> buscar() {
        var resultado = new ListaEnlazada<VotoCandidato>();
        return resultado;
    }

    public void guardarSufragio(int voto, String candidato) {
        crear();
        
        sufragio.setIdVoto(voto);
        
        sufragio.setDniCandidato(candidato);

        try {
            
            guardar(sufragio);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void crear() {
        sufragio = new VotoCandidato();
    }
}
