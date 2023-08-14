package modelo;

public class Votante {
    private String dniPersona;
    private String haVotado;
    private int idPadronElectoral;

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public String getHaVotado() {
        return haVotado;
    }

    public void setHaVotado(String haVotado) {
        this.haVotado = haVotado;
    }

    public int getIdPadronElectoral() {
        return idPadronElectoral;
    }

    public void setIdPadronElectoral(int idPadronElectoral) {
        this.idPadronElectoral = idPadronElectoral;
    }

}
