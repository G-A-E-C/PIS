package modelo;

public class Votante {
    private String dniPersona;
    private char haVotado;
    private int idPadronElectoral;

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public char getHaVotado() {
        return haVotado;
    }

    public void setHaVotado(char haVotado) {
        this.haVotado = haVotado;
    }

    public int getIdPadronElectoral() {
        return idPadronElectoral;
    }

    public void setIdPadronElectoral(int idPadronElectoral) {
        this.idPadronElectoral = idPadronElectoral;
    }

}
