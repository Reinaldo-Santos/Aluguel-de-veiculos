package br.com.telas;

import java.awt.Color;
import javax.swing.JOptionPane;
import br.com.bancoDeDados.Conectar_com_banco_de_dadaos;
import java.sql.*;

/**
 *
 * @author Reinaldo Santos
 */
public class Login extends javax.swing.JFrame {

    Connection conectar = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void logar() {
        String logue = "select * from funcionario where login = ? and senha = ?";
        try {
            pst = conectar.prepareStatement(logue);
            pst.setString(1, jTextFieldNomeDoUsuario.getText());
            pst.setString(2, jPasswordFieldSenhaDoUsuario.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String perfil = rs.getString(7);
                System.out.println(perfil);
                this.dispose();
                if (perfil.equals("Administrador")) {
                    Tela_principal tela1 = new Tela_principal();
                    tela1.setVisible(true);
                    Tela_principal.jMenuCadastro.setEnabled(true);
                    Tela_principal.jMenuItemAtomovel.setEnabled(true);
                    Tela_principal.jMenuItemCliente.setEnabled(true);
                    Tela_principal.jMenuVeiculo.setEnabled(true);
                    Tela_principal.jMenuOpcao.setEnabled(true);
                    Tela_principal.jMenuItemSair.setEnabled(true);
                    Tela_principal.jLabelNomeDoUsuario.setText(rs.getNString(2));
                    Tela_principal.jLabelNomeDoUsuario.setForeground(Color.yellow);
                    Tela_principal.jLabelData.setForeground(Color.yellow);
                    Tela_principal.jLabelData1.setForeground(Color.yellow);
                    Tela_principal.jLabelCargo.setForeground(Color.yellow);
                    Tela_principal.jLabelCargo.setText(perfil);

                } else if (perfil.equals("Atendente")) {
                    Tela_principal tela1 = new Tela_principal();
                    tela1.setVisible(true);
                    Tela_principal.jMenuCadastro.setEnabled(false);
                    Tela_principal.jMenuItemAtomovel.setEnabled(false);
                    Tela_principal.jMenuItemCliente.setEnabled(false);
                    Tela_principal.jMenuVeiculo.setEnabled(true);
                    Tela_principal.jMenuOpcao.setEnabled(true);
                    Tela_principal.jMenuItemSair.setEnabled(true);
                    Tela_principal.jLabelNomeDoUsuario.setText(rs.getNString(2));
                    Tela_principal.jLabelNomeDoUsuario.setForeground(Color.MAGENTA);
                    Tela_principal.jLabelData.setForeground(Color.MAGENTA);
                    Tela_principal.jLabelCargo.setForeground(Color.MAGENTA);
                    Tela_principal.jLabelCargo.setText(perfil);
                    Tela_principal.jLabelData1.setForeground(Color.MAGENTA);
                    
                }
                 else if (perfil.equals("Gerente")) {
                    Tela_principal tela1 = new Tela_principal();
                    tela1.setVisible(true);
                    Tela_principal.jMenuCadastro.setEnabled(true);
                    Tela_principal.jMenuItemAtomovel.setEnabled(true);
                    Tela_principal.jMenuItemCliente.setEnabled(true);
                    Tela_principal.jMenuVeiculo.setEnabled(true);
                    Tela_principal.jMenuOpcao.setEnabled(true);
                    Tela_principal.jMenuItemSair.setEnabled(true);
                    Tela_principal.jLabelNomeDoUsuario.setText(rs.getNString(2));
                    Tela_principal.jLabelNomeDoUsuario.setForeground(Color.MAGENTA);
                    Tela_principal.jLabelData.setForeground(Color.MAGENTA);
                    Tela_principal.jLabelCargo.setForeground(Color.MAGENTA);
                    Tela_principal.jLabelCargo.setText(perfil);
                    Tela_principal.jLabelData1.setForeground(Color.MAGENTA);
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Ou Senha inválido");
            }

        } catch (java.lang.NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Conecte-se ao servidor");
            System.out.println("E: " + e);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            System.out.println("E: " + e);
        }
    }

    public Login() {
        initComponents();
         conectar = Conectar_com_banco_de_dadaos.conexao();
        System.out.println(conectar);
        if (conectar != null) {
            jLabelStatusDoLogin.setVisible(false);
        } else {
            jLabelStatusDoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/Bx.png")));
            jButtonEnter.setVisible(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomeDoUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordFieldSenhaDoUsuario = new javax.swing.JPasswordField();
        jButtonEnter = new javax.swing.JButton();
        jLabelStatusDoLogin = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Sheet Rent Car");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 239, 44);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Locadora de carros");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 40, 160, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Login:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 130, 50, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(260, 200, 60, 20);

        jTextFieldNomeDoUsuario.setBackground(new java.awt.Color(244, 244, 244));
        jTextFieldNomeDoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNomeDoUsuario.setForeground(new java.awt.Color(0, 0, 102));
        jTextFieldNomeDoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        jTextFieldNomeDoUsuario.setFocusCycleRoot(true);
        getContentPane().add(jTextFieldNomeDoUsuario);
        jTextFieldNomeDoUsuario.setBounds(260, 150, 130, 30);

        jLabel6.setBackground(new java.awt.Color(0, 0, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Sheet Rent Car");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 250, 45);

        jPasswordFieldSenhaDoUsuario.setForeground(new java.awt.Color(0, 0, 102));
        jPasswordFieldSenhaDoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        jPasswordFieldSenhaDoUsuario.setMinimumSize(new java.awt.Dimension(3, 19));
        getContentPane().add(jPasswordFieldSenhaDoUsuario);
        jPasswordFieldSenhaDoUsuario.setBounds(260, 220, 130, 30);

        jButtonEnter.setText("Entrar");
        jButtonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEnter);
        jButtonEnter.setBounds(280, 263, 80, 30);

        jLabelStatusDoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/Bx.png"))); // NOI18N
        getContentPane().add(jLabelStatusDoLogin);
        jLabelStatusDoLogin.setBounds(290, 240, 60, 60);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/gg.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, -10, 430, 320);

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnterActionPerformed
        // TODO add your handling code here:
        logar();
    }//GEN-LAST:event_jButtonEnterActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelStatusDoLogin;
    private javax.swing.JPasswordField jPasswordFieldSenhaDoUsuario;
    private javax.swing.JTextField jTextFieldNomeDoUsuario;
    // End of variables declaration//GEN-END:variables
}
