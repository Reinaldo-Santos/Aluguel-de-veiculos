package br.com.telas;

import br.com.bancoDeDados.Conectar_com_banco_de_dadaos;
import br.com.telas.TelaAutomóvel.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Reinaldo Santos
 */
public class TelaLocacao extends javax.swing.JInternalFrame {

    Connection conectar = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String ddd, zj, j, modelo, l;
    boolean ab;

    /**
     * Creates new form TelaLocacao
     */
    public TelaLocacao() {

        initComponents();
        conectar = Conectar_com_banco_de_dadaos.conexao();
    }

    private void ConsultarChelistt() {
        String consultar = "select * from  checklist where veiculo= ? ";
        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextField13.getText());
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

    public void ModificarParaAlugado(JTextArea area, JCheckBox box) {
        String h = "UPDATE `alugueldecarros01`.`checklist` SET `Farol_Esq` = ?, "
                + "`Observações` = ? "
                + "WHERE (`idCheckList` = ?)";
        area.setText("Este veívulo esta alugado. ");
        box.setText("Não");
        box.setSelected(false);
        try {
            pst = conectar.prepareStatement(h);
            pst.setString(1, box.getText());
            pst.setString(7, area.getText());
        } catch (Exception e) {
        }
    }

//    public void AtualizarAluguel() {
//        String d = " UPDATE locacao SET data_devolucao = ? WHERE nrlocacao = ?";
//        try {
//            pst = conectar.prepareStatement(d);
//            pst.setString(1, Entregaa.getText());
//            if (Entregaa.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Somente o campo 'Data de Devolução' pode ser alterado.\n"
//                        + ",Para alterada é necessário preenche-la. ");
//            } else {
//                int confirmarInsercaoDeDados = pst.executeUpdate();
//                if (confirmarInsercaoDeDados > 0) {
//                    JOptionPane.showMessageDialog(null, "Data de devolução alterada com susseso. ");
//                    Entregaa.setText(null);
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "Valo d e devolução no update" + Entregaa.getText());
//                }
//            }
//        } catch (Exception e) {
//        }
//    }

    private void realizarAluguel() {
        String inserirDados = "INSERT INTO `alugueldecarros01`.`locacao` "
                + "(`nrVeiculo`, `matricula`, `nr`, `data_devolucao`) VALUES (?, ?, ?,?)";
        if (ab == false) {
            JOptionPane.showMessageDialog(null, "Este veículo esta indiponível.\nConsulte"
                    + " o cheking do mesmo\npara mais informações.");
        } else {

            try {

                pst = conectar.prepareStatement(inserirDados);
                //pst.setString(1, jTextFieldMatriclula.getText());
                pst.setString(1, jTextField13.getText());
                pst.setString(2, Funcionariu.getText());
                pst.setString(3, cliente.getText());
                pst.setString(4, Locacaoo.getText());

                if (Veiculooo.getText().isEmpty() || Funcionariu.getText().isEmpty()
                        || Locacaoo.getText().isEmpty() || cliente.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos são Obrigatórios!");
                } else {
                    l = Funcionariu.getText();
                    int confirmarInsercaoDeDados = pst.executeUpdate();
                    if (confirmarInsercaoDeDados > 0) {

                        JOptionPane.showMessageDialog(null, "Aluguel realizado com sussesso. ");
                        Veiculooo.setText(null);
                        Funcionariu.setText(null);
                        cliente.setText(null);
                        Locacaoo.setText(null);
                        Entregaa.setText(null);
                        ModificarParaAlugado(jTextAreaObservações, jCheckBoxFarol_Esq);
                        atualizarCheckList01();
                    } else {

                    }

                }
            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Este número de matricula Já exixte");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }

    public void consultarCliente01() {
        // tirar observação jPanel3.setVisible(false);
        String consultar = "SELECT * FROM cliente where razao_social like ?";
        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextFieldRazaoSocial.getText() + "%");
            rs = pst.executeQuery();
            jTable1Ciente.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void preenchimentoAuto() {
        int copia = jTable1Ciente.getSelectedRow();
        try {
            jPanel2.setVisible(false);
            jTextFieldNumeroCli.setText(jTable1Ciente.getModel().getValueAt(copia, 0).toString());
            cliente.setText(jTable1Ciente.getModel().getValueAt(copia, 0).toString());
            jTextFieldRazaoSocial.setText(jTable1Ciente.getModel().getValueAt(copia, 1).toString());
            jTextFieldenderecoCli.setText(jTable1Ciente.getModel().getValueAt(copia, 2).toString());
            jTextFieldCnpjCli.setText(jTable1Ciente.getModel().getValueAt(copia, 3).toString());
            jTextFieldTelefone.setText(jTable1Ciente.getModel().getValueAt(copia, 4).toString());
            jTextFieldEmail.setText(jTable1Ciente.getModel().getValueAt(copia, 5).toString());
            jTextField11.setVisible(true);
            Funcionariu.setVisible(true);
            Veiculooo.setVisible(true);
            cliente.setVisible(true);
            Entregaa.setVisible(true);
            BotaoRealizarAluguel.setVisible(true);
            Locacaoo.setVisible(true);
            jLabel59.setVisible(true);
            jLabel62.setVisible(true);
            jLabel61.setVisible(true);
            jLabel63.setVisible(true);
            Modelo.setVisible(true);
            jLabel64.setVisible(true);
            jLabel65.setVisible(true);
            jPanel2.setVisible(true);
        jTextFieldNumeroCli.setVisible(true);
        jTextFieldCnpjCli.setVisible(true);
        jTextFieldTelefone.setVisible(true);
        jTextFieldEmail.setVisible(true);
        jTextFieldRazaoSocial.setVisible(true);
        jTextFieldenderecoCli.setVisible(true);
        jLabel1.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jLabel7.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
//            jTable1.setVisible(false);
        } catch (Exception e) {

        }

    }

    public void consultarAluguelnomes() {

        String consultar = "SELECT l.nrlocacao as N°, v.Modelo as Modelo, f.nome as Funcionário,c.razao_social as `Razão Social` FROM locacao as l\n"
                + "inner join veiculo as v\n"
                + "on l.nrVeiculo=v.nrVeiculo\n"
                + "inner join funcionario as f\n"
                + "on l.matricula = f.matricula\n"
                + "inner join cliente as c\n"
                + "on l.nr=c.nrCliente \n"
                + "where c.razao_social like ?";
        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextField17.getText() + "%");
            rs = pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void consultarAluguelData() {

        String consultar = "  SELECT data_locacao, data_devolucao ,v.nrVeiculo FROM locacao as l\n"
                + "inner join veiculo as v\n"
                + "on l.nrVeiculo=v.nrVeiculo\n"
                + "inner join funcionario as f\n"
                + "on l.matricula = f.matricula\n"
                + "inner join cliente as c\n"
                + "on l.nr=c.nrCliente \n"
                + "where l.nrlocacao = ?";
        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextField12.getText());
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void preenchimentoAutoAluguelNome() {
        int copia = jTable3.getSelectedRow();
        try {
            jTextField11.setText(jTable3.getModel().getValueAt(copia, 0).toString());
            jTextField12.setText(jTable3.getModel().getValueAt(copia, 0).toString());
            Veiculooo.setText(jTable3.getModel().getValueAt(copia, 1).toString());
            Funcionariu.setText(jTable3.getModel().getValueAt(copia, 2).toString());
            cliente.setText(jTable3.getModel().getValueAt(copia, 3).toString());
            Locacaoo.setText(jTable3.getModel().getValueAt(copia, 4).toString());
            Entregaa.setText(jTable3.getModel().getValueAt(copia, 5).toString());

//            jLabelBotaoAdicionar.setVisible(false);
//            jTextArea1.setLineWrap(true);
//            jTextArea1.setWrapStyleWord(true);
//            jPanel1.setVisible(true);
//            jLabelSalvar.setVisible(false);
        } catch (Exception e) {

        }

    }

    public void preenchimentoAutoAluguelData() {
        int copia = jTable1.getSelectedRow();
        try {
            Locacaoo.setText(jTable1.getModel().getValueAt(copia, 0).toString());
            Entregaa.setText(jTable1.getModel().getValueAt(copia, 1).toString());
            jTextField13.setText(jTable1.getModel().getValueAt(copia, 2).toString());

//            jLabelBotaoAdicionar.setVisible(false);
//            jTextArea1.setLineWrap(true);
//            jTextArea1.setWrapStyleWord(true);
//            jPanel1.setVisible(true);
//            jLabelSalvar.setVisible(false);
        } catch (Exception e) {

        }

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

    public void preenchimentoAutoCarro() {
        int copia = jTable2.getSelectedRow();
        try {
            jPanel2.setVisible(true);
            jTextField1.setText(jTable2.getModel().getValueAt(copia, 0).toString());
            jTextField13.setText(jTable2.getModel().getValueAt(copia, 0).toString());
            jTextField2.setText(jTable2.getModel().getValueAt(copia, 1).toString());
            Veiculooo.setText(jTable2.getModel().getValueAt(copia, 1).toString());
            jTextField3.setText(jTable2.getModel().getValueAt(copia, 2).toString());
            jTextField4.setText(jTable2.getModel().getValueAt(copia, 3).toString());
            jTextField5.setText(jTable2.getModel().getValueAt(copia, 4).toString());
            jTextField6.setText(jTable2.getModel().getValueAt(copia, 5).toString());
            jTextField7.setText(jTable2.getModel().getValueAt(copia, 6).toString());
            jComboBox1.setSelectedItem(jTable2.getModel().getValueAt(copia, 7).toString());
            jTextField11.setVisible(true);
            Funcionariu.setVisible(true);
            Veiculooo.setVisible(true);
            cliente.setVisible(true);
            Entregaa.setVisible(true);
            BotaoRealizarAluguel.setVisible(true);
            Locacaoo.setVisible(true);
            jLabel59.setVisible(true);
            jLabel62.setVisible(true);
            jLabel61.setVisible(true);
            jLabel63.setVisible(true);
            Modelo.setVisible(true);
            jLabel64.setVisible(true);
            jLabel65.setVisible(true);
            jTable1.setVisible(false);

        } catch (Exception e) {

        }

    }

    public JCheckBox escreve_SIM_ou_NAO_no_jcheckbox(JCheckBox j) {
        String nao = "Não", sim = "Ok";
        if (j.getText().equals(sim)) {
            j.setSelected(true);
        } else {
            j.setSelected(false);
        }
        return j;
    }

    private void PesquisarVeiculo() {
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
                escreve_SIM_ou_NAO_no_jcheckbox(jCheckBoxTriângulo);
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
//                MatriculaDoFuncionario.setText(rs.getString(41));
//                jTextField13.setText(rs.getString(41));

                jTextField10.setText(rs.getString(42));
                //jLabelBotaoAdicionar.setToolTipText("Você não pode adicionar este funcionário pois ele já existe");
                //jLabelBotaoAdicionar.setVisible(false);
                jLabel11.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario inexistente");
                jTextField2.setText(null);
                jTextField3.setEditable(true);
                jTextField3.setText(null);
                jTextField4.setText(null);
                jTextField5.setText(null);
                jTextField6.setText(null);
                jTextField1.setText(null);
                jComboBox1.setSelectedItem(null);
                //jLabelBotaoAdicionar.setVisible(true);
                jPanel1.setVisible(false);
            }
        } catch (Exception e) {
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
                    //jLabelBotaoAdicionar.setVisible(true);

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
                    jPanel1.setVisible(true);
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
                    // jLabelBotaoAdicionar.setVisible(true);
                    // TelaInicial();
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
                    //jLabelBotaoAdicionar.setVisible(true);
                    jLabel10.setVisible(true);
                    //jLabelExcluirVeiculo.setVisible(true);
                    jLabel13.setVisible(true);
                    jLabel54.setVisible(true);
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

    public JTextField PesquisarCoverter() {
        String consultar = "select * from veiculo where chassi=?";

        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextField3.getText());
            rs = pst.executeQuery();
            if (rs.next()) {

                jTextField10.setText(rs.getString(1));
                jTextField1.setText(rs.getString(1));
                jTextField13.setText(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return jTextField10;
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
                        //jLabelExcluirVeiculo.setVisible(false);
                        jLabel13.setVisible(false);
                        jLabel54.setVisible(false);
                        //jLabelBotaoAdicionar.setVisible(false);
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

    public void atualizarCheckList01() {
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
            MatriculaDoFuncionario.setText(l);
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
                    // jLabelBotaoAdicionar.setVisible(true);
                    // TelaInicial();
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
//REINALDO,vi no you tobe o comadao getData que pode vir a resover o preblema de não capiturar a data no jtexfield
    //por issso ainda não testei esse metodo EXCLUIR.

    private void ExcluirLocaçao() {
        int ap = JOptionPane.showConfirmDialog(null, "Os dados apagados não poderão ser recuperados\nTem certeza que deseja apagá-lo? ", "Atenção", JOptionPane.YES_NO_OPTION);
        if (ap == 0) {

            String a = "delete from locacao where nrlocacao=? ";

            try {

                int u = JOptionPane.showConfirmDialog(null, "Para excluir locação é necessário  fazer checkin no veículo", "Atenção", JOptionPane.NO_OPTION);
                if (u > 0) {
                    JOptionPane.showMessageDialog(null, "operação cancelada!");
                } else {
                    ConsultarChelistt();
                   
                    if (jTextAreaObservações.equals(zj)) {
                        JOptionPane.showMessageDialog(null, "Escreva 'OK'ou faça outra anotação na fixa de observações");
                    } else {

                        pst = conectar.prepareStatement(a);
                        pst.setString(1, jTextField11.getText());
                        int confg = pst.executeUpdate();
                        if (confg > 0) {
                            jTextField11.setText("");
                            Funcionariu.setText("");
                            cliente.setText("");
                            Veiculooo.setText("");
                            Locacaoo.setText(null);
                            Entregaa.setText(null);

                        }
                    }
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

        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1Ciente = new javax.swing.JTable();
        jTextFieldPesquisarTabelaCliente = new javax.swing.JTextField();
        jTextFieldRazaoSocial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldenderecoCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNumeroCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCnpjCli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
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
        jCheckBoxExtintor = new javax.swing.JCheckBox();
        jCheckBoxDocumento_Veicular = new javax.swing.JCheckBox();
        jCheckBoxCintos_de_segurança = new javax.swing.JCheckBox();
        jCheckBoxLimpeza_Interior = new javax.swing.JCheckBox();
        jCheckBoxLimpeza_Exterior = new javax.swing.JCheckBox();
        jCheckBoxChave_Ignição = new javax.swing.JCheckBox();
        jCheckBoxChave_de_Roda = new javax.swing.JCheckBox();
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
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        MatriculaDoFuncionario = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservações = new javax.swing.JTextArea();
        jCheckBoxFarol_Esq = new javax.swing.JCheckBox();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jCheckBoxTriângulo = new javax.swing.JCheckBox();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        cliente = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        Funcionariu = new javax.swing.JTextField();
        Modelo = new javax.swing.JLabel();
        Veiculooo = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        Locacaoo = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        Entregaa = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        BotaoRealizarAluguel = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tela Para Alugar Automóvel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1018, 680));
        getContentPane().setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/pesquisar11112.png"))); // NOI18N
        jLabel10.setText("Pesquisar cliente");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 10, 160, 25);

        jTable1Ciente.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1Ciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1CienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1Ciente);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 40, 420, 90);

        jTextFieldPesquisarTabelaCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldPesquisarTabelaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarTabelaClienteActionPerformed(evt);
            }
        });
        jTextFieldPesquisarTabelaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarTabelaClienteKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisarTabelaCliente);
        jTextFieldPesquisarTabelaCliente.setBounds(170, 10, 80, 25);

        jTextFieldRazaoSocial.setEditable(false);
        jTextFieldRazaoSocial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldRazaoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRazaoSocialActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldRazaoSocial);
        jTextFieldRazaoSocial.setBounds(70, 160, 170, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("N°");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 130, 20, 20);

        jTextFieldenderecoCli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextFieldenderecoCli);
        jTextFieldenderecoCli.setBounds(270, 160, 160, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Razão Social");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 160, 120, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("End");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(250, 160, 30, 25);

        jTextFieldNumeroCli.setEditable(false);
        jTextFieldNumeroCli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldNumeroCli.setToolTipText("Este Campo é preenchido automaticamaente");
        getContentPane().add(jTextFieldNumeroCli);
        jTextFieldNumeroCli.setBounds(20, 130, 30, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("CNPJ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 130, 50, 25);

        jTextFieldCnpjCli.setEditable(false);
        jTextFieldCnpjCli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextFieldCnpjCli);
        jTextFieldCnpjCli.setBounds(80, 130, 100, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tel");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 130, 20, 25);

        jTextFieldTelefone.setEditable(false);
        jTextFieldTelefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefoneActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTelefone);
        jTextFieldTelefone.setBounds(200, 130, 90, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Email");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(290, 130, 30, 25);

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextFieldEmail);
        jTextFieldEmail.setBounds(320, 130, 110, 25);

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9MouseClicked(evt);
            }
        });
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField9);
        jTextField9.setBounds(550, 10, 120, 25);

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Digite chassi");
        getContentPane().add(jLabel51);
        jLabel51.setBounds(470, 10, 80, 25);

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("Consulatar");
        getContentPane().add(jLabel53);
        jLabel53.setBounds(760, 10, 70, 25);

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("Check liste");
        getContentPane().add(jLabel55);
        jLabel55.setBounds(830, 10, 70, 25);

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoPesquisaLocaçao.png"))); // NOI18N
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel54);
        jLabel54.setBounds(900, 0, 40, 40);

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

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(470, 40, 520, 90);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("N°");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(470, 130, 20, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Chassi");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(840, 130, 40, 25);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("N° de Portas");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(530, 130, 70, 25);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Placa");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(740, 130, 30, 25);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Ano");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(640, 130, 22, 25);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Disponível");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(480, 160, 60, 25);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Tipo De Veículo");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(800, 160, 86, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Modelo");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(590, 160, 39, 25);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Luxo", "Simples", "Diesel" }));
        jComboBox1.setBorder(null);
        jComboBox1.setPreferredSize(new java.awt.Dimension(74, 30));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(890, 160, 100, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(490, 130, 30, 25);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(600, 130, 30, 25);

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7);
        jTextField7.setBounds(540, 160, 40, 25);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(630, 160, 160, 25);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(880, 130, 110, 25);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(770, 130, 60, 25);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(660, 130, 70, 25);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoUpdate.png"))); // NOI18N
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel49);
        jLabel49.setBounds(30, 50, 84, 77);

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoAdcionar.png"))); // NOI18N
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel50);
        jLabel50.setBounds(30, 50, 84, 77);

        jLabel56.setText("Reinaldo c Santos");
        getContentPane().add(jLabel56);
        jLabel56.setBounds(80, 610, 330, 14);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de checagem de item de veículo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel1.setVisible(true);
        jPanel1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.getContentPane().add(jCheckBoxFarol_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxPisca_Esq, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxPisca_Dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxLanterna_Esq, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxLanterna_Dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxLuz_Freio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxLuz_Placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxBuzina, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxAr_condicionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, 18));
        jPanel1.getContentPane().add(jCheckBoxRetrovisor_Interno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxRetrovisor_Esq, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxRetrovisor_Dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxLimpador_Parabrisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxVidros_Laterais, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxParabrisa_Traseiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxParabrisa_Dianteiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxEstofamento_Bancos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxTapetes_Internos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxForro_Interno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, 18));
        jPanel1.getContentPane().add(jCheckBoxMacaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxEstepe, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxExtintor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxDocumento_Veicular, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxCintos_de_segurança, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxLimpeza_Interior, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxLimpeza_Exterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, 16));
        jPanel1.getContentPane().add(jCheckBoxChave_Ignição, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, 18));
        jPanel1.getContentPane().add(jCheckBoxChave_de_Roda, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, 16));

        jLabel16.setText("Farol Esquerdo");
        jPanel1.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 16));

        jLabel17.setText("Farol Direito");
        jPanel1.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 16));

        jLabel18.setText("Pisca Esquerdo");
        jPanel1.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 16));

        jLabel19.setText("Pisca Direito");
        jPanel1.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 16));

        jLabel20.setText("Lanterna Esquerda");
        jPanel1.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 110, 16));

        jLabel21.setText("Lanterna Direita");
        jPanel1.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, 16));

        jLabel22.setText("Luz de Freio");
        jPanel1.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 70, 16));

        jLabel23.setText("Luz Placa");
        jPanel1.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 50, 16));

        jLabel24.setText("Buzina");
        jPanel1.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 16));

        jLabel25.setText("Ar Condicionado");
        jPanel1.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, 18));

        jLabel26.setText("Retrovisor Interno");
        jPanel1.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 90, 16));

        jLabel27.setText("Retovisor Esq");
        jPanel1.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 70, 16));

        jLabel28.setText("Limpador de Parab");
        jPanel1.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 90, 20));

        jLabel29.setText("Vidros Laterais");
        jPanel1.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 70, 16));

        jLabel30.setText("Parabrisa Traseiro");
        jPanel1.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 90, 16));

        jLabel31.setText("Parabrisa Dianteiro");
        jPanel1.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 100, 16));

        jLabel32.setText("Tapetes Internos");
        jPanel1.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 90, 16));

        jLabel33.setText("Forros Internos");
        jPanel1.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 80, 18));

        jLabel34.setText("Macaco");
        jPanel1.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 40, 16));

        jLabel35.setText("Chave de Roda");
        jPanel1.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 80, 16));

        jLabel36.setText("Estepe");
        jPanel1.getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 40, 16));

        jLabel37.setText("Triangolo");
        jPanel1.getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 50, 16));

        jLabel38.setText("Extintor");
        jPanel1.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 50, 16));

        jLabel39.setText("Documento Veicular");
        jPanel1.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 90, 16));

        jLabel40.setText("Cintos de Seg..");
        jPanel1.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, 16));

        jLabel41.setText("Limpesa Interior");
        jPanel1.getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, 16));

        jLabel42.setText("Limpesa Exterior");
        jPanel1.getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 80, 16));

        jLabel43.setText("Retrovisor Dir");
        jPanel1.getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 70, 16));

        jLabel44.setText("Chave de Ignição");
        jPanel1.getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 90, 18));

        jLabel45.setText("Estof do Banco");
        jPanel1.getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 80, 20));

        jLabel46.setText("ID");
        jPanel1.getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 25));

        jTextField8.setEditable(false);
        jPanel1.getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 25));

        MatriculaDoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatriculaDoFuncionarioActionPerformed(evt);
            }
        });
        jPanel1.getContentPane().add(MatriculaDoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 70, 25));

        jTextField10.setEditable(false);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel1.getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 50, 25));
        jPanel1.getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 28, 630, -1));

        jLabel47.setText("Matricla");
        jPanel1.getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 0, 40, 25));

        jLabel48.setText("Nº veiculo");
        jPanel1.getContentPane().add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 50, 25));

        jTextAreaObservações.setColumns(20);
        jTextAreaObservações.setForeground(new java.awt.Color(0, 51, 255));
        jTextAreaObservações.setRows(5);
        jTextAreaObservações.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 51), new java.awt.Color(0, 51, 255), new java.awt.Color(255, 255, 204), new java.awt.Color(255, 255, 0)), "Anotaões do ckecking", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jTextAreaObservações.setDisabledTextColor(new java.awt.Color(255, 255, 0));
        jTextAreaObservações.setSelectionColor(new java.awt.Color(255, 255, 51));
        jScrollPane1.setViewportView(jTextAreaObservações);

        jPanel1.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 360, 110));
        jPanel1.getContentPane().add(jCheckBoxFarol_Esq, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 16));

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/fundo do label de altomovel2.png"))); // NOI18N
        jPanel1.getContentPane().add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 40, 200));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoUpdateLocação.png"))); // NOI18N
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
        });
        jPanel1.getContentPane().add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 40, 40));

        jCheckBoxTriângulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxTriânguloActionPerformed(evt);
            }
        });
        jPanel1.getContentPane().add(jCheckBoxTriângulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, 16));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/fundo do label de altomovel2.png"))); // NOI18N
        jPanel1.getContentPane().add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 40, 200));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/fundo do label de altomovel2.png"))); // NOI18N
        jPanel1.getContentPane().add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 50, 390));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(540, 190, 450, 420);

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField17MouseClicked(evt);
            }
        });
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField17KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField17);
        jTextField17.setBounds(170, 210, 150, 30);

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/pesquisarCliente.png"))); // NOI18N
        jLabel66.setText("Pesquisar Locação");
        getContentPane().add(jLabel66);
        jLabel66.setBounds(30, 210, 140, 30);

        jPanel3.setLayout(null);

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel59.setText("Registro");
        jPanel3.add(jLabel59);
        jLabel59.setBounds(20, 150, 50, 25);

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField11);
        jTextField11.setBounds(70, 150, 30, 25);

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel62.setText("Cliente");
        jPanel3.add(jLabel62);
        jLabel62.setBounds(20, 210, 40, 25);

        cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });
        jPanel3.add(cliente);
        cliente.setBounds(70, 210, 290, 25);

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel61.setText("Funcionário");
        jPanel3.add(jLabel61);
        jLabel61.setBounds(10, 180, 60, 25);

        Funcionariu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Funcionariu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncionariuActionPerformed(evt);
            }
        });
        jPanel3.add(Funcionariu);
        Funcionariu.setBounds(70, 180, 290, 25);

        Modelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Modelo.setText("Modelo");
        jPanel3.add(Modelo);
        Modelo.setBounds(20, 240, 40, 25);

        Veiculooo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Veiculooo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VeiculoooActionPerformed(evt);
            }
        });
        jPanel3.add(Veiculooo);
        Veiculooo.setBounds(70, 240, 290, 25);

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel63.setText("Data de Locação");
        jPanel3.add(jLabel63);
        jLabel63.setBounds(110, 150, 90, 25);

        Locacaoo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Locacaoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocacaooActionPerformed(evt);
            }
        });
        jPanel3.add(Locacaoo);
        Locacaoo.setBounds(200, 150, 100, 25);

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel64.setText("Data De Devolução");
        jPanel3.add(jLabel64);
        jLabel64.setBounds(310, 150, 90, 25);

        Entregaa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Entregaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntregaaActionPerformed(evt);
            }
        });
        jPanel3.add(Entregaa);
        Entregaa.setBounds(400, 150, 100, 25);

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoExcluirLocação.png"))); // NOI18N
        jLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel67MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel67);
        jLabel67.setBounds(400, 190, 40, 40);

        BotaoRealizarAluguel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoAdcionarCliente.png"))); // NOI18N
        BotaoRealizarAluguel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoRealizarAluguelMouseClicked(evt);
            }
        });
        jPanel3.add(BotaoRealizarAluguel);
        BotaoRealizarAluguel.setBounds(400, 240, 40, 40);

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel65.setText("Adicionar");
        jPanel3.add(jLabel65);
        jLabel65.setBounds(450, 260, 50, 10);

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField13);
        jTextField13.setBounds(70, 270, 90, 25);

        jPanel2.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(10, 10, 200, 80);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable3);

        jPanel2.add(jScrollPane5);
        jScrollPane5.setBounds(210, 10, 280, 80);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(10, 20, 500, 110);

        jLabel68.setText("Excluir");
        jPanel3.add(jLabel68);
        jLabel68.setBounds(450, 200, 31, 14);

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel52.setText("Chassi");
        jPanel3.add(jLabel52);
        jLabel52.setBounds(21, 270, 40, 25);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 290, 520, 300);

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField12);
        jTextField12.setBounds(350, 210, 80, 30);

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/a.png"))); // NOI18N
        jLabel69.setText("jLabel69");
        getContentPane().add(jLabel69);
        jLabel69.setBounds(-10, 60, 1030, 740);

        setBounds(0, 0, 1018, 680);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1CienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1CienteMouseClicked
        // TODO add your handling code here:
        preenchimentoAuto();
        jPanel2.setVisible(false);
        jLabel67.setVisible(false);
        
    }//GEN-LAST:event_jTable1CienteMouseClicked

    private void jTextFieldPesquisarTabelaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarTabelaClienteKeyReleased
        // TODO add your handling code here:
        consultarCliente01();
    }//GEN-LAST:event_jTextFieldPesquisarTabelaClienteKeyReleased

    private void jTextFieldRazaoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRazaoSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRazaoSocialActionPerformed

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        // TODO add your handling code here:
        jTable2.setVisible(true);
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
        consultarVeiculo01();
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        // TODO add your handling code here:
        PesquisarVeiculo();
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        preenchimentoAutoCarro();
        jPanel2.setVisible(false);
                
    }//GEN-LAST:event_jTable2MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefoneActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        // TODO add your handling code here:
        atualizarCheckList();
    }//GEN-LAST:event_jLabel49MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:
        adicinarCheckList();
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
        // TODO add your handling code here:
        atualizarCheckList();
    }//GEN-LAST:event_jLabel58MouseClicked

    private void MatriculaDoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatriculaDoFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MatriculaDoFuncionarioActionPerformed

    private void jTextFieldPesquisarTabelaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarTabelaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisarTabelaClienteActionPerformed

    private void jCheckBoxTriânguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxTriânguloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxTriânguloActionPerformed

    private void BotaoRealizarAluguelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRealizarAluguelMouseClicked
        // TODO add your handling code here:
        realizarAluguel();
    }//GEN-LAST:event_BotaoRealizarAluguelMouseClicked

    private void EntregaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntregaaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EntregaaActionPerformed

    private void LocacaooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocacaooActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocacaooActionPerformed

    private void FuncionariuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FuncionariuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FuncionariuActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        jTextField11.setVisible(false);
//        Funcionariu.setVisible(false);
//        Veiculooo.setVisible(false);
//        cliente.setVisible(false);
//        Entregaa.setVisible(false);
//        BotaoRealizarAluguel.setVisible(false);
//        Locacaoo.setVisible(false);
//        jLabel59.setVisible(false);
//        jLabel62.setVisible(false);
//        jLabel61.setVisible(false);
//        jLabel63.setVisible(false);
//        jLabel60.setVisible(false);
//        jLabel64.setVisible(false);
//        jLabel65.setVisible(false);
        jPanel3.setVisible(true);
        preenchimentoAutoAluguelData();

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField17MouseClicked
        // TODO add your handling code here:
        jPanel2.setVisible(true);
        jTable1.setVisible(true);
        cliente.setText(null);
        jTextField13.setText(null);
        jTextFieldNumeroCli.setVisible(false);
        jTextFieldCnpjCli.setVisible(false);
        jTextFieldTelefone.setVisible(false);
        jTextFieldEmail.setVisible(false);
        jTextFieldRazaoSocial.setVisible(false);
        jTextFieldenderecoCli.setVisible(false);
        jLabel1.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel67.setVisible(true);
        
        
//        Funcionariu.setVisible(false);
//        Veiculooo.setVisible(false);
//        cliente.setVisible(false);
//        Entregaa.setVisible(false);
//        BotaoRealizarAluguel.setVisible(false);
//        Locacaoo.setVisible(false);
//        jLabel59.setVisible(false);
//        jLabel62.setVisible(false);
//        jLabel61.setVisible(false);
//        jLabel63.setVisible(false);
//        jLabel60.setVisible(false);
//        jLabel64.setVisible(false);
//        jLabel65.setVisible(false);
        jPanel3.setVisible(true);

    }//GEN-LAST:event_jTextField17MouseClicked

    private void jLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseClicked
        // TODO add your handling code here:
        ExcluirLocaçao();

    }//GEN-LAST:event_jLabel67MouseClicked

    private void jTextField17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyReleased
        // TODO add your handling code here:
        consultarAluguelnomes();
    }//GEN-LAST:event_jTextField17KeyReleased

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        // TODO add your handling code here:
        consultarAluguelData();
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        preenchimentoAutoAluguelNome();
    }//GEN-LAST:event_jTable3MouseClicked

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void VeiculoooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VeiculoooActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VeiculoooActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotaoRealizarAluguel;
    private javax.swing.JTextField Entregaa;
    private javax.swing.JTextField Funcionariu;
    private javax.swing.JTextField Locacaoo;
    private javax.swing.JTextField MatriculaDoFuncionario;
    private javax.swing.JLabel Modelo;
    private javax.swing.JTextField Veiculooo;
    private javax.swing.JTextField cliente;
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
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JInternalFrame jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable1Ciente;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextAreaObservações;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldCnpjCli;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNumeroCli;
    private javax.swing.JTextField jTextFieldPesquisarTabelaCliente;
    private javax.swing.JTextField jTextFieldRazaoSocial;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JTextField jTextFieldenderecoCli;
    // End of variables declaration//GEN-END:variables
}
