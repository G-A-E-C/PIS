package vista.tabla;

import controlador.dao.DaoDignidad;
import controlador.dao.DaoPartidoPolitico;
import controlador.dao.DaoPersona;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;

import controlador.lista.ListaEnlazada;

import javax.swing.table.AbstractTableModel;
import modelo.Candidato;

public class TablaCandidato extends AbstractTableModel{
    
    private ListaEnlazada<Candidato> data;

    public void setData(ListaEnlazada<Candidato> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Candidato d = null;
        
        try {
            d = data.obtener(row);
        } catch (ListaPosicionExcepcion | ListaVaciaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
        var p = new DaoPersona().buscar("dni", d.getDniPersona());
        
        if(column == 0) return p.getPrimerNombre() +" "+ p.getSegundoNombre();
        if(column == 1) return p.getPrimerApellido() +" "+ p.getSegundoApellido();
        if(column == 2) return util.Info.calcularEdad(p.getFechaNacimiento());
        if(column == 3) return new DaoDignidad().buscar("id", d.getIdDignidad()).getNombre();
        if(column == 4) return new DaoPartidoPolitico().buscar("id", d.getIdPartidoPolitico()).getNombre();
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        if(column == 0) return "Nombre";
        if(column == 1) return "Apellido";
        if(column == 2) return "Edad";
        if(column == 3) return "Dignidad";
        if(column == 4) return "Partido Político";
        
        return null;
    }
    
}
