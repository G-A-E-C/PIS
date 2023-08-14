package componentes.controls.contrainers;

import controlador.dao.DaoPadronElectoral;
import controlador.dao.DaoPersona;
import controlador.dao.DaoVotante;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.Info;

public class FormVotante extends javax.swing.JPanel {
    
    public FormVotante() {
        initComponents();
        initCombos();
    }
    
    private void initCombos() {
        var padrones = new DaoPadronElectoral().listar().toArray();
        cbPadron.removeAllItems();
        
        if(padrones == null) return;
        
        for (int i = 0; i < padrones.length; i++) {
            cbPadron.addItem(padrones[i].getNombre());
        }
    }
    
    private void guardar() {
        String dni = txtDni.getText();
        String nombre = txtNombres.getText();
        String apellido = txtApellidos.getText();
        String nacimiento = txtNacimiento.getText();
        int padron = new DaoPadronElectoral().buscar("nombre", cbPadron.getSelectedItem().toString()).getId();
        
        if (!validar(nacimiento, "\\d{4}-\\d{2}-\\d{2}")) {
            Info.showInfo("El campo fecha no coincide con el formato 'aaaa-mm-dd'", 0);
            return;
        }
        
        var nombres = nombre.split(" ");
        var apellidos = apellido.split(" ");
        
        if (nombres.length != 2 || apellidos.length != 2) {
            Info.showInfo("Ingrese nombres y apellidos completos", 0);
            return;
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            Date fecha = dateFormat.parse(nacimiento);
            new DaoPersona().registrarPersona(dni, nombres[0], nombres[1], apellidos[0], apellidos[1], fecha);
            new DaoVotante().registrarVotante(dni, padron);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    private boolean validar(String input, String regex) {
        
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(input);
        
        return matcher.matches();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new componentes.controls.Label();
        label2 = new componentes.controls.Label();
        txtDni = new componentes.controls.TextField();
        btnCrear = new componentes.controls.Button();
        label6 = new componentes.controls.Label();
        cbPadron = new componentes.controls.Combo();
        label3 = new componentes.controls.Label();
        txtNombres = new componentes.controls.TextField();
        Apellidos = new componentes.controls.Label();
        txtApellidos = new componentes.controls.TextField();
        label5 = new componentes.controls.Label();
        txtNacimiento = new componentes.controls.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("CANDIDATO");
        label1.setFont(new java.awt.Font("Microsoft JhengHei Ui", 1, 18)); // NOI18N

        label2.setText("Dni");
        label2.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        txtDni.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        btnCrear.setBackground(new java.awt.Color(199, 231, 233));
        btnCrear.setText("Crear");
        btnCrear.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnCrear.setRippleColor(new java.awt.Color(255, 255, 255));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        label6.setText("Padrón Electoral");
        label6.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        cbPadron.setBackground(new java.awt.Color(199, 231, 233));
        cbPadron.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        label3.setText("Nombres");
        label3.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        txtNombres.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        Apellidos.setText("Apellidos");
        Apellidos.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        txtApellidos.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        label5.setText("Fecha Nacimiento");
        label5.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        txtNacimiento.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cbPadron, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPadron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.controls.Label Apellidos;
    private componentes.controls.Button btnCrear;
    private componentes.controls.Combo cbPadron;
    private componentes.controls.Label label1;
    private componentes.controls.Label label2;
    private componentes.controls.Label label3;
    private componentes.controls.Label label5;
    private componentes.controls.Label label6;
    private componentes.controls.TextField txtApellidos;
    private componentes.controls.TextField txtDni;
    private componentes.controls.TextField txtNacimiento;
    private componentes.controls.TextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
