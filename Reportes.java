/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mirna
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        listarCitasAtendidas();
        listarCitasPendientes();
        listarMontoGeneral();
        listarDoctoresActivos();
        listarCitas();
        
    }
    public void listarCitasAtendidas(){
        CitasDatos doc= new CitasDatos();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int cont=0;
        
        for(int i=0; i<doc.citas.size();i++){
          
            if(doc.citas.get(i)!=null && doc.citas.get(i).getEstadoCita().equals("ATENDIDA")){
                cont++;   
            }
        }
         model.addRow(new Object[]{"Citas atendidas",cont});
    }
    public void listarCitasPendientes(){
        CitasDatos doc= new CitasDatos();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int cont=0;
        
        for(int i=0; i<doc.citas.size();i++){
          
            if(doc.citas.get(i)!=null && doc.citas.get(i).getEstadoCita().equals("PENDIENTE")){
                cont++;   
            }
        }
         model.addRow(new Object[]{"Citas pendientes",cont});
    }
    public void listarMontoGeneral(){
        CitasDatos doc= new CitasDatos();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int suma=0;
        
        for(int i=0; i<doc.citas.size();i++){
          
            if(doc.citas.get(i)!=null){
                suma+=doc.citas.get(i).getMontoCita();   
            }
        }
         model.addRow(new Object[]{"Monto Total",suma});
    }
    public void listarDoctoresActivos(){
        DoctoresDatos doc= new DoctoresDatos();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int cont=0;
        
        for(int i=0; i<doc.doctores.size();i++){
          
            if(doc.doctores.get(i)!=null && doc.doctores.get(i).isActivo()){
                cont++;   
            }
        }
         model.addRow(new Object[]{"Doctores Activos",cont});
    }
    public void listarCitas(){
    CitasDatos citas= new CitasDatos();
        DoctoresDatos doc=new DoctoresDatos();
        PacientesDatos pac=new PacientesDatos();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
       
        for(int i=0; i<citas.citas.size();i++){
        DoctoresDatos doctor=doc.findUserByCode(citas.findCitaByCode(citas.citas.get(i).getCodigoCita()).getCodigoDoctor());
        PacientesDatos paciente=pac.findPacByCode(citas.findCitaByCode(citas.citas.get(i).getCodigoCita()).getCodigoPaciente());
        Date today = new Date();
        Date endDate = citas.citas.get(i).fecha;
            System.out.println(endDate);
            System.out.println(today);

            if(citas.citas.get(i)!=null && endDate.before(today)){
                
                model.addRow(new Object[]{citas.citas.get(i).getCodigoCita(),doctor.getNombreCompleto()+"-"+doctor.getCodigoSecuencial(),paciente.getNombreCompleto()+"-"+paciente.getCódigoSecuencial(),
                citas.citas.get(i).getFecha(),citas.citas.get(i).getDescripcion(),citas.citas.get(i).getTipoCita(),citas.citas.get(i).getEstadoCita(),citas.citas.get(i).getMontoCita()});
            }
        }
   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REPORTES");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Estadistica"
            }
        ));
        jScrollPane1.setViewportView(table);

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Cita", "Doctor", "Paciente", "Tipo de cita", "Estado"
            }
        ));
        jScrollPane2.setViewportView(table2);

        jButton1.setText("Regresar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        MenuPrincipal menu= new MenuPrincipal();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}