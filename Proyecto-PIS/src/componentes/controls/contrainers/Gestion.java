package componentes.controls.contrainers;

import controlador.ControladorAdministrador;
import vista.FrmFormulario;
import vista.tabla.TablaCandidato;
import vista.tabla.TablaEleccion;
import vista.tabla.TablaLocalidad;
import vista.tabla.TablaPadronElectoral;
import vista.tabla.TablaPartidoPolitico;
import vista.tabla.TablaVotante;

public class Gestion extends javax.swing.JPanel {

    private int tipo;
    private TablaEleccion modeloEleccion;
    private TablaLocalidad modeloLocalidad;
    private TablaPadronElectoral modeloPadron;
    private TablaPartidoPolitico modeloPartido;
    private TablaCandidato modeloCandidato;
    private TablaVotante modeloVotante;
    private ControladorAdministrador controlador;

    public Gestion() {
        initComponents();
    }

    public void show(String titulo, String[] filtros, int tipo) {
        setTitulo(titulo);
        initCobo(filtros);
        this.tipo = tipo;
        controlador = new ControladorAdministrador();
        cargarTabla(tipo);
    }

    private void setTitulo(String titulo) {
        lbModulo.setText(titulo);
    }

    private void initCobo(String[] filtros) {
        cbFiltro.removeAllItems();

        for (var f : filtros) {
            cbFiltro.addItem(f);
        }
    }

    private void cargarTabla(int tipo) {
        if (tipo == 0) {
            modeloEleccion = new TablaEleccion();
            modeloEleccion.setData(controlador.listarElecciones());
            tbDatos.setModel(modeloEleccion);
        }
        
        if (tipo == 1) {
            modeloLocalidad = new TablaLocalidad();
            modeloLocalidad.setData(controlador.listarLocalidades());
            tbDatos.setModel(modeloLocalidad);
        }
        
        if (tipo == 2) {
            modeloPadron = new TablaPadronElectoral();
            modeloPadron.setData(controlador.listarPadrones());
            tbDatos.setModel(modeloPadron);
        }
        
        if (tipo == 3) {
            modeloPartido = new TablaPartidoPolitico();
            modeloPartido.setData(controlador.listarPartidos());
            tbDatos.setModel(modeloPartido);
        }
        
        if (tipo == 4) {
            modeloCandidato = new TablaCandidato();
            modeloCandidato.setData(controlador.listarCandidatos());
            tbDatos.setModel(modeloCandidato);
        }
        
        if (tipo == 5) {
            modeloVotante = new TablaVotante();
            modeloVotante.setData(controlador.listarVotantes());
            tbDatos.setModel(modeloVotante);
        }

        tbDatos.updateUI();
    }
    
    private void buscar(){
        
        if(tipo == 0) buscarEleccion();
        if(tipo == 1) buscarLocalidad();
        if(tipo == 2) buscarPadron();
        if(tipo == 3) buscarPartido();
        if(tipo == 4) buscarCandidato();
        if(tipo == 5) buscarVotante();
        
        tbDatos.updateUI();
    }
    
    private void buscarEleccion(){
        
        String atributo = cbFiltro.getSelectedItem().toString();
        String dato = txtBuscar.getText();
        
        modeloEleccion.setData(controlador.buscarEleccion(atributo, dato));
        tbDatos.setModel(modeloEleccion);
        
    }
    
    private void buscarLocalidad(){
        String atributo = cbFiltro.getSelectedItem().toString();
        String dato = txtBuscar.getText();
        
        modeloLocalidad.setData(controlador.buscarLocalidad(atributo, dato));
        tbDatos.setModel(modeloLocalidad);
    }
    
    private void buscarPadron(){
        String atributo = cbFiltro.getSelectedItem().toString();
        String dato = txtBuscar.getText();
        
        modeloPadron.setData(controlador.buscarPadronElectoral(atributo, dato));
        tbDatos.setModel(modeloPadron);
    }
    
    private void buscarPartido(){
        String atributo = cbFiltro.getSelectedItem().toString();
        
        if(atributo.equals("Lista")){
            double dato = Double.parseDouble(txtBuscar.getText());
            modeloPartido.setData(controlador.buscarPartidoPolitico(atributo, dato));
            tbDatos.setModel(modeloPartido);
            return;
        }
        
        String dato = txtBuscar.getText();
        modeloPartido.setData(controlador.buscarPartidoPolitico(atributo, dato));
        tbDatos.setModel(modeloPartido);
    }
    
    private void buscarVotante(){
        String atributo = cbFiltro.getSelectedItem().toString();
        String dato = txtBuscar.getText();
        
        modeloVotante.setData(controlador.buscarVoatante(atributo, dato));
        tbDatos.setModel(modeloVotante);
    }

    private void buscarCandidato(){
        String atributo = cbFiltro.getSelectedItem().toString();
        String dato = txtBuscar.getText();
        
        modeloCandidato.setData(controlador.buscarCanditato(atributo, dato));
        tbDatos.setModel(modeloCandidato);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbModulo = new componentes.controls.Label();
        panelRound1 = new componentes.controls.PanelRound();
        txtBuscar = new componentes.controls.TextField();
        btnBuscar = new componentes.controls.Button();
        cbFiltro = new componentes.controls.Combo();
        btnAgregar = new componentes.controls.Button();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatos = new componentes.controls.Table();
        scrollBar1 = new componentes.controls.ScrollBar();

        setBackground(new java.awt.Color(255, 255, 255));

        lbModulo.setForeground(new java.awt.Color(0, 0, 0));
        lbModulo.setText("ELECCIÓN");
        lbModulo.setFont(new java.awt.Font("Microsoft JhengHei Ui", 1, 18)); // NOI18N

        panelRound1.setBackground(new java.awt.Color(235, 247, 247));

        txtBuscar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtBuscar.setShadowColor(new java.awt.Color(199, 231, 233));

        btnBuscar.setBackground(new java.awt.Color(199, 231, 233));
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        btnBuscar.setRippleColor(new java.awt.Color(255, 255, 255));
        btnBuscar.setShadowColor(new java.awt.Color(199, 231, 233));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbFiltro.setBackground(new java.awt.Color(199, 231, 233));
        cbFiltro.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnAgregar.setBackground(new java.awt.Color(251, 253, 253));
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agregar.png"))); // NOI18N
        btnAgregar.setText("Crear Nueva");
        btnAgregar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDatos.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        tbDatos.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbDatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(scrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        new FrmFormulario(null, true, tipo).setVisible(true);
        cargarTabla(tipo);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.controls.Button btnAgregar;
    private componentes.controls.Button btnBuscar;
    private componentes.controls.Combo cbFiltro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.controls.Label lbModulo;
    private componentes.controls.PanelRound panelRound1;
    private componentes.controls.ScrollBar scrollBar1;
    private componentes.controls.Table tbDatos;
    private componentes.controls.TextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
