package controlador.lista;

import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;

import java.lang.reflect.Field;
import java.util.Random;

public class ListaEnlazada<E> {
    private Nodo<E> cabeza;
    private int longitud = 0;
    private Field campo;
    private String tipoCampo;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public int size() {
        return this.longitud;
    }

    public boolean isEmpty() {
        return this.cabeza == null;
    }

    public void insertarPrimero(E info) {

        longitud++;

        if (isEmpty()) {
            cabeza = new Nodo<>(info);
            return;
        }

        var newNode = new Nodo<>(info);

        newNode.setSig(cabeza);

        cabeza = newNode;

    }

    public void insertar(E info) {

        if (isEmpty()) {
            insertarPrimero(info);
            return;
        }

        var tmp = cabeza;

        while (tmp.getSig() != null) {
            tmp = tmp.getSig();
        }

        tmp.setSig(new Nodo<>(info));

        longitud++;

    }

    public void insertar(int idx, E info) throws ListaPosicionExcepcion, ListaVaciaExcepcion {

        if (idx < 0 || idx >= size()) throw new ListaPosicionExcepcion();

        if (isEmpty() || idx == 0) {
            insertarPrimero(info);
            return;
        }

        var newNode = new Nodo<>(info);

        var tmp = obtenerNodo(idx - 1);

        newNode.setSig(tmp.getSig());

        tmp.setSig(newNode);

        this.longitud++;
    }

    public E obtener(int idx) throws ListaPosicionExcepcion, ListaVaciaExcepcion {

        if (isEmpty()) throw new ListaVaciaExcepcion();

        if (idx < 0 || idx > size()) throw new ListaPosicionExcepcion();

        if (idx == 0) return cabeza.getData();

        var tmp = obtenerNodo(idx);

        return tmp.getData();

    }

    private Nodo<E> obtenerNodo(int idx) throws ListaVaciaExcepcion, ListaPosicionExcepcion {

        if (isEmpty()) throw new ListaVaciaExcepcion();

        if (idx < 0 || idx > size()) throw new ListaPosicionExcepcion();

        var tmp = cabeza;

        for (int i = 0; i < idx; i++) tmp = tmp.getSig();

        return tmp;

    }

    public void actualizar(int idx, E data) throws ListaVaciaExcepcion, ListaPosicionExcepcion{

        if(isEmpty()) throw new ListaVaciaExcepcion();

        if(idx < 0 || idx > size()) throw new ListaPosicionExcepcion();

        var tmp = obtenerNodo(idx);

        tmp.setData(data);

    }

    public E eliminar(int idx) throws ListaPosicionExcepcion, ListaVaciaExcepcion {

        if (isEmpty()) throw new ListaVaciaExcepcion();

        if (idx < 0 || idx > size()) throw new ListaPosicionExcepcion();

        E info;

        longitud--;

        if (idx != 0) {

            var tmp = obtenerNodo(idx - 1);

            info = tmp.getSig().getData();

            tmp.setSig(tmp.getSig().getSig());

            return info;

        }

        info = cabeza.getData();

        cabeza = cabeza.getSig();

        return info;

    }

    public void eliminarTodo() {
        cabeza = null;
        longitud = 0;
    }

    public void imprimir() throws ListaVaciaExcepcion {

        if (isEmpty()) throw new ListaVaciaExcepcion();

        var tmp = cabeza;

        System.out.println("List[" + size() + "]");
        System.out.println("{");
        while (tmp != null) {
            System.out.println(tmp.getData().toString());
            tmp = tmp.getSig();
        }
        System.out.println("}");

    }

    public E[] toArray() {

        E[] array = null;

        if(this.size() == 0) return array;

        array = (E[]) java.lang.reflect.Array.newInstance(cabeza.getData().getClass(), size());

        var tmp = cabeza;

        for (int i = 0; i < size(); i++) {
            array[i] = tmp.getData();
            tmp = tmp.getSig();
        }

        return array;

    }

    public void toList(E[] array) {

        this.eliminarTodo();

        for (E e : array) this.insertar(e);

    }

    private void obtenerAtributos(String attribute) {

        Field[] fields = cabeza.getData().getClass().getDeclaredFields();

        for (var fld : fields) if (fld.getName().equals(attribute)) campo = fld;

        campo.setAccessible(true);

        tipoCampo = campo.getType().getSimpleName();

    }

    private void reiniciarAtributos() {
        campo = null;
        tipoCampo = null;
    }

    private int comparar(E e1, E e2) throws IllegalAccessException {

        if (tipoCampo.equals("int") || tipoCampo.equals("double")) {

            return Double.compare(((Number) campo.get(e1)).doubleValue(), ((Number) campo.get(e2)).doubleValue());

        } else {

            return Integer.compare(campo.get(e1).toString().compareToIgnoreCase(campo.get(e2).toString()), 0);

        }

    }

    private int compararB(E e1, Object e2) throws IllegalAccessException {

        if (tipoCampo.equals("int") || tipoCampo.equals("double")) {

            return Double.compare(((Number) campo.get(e1)).doubleValue(), ((Number) e2).doubleValue());

        } else {

            return Integer.compare(campo.get(e1).toString().compareToIgnoreCase(e2.toString()), 0);

        }

    }

    public void desordenar() throws ListaVaciaExcepcion {

        var tmpArr = this.toArray();

        Random aleatorio = new Random();

        for (int i = 0; i < tmpArr.length; i++) {

            int numAleatorio = aleatorio.nextInt(tmpArr.length - 1);

            var tmp = tmpArr[i];

            tmpArr[i] = tmpArr[numAleatorio];

            tmpArr[numAleatorio] = tmp;

        }

        this.toList(tmpArr);

    }

    private int partition(E[] arr, int low, int high, boolean typeSort) throws IllegalAccessException {

        var pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j < high; j++) {

            if (typeSort ? comparar(arr[j], pivot) <= 0 : comparar(arr[j], pivot) >= 0) {

                i++;
                var tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

            }

        }

        var tmp = arr[i + 1];

        arr[i + 1] = arr[high];

        arr[high] = tmp;

        return i + 1;

    }

    private void quick(E[] arr, int low, int high, boolean typeSort) throws IllegalAccessException {

        if (low < high) {

            int pi = partition(arr, low, high, typeSort);

            quick(arr, low, pi - 1, typeSort);

            quick(arr, pi + 1, high, typeSort);

        }

    }

    private void merge(E[] arr, int l, int m, int r, boolean typeSort) throws IllegalAccessException {

        int n1 = m - l + 1;
        int n2 = r - m;

        E[] L = (E[]) java.lang.reflect.Array.newInstance(cabeza.getData().getClass(), n1);

        E[] R = (E[]) java.lang.reflect.Array.newInstance(cabeza.getData().getClass(), n2);

        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];

        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {

            if (typeSort ? comparar(L[i], R[j]) <= 0 : comparar(L[i], R[j]) >= 0) {

                arr[k] = L[i];
                i++;

            } else {

                arr[k] = R[j];
                j++;

            }

            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    private void sortMerge(E[] arr, int l, int r, boolean typeSort) throws IllegalAccessException {

        if (l < r) {

            int m = l + (r - l) / 2;

            sortMerge(arr, l, m, typeSort);

            sortMerge(arr, m + 1, r, typeSort);

            merge(arr, l, m, r, typeSort);

        }

    }

    public void mergeSort(String attribute, boolean typeSort) throws ListaVaciaExcepcion, IllegalAccessException {

        if (isEmpty()) throw new ListaVaciaExcepcion();

        if (size() == 1) return;

        obtenerAtributos(attribute);

        var tmp = this.toArray();

        sortMerge(tmp, 0, (tmp.length - 1), typeSort);

        reiniciarAtributos();

        this.toList(tmp);

    }

    public void quickSort(String attribute, boolean typeSort) throws ListaVaciaExcepcion, IllegalAccessException {

        if (isEmpty()) throw new ListaVaciaExcepcion();

        if (size() == 1) return;

        obtenerAtributos(attribute);

        var tmp = this.toArray();

        quick(tmp, 0, (tmp.length - 1), typeSort);

        reiniciarAtributos();

        this.toList(tmp);

    }


    private int binary(E[] arr, Object element, int low, int high) throws IllegalAccessException {

        if (high >= low) {

            int mid = low + (high - low) / 2;

            if (compararB(arr[mid], element) == 0) return mid;

            if (compararB(arr[mid], element) > 0) return binary(arr, element, low, mid - 1);

            return binary(arr, element, mid + 1, high);

        }

        return -1;
    }

    public E busquedaBinaria(String attribute, Object info) throws ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion, ListaPosicionExcepcion {

        if (isEmpty()) throw new ListaVaciaExcepcion();

        var tmpArray = this.toArray();

        obtenerAtributos(attribute);

        int idx = binary(tmpArray, info, 0, tmpArray.length - 1);

        reiniciarAtributos();

        if (idx == -1) throw new ListaElementoNoExisteExcepcion();

        return this.obtener(idx);
    }

    public ListaEnlazada<E> busquedaLineal(String attribute, Object info) throws ListaVaciaExcepcion, IllegalAccessException, ListaElementoNoExisteExcepcion, ListaPosicionExcepcion {

        ListaEnlazada<E> result = new ListaEnlazada<>();

        var tmpArray = toArray();

        obtenerAtributos(attribute);

        int idx = binary(tmpArray, info, 0, tmpArray.length - 1);

        if (idx == -1) throw new ListaElementoNoExisteExcepcion();

        int tmpIdx = 0;

        for (int i = idx; i >= 0; i--) {
            if (compararB(this.obtener(i), info) != 0) break;
            tmpIdx = i;
        }

        for (int i = tmpIdx; i < this.size(); i++) {
            if (compararB(this.obtener(i), info) != 0) break;
            result.insertar(this.obtener(i));
        }

        reiniciarAtributos();

        return result;
    }

    public ListaEnlazada<E> busqueda(String atributo, Object info) throws ListaVaciaExcepcion, ListaPosicionExcepcion, IllegalAccessException{
        
        if (isEmpty()) throw new ListaVaciaExcepcion();
        
        ListaEnlazada<E> resultado = new ListaEnlazada<>();

        var tmpArray = toArray();
        
        obtenerAtributos(atributo);
        
        for(int i = 0 ; i < tmpArray.length ; i++){
            if(compararTodo(this.obtener(i), info) != 0) continue;
            resultado.insertar((this.obtener(i)));
        }
        
        return resultado;
    }
    
    public ListaEnlazada<E> busquedaLista(String atributo, ListaEnlazada<E> lista) throws ListaVaciaExcepcion, IllegalAccessException, ListaPosicionExcepcion{
        
        if (isEmpty() || lista.isEmpty()) throw new ListaVaciaExcepcion();
        
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        
        var tmpArray = toArray();
        
        var tmpList = lista.toArray();
        
        obtenerAtributos(atributo);
        
        for(int i = 0 ; i < tmpArray.length ; i++){
            for (E tmpList1 : tmpList) {
                if (compararList(this.obtener(i), tmpList1) != 0) {
                    continue;
                }
                resultado.insertar(this.obtener(i));
            }
        }
        
        return resultado;
    }
    
    private int compararTodo(E e1, Object e2) throws IllegalAccessException {

        if (tipoCampo.equals("int") || tipoCampo.equals("double")) {

            return Double.compare(((Number) campo.get(e1)).doubleValue(), ((Number) e2).doubleValue());

        } else {
            
            return campo.get(e1).toString().toLowerCase().startsWith(e2.toString().toLowerCase()) ? 0 : 1;

        }

    }
    
    private int compararList(E e1, E e2) throws IllegalAccessException {

        if (tipoCampo.equals("int") || tipoCampo.equals("double")) {

            return Double.compare(((Number) campo.get(e1)).doubleValue(), ((Number) campo.get(e2)).doubleValue());

        } else {
            
            return campo.get(e1).toString().toLowerCase().startsWith(campo.get(e2).toString().toLowerCase()) ? 0 : 1;

        }

    }
}
