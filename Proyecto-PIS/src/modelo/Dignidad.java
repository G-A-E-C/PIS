package modelo;

public enum Dignidad {
    PRESIDENTE(1),
    VICEPRESIDENTE(2),
    ASAMBLEISTA(3);

    public final int id;
    private Dignidad(int id){
        this.id = id;
    }

}
