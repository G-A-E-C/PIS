package vista;

import componentes.controls.contrainers.CandidatoPapeleta;
import controlador.ControladorCuenta;
import controlador.ControladorPapeleta;
import controlador.dao.DaoPartidoPolitico;
import controlador.lista.ListaEnlazada;

public class FrmPanel extends javax.swing.JFrame {

    private ControladorCuenta controladorCuenta;
    private ControladorPapeleta controladorPapeleta = new ControladorPapeleta();
    private ListaEnlazada<CandidatoPapeleta> paneles = new ListaEnlazada<>();
    private ListaEnlazada<String> votos = new ListaEnlazada<>();

    private int estado = 1;

    public FrmPanel() {
        initComponents();
        cargarPapeletas();
    }

    public FrmPanel(ControladorCuenta controladorCuenta) {
        initComponents();
        cargarPapeletas();
        this.controladorCuenta = controladorCuenta;
        presentarPapeleta();
    }

    private void presentarPapeleta() {
        controladorPapeleta.presentarPapeleta(controladorCuenta.votantePadronElectoral());
    }

    private void addItem(String c1, String c2, String partido, int lista, String d1, String d2, String dni) {
        CandidatoPapeleta c = new CandidatoPapeleta();
        c.cargarDatos(c1, c2, partido, lista, d1, d2, dni);
        paneles.insertar(c);

        itemCandidato.add(c);
        itemCandidato.repaint();
        itemCandidato.revalidate();
    }

    private void cargarPapeletas() {

        String nombreUno, nombreDos, nombrePartido, dni;
        int lista;
        int partidos = new DaoPartidoPolitico().listar().toArray().length;

        if (estado == 1) {

            for (int i = 0; i < partidos; i++) {
                controladorPapeleta.buscarInformacion(i, "Presidente");
                nombreUno = controladorPapeleta.getDaoPersona().getPersona().getPrimerNombre() + " " + controladorPapeleta.getDaoPersona().getPersona().getPrimerApellido();
                dni = controladorPapeleta.getDaoCandidato().getCandidato().getDniPersona();
                controladorPapeleta.buscarInformacion(i, "Vicepresidente");
                nombreDos = controladorPapeleta.getDaoPersona().getPersona().getPrimerNombre() + " " + controladorPapeleta.getDaoPersona().getPersona().getPrimerApellido();
                nombrePartido = controladorPapeleta.getDaoPartido().getPartidoPolitico().getNombre();
                lista = controladorPapeleta.getDaoPartido().getPartidoPolitico().getNumeroLista();

                addItem(nombreUno, nombreDos, nombrePartido, lista, "Presidente", "Vicepresidente", dni);
            }

            estado++;
            return;
        }

        for (int i = 0; i < partidos; i++) {
            controladorPapeleta.buscarOtros(i, "Asambleista", 0);
            nombreUno = controladorPapeleta.getDaoPersona().getPersona().getPrimerNombre() + controladorPapeleta.getDaoPersona().getPersona().getPrimerApellido();
            dni = controladorPapeleta.getDaoCandidato().getCandidato().getDniPersona();
            controladorPapeleta.buscarOtros(i, "Asambleista", 1);
            nombreDos = controladorPapeleta.getDaoPersona().getPersona().getPrimerNombre() + controladorPapeleta.getDaoPersona().getPersona().getPrimerApellido();
            nombrePartido = controladorPapeleta.getDaoPartido().getPartidoPolitico().getNombre();
            lista = controladorPapeleta.getDaoPartido().getPartidoPolitico().getNumeroLista();

            addItem(nombreUno, nombreDos, nombrePartido, lista, "Asambleista", "Asambleista", dni);
        }

        estado++;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        button2 = new componentes.controls.Button();
        pnPapeleta = new javax.swing.JPanel();
        label1 = new componentes.controls.Label();
        btnVotar = new componentes.controls.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemCandidato = new componentes.controls.PanelBallot();
        pnEstadistica = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(199, 231, 233));

        button2.setBackground(new java.awt.Color(199, 231, 233));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/salir.png"))); // NOI18N
        button2.setRippleColor(new java.awt.Color(255, 255, 255));
        button2.setShadowColor(new java.awt.Color(199, 231, 233));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(501, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnPapeleta.setBackground(new java.awt.Color(255, 255, 255));

        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("Elecciones Nacionales");
        label1.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 26)); // NOI18N

        btnVotar.setBackground(new java.awt.Color(199, 231, 233));
        btnVotar.setText("Votar");
        btnVotar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        btnVotar.setRippleColor(new java.awt.Color(255, 255, 255));
        btnVotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVotarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(itemCandidato);

        javax.swing.GroupLayout pnPapeletaLayout = new javax.swing.GroupLayout(pnPapeleta);
        pnPapeleta.setLayout(pnPapeletaLayout);
        pnPapeletaLayout.setHorizontalGroup(
            pnPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPapeletaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPapeletaLayout.createSequentialGroup()
                .addGap(0, 272, Short.MAX_VALUE)
                .addComponent(btnVotar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
            .addGroup(pnPapeletaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnPapeletaLayout.setVerticalGroup(
            pnPapeletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPapeletaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnVotar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel1.add(pnPapeleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 710, 550));

        pnEstadistica.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout pnEstadisticaLayout = new javax.swing.GroupLayout(pnEstadistica);
        pnEstadistica.setLayout(pnEstadisticaLayout);
        pnEstadisticaLayout.setHorizontalGroup(
            pnEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        pnEstadisticaLayout.setVerticalGroup(
            pnEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel1.add(pnEstadistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 710, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVotarActionPerformed
        // TODO add your handling code here:
        if (controladorCuenta.estadoVotante()) {
            return;
        }

        var aux = paneles.toArray();
        int count = 0;
        int pos = -1;

        for (int i = 0; i < aux.length; i++) {
            if (aux[i].seleccion()) {
                pos = i;
                count++;
            }
        }

        if (count > 1) {
            votos.insertar("Nulo");
        }
        if (count == 0) {
            votos.insertar("Blanco");
        }
        if (count != -1) {
            votos.insertar(aux[pos].candidato());
        }

        if (estado > 2) {
            controladorCuenta.actualizarDatosVotante("s");
            controladorPapeleta.votar(votos);
            this.dispose();
            new FrmLogin().setVisible(true);
        }

        paneles.eliminarTodo();
        itemCandidato.removeAll();
        cargarPapeletas();
    }//GEN-LAST:event_btnVotarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.controls.Button btnVotar;
    private componentes.controls.Button button2;
    private componentes.controls.PanelBallot itemCandidato;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.controls.Label label1;
    private javax.swing.JPanel pnEstadistica;
    private javax.swing.JPanel pnPapeleta;
    // End of variables declaration//GEN-END:variables
}
