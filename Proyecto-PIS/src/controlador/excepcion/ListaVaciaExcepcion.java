package controlador.excepcion;

public class ListaVaciaExcepcion extends Exception{
    public ListaVaciaExcepcion(){
        super("La lista esta vacia");
    }

    public ListaVaciaExcepcion(String msg){
        super(msg);
    }
}