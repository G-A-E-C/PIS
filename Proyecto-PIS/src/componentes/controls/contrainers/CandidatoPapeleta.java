package componentes.controls.contrainers;

import java.awt.Color;

public class CandidatoPapeleta extends javax.swing.JPanel {

    private String dni;
    private boolean seleccion = false;

    public CandidatoPapeleta() {
        initComponents();
    }

    public void cargarDatos(String c1, String c2, String partido, int lista, String d1, String d2, String dni) {
        lbPartido.setText(partido);
        lbLista.setText(lista + "");
        lbDignidadUno.setText(d1);
        lbNombreDigUno.setText(c1);
        lbDignidadDos.setText(d2);
        lbNombreDigDos.setText(c2);
        this.dni = dni;
    }

    public String candidato() {
        return dni;
    }

    public boolean seleccion() {
        return seleccion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbPartido = new componentes.controls.Label();
        lbLista = new componentes.controls.Label();
        jLabel1 = new javax.swing.JLabel();
        lbDignidadUno = new componentes.controls.Label();
        lbNombreDigUno = new componentes.controls.Label();
        lbDignidadDos = new componentes.controls.Label();
        lbNombreDigDos = new componentes.controls.Label();

        setBackground(new java.awt.Color(249, 252, 253));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbPartido.setForeground(new java.awt.Color(51, 51, 51));
        lbPartido.setText("Partido Politico");
        lbPartido.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        lbLista.setText("Nro Lista");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/partido.png"))); // NOI18N

        lbDignidadUno.setText("Presidente");

        lbNombreDigUno.setText("Nombre Candidato");
        lbNombreDigUno.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        lbDignidadDos.setText("Vicepresidente");

        lbNombreDigDos.setText("Nombre Candidato");
        lbNombreDigDos.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPartido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDignidadUno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNombreDigUno, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(lbDignidadDos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNombreDigDos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(lbDignidadUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNombreDigUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDignidadDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNombreDigDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if(seleccion){
            seleccion = false;
            setBackground(new Color(249,252,253));
        } else {
            seleccion = true;
            setBackground(new Color(186,226,228));
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private componentes.controls.Label lbDignidadDos;
    private componentes.controls.Label lbDignidadUno;
    private componentes.controls.Label lbLista;
    private componentes.controls.Label lbNombreDigDos;
    private componentes.controls.Label lbNombreDigUno;
    private componentes.controls.Label lbPartido;
    // End of variables declaration//GEN-END:variables
}
