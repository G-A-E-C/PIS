package controlador.dao;

import controlador.conexion.AdaptadorDao;
import controlador.excepcion.ListaElementoNoExisteExcepcion;
import controlador.excepcion.ListaPosicionExcepcion;
import controlador.excepcion.ListaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import modelo.Papeleta;

public class DaoPapeleta extends AdaptadorDao<Papeleta>{
    private Papeleta papeleta;
    
    public DaoPapeleta(){
        super(Papeleta.class);
    }
    
    public ListaEnlazada<Papeleta> buscar(){
        var resultado = new ListaEnlazada<Papeleta>();
        return resultado;
    }
    
    public void presentarPapeleta(int padronElectoral) {
        try {
            var papeletas = listar();
            
            papeletas.mergeSort("idPadronElectoral", true);
            
            var papeletasPadron = papeletas.busquedaLineal("idPadronElectoral", padronElectoral);
            
            papeleta = papeletasPadron.busquedaLineal("idVoto", 0).obtener(0);
            
            if(papeleta == null){
                System.out.println("ya no existen papeletas disponibles");
            }
        } catch (ListaVaciaExcepcion | IllegalAccessException | ListaElementoNoExisteExcepcion | ListaPosicionExcepcion ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void generarPapeleta(int padron){
        crear();
        
        papeleta.setIdPadronElectoral(padron);
        papeleta.setIdVoto(0);
        
        try {
            guardar(papeleta);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void crear(){
        papeleta = new Papeleta();
    }

    public Papeleta getPapeleta() {
        return papeleta;
    }

    public void setPapeleta(Papeleta papeleta) {
        this.papeleta = papeleta;
    }
    
}
