package util;

import java.util.Date;
import javax.swing.JOptionPane;

public class Info {
    
    public static void showInfo(String msg, int tipo){
        System.out.println(tipo);
        JOptionPane.showMessageDialog(null, msg, "Información", tipo);
    }
    
    public static int calcularEdad(Date fechaNacimiento) {
        int edad = 0;
        Date fechaActual = new Date();
        // Comparar años
        int anioNacimiento = fechaNacimiento.getYear();
        int anioActual = fechaActual.getYear();
        edad = anioActual - anioNacimiento;
        
        int mesNacimiento = fechaNacimiento.getMonth();
        int mesActual = fechaActual.getMonth();
        if (mesActual < mesNacimiento) {
            edad--;
        }
        
        else if (mesActual == mesNacimiento) {
            int diaNacimiento = fechaNacimiento.getDay();
            int diaActual = fechaActual.getDay();
            if (diaActual < diaNacimiento) {
                edad--;
            }
        }
        
        return edad;
    }
    
    public static boolean verificarHora(Date fecha, int inicio, int fin){
        
        Date fInicio = new Date(fecha.getTime()); // Clonar la fecha para no modificar la original
        Date fFin = new Date(fecha.getTime()); // Clonar la fecha para no modificar la original
        
        fInicio.setHours(inicio);
        fInicio.setMinutes(0); // Restablecer los minutos y segundos a cero
        fInicio.setSeconds(0);
        
        fFin.setHours(fin);
        fFin.setMinutes(59); // Establecer los minutos y segundos al máximo
        fFin.setSeconds(59);
        
        Date fechaActual = new Date(); 
        
        return fechaActual.compareTo(fInicio) > 0 && fechaActual.compareTo(fFin) < 0;
    }
    
    /*public ListaEnlazada<E> busqueda(String atributo, Object info) throws ListaVaciaExcepcion, ListaPosicionExcepcion, IllegalAccessException{
        
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
    
    public ListaEnlazada<E> buscarLista(ListaEnlazada<E> lista, String atributo) throws ListaVaciaExcepcion, IllegalAccessException, ListaPosicionExcepcion{
        
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

    }*/
}
