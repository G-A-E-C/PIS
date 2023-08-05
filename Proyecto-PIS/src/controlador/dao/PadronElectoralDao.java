package controlador.dao;

import controlador.adap.AdaptadorDao;
import modelo.PadronElectoral;

public class PadronElectoralDao extends AdaptadorDao<PadronElectoral> {
    private PadronElectoral padronElectoral;

    public PadronElectoralDao(){
        super(PadronElectoral.class);
    }

    public PadronElectoral getPadronElectoral() {
        if(padronElectoral == null) padronElectoral = new PadronElectoral();
        return padronElectoral;
    }

    public void setPadronElectoral(PadronElectoral padronElectoral) {
        this.padronElectoral = padronElectoral;
    }
}
