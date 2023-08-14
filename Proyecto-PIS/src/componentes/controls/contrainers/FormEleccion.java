package componentes.controls.contrainers;

import controlador.dao.DaoEleccion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.Horas;
import util.Info;

public class FormEleccion extends javax.swing.JPanel {

    public FormEleccion() {
        initComponents();
        initCombo();
    }

    private void initCombo() {
        cbInicio.removeAllItems();

        cbFinal.removeAllItems();

        for (var h : Horas.values()) {
            cbInicio.addItem(h.formato);
            cbFinal.addItem(h.formato);
        }

    }

    private int hora(String hora) {
        for (var h : Horas.values()) {
            if (h.formato.equals(hora)) {
                return h.valor;
            }
        }

        return -1;
    }

    private void guardar() {
        String nombre = txtNombre.getText();
        String fecha = txtFecha.getText();
        String periodo = txtPeriodo.getText();
        String hInicio = cbInicio.getSelectedItem().toString();
        String hFinal = cbFinal.getSelectedItem().toString();

        if (!validar(fecha, "\\d{4}-\\d{2}-\\d{2}")) {
            Info.showInfo("El campo fecha no coincide con el formato 'aaaa-mm-dd'", 0);
            return;
        }

        if (!validar(periodo, "\\d{4}-\\d{4}")) {
            Info.showInfo("El campo período no coincide con el formato 'aaaa-aaaa'", 0);
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date fInicio = dateFormat.parse(fecha);
            Date fFinal = dateFormat.parse(fecha);

            fInicio.setHours(hora(hInicio));
            fFinal.setHours(hora(hFinal));

            new DaoEleccion().crearEleccion(nombre, fInicio, fFinal, periodo);
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
        txtNombre = new componentes.controls.TextField();
        label3 = new componentes.controls.Label();
        txtPeriodo = new componentes.controls.TextField();
        label4 = new componentes.controls.Label();
        txtFecha = new componentes.controls.TextField();
        label5 = new componentes.controls.Label();
        cbInicio = new componentes.controls.Combo();
        label6 = new componentes.controls.Label();
        cbFinal = new componentes.controls.Combo();
        btnCrear = new componentes.controls.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("ELECCIÓN");
        label1.setFont(new java.awt.Font("Microsoft JhengHei Ui", 1, 24)); // NOI18N

        label2.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N

        label3.setText("Período");

        txtPeriodo.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N

        label4.setText("Fecha");

        txtFecha.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N

        label5.setText("Inicio");

        cbInicio.setBackground(new java.awt.Color(199, 231, 233));
        cbInicio.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N

        label6.setText("Final");

        cbFinal.setBackground(new java.awt.Color(199, 231, 233));
        cbFinal.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N

        btnCrear.setBackground(new java.awt.Color(199, 231, 233));
        btnCrear.setText("Crear");
        btnCrear.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        btnCrear.setRippleColor(new java.awt.Color(255, 255, 255));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.controls.Button btnCrear;
    private componentes.controls.Combo cbFinal;
    private componentes.controls.Combo cbInicio;
    private componentes.controls.Label label1;
    private componentes.controls.Label label2;
    private componentes.controls.Label label3;
    private componentes.controls.Label label4;
    private componentes.controls.Label label5;
    private componentes.controls.Label label6;
    private componentes.controls.TextField txtFecha;
    private componentes.controls.TextField txtNombre;
    private componentes.controls.TextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
