package modelo;

public class Cuenta {
    private int id;
    private String dniPersona;
    private String clave;
    private int idRol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int id_rol) {
        this.idRol = id_rol;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", dni='" + dniPersona + '\'' +
                ", clave='" + clave + '\'' +
                ", idRol=" + idRol +
                '}';
    }
}
