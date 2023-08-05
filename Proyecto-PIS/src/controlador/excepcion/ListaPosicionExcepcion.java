package controlador.excepcion;

public class ListaPosicionExcepcion extends Exception{
    public ListaPosicionExcepcion(){
        super("La posicion no existe en la lista");
    }

    public ListaPosicionExcepcion(String msg){
        super(msg);
    }
}
