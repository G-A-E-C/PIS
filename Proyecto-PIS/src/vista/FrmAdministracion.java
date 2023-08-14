package vista;

public class FrmAdministracion extends javax.swing.JFrame {

    
    
    public FrmAdministracion() {
        initComponents();
        initPanels();
        hideAll();
        eleccion.setVisible(true);
    }

    private void initPanels() {
        String[] eleciones = {"Nombre", "Periodo"};
        String[] localidades = {"Nombre", "Elección"};
        String[] padrones = {"Nombre", "Localidad"};
        String[] partidos = {"Nombre", "Lista", "Ideologia"};
        String[] candidatos = {"Nombre", "Apellido", "Dignidad", "Partido Politico"};
        String[] votantes = {"Nombre", "Apellido", "Padron Electoral", "Estado"};
        
        eleccion.show("Elección", eleciones, 0);
        localidad.show("Localidad", localidades, 1);
        padron.show("Padrón Electoral", padrones, 2);
        partido.show("Partido Político", partidos, 3);
        candidato.show("Candidato", candidatos, 4);
        votante.show("Votante", votantes, 5);
    }

    private void hideAll(){
        eleccion.setVisible(false);
        localidad.setVisible(false);
        padron.setVisible(false);
        partido.setVisible(false);
        candidato.setVisible(false);
        votante.setVisible(false);
    }
    
    private void showPanel(int tipo){
        hideAll();
        
        if(tipo == 0) eleccion.setVisible(true);
        if(tipo == 1) localidad.setVisible(true);
        if(tipo == 2) padron.setVisible(true);
        if(tipo == 3) partido.setVisible(true);
        if(tipo == 4) candidato.setVisible(true);
        if(tipo == 5) votante.setVisible(true);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLocalidad = new componentes.controls.Button();
        btnEleccion = new componentes.controls.Button();
        btnPadron = new componentes.controls.Button();
        btnPartido = new componentes.controls.Button();
        btnLogout = new componentes.controls.Button();
        btnCandidato = new componentes.controls.Button();
        btnVotante = new componentes.controls.Button();
        eleccion = new componentes.controls.contrainers.Gestion();
        localidad = new componentes.controls.contrainers.Gestion();
        padron = new componentes.controls.contrainers.Gestion();
        partido = new componentes.controls.contrainers.Gestion();
        candidato = new componentes.controls.contrainers.Gestion();
        votante = new componentes.controls.contrainers.Gestion();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(199, 231, 233));

        btnLocalidad.setBackground(new java.awt.Color(199, 231, 233));
        btnLocalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/localidad.png"))); // NOI18N
        btnLocalidad.setRippleColor(new java.awt.Color(255, 255, 255));
        btnLocalidad.setShadowColor(new java.awt.Color(199, 231, 233));
        btnLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalidadActionPerformed(evt);
            }
        });

        btnEleccion.setBackground(new java.awt.Color(199, 231, 233));
        btnEleccion.setForeground(new java.awt.Color(0, 0, 0));
        btnEleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eleccion.png"))); // NOI18N
        btnEleccion.setRippleColor(new java.awt.Color(255, 255, 255));
        btnEleccion.setShadowColor(new java.awt.Color(199, 231, 233));
        btnEleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEleccionActionPerformed(evt);
            }
        });

        btnPadron.setBackground(new java.awt.Color(199, 231, 233));
        btnPadron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/padron.png"))); // NOI18N
        btnPadron.setRippleColor(new java.awt.Color(255, 255, 255));
        btnPadron.setShadowColor(new java.awt.Color(199, 231, 233));
        btnPadron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPadronActionPerformed(evt);
            }
        });

        btnPartido.setBackground(new java.awt.Color(199, 231, 233));
        btnPartido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/partidos.png"))); // NOI18N
        btnPartido.setRippleColor(new java.awt.Color(255, 255, 255));
        btnPartido.setShadowColor(new java.awt.Color(199, 231, 233));
        btnPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidoActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(199, 231, 233));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/salir.png"))); // NOI18N
        btnLogout.setRippleColor(new java.awt.Color(255, 255, 255));
        btnLogout.setShadowColor(new java.awt.Color(199, 231, 233));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnCandidato.setBackground(new java.awt.Color(199, 231, 233));
        btnCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/candidate.png"))); // NOI18N
        btnCandidato.setRippleColor(new java.awt.Color(255, 255, 255));
        btnCandidato.setShadowColor(new java.awt.Color(199, 231, 233));
        btnCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCandidatoActionPerformed(evt);
            }
        });

        btnVotante.setBackground(new java.awt.Color(199, 231, 233));
        btnVotante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/votante.png"))); // NOI18N
        btnVotante.setRippleColor(new java.awt.Color(255, 255, 255));
        btnVotante.setShadowColor(new java.awt.Color(199, 231, 233));
        btnVotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVotanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPadron, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPadron, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnVotante, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(votante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(candidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(padron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(votante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(candidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(padron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidoActionPerformed
        // TODO add your handling code here:
        showPanel(3);
    }//GEN-LAST:event_btnPartidoActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnEleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEleccionActionPerformed
        // TODO add your handling code here:
        showPanel(0);
    }//GEN-LAST:event_btnEleccionActionPerformed

    private void btnLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalidadActionPerformed
        // TODO add your handling code here:
        showPanel(1);
    }//GEN-LAST:event_btnLocalidadActionPerformed

    private void btnPadronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPadronActionPerformed
        // TODO add your handling code here:
        showPanel(2);
    }//GEN-LAST:event_btnPadronActionPerformed

    private void btnCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCandidatoActionPerformed
        // TODO add your handling code here:
        showPanel(4);
    }//GEN-LAST:event_btnCandidatoActionPerformed

    private void btnVotanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVotanteActionPerformed
        // TODO add your handling code here:
        showPanel(5);
    }//GEN-LAST:event_btnVotanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdministracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.controls.Button btnCandidato;
    private componentes.controls.Button btnEleccion;
    private componentes.controls.Button btnLocalidad;
    private componentes.controls.Button btnLogout;
    private componentes.controls.Button btnPadron;
    private componentes.controls.Button btnPartido;
    private componentes.controls.Button btnVotante;
    private componentes.controls.contrainers.Gestion candidato;
    private componentes.controls.contrainers.Gestion eleccion;
    private javax.swing.JPanel jPanel1;
    private componentes.controls.contrainers.Gestion localidad;
    private componentes.controls.contrainers.Gestion padron;
    private componentes.controls.contrainers.Gestion partido;
    private componentes.controls.contrainers.Gestion votante;
    // End of variables declaration//GEN-END:variables
}
