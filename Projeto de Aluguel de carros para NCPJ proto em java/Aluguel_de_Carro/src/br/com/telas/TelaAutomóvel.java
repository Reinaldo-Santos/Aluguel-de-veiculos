/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.telas;

import java.awt.Color;
import javax.swing.*;
import br.com.bancoDeDados.Conectar_com_banco_de_dadaos;
import java.sql.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Reinaldo Santos
 */
public class TelaAutomóvel extends javax.swing.JInternalFrame {
//Reinald vc precisa colocar uma chave estrangeira do veiculo no checkListe para poder associar o carro a lita.

    
    Connection conectar = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String ddd, j, modelo;
    boolean ab;

    public JCheckBox escreve_SIM_ou_NAO_no_jcheckbox(JCheckBox j) {
        String nao = "Não", sim = "Ok";

        if (j.getText().equals(sim)) {
            j.setSelected(true);
        } else {
            j.setSelected(false);
        }
        return j;
    }

    public TelaAutomóvel() {
        initComponents();
        conectar = Conectar_com_banco_de_dadaos.conexao();
        jPanel1.setVisible(false);
        jPanel1.setBackground(new Color(0, 0, 255, 100));
        jPanel2.setBackground(new Color(0, 0, 0, 0));
        jTextAreaObservações.setWrapStyleWord(true);
        jTextAreaObservações.setLineWrap(true);
        
    }

    public void TelaInicial() {

        jTextField1.setText(null);
        //jTextField1.setEditable(true);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField3.setEditable(true);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        MatriculaDoFuncionario.setText(null);
        jTextField10.setText(null);
        jTextAreaObservações.setText(null);
        jCheckBoxFarol_Esq.setSelected(false);
        jCheckBoxFarol_dir.setSelected(false);
        jCheckBoxPisca_Esq.setSelected(false);
        jCheckBoxPisca_Dir.setSelected(false);
        jCheckBoxLanterna_Esq.setSelected(false);
        jCheckBoxLanterna_Dir.setSelected(false);
        jCheckBoxLuz_Freio.setSelected(false);
        jCheckBoxLuz_Placa.setSelected(false);
        jCheckBoxBuzina.setSelected(false);
        jCheckBoxAr_condicionado.setSelected(false);
        jCheckBoxRetrovisor_Interno.setSelected(false);
        jCheckBoxRetrovisor_Esq.setSelected(false);
        jCheckBoxRetrovisor_Dir.setSelected(false);
        jCheckBoxLimpador_Parabrisa.setSelected(false);
        jCheckBoxVidros_Laterais.setSelected(false);
        jCheckBoxParabrisa_Traseiro.setSelected(false);
        jCheckBoxParabrisa_Dianteiro.setSelected(false);
        jCheckBoxEstofamento_Bancos.setSelected(false);
        jCheckBoxTapetes_Internos.setSelected(false);
        jCheckBoxForro_Interno.setSelected(false);
        jCheckBoxMacaco.setSelected(false);
        jCheckBoxChave_de_Roda.setSelected(false);
        jCheckBoxEstepe.setSelected(false);
        jCheckBoxTriângulo.setSelected(false);
        jCheckBoxExtintor.setSelected(false);
        jCheckBoxDocumento_Veicular.setSelected(false);
        jCheckBoxCintos_de_segurança.setSelected(false);
        jCheckBoxLimpeza_Interior.setSelected(false);
        jCheckBoxLimpeza_Exterior.setSelected(false);
        jCheckBoxChave_Ignição.setSelected(false);

        jCheckBoxFarol_Esq.setText(null);
        jCheckBoxEstofamento_Bancos.setText(null);
        jCheckBoxFarol_dir.setText(null);
        jCheckBoxPisca_Esq.setText(null);
        jCheckBoxPisca_Dir.setText(null);
        jCheckBoxLanterna_Esq.setText(null);
        jCheckBoxLanterna_Dir.setText(null);
        jTextAreaObservações.setText(null);
        jCheckBoxLuz_Freio.setText(null);
        jCheckBoxLuz_Placa.setText(null);
        jCheckBoxBuzina.setText(null);
        jCheckBoxAr_condicionado.setText(null);
        jCheckBoxRetrovisor_Interno.setText(null);
        jCheckBoxRetrovisor_Esq.setText(null);
        jCheckBoxRetrovisor_Dir.setText(null);
        jCheckBoxLimpador_Parabrisa.setText(null);
        jCheckBoxVidros_Laterais.setText(null);
        jCheckBoxParabrisa_Traseiro.setText(null);
        jCheckBoxParabrisa_Dianteiro.setText(null);
        jCheckBoxTapetes_Internos.setText(null);
        jCheckBoxForro_Interno.setText(null);
        jCheckBoxMacaco.setText(null);
        jCheckBoxChave_de_Roda.setText(null);
        jCheckBoxEstepe.setText(null);
        jCheckBoxTriângulo.setText(null);
        jCheckBoxExtintor.setText(null);
        jCheckBoxDocumento_Veicular.setText(null);
        jCheckBoxCintos_de_segurança.setText(null);
        jCheckBoxLimpeza_Interior.setText(null);
        jCheckBoxLimpeza_Exterior.setText(null);
        jCheckBoxChave_Ignição.setText(null);
        jPanel1.setVisible(false);
        jLabelBotaoAdicionar.setVisible(true);
        jTable2.setVisible(false);
    }
    
    public void consultarVeiculo01() {
        
        String consultar = "select * from  veiculo where chassi like ?";

        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextField9.getText() + "%");
            rs = pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void preenchimentoAuto() {
        int copia = jTable2.getSelectedRow();
        try {
            jTextField1.setText(jTable2.getModel().getValueAt(copia, 0).toString());
            jTextField11.setText(jTable2.getModel().getValueAt(copia, 0).toString());
            jTextField10.setText(jTable2.getModel().getValueAt(copia, 0).toString());
            jTextField2.setText(jTable2.getModel().getValueAt(copia, 1).toString());
            jTextField3.setText(jTable2.getModel().getValueAt(copia, 2).toString());
            jTextField4.setText(jTable2.getModel().getValueAt(copia, 3).toString());
            jTextField5.setText(jTable2.getModel().getValueAt(copia, 4).toString());
            jTextField6.setText(jTable2.getModel().getValueAt(copia, 5).toString());
            jTextField7.setText(jTable2.getModel().getValueAt(copia, 6 ).toString());
            jComboBox1.setSelectedItem(jTable2.getModel().getValueAt(copia, 7).toString());
            jLabelBotaoAdicionar.setVisible(false);
//            jTextArea1.setLineWrap(true);
//            jTextArea1.setWrapStyleWord(true);
//            jPanel1.setVisible(true);
//            jLabelSalvar.setVisible(false);
        } catch (Exception e) {

        }

    }

    public void PesquisarVeiculo() {
        String consultar = "select * from  \n"
                + "veiculo as v \n"
                + "inner join checklist as ch\n"
                + "on v.nrVeiculo=ch.veiculo\n"
                + "where chassi =?";
        jPanel1.setVisible(true);
        jTextField1.setEditable(false);
        jTextField3.setEditable(false);
        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextField3.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                jTextField1.setText(rs.getString(1));
                j = jTextField1.getText();

                jTextField2.setText(rs.getString(2));
                jTextField4.setText(rs.getString(4));
                jTextField5.setText(rs.getString(5));
                jTextField6.setText(rs.getString(6));
                jTextField7.setText(rs.getString(7));
                jComboBox1.setSelectedItem(rs.getString(8));
                jTextField8.setText(rs.getString(9));
                jCheckBoxFarol_Esq.setText(rs.getString(10));
                jCheckBoxFarol_dir.setText(rs.getString(11));
                jCheckBoxPisca_Esq.setText(rs.getString(12));
                jCheckBoxPisca_Dir.setText(rs.getString(13));
                jCheckBoxLanterna_Esq.setText(rs.getString(14));
                jCheckBoxLanterna_Dir.setText(rs.getString(15));
                jTextAreaObservações.setText(rs.getString(16));
                jCheckBoxLuz_Freio.setText(rs.getString(17));
                jCheckBoxLuz_Placa.setText(rs.getString(18));
                jCheckBoxBuzina.setText(rs.getString(19));
                jCheckBoxAr_condicionado.setText(rs.getString(20));
                jCheckBoxRetrovisor_Interno.setText(rs.getString(21));
                jCheckBoxRetrovisor_Esq.setText(rs.getString(22));
                jCheckBoxRetrovisor_Dir.setText(rs.getString(23));
                jCheckBoxLimpador_Parabrisa.setText(rs.getString(24));
                jCheckBoxVidros_Laterais.setText(rs.getString(25));
                jCheckBoxParabrisa_Traseiro.setText(rs.getString(26));
                jCheckBoxParabrisa_Dianteiro.setText(rs.getString(27));
                jCheckBoxEstofamento_Bancos.setText(rs.getString(28));
                jCheckBoxTapetes_Internos.setText(rs.getString(29));
                jCheckBoxForro_Interno.setText(rs.getString(30));
                jCheckBoxMacaco.setText(rs.getString(31));
                jCheckBoxChave_de_Roda.setText(rs.getString(32));
                jCheckBoxEstepe.setText(rs.getString(33));
                jCheckBoxTriângulo.setText(rs.getString(34));
                jCheckBoxExtintor.setText(rs.getString(35));
                jCheckBoxDocumento_Veicular.setText(rs.getString(36));
                jCheckBoxCintos_de_segurança.setText(rs.getString(37));
                jCheckBoxLimpeza_Interior.setText(rs.getString(38));
                jCheckBoxLimpeza_Exterior.setText(rs.getString(39));
                jCheckBoxChave_Ignição.setText(rs.getString(40));
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxParabrisa_Dianteiro);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxFarol_Esq);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxFarol_dir);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxPisca_Esq);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxPisca_Dir);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxLanterna_Esq);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxLanterna_Dir);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxLuz_Freio);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxLuz_Placa);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxBuzina);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxAr_condicionado);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxRetrovisor_Interno);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxRetrovisor_Esq);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxRetrovisor_Dir);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxLimpador_Parabrisa);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxVidros_Laterais);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxParabrisa_Traseiro);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxEstofamento_Bancos);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxTapetes_Internos);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxForro_Interno);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxMacaco);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxChave_de_Roda);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxExtintor);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxDocumento_Veicular);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxCintos_de_segurança);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxLimpeza_Interior);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxLimpeza_Exterior);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxChave_Ignição);
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxEstepe);

                MatriculaDoFuncionario.setText(rs.getString(41));
                jTextField10.setText(rs.getString(42));
                jLabelBotaoAdicionar.setToolTipText("Você não pode adicionar este funcionário pois ele já existe");
                jLabelBotaoAdicionar.setVisible(false);
                jLabel11.setVisible(false);
            } else {
               int o= JOptionPane.showConfirmDialog(null, "Este veíclo esta indiponívevel.\n"
                       + "Você deseja atualizar o cheking?");
                       
               if(o>0){
                jTextField2.setText(null);
                jTextField3.setEditable(true);
                jTextField3.setText(null);
                jTextField4.setText(null);
                jTextField5.setText(null);
                jTextField6.setText(null);
                jTextField1.setText(null);
                jComboBox1.setSelectedItem(null);
                jLabelBotaoAdicionar.setVisible(true);
                jPanel1.setVisible(false);
               }else{
                jPanel1.setVisible(true);
               }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Esta função retorna o id do automovel automaticamente par o checking
    public JTextField PesquisarCoverter() {
        String consultar = "select * from veiculo where chassi=?";

        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextField3.getText());
            rs = pst.executeQuery();
            if (rs.next()) {

                jTextField10.setText(rs.getString(1));
                jTextField1.setText(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return jTextField10;
    }
    
// A condição SIM ou NÃO para disponível esta dentro deste método
    public void atualizarVeiculo() {
        String atualizar = "UPDATE veiculo SET Modelo = ?,"
                + "chassi = ?, nrPortas = ?,placa = ?, ano = ?,"
                + "disponibilidade = ?, tipoVeiculo = ?"
                + "WHERE(nrVeiculo = ?)";
        if (ab == true) {
            
            jTextField7.setText("Sim");
        } else {
            jTextField7.setText("Não");
        }
        try {
            pst = conectar.prepareStatement(atualizar);
            pst.setString(1, jTextField2.getText());
            pst.setString(2, jTextField3.getText());
            pst.setString(3, jTextField4.getText());
            pst.setString(4, jTextField5.getText());
            pst.setString(5, jTextField6.getText());
            pst.setString(6, jTextField7.getText());
            pst.setString(7, jComboBox1.getSelectedItem().toString());
            pst.setString(8, jTextField1.getText());

            if (jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty()
                    || jTextField4.getText().isEmpty() || jTextField5.getText().isEmpty()
                    || jTextField6.getText().isEmpty() || jComboBox1.getSelectedItem().toString().isEmpty()
                    || jComboBox1.getSelectedItem().toString().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Preencha todos os campos são Obrigatórios.");
            } else {

                int c = pst.executeUpdate();
                if (c > 0) {
                    JOptionPane.showMessageDialog(null, jTextField2.getText() + "\n Foi alterado com sussesso. ");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jTextField6.setText("");
                    jTextField1.setText("");
                    jComboBox1.setSelectedItem(null);
                    jLabelBotaoAdicionar.setVisible(true);

                } else {

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void atualizarCheckList() {
        String atualizar = "UPDATE `alugueldecarros01`.`checklist` "
                + "SET `Farol_Esq` = ?, `Farol_dir` = ?, "
                + "`Pisca_Esq` = ?, `Pisca_Dir` = ?, `Lanterna_Esq` = ?,"
                + " `Lanterna_Dir` = ?,`Observações`=?, `Luz_Freio` = ?, `Luz_Placa` = ?,"
                + " `Buzina` = ?, `Ar_condicionado` = ?, `Retrovisor_Interno` = ?,"
                + " `Retrovisor_Esq` = ?, `Retrovisor_Dir` = ?, `Limpador_Parabrisa` = ?, "
                + "`Vidros_Laterais` = ?, `Parabrisa_Traseiro` = ?, `Parabrisa_Dianteiro` = ?, "
                + "`Estofamento_Bancos` = ?, `Tapetes_Internos` = ?, `Forro_Interno` = ?, "
                + "`Macaco` = ?, `Chave_de_Roda` = ?, `Estepe` = ?, "
                + "`Triângulo` = ?, `Extintor` = ?, `Documento_Veicular` = ?, "
                + "`Cintos_de_segurança` = ?, `Limpeza_Interior` = ?, `Limpeza_Exterior` = ?, "
                + "`Chave_Ignição` = ?, `matricula` = ? WHERE (`idCheckList` = ?)";
        tratandoJcheckbox(jCheckBoxFarol_Esq);
        tratandoJcheckbox(jCheckBoxFarol_dir);
        tratandoJcheckbox(jCheckBoxPisca_Esq);
        tratandoJcheckbox(jCheckBoxPisca_Dir);
        tratandoJcheckbox(jCheckBoxLanterna_Esq);
        tratandoJcheckbox(jCheckBoxLanterna_Dir);
        tratandoJcheckbox(jCheckBoxLuz_Freio);
        tratandoJcheckbox(jCheckBoxLuz_Placa);
        tratandoJcheckbox(jCheckBoxBuzina);
        tratandoJcheckbox(jCheckBoxAr_condicionado);
        tratandoJcheckbox(jCheckBoxRetrovisor_Interno);
        tratandoJcheckbox(jCheckBoxRetrovisor_Esq);
        tratandoJcheckbox(jCheckBoxRetrovisor_Dir);
        tratandoJcheckbox(jCheckBoxLimpador_Parabrisa);
        tratandoJcheckbox(jCheckBoxVidros_Laterais);
        tratandoJcheckbox(jCheckBoxParabrisa_Traseiro);
        tratandoJcheckbox(jCheckBoxParabrisa_Dianteiro);
        tratandoJcheckbox(jCheckBoxEstofamento_Bancos);
        tratandoJcheckbox(jCheckBoxTapetes_Internos);
        tratandoJcheckbox(jCheckBoxForro_Interno);
        tratandoJcheckbox(jCheckBoxMacaco);
        tratandoJcheckbox(jCheckBoxChave_de_Roda);
        tratandoJcheckbox(jCheckBoxEstepe);
        tratandoJcheckbox(jCheckBoxTriângulo);
        tratandoJcheckbox(jCheckBoxExtintor);
        tratandoJcheckbox(jCheckBoxDocumento_Veicular);
        tratandoJcheckbox(jCheckBoxCintos_de_segurança);
        tratandoJcheckbox(jCheckBoxLimpeza_Interior);
        tratandoJcheckbox(jCheckBoxLimpeza_Exterior);
        tratandoJcheckbox(jCheckBoxChave_Ignição);

        verddadeMentira();

        try {

            pst = conectar.prepareStatement(atualizar);
            pst.setString(1, jCheckBoxFarol_Esq.getText());
            pst.setString(2, jCheckBoxFarol_dir.getText());
            pst.setString(3, jCheckBoxPisca_Esq.getText());
            pst.setString(4, jCheckBoxPisca_Dir.getText());
            pst.setString(5, jCheckBoxLanterna_Esq.getText());
            pst.setString(6, jCheckBoxLanterna_Dir.getText());
            pst.setString(7, jTextAreaObservações.getText());
            pst.setString(8, jCheckBoxLuz_Freio.getText());
            pst.setString(9, jCheckBoxLuz_Placa.getText());
            pst.setString(10, jCheckBoxBuzina.getText());
            pst.setString(11, jCheckBoxAr_condicionado.getText());
            pst.setString(12, jCheckBoxRetrovisor_Interno.getText());
            pst.setString(13, jCheckBoxRetrovisor_Esq.getText());
            pst.setString(14, jCheckBoxRetrovisor_Dir.getText());
            pst.setString(15, jCheckBoxLimpador_Parabrisa.getText());
            pst.setString(16, jCheckBoxVidros_Laterais.getText());
            pst.setString(17, jCheckBoxParabrisa_Traseiro.getText());
            pst.setString(18, jCheckBoxParabrisa_Dianteiro.getText());
            pst.setString(19, jCheckBoxEstofamento_Bancos.getText());
            pst.setString(20, jCheckBoxTapetes_Internos.getText());
            pst.setString(21, jCheckBoxForro_Interno.getText());
            pst.setString(22, jCheckBoxMacaco.getText());
            pst.setString(23, jCheckBoxChave_de_Roda.getText());
            pst.setString(24, jCheckBoxEstepe.getText());
            pst.setString(25, jCheckBoxTriângulo.getText());
            pst.setString(26, jCheckBoxExtintor.getText());
            pst.setString(27, jCheckBoxDocumento_Veicular.getText());
            pst.setString(28, jCheckBoxCintos_de_segurança.getText());
            pst.setString(29, jCheckBoxLimpeza_Interior.getText());
            pst.setString(30, jCheckBoxLimpeza_Exterior.getText());
            pst.setString(31, jCheckBoxChave_Ignição.getText());
            pst.setString(32, MatriculaDoFuncionario.getText());
            pst.setString(33, jTextField8.getText());

            if (MatriculaDoFuncionario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos são Obrigatórios. ");

            } else {
                int confirmarInsercaoDeDados = pst.executeUpdate();
                if (confirmarInsercaoDeDados > 0) {

                    JOptionPane.showMessageDialog(null, "Checking de " + jTextField3.getText() + "\n"
                            + " foi adicionado com sussesso. ");
                    atualizarVeiculo();
                    jPanel1.setVisible(false);
                    jCheckBoxFarol_Esq.setSelected(false);
                    jCheckBoxFarol_dir.setSelected(false);
                    jCheckBoxPisca_Esq.setSelected(false);
                    jCheckBoxPisca_Dir.setSelected(false);
                    jCheckBoxLanterna_Esq.setSelected(false);
                    jCheckBoxLanterna_Dir.setSelected(false);
                    jCheckBoxLuz_Freio.setSelected(false);
                    jCheckBoxLuz_Placa.setSelected(false);
                    jCheckBoxBuzina.setSelected(false);
                    jCheckBoxAr_condicionado.setSelected(false);
                    jCheckBoxRetrovisor_Interno.setSelected(false);
                    jCheckBoxRetrovisor_Esq.setSelected(false);
                    jCheckBoxRetrovisor_Dir.setSelected(false);
                    jCheckBoxLimpador_Parabrisa.setSelected(false);
                    jCheckBoxVidros_Laterais.setSelected(false);
                    jCheckBoxParabrisa_Traseiro.setSelected(false);
                    jCheckBoxParabrisa_Dianteiro.setSelected(false);
                    jCheckBoxEstofamento_Bancos.setSelected(false);
                    jCheckBoxTapetes_Internos.setSelected(false);
                    jCheckBoxForro_Interno.setSelected(false);
                    jCheckBoxMacaco.setSelected(false);
                    jCheckBoxChave_de_Roda.setSelected(false);
                    jCheckBoxEstepe.setSelected(false);
                    jCheckBoxTriângulo.setSelected(false);
                    jCheckBoxExtintor.setSelected(false);
                    jCheckBoxDocumento_Veicular.setSelected(false);
                    jCheckBoxCintos_de_segurança.setSelected(false);
                    jCheckBoxLimpeza_Interior.setSelected(false);
                    jCheckBoxLimpeza_Exterior.setSelected(false);
                    jCheckBoxChave_Ignição.setSelected(false);
                    jTextField10.setText(null);
                    MatriculaDoFuncionario.setText(null);
                    jLabelBotaoAdicionar.setVisible(true);
                    TelaInicial();
                } else {

                }

            }

        } /*catch (java.sql.SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Este número de matricula Já exixte"); /*catch (java.sql.SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Este número de matricula Já exixte");
            }*/ catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private JCheckBox tratandoJcheckbox(JCheckBox jkj) {
        String o = "Ok", jjj = "Não";
        if (jkj.isSelected() == false) {
            jkj.setText(jjj);

        } else {
            jkj.setText(o);

        };

        return jkj;
    }

    public boolean verddadeMentira() {
        if (jCheckBoxFarol_Esq.isSelected() == false || jCheckBoxFarol_dir.isSelected() == false
                || jCheckBoxRetrovisor_Interno.isSelected() == false || jCheckBoxRetrovisor_Esq.isSelected() == false
                || jCheckBoxRetrovisor_Dir.isSelected() == false || jCheckBoxLimpador_Parabrisa.isSelected() == false
                || jCheckBoxVidros_Laterais.isSelected() == false || jCheckBoxParabrisa_Traseiro.isSelected() == false
                || jCheckBoxParabrisa_Dianteiro.isSelected() == false || jCheckBoxPisca_Dir.isSelected() == false
                || jCheckBoxPisca_Esq.isSelected() == false || jCheckBoxLanterna_Esq.isSelected() == false
                || jCheckBoxLanterna_Dir.isSelected() == false || jCheckBoxLuz_Freio.isSelected() == false
                || jCheckBoxLuz_Placa.isSelected() == false || jCheckBoxBuzina.isSelected() == false
                || jCheckBoxAr_condicionado.isSelected() == false || jCheckBoxEstofamento_Bancos.isSelected() == false
                || jCheckBoxMacaco.isSelected() == false || jCheckBoxChave_de_Roda.isSelected() == false
                || jCheckBoxEstepe.isSelected() == false || jCheckBoxTriângulo.isSelected() == false
                || jCheckBoxExtintor.isSelected() == false || jCheckBoxDocumento_Veicular.isSelected() == false
                || jCheckBoxCintos_de_segurança.isSelected() == false || jCheckBoxLimpeza_Interior.isSelected() == false
                || jCheckBoxLimpeza_Exterior.isSelected() == false || jCheckBoxChave_Ignição.isSelected() == false) {
            ab = false;
        } else {
            ab = true;
        }
//        JOptionPane.showMessageDialog(null, "valor Ab na vedade ou mentira "+ab);
        return ab;
    }

    public void adicinarCheckList() {

        String inserirDado = "INSERT INTO `alugueldecarros01`.`checklist`"
                + "(`Farol_Esq`, `Farol_dir`, `Pisca_Esq`, `Pisca_Dir`, "
                + "`Lanterna_Esq`, `Lanterna_Dir`, `Observações`, `Luz_Freio`, "
                + "`Luz_Placa`, `Buzina`, `Ar_condicionado`, `Retrovisor_Interno`, "
                + "`Retrovisor_Esq`, `Retrovisor_Dir`, `Limpador_Parabrisa`, `Vidros_Laterais`, "
                + "`Parabrisa_Traseiro`, `Parabrisa_Dianteiro`, `Estofamento_Bancos`, `Tapetes_Internos`, "
                + "`Forro_Interno`, `Macaco`, `Chave_de_Roda`, `Estepe`, "
                + "`Triângulo`, `Extintor`, `Documento_Veicular`, `Cintos_de_segurança`, "
                + "`Limpeza_Interior`, `Limpeza_Exterior`, `Chave_Ignição`, `matricula`, "
                + "`veiculo`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        tratandoJcheckbox(jCheckBoxFarol_Esq);
        tratandoJcheckbox(jCheckBoxFarol_dir);
        tratandoJcheckbox(jCheckBoxPisca_Esq);
        tratandoJcheckbox(jCheckBoxPisca_Dir);
        tratandoJcheckbox(jCheckBoxLanterna_Esq);
        tratandoJcheckbox(jCheckBoxLanterna_Dir);
        tratandoJcheckbox(jCheckBoxLuz_Freio);
        tratandoJcheckbox(jCheckBoxLuz_Placa);
        tratandoJcheckbox(jCheckBoxBuzina);
        tratandoJcheckbox(jCheckBoxAr_condicionado);
        tratandoJcheckbox(jCheckBoxRetrovisor_Interno);
        tratandoJcheckbox(jCheckBoxRetrovisor_Esq);
        tratandoJcheckbox(jCheckBoxRetrovisor_Dir);
        tratandoJcheckbox(jCheckBoxLimpador_Parabrisa);
        tratandoJcheckbox(jCheckBoxVidros_Laterais);
        tratandoJcheckbox(jCheckBoxParabrisa_Traseiro);
        tratandoJcheckbox(jCheckBoxParabrisa_Dianteiro);
        tratandoJcheckbox(jCheckBoxEstofamento_Bancos);
        tratandoJcheckbox(jCheckBoxTapetes_Internos);
        tratandoJcheckbox(jCheckBoxForro_Interno);
        tratandoJcheckbox(jCheckBoxMacaco);
        tratandoJcheckbox(jCheckBoxChave_de_Roda);
        tratandoJcheckbox(jCheckBoxEstepe);
        tratandoJcheckbox(jCheckBoxTriângulo);
        tratandoJcheckbox(jCheckBoxExtintor);
        tratandoJcheckbox(jCheckBoxDocumento_Veicular);
        tratandoJcheckbox(jCheckBoxCintos_de_segurança);
        tratandoJcheckbox(jCheckBoxLimpeza_Interior);
        tratandoJcheckbox(jCheckBoxLimpeza_Exterior);
        tratandoJcheckbox(jCheckBoxChave_Ignição);
        verddadeMentira();

        try {

            pst = conectar.prepareStatement(inserirDado);
            pst.setString(1, jCheckBoxFarol_Esq.getText());
            pst.setString(2, jCheckBoxFarol_dir.getText());
            pst.setString(3, jCheckBoxPisca_Esq.getText());
            pst.setString(4, jCheckBoxPisca_Dir.getText());
            pst.setString(5, jCheckBoxLanterna_Esq.getText());
            pst.setString(6, jCheckBoxLanterna_Dir.getText());
            pst.setString(7, jTextAreaObservações.getText());
            pst.setString(8, jCheckBoxLuz_Freio.getText());
            pst.setString(9, jCheckBoxLuz_Placa.getText());
            pst.setString(10, jCheckBoxBuzina.getText());
            pst.setString(11, jCheckBoxAr_condicionado.getText());
            pst.setString(12, jCheckBoxRetrovisor_Interno.getText());
            pst.setString(13, jCheckBoxRetrovisor_Esq.getText());
            pst.setString(14, jCheckBoxRetrovisor_Dir.getText());
            pst.setString(15, jCheckBoxLimpador_Parabrisa.getText());
            pst.setString(16, jCheckBoxVidros_Laterais.getText());
            pst.setString(17, jCheckBoxParabrisa_Traseiro.getText());
            pst.setString(18, jCheckBoxParabrisa_Dianteiro.getText());
            pst.setString(19, jCheckBoxEstofamento_Bancos.getText());
            pst.setString(20, jCheckBoxTapetes_Internos.getText());
            pst.setString(21, jCheckBoxForro_Interno.getText());
            pst.setString(22, jCheckBoxMacaco.getText());
            pst.setString(23, jCheckBoxChave_de_Roda.getText());
            pst.setString(24, jCheckBoxEstepe.getText());
            pst.setString(25, jCheckBoxTriângulo.getText());
            pst.setString(26, jCheckBoxExtintor.getText());
            pst.setString(27, jCheckBoxDocumento_Veicular.getText());
            pst.setString(28, jCheckBoxCintos_de_segurança.getText());
            pst.setString(29, jCheckBoxLimpeza_Interior.getText());
            pst.setString(30, jCheckBoxLimpeza_Exterior.getText());
            pst.setString(31, jCheckBoxChave_Ignição.getText());
            pst.setString(32, MatriculaDoFuncionario.getText());
            pst.setString(33, jTextField10.getText());

            if (MatriculaDoFuncionario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha o campo MATRICULA. ");
            } else {
                int confirmarInsercaoDeDados = pst.executeUpdate();
                if (confirmarInsercaoDeDados > 0) {

                    atualizarVeiculo();
                    JOptionPane.showMessageDialog(null, "checking list de " + modelo + "\n"
                            + " Foi adicionado com sussesso. ");
                    jPanel1.setVisible(false);
                    jCheckBoxFarol_Esq.setSelected(false);
                    jCheckBoxFarol_dir.setSelected(false);
                    jCheckBoxPisca_Esq.setSelected(false);
                    jCheckBoxPisca_Dir.setSelected(false);
                    jCheckBoxLanterna_Esq.setSelected(false);
                    jCheckBoxLanterna_Dir.setSelected(false);
                    jCheckBoxLuz_Freio.setSelected(false);
                    jCheckBoxLuz_Placa.setSelected(false);
                    jCheckBoxBuzina.setSelected(false);
                    jCheckBoxAr_condicionado.setSelected(false);
                    jCheckBoxRetrovisor_Interno.setSelected(false);
                    jCheckBoxRetrovisor_Esq.setSelected(false);
                    jCheckBoxRetrovisor_Dir.setSelected(false);
                    jCheckBoxLimpador_Parabrisa.setSelected(false);
                    jCheckBoxVidros_Laterais.setSelected(false);
                    jCheckBoxParabrisa_Traseiro.setSelected(false);
                    jCheckBoxParabrisa_Dianteiro.setSelected(false);
                    jCheckBoxEstofamento_Bancos.setSelected(false);
                    jCheckBoxTapetes_Internos.setSelected(false);
                    jCheckBoxForro_Interno.setSelected(false);
                    jCheckBoxMacaco.setSelected(false);
                    jCheckBoxChave_de_Roda.setSelected(false);
                    jCheckBoxEstepe.setSelected(false);
                    jCheckBoxTriângulo.setSelected(false);
                    jCheckBoxExtintor.setSelected(false);
                    jCheckBoxDocumento_Veicular.setSelected(false);
                    jCheckBoxCintos_de_segurança.setSelected(false);
                    jCheckBoxLimpeza_Interior.setSelected(false);
                    jCheckBoxLimpeza_Exterior.setSelected(false);
                    jCheckBoxChave_Ignição.setSelected(false);
                    jTextField10.setText(null);
                    MatriculaDoFuncionario.setText(null);
                    jLabelBotaoAdicionar.setVisible(true);
                    jLabel10.setVisible(true);
                    jLabelExcluirVeiculo.setVisible(true);
                    jLabel13.setVisible(true);
                    jLabel54.setVisible(true);
                    jLabelBotaoAdicionar.setVisible(true);
                } else {

                }
            }

        } /*catch (java.sql.SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Este número de matricula Já exixte"); /*catch (java.sql.SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Este número de matricula Já exixte");
            }*/ catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void adicinarNovoAutomóvel() {
        String inserirDados = "INSERT INTO veiculo (Modelo, chassi, nrPortas, placa, "
                + "ano, disponibilidade, tipoVeiculo) VALUES (?, ?, ?, ?, "
                + "?, ?, ?)";

        try {

            pst = conectar.prepareStatement(inserirDados);
            pst.setString(1, jTextField2.getText());
            pst.setString(2, jTextField3.getText());
            modelo = jTextField3.getText();
            pst.setString(3, jTextField4.getText());
            pst.setString(4, jTextField5.getText());
            pst.setString(5, jTextField6.getText());
            pst.setString(6, jTextField7.getText());
            pst.setString(7, jComboBox1.getSelectedItem().toString());
            jCheckBoxFarol_Esq.setSelected(true);
            if (jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty()
                    || jTextField4.getText().isEmpty() || jTextField5.getText().isEmpty()
                    || jTextField6.getText().isEmpty() || jComboBox1.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos são Obrigatórios. ");
            } else {
                jPanel1.setVisible(true);
                if (jCheckBoxFarol_Esq.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Preenvha ao menos um campo do checking");
                } else {

                    int confirmarInsercaoDeDados = pst.executeUpdate();
                    if (confirmarInsercaoDeDados > 0) {
                        jLabel10.setVisible(false);
                        jLabelExcluirVeiculo.setVisible(false);
                        jLabel13.setVisible(false);
                        jLabel54.setVisible(false);
                        jLabelBotaoAdicionar.setVisible(false);
                        jLabel11.setVisible(true);
                        JOptionPane.showMessageDialog(null, jTextField2.getText() + "\n Foi adicionado com sussesso. ");
                        JOptionPane.showMessageDialog(null, "Preencha faça o checking para o veiculo não ficar sem ficha de checagem.");
                        // Esta função retorna o id do automovel automaticamente par o checking

                        PesquisarCoverter();

                    } else {

                    }
                }

            }
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Este número de matricula Já exixte");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
     private void ConsultarChelistt() {
        String consultar = "select * from  checklist where veiculo= ? ";
        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextField11.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                jTextField8.setText(rs.getString(1));
                jCheckBoxFarol_Esq.setText(rs.getString(2));
                jCheckBoxFarol_dir.setText(rs.getString(3));
                jCheckBoxPisca_Esq.setText(rs.getString(4));
                jCheckBoxPisca_Dir.setText(rs.getString(5));
                jCheckBoxLanterna_Esq.setText(rs.getString(6));
                jCheckBoxLanterna_Dir.setText(rs.getString(7));
                jTextAreaObservações.setText(rs.getString(8));
                jCheckBoxLuz_Freio.setText(rs.getString(9));
                jCheckBoxLuz_Placa.setText(rs.getString(10));
                jCheckBoxBuzina.setText(rs.getString(11));
                jCheckBoxAr_condicionado.setText(rs.getString(12));
                jCheckBoxRetrovisor_Interno.setText(rs.getString(13));
                jCheckBoxRetrovisor_Esq.setText(rs.getString(14));
                jCheckBoxRetrovisor_Dir.setText(rs.getString(15));
                jCheckBoxLimpador_Parabrisa.setText(rs.getString(16));
                jCheckBoxVidros_Laterais.setText(rs.getString(17));
                jCheckBoxParabrisa_Traseiro.setText(rs.getString(18));
                jCheckBoxParabrisa_Dianteiro.setText(rs.getString(19));
                jCheckBoxEstofamento_Bancos.setText(rs.getString(20));
                jCheckBoxTapetes_Internos.setText(rs.getString(21));
                jCheckBoxForro_Interno.setText(rs.getString(22));
                jCheckBoxMacaco.setText(rs.getString(23));
                jCheckBoxChave_de_Roda.setText(rs.getString(24));
                jCheckBoxEstepe.setText(rs.getString(25));
                jCheckBoxTriângulo.setText(rs.getString(26));
                jCheckBoxExtintor.setText(rs.getString(27));
                jCheckBoxDocumento_Veicular.setText(rs.getString(28));
                jCheckBoxCintos_de_segurança.setText(rs.getString(29));
                jCheckBoxLimpeza_Interior.setText(rs.getString(30));
                jCheckBoxLimpeza_Exterior.setText(rs.getString(31));
                jCheckBoxChave_Ignição.setText(rs.getString(32));
                MatriculaDoFuncionario.setText(rs.getString(33));
                jTextField10.setText(rs.getString(34));

                

//                tratandoJcheckbox(jCheckBoxFarol_Esq);
//                tratandoJcheckbox(jCheckBoxFarol_dir);
//                tratandoJcheckbox(jCheckBoxPisca_Esq);
//                tratandoJcheckbox(jCheckBoxPisca_Dir);
//                tratandoJcheckbox(jCheckBoxLanterna_Esq);
//                tratandoJcheckbox(jCheckBoxLanterna_Dir);
//                tratandoJcheckbox(jCheckBoxLuz_Freio);
//                tratandoJcheckbox(jCheckBoxLuz_Placa);
//                tratandoJcheckbox(jCheckBoxBuzina);
//                tratandoJcheckbox(jCheckBoxAr_condicionado);
//                tratandoJcheckbox(jCheckBoxRetrovisor_Interno);
//                tratandoJcheckbox(jCheckBoxRetrovisor_Esq);
//                tratandoJcheckbox(jCheckBoxRetrovisor_Dir);
//                tratandoJcheckbox(jCheckBoxLimpador_Parabrisa);
//                tratandoJcheckbox(jCheckBoxVidros_Laterais);
//                tratandoJcheckbox(jCheckBoxParabrisa_Traseiro);
//                tratandoJcheckbox(jCheckBoxParabrisa_Dianteiro);
//                tratandoJcheckbox(jCheckBoxEstofamento_Bancos);
//                tratandoJcheckbox(jCheckBoxTapetes_Internos);
//                tratandoJcheckbox(jCheckBoxForro_Interno);
//                tratandoJcheckbox(jCheckBoxMacaco);
//                tratandoJcheckbox(jCheckBoxChave_de_Roda);
//                tratandoJcheckbox(jCheckBoxEstepe);
//                tratandoJcheckbox(jCheckBoxTriângulo);
//                tratandoJcheckbox(jCheckBoxExtintor);
//                tratandoJcheckbox(jCheckBoxDocumento_Veicular);
//                tratandoJcheckbox(jCheckBoxCintos_de_segurança);
//                tratandoJcheckbox(jCheckBoxLimpeza_Interior);
//                tratandoJcheckbox(jCheckBoxLimpeza_Exterior);
//                tratandoJcheckbox(jCheckBoxChave_Ignição);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario inexistente");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ExcluirVeiculo() {

        int ap = JOptionPane.showConfirmDialog(null, "Os dados apagados não poderão ser recuperados\nTem certeza que deseja apagá-lo? ", "Atenção", JOptionPane.YES_NO_OPTION);
        if (ap == 0) {
            
            String a = "DELETE FROM `alugueldecarros01`.`veiculo` WHERE (`nrVeiculo` = ?) ";
            ExcluirVeiculoo();
            try {
                pst = conectar.prepareStatement(a);
                pst.setString(1, jTextField1.getText());
                int confg = pst.executeUpdate();
                if (confg > 0) {
                    TelaInicial();
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public void ExcluirVeiculoo() {
        String a = "DELETE FROM checklist WHERE (idCheckList = ?)";
        try {
            pst = conectar.prepareStatement(a);
            pst.setString(1, jTextField8.getText());
            int confg = pst.executeUpdate();
            if (confg > 0) {
                JOptionPane.showMessageDialog(null, "Veículo e check list apagda com sucesso");
                //ExcluirVeiculo();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelBotaoAdicionar = new javax.swing.JLabel();
        jLabelExcluirVeiculo = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JInternalFrame();
        jCheckBoxFarol_dir = new javax.swing.JCheckBox();
        jCheckBoxPisca_Esq = new javax.swing.JCheckBox();
        jCheckBoxPisca_Dir = new javax.swing.JCheckBox();
        jCheckBoxLanterna_Esq = new javax.swing.JCheckBox();
        jCheckBoxLanterna_Dir = new javax.swing.JCheckBox();
        jCheckBoxLuz_Freio = new javax.swing.JCheckBox();
        jCheckBoxLuz_Placa = new javax.swing.JCheckBox();
        jCheckBoxBuzina = new javax.swing.JCheckBox();
        jCheckBoxAr_condicionado = new javax.swing.JCheckBox();
        jCheckBoxRetrovisor_Interno = new javax.swing.JCheckBox();
        jCheckBoxRetrovisor_Esq = new javax.swing.JCheckBox();
        jCheckBoxRetrovisor_Dir = new javax.swing.JCheckBox();
        jCheckBoxLimpador_Parabrisa = new javax.swing.JCheckBox();
        jCheckBoxVidros_Laterais = new javax.swing.JCheckBox();
        jCheckBoxParabrisa_Traseiro = new javax.swing.JCheckBox();
        jCheckBoxParabrisa_Dianteiro = new javax.swing.JCheckBox();
        jCheckBoxEstofamento_Bancos = new javax.swing.JCheckBox();
        jCheckBoxTapetes_Internos = new javax.swing.JCheckBox();
        jCheckBoxForro_Interno = new javax.swing.JCheckBox();
        jCheckBoxMacaco = new javax.swing.JCheckBox();
        jCheckBoxEstepe = new javax.swing.JCheckBox();
        jCheckBoxTriângulo = new javax.swing.JCheckBox();
        jCheckBoxExtintor = new javax.swing.JCheckBox();
        jCheckBoxDocumento_Veicular = new javax.swing.JCheckBox();
        jCheckBoxCintos_de_segurança = new javax.swing.JCheckBox();
        jCheckBoxLimpeza_Interior = new javax.swing.JCheckBox();
        jCheckBoxLimpeza_Exterior = new javax.swing.JCheckBox();
        jCheckBoxChave_Ignição = new javax.swing.JCheckBox();
        jCheckBoxChave_de_Roda = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        MatriculaDoFuncionario = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservações = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jCheckBoxFarol_Esq = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1018, 680));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("N° Veículo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chassi");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 110, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("N° de Portas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 120, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Placa");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 120, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ano");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 130, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Disponibilidade");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 100, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tipo De Veículo");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 120, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Modelo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, 30));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setToolTipText("O número de matricula é gerado automaticamente");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTextField1.setMinimumSize(new java.awt.Dimension(7, 30));
        jTextField1.setPreferredSize(new java.awt.Dimension(7, 30));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 250, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTextField2.setPreferredSize(new java.awt.Dimension(7, 30));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 250, -1));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTextField3.setPreferredSize(new java.awt.Dimension(7, 30));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 250, -1));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTextField4.setPreferredSize(new java.awt.Dimension(7, 30));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 250, 30));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTextField5.setPreferredSize(new java.awt.Dimension(7, 30));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 250, -1));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTextField6.setPreferredSize(new java.awt.Dimension(7, 30));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 250, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Luxo", "Simples", "Diesel" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jComboBox1.setPreferredSize(new java.awt.Dimension(74, 30));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 250, -1));

        jLabelBotaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoAdcionar.png"))); // NOI18N
        jLabelBotaoAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotaoAdicionarMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBotaoAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        jLabelExcluirVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoExcluir.png"))); // NOI18N
        jLabelExcluirVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExcluirVeiculoMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelExcluirVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, -1, 80));

        jTextField7.setEditable(false);
        jTextField7.setToolTipText("Este campo será preenchido altomaticamente após o preenchimento da CHECK LIST");
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 250, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/fundo do label de altomovel.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 200, 410));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/BotaoVoltar.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(51, 0, 255));
        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 255, 0), new java.awt.Color(0, 0, 255), java.awt.Color.white, new java.awt.Color(0, 204, 153)));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 150, 1080, 10));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/pesquisar veiculo.png"))); // NOI18N
        jPanel2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 41));

        jTextField9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9MouseClicked(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 24, 226, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Pesquisar veículo com o Nº do cgassi");
        jPanel2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 1, -1, -1));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/Imagem checklist.png"))); // NOI18N
        jLabel52.setText("jLabel52");
        jPanel2.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 48, 134, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("Para conslta da check ");
        jPanel2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 67, -1, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("list aperte o botão");
        jPanel2.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 90, 137, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setText("Pequisar ao lado");
        jPanel2.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 113, 137, -1));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoPesquisa.png"))); // NOI18N
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 630, 100));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 150));

        jPanel1.setVisible(true);
        jPanel1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxFarol_dir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxFarol_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFarol_dirActionPerformed(evt);
            }
        });
        jPanel1.getContentPane().add(jCheckBoxFarol_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, 25));

        jCheckBoxPisca_Esq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxPisca_Esq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, 25));

        jCheckBoxPisca_Dir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxPisca_Dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, 25));

        jCheckBoxLanterna_Esq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxLanterna_Esq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, 25));

        jCheckBoxLanterna_Dir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxLanterna_Dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, 25));

        jCheckBoxLuz_Freio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxLuz_Freio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, 25));

        jCheckBoxLuz_Placa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxLuz_Placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, 25));

        jCheckBoxBuzina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxBuzina, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, 25));

        jCheckBoxAr_condicionado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxAr_condicionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, 25));

        jCheckBoxRetrovisor_Interno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxRetrovisor_Interno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, 25));

        jCheckBoxRetrovisor_Esq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxRetrovisor_Esq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, 25));

        jCheckBoxRetrovisor_Dir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxRetrovisor_Dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, 25));

        jCheckBoxLimpador_Parabrisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxLimpador_Parabrisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, 25));

        jCheckBoxVidros_Laterais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxVidros_Laterais, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, 25));

        jCheckBoxParabrisa_Traseiro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxParabrisa_Traseiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, 25));

        jCheckBoxParabrisa_Dianteiro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxParabrisa_Dianteiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, 25));

        jCheckBoxEstofamento_Bancos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxEstofamento_Bancos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 25));

        jCheckBoxTapetes_Internos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxTapetes_Internos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, 25));

        jCheckBoxForro_Interno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxForro_Interno, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, 25));

        jCheckBoxMacaco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxMacaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, 25));

        jCheckBoxEstepe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxEstepe, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, 25));

        jCheckBoxTriângulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxTriângulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, 25));

        jCheckBoxExtintor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxExtintor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, 25));

        jCheckBoxDocumento_Veicular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxDocumento_Veicular, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, 25));

        jCheckBoxCintos_de_segurança.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxCintos_de_segurança, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, 25));

        jCheckBoxLimpeza_Interior.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxLimpeza_Interior, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, 25));

        jCheckBoxLimpeza_Exterior.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxLimpeza_Exterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, 25));

        jCheckBoxChave_Ignição.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxChave_Ignição, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, 25));

        jCheckBoxChave_de_Roda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jCheckBoxChave_de_Roda, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, 25));

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Farol Esquerdo");
        jPanel1.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, 25));

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("Farol Direito");
        jPanel1.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 90, 25));

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 0));
        jLabel16.setText("Pisca Esquerdo");
        jPanel1.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 25));

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText("Pisca Direito");
        jPanel1.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 100, 25));

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("Lanterna Esquerda");
        jPanel1.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 140, 25));

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 0));
        jLabel19.setText("Lanterna Direita");
        jPanel1.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 120, 25));

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 0));
        jLabel20.setText("Luz de Freio");
        jPanel1.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, 25));

        jLabel21.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 0));
        jLabel21.setText("Luz Placa");
        jPanel1.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 70, 25));

        jLabel22.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 0));
        jLabel22.setText("Buzina");
        jPanel1.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, 25));

        jLabel23.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 0));
        jLabel23.setText("Ar Condicionado");
        jPanel1.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, 25));

        jLabel24.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 0));
        jLabel24.setText("Retrovisor Interno");
        jPanel1.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 140, 25));

        jLabel25.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 0));
        jLabel25.setText("Retovisor Esquerdo");
        jPanel1.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 140, 25));

        jLabel26.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 0));
        jLabel26.setText("Limpador de Parabrisa");
        jPanel1.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 300, 160, 25));

        jLabel27.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 0));
        jLabel27.setText("Vidros Laterais");
        jPanel1.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 110, 25));

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 0));
        jLabel28.setText("Parabrisa Traseiro");
        jPanel1.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 130, 25));

        jLabel29.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 0));
        jLabel29.setText("Parabrisa Dianteiro");
        jPanel1.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 140, 25));

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 0));
        jLabel30.setText("Tapetes Internos");
        jPanel1.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 120, 25));

        jLabel31.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 0));
        jLabel31.setText("Forros Internos");
        jPanel1.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 120, 25));

        jLabel32.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 0));
        jLabel32.setText("Macaco");
        jPanel1.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 60, 25));

        jLabel33.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 0));
        jLabel33.setText("Chave de Roda");
        jPanel1.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 110, 25));

        jLabel34.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 0));
        jLabel34.setText("Estepe");
        jPanel1.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 60, 25));

        jLabel35.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 0));
        jLabel35.setText("Triangolo");
        jPanel1.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 70, 25));

        jLabel36.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 0));
        jLabel36.setText("Extintor");
        jPanel1.getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 70, 25));

        jLabel37.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 0));
        jLabel37.setText("Documento Veicular");
        jPanel1.getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 150, 25));

        jLabel38.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 0));
        jLabel38.setText("Cintos de Segurança");
        jPanel1.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 150, 25));

        jLabel39.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 0));
        jLabel39.setText("Limpesa Interior");
        jPanel1.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 120, 25));

        jLabel40.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 0));
        jLabel40.setText("Limpesa Exterior");
        jPanel1.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 120, 25));

        jLabel41.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 0));
        jLabel41.setText("Retrovisor Direito");
        jPanel1.getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, 25));

        jLabel42.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 0));
        jLabel42.setText("Chave de Ignição");
        jPanel1.getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 120, 25));

        jLabel43.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 0));
        jLabel43.setText("Estofamento do Banco");
        jPanel1.getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 170, 25));

        jLabel44.setText("ID");
        jPanel1.getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 20));

        jTextField8.setEditable(false);
        jPanel1.getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 20));
        jPanel1.getContentPane().add(MatriculaDoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 70, -1));

        jTextField10.setEditable(false);
        jPanel1.getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 50, -1));
        jPanel1.getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 630, -1));

        jLabel45.setText("Matricla");
        jPanel1.getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, 20));

        jLabel46.setText("Nº veiculo");
        jPanel1.getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 60, 20));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 10, 530));

        jTextAreaObservações.setColumns(20);
        jTextAreaObservações.setForeground(new java.awt.Color(0, 51, 255));
        jTextAreaObservações.setRows(5);
        jTextAreaObservações.setDisabledTextColor(new java.awt.Color(255, 255, 0));
        jTextAreaObservações.setSelectionColor(new java.awt.Color(255, 255, 51));
        jScrollPane1.setViewportView(jTextAreaObservações);

        jPanel1.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 90, 320));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoUpdate.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));
        jPanel1.getContentPane().add(jCheckBoxFarol_Esq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 25));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoAdcionar.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/fundo do label de altomovel2.png"))); // NOI18N
        jPanel1.getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 40, 460));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/fundo do label de altomovel2.png"))); // NOI18N
        jPanel1.getContentPane().add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 40, 470));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/Tela fundo automoveAgora siml.jpg"))); // NOI18N
        jPanel1.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-360, -220, -1, -1));

        jTextField11.setText("jTextField11");
        jPanel1.getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 650, 470));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/Tela fundo automoveAgora siml.jpg"))); // NOI18N
        getContentPane().add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        setBounds(0, 0, 1018, 680);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelBotaoAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotaoAdicionarMouseClicked
        // TODO add your handling code here:
        adicinarNovoAutomóvel();
    }//GEN-LAST:event_jLabelBotaoAdicionarMouseClicked

    private void jLabelExcluirVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExcluirVeiculoMouseClicked
        // TODO add your handling code here:
        ExcluirVeiculo();
    }//GEN-LAST:event_jLabelExcluirVeiculoMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        TelaInicial();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
        consultarVeiculo01();
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        // TODO add your handling code here:
        jTable2.setVisible(true);
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        // TODO add your handling code here:
        PesquisarVeiculo();
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        preenchimentoAuto();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        atualizarCheckList();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        adicinarCheckList();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jCheckBoxFarol_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFarol_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxFarol_dirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MatriculaDoFuncionario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBoxAr_condicionado;
    private javax.swing.JCheckBox jCheckBoxBuzina;
    private javax.swing.JCheckBox jCheckBoxChave_Ignição;
    private javax.swing.JCheckBox jCheckBoxChave_de_Roda;
    private javax.swing.JCheckBox jCheckBoxCintos_de_segurança;
    private javax.swing.JCheckBox jCheckBoxDocumento_Veicular;
    private javax.swing.JCheckBox jCheckBoxEstepe;
    private javax.swing.JCheckBox jCheckBoxEstofamento_Bancos;
    private javax.swing.JCheckBox jCheckBoxExtintor;
    private javax.swing.JCheckBox jCheckBoxFarol_Esq;
    private javax.swing.JCheckBox jCheckBoxFarol_dir;
    private javax.swing.JCheckBox jCheckBoxForro_Interno;
    private javax.swing.JCheckBox jCheckBoxLanterna_Dir;
    private javax.swing.JCheckBox jCheckBoxLanterna_Esq;
    private javax.swing.JCheckBox jCheckBoxLimpador_Parabrisa;
    private javax.swing.JCheckBox jCheckBoxLimpeza_Exterior;
    private javax.swing.JCheckBox jCheckBoxLimpeza_Interior;
    private javax.swing.JCheckBox jCheckBoxLuz_Freio;
    private javax.swing.JCheckBox jCheckBoxLuz_Placa;
    private javax.swing.JCheckBox jCheckBoxMacaco;
    private javax.swing.JCheckBox jCheckBoxParabrisa_Dianteiro;
    private javax.swing.JCheckBox jCheckBoxParabrisa_Traseiro;
    private javax.swing.JCheckBox jCheckBoxPisca_Dir;
    private javax.swing.JCheckBox jCheckBoxPisca_Esq;
    private javax.swing.JCheckBox jCheckBoxRetrovisor_Dir;
    private javax.swing.JCheckBox jCheckBoxRetrovisor_Esq;
    private javax.swing.JCheckBox jCheckBoxRetrovisor_Interno;
    private javax.swing.JCheckBox jCheckBoxTapetes_Internos;
    private javax.swing.JCheckBox jCheckBoxTriângulo;
    private javax.swing.JCheckBox jCheckBoxVidros_Laterais;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBotaoAdicionar;
    private javax.swing.JLabel jLabelExcluirVeiculo;
    private javax.swing.JInternalFrame jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextAreaObservações;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
