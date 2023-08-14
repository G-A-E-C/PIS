package vista;

import controlador.ControladorCuenta;
import controlador.ControladorEleccion;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.Info;

public class FrmLogin extends javax.swing.JFrame {

    private final ControladorCuenta controlador = new ControladorCuenta();
    private ControladorEleccion controladorEleccion = new ControladorEleccion();

    public FrmLogin() {
        initComponents();
        pnRegistro.setVisible(false);
    }

    private void login() {
        String usuario = txtDni.getText();
        String clave = txtClave.getText();

        if (controlador.login(usuario, clave)) {
            // mostrar el siguiente frm
            if (!Info.verificarHora(controladorEleccion.fechaEleccion(), controladorEleccion.inicial(), controladorEleccion.fin())) {
                Info.showInfo("La eleccion no esta disponible", 0);
                return;
            }
            controlador.cargarVotante(usuario);
            if (controlador.estadoVotante()) {
                Info.showInfo("Ya realizo su voto", 0);
                return;
            }
            if (controlador.rol(usuario) == 1) {
                new FrmPanel(controlador).setVisible(true);
                this.dispose();
            } else {
                new FrmAdministracion().setVisible(true);
                this.dispose();
            }
            return;
        }

        Info.showInfo("No existe la cuenta", 0);
    }

    private void cleanAll() {
        txtDni.setText("");
        txtClave.setText("");
        txtDniRegistro.setText("");
        txtClaveRegistro.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }

    private void registrar() {

        String dni = txtDniRegistro.getText();
        String clave = txtClaveRegistro.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();

        if (!verificarCampos(telefono, email)) {
            return;
        }

        if (!controlador.esApto(dni)) {
            Info.showInfo("NO es apto para la votacion", 0);
            return;
        }

        if (controlador.existeCuenta(dni)) {
            Info.showInfo("La cuenta ya existe", 0);
            return;
        }

        if (!controlador.registrar(dni, clave, telefono, email)) {
            Info.showInfo("Error en el registro", 0);
            return;
        }

        Info.showInfo("Cuenta registrada", 1);

        cleanAll();
        pnLogin.setVisible(true);
        pnRegistro.setVisible(false);
    }

    private boolean verificarCampos(String telefono, String email) {

        var campoTelefono = validar(telefono, "^\\d{9}$");
        var campoEmail = validar(email, "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        if (campoEmail && campoTelefono) {
            return true;
        }

        if (!campoEmail && !campoTelefono) {
            // mostar mensaje de que los dos campos estan mal
            Info.showInfo("Los campos Correo Electrónico y Teléfono no son validos", 0);
            return false;
        }

        if (campoEmail && !campoTelefono) {
            // mostar mensaje de que el email esta mal
            Info.showInfo("El campo Telefono no es validos", 0);
            return false;
        }

        if (!campoEmail && campoTelefono) {
            // mostar mensaje de que el telefono esta mal
            Info.showInfo("El campo Correo Electrónico no es validos", 0);
            return false;
        }

        return false;
    }

    private boolean validar(String input, String regex) {

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnRegistro = new javax.swing.JPanel();
        label6 = new componentes.controls.Label();
        txtDniRegistro = new componentes.controls.TextField();
        label7 = new componentes.controls.Label();
        label8 = new componentes.controls.Label();
        label9 = new componentes.controls.Label();
        txtTelefono = new componentes.controls.TextField();
        label10 = new componentes.controls.Label();
        txtEmail = new componentes.controls.TextField();
        btnRegistro = new componentes.controls.Button();
        label11 = new componentes.controls.Label();
        btnIngresar = new componentes.controls.Button();
        txtClaveRegistro = new componentes.controls.PassField();
        button1 = new componentes.controls.Button();
        pnLogin = new javax.swing.JPanel();
        label1 = new componentes.controls.Label();
        label2 = new componentes.controls.Label();
        txtDni = new componentes.controls.TextField();
        label3 = new componentes.controls.Label();
        label4 = new componentes.controls.Label();
        btnLogin = new componentes.controls.Button();
        label5 = new componentes.controls.Label();
        btnRegistrate = new componentes.controls.Button();
        txtClave = new componentes.controls.PassField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(199, 231, 233));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnRegistro.setBackground(new java.awt.Color(255, 255, 255));
        pnRegistro.setPreferredSize(new java.awt.Dimension(460, 520));

        label6.setForeground(new java.awt.Color(0, 0, 0));
        label6.setText("Registro");
        label6.setFont(new java.awt.Font("Microsoft JhengHei Ui", 1, 24)); // NOI18N

        txtDniRegistro.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        label7.setText("Dni");
        label7.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        label8.setText("Contraseña");
        label8.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        label9.setText("Telefono");
        label9.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        label10.setText("Correo Electronico");
        label10.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        btnRegistro.setBackground(new java.awt.Color(199, 231, 233));
        btnRegistro.setText("Registrarse");
        btnRegistro.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnRegistro.setRippleColor(new java.awt.Color(255, 255, 255));
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        label11.setText("Ya tienes cuenta?");
        label11.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        btnIngresar.setBackground(new java.awt.Color(249, 252, 253));
        btnIngresar.setText("Ingresar");
        btnIngresar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnIngresar.setRippleColor(new java.awt.Color(255, 255, 255));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRegistroLayout = new javax.swing.GroupLayout(pnRegistro);
        pnRegistro.setLayout(pnRegistroLayout);
        pnRegistroLayout.setHorizontalGroup(
            pnRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRegistroLayout.createSequentialGroup()
                .addGroup(pnRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRegistroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnRegistroLayout.createSequentialGroup()
                        .addGroup(pnRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnRegistroLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnRegistroLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(pnRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtClaveRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDniRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnRegistroLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(pnRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnRegistroLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        pnRegistroLayout.setVerticalGroup(
            pnRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDniRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClaveRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        button1.setBackground(new java.awt.Color(255, 160, 179));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        pnLogin.setBackground(new java.awt.Color(255, 255, 255));

        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("Bienvenido a eVote");
        label1.setFont(new java.awt.Font("Microsoft JhengHei Ui", 1, 24)); // NOI18N

        label2.setText("Registra tu voto");

        txtDni.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        label3.setText("Dni");
        label3.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        label4.setText("Contraseña");
        label4.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        btnLogin.setBackground(new java.awt.Color(199, 231, 233));
        btnLogin.setText("Ingresar");
        btnLogin.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnLogin.setRippleColor(new java.awt.Color(255, 255, 255));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        label5.setText("No tienes cuenta?");
        label5.setFont(new java.awt.Font("Microsoft JhengHei Ui", 0, 12)); // NOI18N

        btnRegistrate.setBackground(new java.awt.Color(249, 252, 253));
        btnRegistrate.setText("Registrate");
        btnRegistrate.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnRegistrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLoginLayout = new javax.swing.GroupLayout(pnLogin);
        pnLogin.setLayout(pnLoginLayout);
        pnLoginLayout.setHorizontalGroup(
            pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginLayout.createSequentialGroup()
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnLoginLayout.createSequentialGroup()
                        .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnLoginLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnLoginLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnLoginLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLoginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnLoginLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        pnLoginLayout.setVerticalGroup(
            pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegistrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrateActionPerformed
        // TODO add your handling code here:
        pnRegistro.setVisible(true);
        pnLogin.setVisible(false);
    }//GEN-LAST:event_btnRegistrateActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        pnRegistro.setVisible(false);
        pnLogin.setVisible(true);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.controls.Button btnIngresar;
    private componentes.controls.Button btnLogin;
    private componentes.controls.Button btnRegistrate;
    private componentes.controls.Button btnRegistro;
    private componentes.controls.Button button1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private componentes.controls.Label label1;
    private componentes.controls.Label label10;
    private componentes.controls.Label label11;
    private componentes.controls.Label label2;
    private componentes.controls.Label label3;
    private componentes.controls.Label label4;
    private componentes.controls.Label label5;
    private componentes.controls.Label label6;
    private componentes.controls.Label label7;
    private componentes.controls.Label label8;
    private componentes.controls.Label label9;
    private javax.swing.JPanel pnLogin;
    private javax.swing.JPanel pnRegistro;
    private componentes.controls.PassField txtClave;
    private componentes.controls.PassField txtClaveRegistro;
    private componentes.controls.TextField txtDni;
    private componentes.controls.TextField txtDniRegistro;
    private componentes.controls.TextField txtEmail;
    private componentes.controls.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
