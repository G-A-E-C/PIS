package modelo;

public class PadronElectoral {
    private int id;
    private String nombre;
    private int idLocalidad;

    public PadronElectoral() {
    }

    public PadronElectoral(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
}
