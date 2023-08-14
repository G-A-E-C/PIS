package modelo;

public class Localidad {
    private int id;
    private String nombre;
    private int idEleccion;

    public Localidad() {
    }

    public Localidad(int idEleccion) {
        this.idEleccion = idEleccion;
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

    public int getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(int idEleccion) {
        this.idEleccion = idEleccion;
    }
}
