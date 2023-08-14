package vista.tabla;

import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;

import controlador.lista.ListaEnlazada;

import javax.swing.table.AbstractTableModel;
import modelo.PartidoPolitico;

public class TablaPartidoPolitico extends AbstractTableModel{
    
    private ListaEnlazada<PartidoPolitico> data;

    public void setData(ListaEnlazada<PartidoPolitico> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        PartidoPolitico d = null;
        
        try {
            d = data.obtener(row);
        } catch (ListaPosicionExcepcion | ListaVaciaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        if(column == 0) return d.getNombre();
        if(column == 1) return d.getNumeroLista();
        if(column == 2) return d.getIdeologia();
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        if(column == 0) return "Nombre";
        if(column == 1) return "Nro Lista";
        if(column == 2) return "Ideología";
        
        return null;
    }
    
}
