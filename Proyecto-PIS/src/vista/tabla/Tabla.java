package vista.tabla;

import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;

import controlador.lista.ListaEnlazada;

import javax.swing.table.AbstractTableModel;

public class Tabla extends AbstractTableModel{
    
    private ListaEnlazada<Object> data;

    public void setData(ListaEnlazada<Object> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object d = null;
        
        try {
            d = data.obtener(row);
        } catch (ListaPosicionExcepcion | ListaVaciaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        if(column == 0) return d;
        if(column == 1) return d;
        if(column == 2) return d;
        if(column == 3) return d;
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        if(column == 0) return "";
        if(column == 1) return "";
        if(column == 2) return "";
        if(column == 3) return "";
        
        return null;
    }
    
    
    
}
