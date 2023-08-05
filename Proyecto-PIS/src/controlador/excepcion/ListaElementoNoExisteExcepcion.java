package controlador.excepcion;

public class ListaElementoNoExisteExcepcion extends Exception{
    public ListaElementoNoExisteExcepcion(){
        super("El atributo no existe en la lista");
    }

    public ListaElementoNoExisteExcepcion(String msg){
        super(msg);
    }
}
