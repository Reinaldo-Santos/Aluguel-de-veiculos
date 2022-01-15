/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.telas;

import br.com.bancoDeDados.Conectar_com_banco_de_dadaos;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Reinaldo Santos
 */
public class TelaFuncionario extends javax.swing.JInternalFrame {

    Connection conectar = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaFuncionario() {
        initComponents();
        conectar = Conectar_com_banco_de_dadaos.conexao();
    }
    private void PesquisarFuncionario() {
        String consultar = "select * from funcionario where CPF=?";
        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextFieldCPF.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                jTextFieldMatriclula.setText(rs.getString(1));
                jTextFieldNome.setText(rs.getString(2));
                jTextFieldRG.setText(rs.getString(3));
                jTextFieldCPF.setText(rs.getString(4));
                jTextFieldEndereco.setText(rs.getString(5));
                jTextFieldTelefone.setText(rs.getString(6));
                jComboBoxPerfil.setSelectedItem(rs.getString(7));
                jTextFieldLogin.setText(rs.getString(8));
                jTextFieldSenha.setText(rs.getString(9));
                jTextFieldEmail.setText(rs.getString(10));
                jLabelAdicionar.setEnabled(false);
                jLabelAdicionar.setToolTipText("Você não pode adicionar este funcionário pois ele já existe");

            } else {
                JOptionPane.showMessageDialog(null, "Usuario inexistente");
                jTextFieldNome.setText("");
                jTextFieldEndereco.setText("");
                jTextFieldTelefone.setText("");
                jTextFieldEmail.setText("");
                jTextFieldLogin.setText("");
                jTextFieldSenha.setText("");
                jComboBoxPerfil.setSelectedItem("");
                jTextFieldCPF.setText("");
                jTextFieldRG.setText("");
                jLabelAdicionar.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void atualizarFuncionario() {
        String atualizar = "update funcionario set nome=?,endereco=?,telefone=?,email=?,login=?,senha=?,perfil=?,cpf=?,rg=? where matricula=? ";
        try {
            pst = conectar.prepareStatement(atualizar);
            pst.setString(1, jTextFieldNome.getText());
            pst.setString(2, jTextFieldEndereco.getText());
            pst.setString(3, jTextFieldTelefone.getText());
            pst.setString(4, jTextFieldEmail.getText());
            pst.setString(5, jTextFieldLogin.getText());
            pst.setString(6, jTextFieldSenha.getText());
            pst.setString(7, jComboBoxPerfil.getSelectedItem().toString());
            pst.setString(8, jTextFieldCPF.getText());
            pst.setString(9, jTextFieldRG.getText());
            pst.setString(10, jTextFieldMatriclula.getText());
      
           
            if (jTextFieldNome.getText().isEmpty() || jTextFieldEndereco.getText().isEmpty()
                    || jTextFieldEmail.getText().isEmpty()|| jTextFieldCPF.getText().isEmpty()
                    || jTextFieldRG.getText().isEmpty()|| jComboBoxPerfil.getSelectedItem().toString().isEmpty()
                    || jTextFieldLogin.getText().isEmpty()|| jTextFieldSenha.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos Obrigatórios!\nEstão sinalizados com '*' astericos ");
            } else {

                int c = pst.executeUpdate();
                if (c > 0) {
                    JOptionPane.showMessageDialog(null, jTextFieldNome.getText() + "\n Foi alterado com sussesso. ");
                    jTextFieldNome.setText("");
                    jTextFieldEndereco.setText("");
                    jTextFieldTelefone.setText("");
                    jTextFieldEmail.setText("");
                    jTextFieldLogin.setText("");
                    jTextFieldSenha.setText("");
                    jComboBoxPerfil.setSelectedItem(null);
                    jTextFieldCPF.setText("");
                    jTextFieldRG.setText("");
                    jTextFieldMatriclula.setText("");
                    jLabelAdicionar.setEnabled(true);
                    
                } else {

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void adicinarNovoFuncionario() {
        String inserirDados = "insert into funcionario(nome,endereco,telefone,email,login,senha,perfil,cpf,rg) values(?,?,?,?,?,?,?,?,?)";
        try {
            //REINALDO há um problema em relação ao Id que deve ser informado ao usuário!!!!!!! ATENÇÃo
            pst = conectar.prepareStatement(inserirDados);
            //pst.setString(1, jTextFieldMatriclula.getText());
            pst.setString(1, jTextFieldNome.getText());
            pst.setString(2, jTextFieldEndereco.getText());
            pst.setString(3, jTextFieldTelefone.getText());
            pst.setString(4, jTextFieldEmail.getText());
            pst.setString(5, jTextFieldLogin.getText());
            pst.setString(6, jTextFieldSenha.getText());
            pst.setString(7, jComboBoxPerfil.getSelectedItem().toString());
            pst.setString(8, jTextFieldCPF.getText());
            pst.setString(9, jTextFieldRG.getText());
            
            if (jTextFieldNome.getText().isEmpty() || jTextFieldEndereco.getText().isEmpty()
                    || jTextFieldEmail.getText().isEmpty()|| jTextFieldCPF.getText().isEmpty()
                    || jTextFieldRG.getText().isEmpty()|| jComboBoxPerfil.getSelectedItem().toString().isEmpty()
                    || jTextFieldLogin.getText().isEmpty()|| jTextFieldSenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos Obrigatórios!\nEstão sinalizados com '*' astericos ");
            } else {

                int confirmarInsercaoDeDados = pst.executeUpdate();
                if (confirmarInsercaoDeDados > 0) {
                    JOptionPane.showMessageDialog(null, jTextFieldNome.getText() + "\n Foi adicionado com sussesso. ");
                    jTextFieldNome.setText("");
                    jTextFieldEndereco.setText("");
                    jTextFieldTelefone.setText("");
                    jTextFieldEmail.setText("");
                    jTextFieldLogin.setText("");
                    jTextFieldSenha.setText("");
                    jComboBoxPerfil.setSelectedItem(null);
                    jTextFieldCPF.setText("");
                    jTextFieldRG.setText("");
                    jTextFieldMatriclula.setText("");
                    
                } else {

                }
            }
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Este número de matricula Já exixte"); 
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           
        }
    }   
    private void ExcluirFuncionario() {
        int ap = JOptionPane.showConfirmDialog(null, "Os dados apagados não poderão ser recuperados\nTem certeza que deseja apagá-lo? ", "Atenção", JOptionPane.YES_NO_OPTION);
        if (ap == 0) {

            String a = "delete from funcionario where matricula=? ";

            try {
                pst = conectar.prepareStatement(a);
                pst.setString(1, jTextFieldMatriclula.getText());
               int confg= pst.executeUpdate();
               if(confg>0){
               jTextFieldNome.setText("");
                    jTextFieldEndereco.setText("");
                    jTextFieldTelefone.setText("");
                    jTextFieldEmail.setText("");
                    jTextFieldLogin.setText("");
                    jTextFieldSenha.setText("");
                    jComboBoxPerfil.setSelectedItem(null);
                    jTextFieldCPF.setText("");
                    jTextFieldRG.setText("");
                    jTextFieldMatriclula.setText("");
               }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
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

        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldMatriclula = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldRG = new javax.swing.JTextField();
        jTextFieldCPF = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldSenha = new javax.swing.JTextField();
        jLabelAdicionar = new javax.swing.JLabel();
        jLabelExcluir = new javax.swing.JLabel();
        jLabelAtualizar = new javax.swing.JLabel();
        jLabelPesquisar = new javax.swing.JLabel();
        jComboBoxPerfil = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel12.setText("jLabel12");

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Funcionário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1018, 680));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("*Matricula");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 60, 110, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("*Nome");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(23, 100, 70, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("*RG");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 140, 50, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("*CPF");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 170, 60, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("*Edereço");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 210, 90, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 51));
        jLabel6.setText("Telefone");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 250, 90, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 51));
        jLabel7.setText("Perfil");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 300, 60, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 51));
        jLabel8.setText("Senha");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 380, 70, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 51));
        jLabel9.setText("* Campo obrigatorio");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(380, 10, 216, 29);

        jTextFieldMatriclula.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jTextFieldMatriclula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMatriclulaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldMatriclula);
        jTextFieldMatriclula.setBounds(100, 50, 240, 30);

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNome);
        jTextFieldNome.setBounds(100, 90, 240, 30);

        jTextFieldRG.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        getContentPane().add(jTextFieldRG);
        jTextFieldRG.setBounds(100, 130, 240, 30);

        jTextFieldCPF.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        getContentPane().add(jTextFieldCPF);
        jTextFieldCPF.setBounds(100, 170, 240, 30);

        jTextFieldEndereco.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jTextFieldEndereco.setMinimumSize(new java.awt.Dimension(7, 30));
        jTextFieldEndereco.setPreferredSize(new java.awt.Dimension(7, 30));
        jTextFieldEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldEndereco);
        jTextFieldEndereco.setBounds(100, 210, 240, 30);

        jTextFieldTelefone.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        getContentPane().add(jTextFieldTelefone);
        jTextFieldTelefone.setBounds(100, 250, 240, 30);

        jTextFieldSenha.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        getContentPane().add(jTextFieldSenha);
        jTextFieldSenha.setBounds(100, 370, 240, 30);

        jLabelAdicionar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoAdcionar.png"))); // NOI18N
        jLabelAdicionar.setText("                           ");
        jLabelAdicionar.setToolTipText("Adicionar");
        jLabelAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdicionarMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelAdicionar);
        jLabelAdicionar.setBounds(30, 460, 90, 77);

        jLabelExcluir.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoExcluir.png"))); // NOI18N
        jLabelExcluir.setToolTipText("Excluir");
        jLabelExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExcluirMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelExcluir);
        jLabelExcluir.setBounds(350, 460, 84, 77);

        jLabelAtualizar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoUpdate.png"))); // NOI18N
        jLabelAtualizar.setToolTipText("Atualizar");
        jLabelAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtualizarMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelAtualizar);
        jLabelAtualizar.setBounds(140, 460, 84, 77);

        jLabelPesquisar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoPesquisa.png"))); // NOI18N
        jLabelPesquisar.setToolTipText("Pesquizar");
        jLabelPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPesquisarMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelPesquisar);
        jLabelPesquisar.setBounds(240, 460, 84, 77);

        jComboBoxPerfil.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jComboBoxPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "         ", "Administrador", "Gerente", "Atendente" }));
        jComboBoxPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxPerfil);
        jComboBoxPerfil.setBounds(100, 290, 240, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("Email");
        jLabel10.setPreferredSize(new java.awt.Dimension(57, 22));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 410, 60, 30);

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        getContentPane().add(jTextFieldEmail);
        jTextFieldEmail.setBounds(100, 410, 240, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("login");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(40, 330, 110, 30);

        jTextFieldLogin.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        getContentPane().add(jTextFieldLogin);
        jTextFieldLogin.setBounds(100, 330, 240, 30);

        jLabel14.setText("Reiando c Santos");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 620, 100, 14);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/carro1.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -10, 1040, 710);

        setBounds(0, 0, 1018, 680);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMatriclulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMatriclulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMatriclulaActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoActionPerformed

    private void jLabelPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisarMouseClicked
        // TODO add your handling code here:
        PesquisarFuncionario();
    }//GEN-LAST:event_jLabelPesquisarMouseClicked

    private void jLabelAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtualizarMouseClicked
        // TODO add your handling code here:
        atualizarFuncionario();
    }//GEN-LAST:event_jLabelAtualizarMouseClicked

    private void jComboBoxPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPerfilActionPerformed

    private void jLabelAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdicionarMouseClicked
        // TODO add your handling code here:
        adicinarNovoFuncionario();
    }//GEN-LAST:event_jLabelAdicionarMouseClicked

    private void jLabelExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExcluirMouseClicked
        // TODO add your handling code here:
        ExcluirFuncionario();
    }//GEN-LAST:event_jLabelExcluirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAdicionar;
    private javax.swing.JLabel jLabelAtualizar;
    private javax.swing.JLabel jLabelExcluir;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldMatriclula;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldRG;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
