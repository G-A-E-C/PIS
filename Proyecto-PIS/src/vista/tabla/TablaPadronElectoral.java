package vista.tabla;

import controlador.dao.DaoEleccion;
import controlador.dao.DaoLocalidad;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;

import controlador.lista.ListaEnlazada;

import javax.swing.table.AbstractTableModel;
import modelo.PadronElectoral;

public class TablaPadronElectoral extends AbstractTableModel{
    
    private ListaEnlazada<PadronElectoral> data;

    public void setData(ListaEnlazada<PadronElectoral> data) {
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
        PadronElectoral d = null;
        
        try {
            d = data.obtener(row);
        } catch (ListaPosicionExcepcion | ListaVaciaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        if(column == 0) return d.getNombre();
        if(column == 1) return new DaoLocalidad().buscar("id", d.getIdLocalidad()).getNombre();
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        if(column == 0) return "Nombre";
        if(column == 1) return "Localidad";
        
        return null;
    }
    
}
