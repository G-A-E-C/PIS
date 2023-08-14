package vista.tabla;

import controlador.dao.DaoEleccion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;

import controlador.lista.ListaEnlazada;

import javax.swing.table.AbstractTableModel;
import modelo.Localidad;

public class TablaLocalidad extends AbstractTableModel{
    
    private ListaEnlazada<Localidad> data;

    public void setData(ListaEnlazada<Localidad> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Localidad d = null;
        
        try {
            d = data.obtener(row);
        } catch (ListaPosicionExcepcion | ListaVaciaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        if(column == 0) return d.getNombre();
        if(column == 1) return new DaoEleccion().buscar("id", d.getIdEleccion()).getNombre();
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        if(column == 0) return "Nombre";
        if(column == 1) return "Elección";
        
        return null;
    }
    
}
