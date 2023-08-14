package controlador;

import controlador.dao.DaoCandidato;
import controlador.dao.DaoPartidoPolitico;
import controlador.dao.DaoPersona;

public class ControladorCandidatos {
    private final DaoCandidato candidatoDao;
    private final DaoPersona personaDao;
    private final DaoPartidoPolitico partidoPoliticoDao;
    
    public ControladorCandidatos(){
        this.candidatoDao = new DaoCandidato();
        this.personaDao = new DaoPersona();
        this.partidoPoliticoDao = new DaoPartidoPolitico();
    }
    
    
    
    

}
