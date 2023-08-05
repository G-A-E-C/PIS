package controlador.lista;

public class Nodo <E>{
    private E data;
    private Nodo<E> sig;

    public Nodo(E data) {
        this.data = data;
        this.sig = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Nodo<E> getSig() {
        return sig;
    }

    public void setSig(Nodo<E> sig) {
        this.sig = sig;
    }
}
