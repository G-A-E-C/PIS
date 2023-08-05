package modelo;

public enum Rol {
    USUARIO(1),
    ADMINISTRADOR(2);

    public final int id;
    private Rol(int id){
        this.id = id;
    }

}
