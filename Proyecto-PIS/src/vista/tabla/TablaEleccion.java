package vista.tabla;

import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;

import controlador.lista.ListaEnlazada;

import javax.swing.table.AbstractTableModel;
import modelo.Eleccion;

public class TablaEleccion extends AbstractTableModel{
    
    private ListaEnlazada<Eleccion> data;

    public void setData(ListaEnlazada<Eleccion> data) {
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
        Eleccion d = null;
        
        try {
            d = data.obtener(row);
        } catch (ListaPosicionExcepcion | ListaVaciaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        if(column == 0) return d.getNombre();
        if(column == 1) return d.getPeriodo();
        if(column == 2) return d.getFechaInicio();
        if(column == 3) return d.getFechaFinal();
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        if(column == 0) return "Nombre";
        if(column == 1) return "Período";
        if(column == 2) return "Inicio";
        if(column == 3) return "Final";
        
        return null;
    }
    
}
