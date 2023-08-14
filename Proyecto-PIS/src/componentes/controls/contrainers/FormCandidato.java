package componentes.controls.contrainers;

import controlador.dao.DaoCandidato;
import controlador.dao.DaoDignidad;
import controlador.dao.DaoPartidoPolitico;
import controlador.dao.DaoPersona;
import util.Info;

public class FormCandidato extends javax.swing.JPanel {

    public FormCandidato() {
        initComponents();
        initInfo();
    }

    // cargar todos los datos para llenar los combos
    private void initInfo() {
        var dignidades = new DaoDignidad().listar().toArray();
        var partidos = new DaoPartidoPolitico().listar().toArray();
        cbDignidad.removeAllItems();
        cbPartido.removeAllItems();

        for (int i = 0; i < dignidades.length; i++) {
            cbDignidad.addItem(dignidades[i].getNombre());
        }

        if(partidos == null){
            return;
        }
        for (int i = 0; i < partidos.length; i++) {
            cbPartido.addItem(partidos[i].getNombre());
        }
    }

    private void registrar() {
        String dni = txtDni.getText();
        int partido = new DaoPartidoPolitico().buscar("nombre", cbPartido.getSelectedItem().toString()).getId();
        int dignidad = new DaoDignidad().buscar("nombre", cbDignidad.getSelectedItem().toString()).getId();
        
        if (new DaoPersona().buscar("dni", dni).getDni() == null) {
            Info.showInfo("Esta persona no existe", 0);
            return;
        }
        
        new DaoCandidato().registrarCandidato(dni, dignidad, partido);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new componentes.controls.Label();
        label2 = new componentes.controls.Label();
        txtDni = new componentes.controls.TextField();
        label5 = new componentes.controls.Label();
        cbDignidad = new componentes.controls.Combo();
        btnCrear = new componentes.controls.Button();
        label6 = new componentes.controls.Label();
        cbPartido = new componentes.controls.Combo();

        setBackground(new java.awt.Color(255, 255, 255));

        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("CANDIDATO");
        label1.setFont(new java.awt.Font("Microsoft JhengHei Ui", 1, 24)); // NOI18N

        label2.setText("Dni");

        txtDni.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N

        label5.setText("Dignidad");

        cbDignidad.setBackground(new java.awt.Color(199, 231, 233));
        cbDignidad.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N

        btnCrear.setBackground(new java.awt.Color(199, 231, 233));
        btnCrear.setText("Crear");
        btnCrear.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        btnCrear.setRippleColor(new java.awt.Color(255, 255, 255));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        label6.setText("Partido Político");

        cbPartido.setBackground(new java.awt.Color(199, 231, 233));
        cbPartido.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbDignidad, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDignidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_btnCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.controls.Button btnCrear;
    private componentes.controls.Combo cbDignidad;
    private componentes.controls.Combo cbPartido;
    private componentes.controls.Label label1;
    private componentes.controls.Label label2;
    private componentes.controls.Label label5;
    private componentes.controls.Label label6;
    private componentes.controls.TextField txtDni;
    // End of variables declaration//GEN-END:variables
}
