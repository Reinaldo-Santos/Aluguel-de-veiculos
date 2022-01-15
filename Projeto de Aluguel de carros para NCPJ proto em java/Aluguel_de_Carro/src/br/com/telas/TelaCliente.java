package br.com.telas;

import java.awt.Color;
import br.com.bancoDeDados.Conectar_com_banco_de_dadaos;
import java.sql.*;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Reinaldo Santos
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conectar = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String vv, contrato;

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conectar = Conectar_com_banco_de_dadaos.conexao();
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel2.setBackground(new Color(0, 0, 0, 0));
        jCheckBox2.setVisible(false);
        jLabelBotaoOK.setVisible(false);
        jLabel2.setVisible(false);
        jPanel1.setVisible(false);

    }

    void telaInicialClienete() {
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel2.setBackground(new Color(0, 0, 0, 0));
        jCheckBox2.setVisible(false);
        jLabelBotaoOK.setVisible(false);
        jPanel1.setVisible(false);
        jLabelBotaoSalvar1.setVisible(true);
        jLabelBotaoExcluir.setVisible(true);
        jLabelBotaoAtualizar.setVisible(true);
        jTextFieldNumeroCli.setVisible(true);
        jTextFieldCnpjCli.setVisible(true);
        jTextFieldEmail.setVisible(true);
        jTextFieldRazaoSocial.setVisible(true);
        jTextFieldTelefone.setVisible(true);
        jTextFieldenderecoCli.setVisible(true);
        jTextFieldNumeroCli.setText(null);
        jTextFieldCnpjCli.setText(null);
        jTextFieldEmail.setText(null);
        jTextFieldRazaoSocial.setText(null);
        jTextFieldTelefone.setText(null);
        jTextFieldenderecoCli.setText(null);
        jTextFieldPesquisarTabelaCliente.setText(null);
        jTable1Ciente.isShowing();
        jLabelSalvar.setVisible(true);
        jTable1Ciente.setEnabled(true);
        jTable1Ciente.setVisible(true);
        jTextFieldenderecoCli.setEditable(true);
        jTextFieldPesquisarTabelaCliente.setVisible(true);
        jTextFieldCnpjCli.setEditable(true);
        jTextFieldTelefone.setEditable(true);
        jTextFieldRazaoSocial.setEditable(true);
        jTextFieldEmail.setEditable(true);

    }

    //Este método gera o contrato do cliente.
    public void contrato() {
        //Este fragmento carrega o contrato.
        contrato = "\t\t\tCONTRATO DE LOCAÇÃO DE VEÍCULO\n\n\n"
                + "LOCADOR: Sheet Rent Car, portador do CNPJ nº 53932994000140, Endereço fisíco Rua Estr. Dr. Plínio Casado, 1466 - Centro, Nova Iguaçu - RJ, 26220-099.\n\n"
                + " LOCATÓRIO: " + jTextFieldRazaoSocial.getText() + " CNPJ: " + jTextFieldCnpjCli.getText() + " com sede " + jTextFieldenderecoCli.getText() + "\n"
                + "\n"
                + "As partes acima identificadas têm, entre si, justo e acertado o presente Contrato de Locação de Automóvel que se regerá pelas cláusulas seguintes e pelas condições descritas no presente.\n"
                + "\n"
                + "1. CLÁUSULA PRIMEIRA – DO OBJETO, PRAZO E USO\n"
                + "\n"
                + "\n"
                + "2.1. O LOCATÁRIO pagará ao LOCADOR a título de locação o valor anual de R$:...\n"
                + "\n"
                + "2.1.1. O atraso no pagamento do acordo da cláusula acima enseja multa de 5 % (cinco por cento) e juros de 1% (um por cento) ao dia.\n"
                + "\n"
                + "3. CLAÚSULA TERCEIRA – DAS OBRIGAÇÕES\n"
                + "\n"
                + "3.1. O LOCATÁRIO deverá manter o veículo em perfeito estado de conservação, de ordem mecânica, tapeçaria, funilaria e pneus, devendo entregar, com o término do contrato, o veículo e sua documentação ao LOCADOR nas mesmas condições em que recebeu.\n"
                + "\n"
                + "3.2. É de inteira responsabilidade do LOCATÁRIO os débitos de qualquer natureza, com data posterior a assinatura do presente contrato e até a data da rescisão, sejam de multas de trânsito, taxa de licenciamento, seguro obrigatório, seguro do veículo, IPVA e outros relacionados ao veículo.\n"
                + "\n"
                + "4. CLÁUSULA QUARTA - DA AUTORIZAÇÃO\n"
                + "\n"
                + "4.1. O LOCADOR, desde já autoriza o LOCATÁRIO, à implantação da identificação visual e do sistema de monitoramento instituído pela ARSAL.\n"
                + "\n"
                + "5. CLÁUSULA QUINTA – DA RESCISÃO \n"
                + "\n"
                + "5.1. A rescisão, antes do vencimento contratual, por iniciativa de qualquer das partes deverá ser precedida de notificação expressa com antecedência mínima de 60 (sessenta) dias a outra parte.\n"
                + "\n"
                + "5.2. O LOCATÁRIO, permissionário/autorizado, fica obrigado a comunicar à ARSAL sobre a intenção de rescisão do presente contrato manifestada por qualquer das partes, com antecedência mínima de 15 (quinze) dias.\n"
                + "\n"
                + "5.3. O descumprimento de qualquer das cláusulas por parte dos contratantes ensejará a rescisão deste instrumento e o devido pagamento de multa, pela parte inadimplente no valor de 3% (três por cento) do valor contratual.\n"
                + "\n"
                + "6. CLÁUSULA SEXTA – DAS DISPOSIÇÕES GERAIS \n"
                + "\n"
                + "6.1. O LOCADOR e LOCATÁRIO atestam que o veículo está sendo entregue em perfeitas condições de uso, na data da assinatura do presente instrumento, mediante vistoria.\n"
                + "\n"
                + "6.2. As partes contratantes elegem o foro de Maceió-AL, para dirimir qualquer ação oriunda deste contrato.\n"
                + "\n"
                + "E por estarem justo e contratados, assinam o presente instrumento em 02 (duas) vias de igual teor e forma, na presença de 02 (duas) testemunhas abaixo assinadas.\n"
                + "\n"
                + "\n";

        // Este fragmento (inserirDados) carrea a Inserção na tabela cliente da banco de dados
        String inserirDados = " INSERT INTO `alugueldecarros01`.`cliente` ( `razao_social`, `end_2`, `cnpj`, `telefone`, `email`, `contrato`) VALUES (?, ?,?, ?, ?, ?, ?)";
        ;
        // O try catch faz o tratamento de Exceção.
        try {
            pst = conectar.prepareStatement(inserirDados);
            pst.setString(1, jTextFieldRazaoSocial.getText());
            pst.setString(2, jTextFieldenderecoCli.getText());
            pst.setString(3, jTextFieldCnpjCli.getText());
            pst.setString(4, jTextFieldTelefone.getText());
            pst.setString(5, jTextFieldEmail.getText());
            // Este if impede o usuário de cadastrar um cliente sem um dos campos preenchidos
            if (jTextFieldRazaoSocial.getText().isEmpty() || jTextFieldenderecoCli.getText().isEmpty()
                    || jTextFieldCnpjCli.getText().isEmpty() || jTextFieldTelefone.getText().isEmpty()
                    || jTextFieldEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos Obrigatórios!");
            } else {
                //Oferece contrato
                int i = JOptionPane.showConfirmDialog(jPanel2, "Gerar contrato?"
                        + " ", "Atenção", JOptionPane.YES_OPTION);
                if (i > 0) {
                    int j = JOptionPane.showConfirmDialog(jPanel2, "Manter campos preenchido?"
                            + " ", "Esta opção limpa ou matém os campos acima preechidos", JOptionPane.YES_OPTION);
                    if (j > 0) {
                        jTextFieldNumeroCli.setText(null);
                        jTextFieldenderecoCli.setText(null);
                        jTextFieldCnpjCli.setText(null);
                        jTextFieldTelefone.setText(null);
                        jTextFieldRazaoSocial.setText(null);
                        jTextFieldEmail.setText(null);
                    } else {
                    }
                } else {
                    // Não deixa as frases serem quebrada independente do \n no fragmento.
                    jTextArea1.setWrapStyleWord(true);
                    // Quebra a linha detro do jTextArea. 
                    jTextArea1.setLineWrap(true);
                    //Torna o jPanel1 visível.
                    jPanel1.setVisible(true);
                    //Torna o jCheckBox2 visível.
                    jCheckBox2.setVisible(true);
                    //Método verifica se o jCheckBox2 esta preenchido.
                    checkbox_verdadeiro_falso(jCheckBox2);
                    jTextArea1.setText(contrato);
                    jPanel1.setVisible(true);
                    vv = jTextFieldNumeroCli.getText();
                    jTextFieldNumeroCli.setVisible(false);
                    jTable1Ciente.setEnabled(false);
                    jTable1Ciente.setVisible(false);
                    jTextFieldenderecoCli.setEditable(false);
                    jTextFieldPesquisarTabelaCliente.setVisible(false);
                    jTextFieldCnpjCli.setEditable(false);
                    jTextFieldTelefone.setEditable(false);
                    jTextFieldRazaoSocial.setEditable(false);
                    jTextFieldEmail.setEditable(false);
                    jLabelBotaoSalvar1.setVisible(false);
                    jLabelBotaoAtualizar.setVisible(false);
                    jLabelBotaoExcluir.setVisible(false);
                    jLabelSalvar.setVisible(false);
//                    jLabel1.setVisible(false);
//                    jLabel3.setVisible(false);
//                    jLabel4.setVisible(false);
//                    jLabel5.setVisible(false);
//                    jLabel6.setVisible(false);
//                    jLabel7.setVisible(false);
                    jLabel18.setVisible(false);
                    jLabel19.setVisible(false);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public JCheckBox checkbox_verdadeiro_falso(JCheckBox b) {
        jLabelBotaoOK.setVisible(true);
        if (b.isSelected() == true) {
            b.setSelected(true);
        } else {
            b.setSelected(false);
        }
        return b;

    }

    //Este método pesquisa os usuarios
    private void consultarCliente() {
        String consultar = "SELECT * FROM cliente where razao_social = ?";
        try {
            pst = conectar.prepareStatement(consultar);
            pst.setString(1, jTextFieldRazaoSocial.getText());
            rs = pst.executeQuery();
            if (rs.next()) {

                jTextFieldNumeroCli.setText(rs.getString(1));
                jTextFieldenderecoCli.setText(rs.getString(2));
                jTextFieldCnpjCli.setText(rs.getString(4));
                jTextFieldTelefone.setText(rs.getString(5));
                jTextFieldEmail.setText(rs.getString(6));
                jLabelBotaoSalvar1.setVisible(false);
                jLabelSalvar.setVisible(false);
                contrato();

            } else {
                JOptionPane.showMessageDialog(null, "Usuario inexistente");
                jTextFieldNumeroCli.setText(null);
                jTextFieldenderecoCli.setText(null);
                jTextFieldCnpjCli.setText(null);
                jTextFieldTelefone.setText(null);
                jTextFieldTelefone.setText(null);
                jTextFieldEmail.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void consultarCliente01() {
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
            jTextFieldNumeroCli.setText(jTable1Ciente.getModel().getValueAt(copia, 0).toString());
            jTextFieldRazaoSocial.setText(jTable1Ciente.getModel().getValueAt(copia, 1).toString());
            jTextFieldenderecoCli.setText(jTable1Ciente.getModel().getValueAt(copia, 2).toString());
            jTextFieldCnpjCli.setText(jTable1Ciente.getModel().getValueAt(copia, 3).toString());
            jTextFieldTelefone.setText(jTable1Ciente.getModel().getValueAt(copia, 4).toString());
            jTextFieldEmail.setText(jTable1Ciente.getModel().getValueAt(copia, 5).toString());
            jTextArea1.setText(jTable1Ciente.getModel().getValueAt(copia, 6).toString());
            jLabelBotaoSalvar1.setVisible(false);
            jTextArea1.setLineWrap(true);
            jTextArea1.setWrapStyleWord(true);
            jPanel1.setVisible(true);
            jLabelSalvar.setVisible(false);
        } catch (Exception e) {

        }

    }

    //Se o id do cliente estiver vazio esse metodo vai gerar um id.
    private void CompletaconfirmarCliente() {
        String inserirDados = "INSERT INTO cliente(razao_social, end_2, cnpj,"
                + " telefone, email,contrato) VALUES (?,?,?,?,?,?)";
        try {
            pst = conectar.prepareStatement(inserirDados);
            pst.setString(1, jTextFieldRazaoSocial.getText());
            pst.setString(2, jTextFieldenderecoCli.getText());
            pst.setString(3, jTextFieldCnpjCli.getText());
            pst.setString(4, jTextFieldTelefone.getText());
            pst.setString(5, jTextFieldEmail.getText());
            if (jCheckBox2.isSelected() == false) {

                JOptionPane.showMessageDialog(jPanel2, "Para efetuar o cadastro o contrato deve ser aceito.");
            } else {
                pst.setString(6, jTextArea1.getText());

                if (jTextFieldRazaoSocial.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos Obrigatórios!\nEstão sinalizados com '*' astericos ");
                } else {

                    int confirmarInsercaoDeDados = pst.executeUpdate();
                    if (confirmarInsercaoDeDados > 0) {
                        JOptionPane.showMessageDialog(null, jTextFieldRazaoSocial.getText() + "\n Foi adicionado com sussesso. ");
                        telaInicialClienete();
                        jTextFieldNumeroCli.setVisible(true);
                        jTextFieldenderecoCli.setVisible(true);
                        jTextFieldCnpjCli.setVisible(true);
                        jTextFieldTelefone.setVisible(true);
                        jTextFieldRazaoSocial.setVisible(true);
                        jTextFieldEmail.setVisible(true);
                        jPanel1.setVisible(false);
                        jTextArea1.setVisible(false);
                        jLabelBotaoOK.setVisible(false);
                        jCheckBox2.setVisible(false);
                        jLabelBotaoSalvar1.setVisible(true);
                        jLabelBotaoAtualizar.setVisible(true);
                        jLabelBotaoExcluir.setVisible(true);

                    } else {

                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void confirmarCliente() {
//        JOptionPane.showMessageDialog(null, vv);
        jTextFieldNumeroCli.setText(vv);
        if (jTextFieldNumeroCli.getText().isEmpty()) {
            CompletaconfirmarCliente();
        } else {

            String inserirDados = "INSERT INTO cliente(nrCliente,razao_social, end_2, cnpj,"
                    + " telefone, email,contrato) VALUES (?,?,?,?,?,?,?)";
            try {
                pst = conectar.prepareStatement(inserirDados);
                pst.setString(1, jTextFieldNumeroCli.getText());
                pst.setString(2, jTextFieldRazaoSocial.getText());
                pst.setString(3, jTextFieldenderecoCli.getText());
                pst.setString(4, jTextFieldCnpjCli.getText());
                pst.setString(5, jTextFieldTelefone.getText());
                pst.setString(6, jTextFieldEmail.getText());
                if (jCheckBox2.isSelected() == false) {

                    JOptionPane.showMessageDialog(jPanel2, "Para efetuar o cadastro o contrato deve ser aceito.");
                } else {
                    pst.setString(7, jTextArea1.getText());

                    if (jTextFieldRazaoSocial.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos Obrigatórios!\nEstão sinalizados com '*' astericos ");
                    } else {

                        int confirmarInsercaoDeDados = pst.executeUpdate();
                        if (confirmarInsercaoDeDados > 0) {
                            JOptionPane.showMessageDialog(null, jTextFieldRazaoSocial.getText() + "\n Foi adicionado com sussesso. ");
                            telaInicialClienete();
                            jTextFieldNumeroCli.setVisible(true);
                            jTextFieldenderecoCli.setVisible(true);
                            jTextFieldCnpjCli.setVisible(true);
                            jTextFieldTelefone.setVisible(true);
                            jTextFieldRazaoSocial.setVisible(true);
                            jTextFieldEmail.setVisible(true);
                            jPanel1.setVisible(false);
                            jTextArea1.setVisible(false);
                            jLabelBotaoOK.setVisible(false);
                            
                            jCheckBox2.setVisible(false);
                            jLabelBotaoSalvar1.setVisible(true);
                            jLabelBotaoAtualizar.setVisible(true);
                           
                            jLabelBotaoExcluir.setVisible(true);

                        } else {

                        }
                    }
                }

            } catch (java.sql.SQLIntegrityConstraintViolationException e) {

                JOptionPane.showMessageDialog(null, "Este usuario já existe.\n"
                        + "Se desejar aleterar os dados\n aperete em VOLTA e pesquise\n"
                        + "o nome desejado, não gere\n contrato, mantenha os campos\n"
                        + "preenchido, altere os campos desejado\ne aperte ATUALIZAR. ");
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void updatee() {
        String atualizar = "UPDATE cliente SET razao_social = ?, end_2 = ?, cnpj =?, telefone = ?, email = ?, contrato = ? WHERE (nrCliente = ?)";
        try {
             contrato = "\t\t\tCONTRATO DE LOCAÇÃO DE VEÍCULO\n\n\n"
                + "LOCADOR: Sheet Rent Car, portador do CNPJ nº 53932994000140, Endereço fisíco Rua Estr. Dr. Plínio Casado, 1466 - Centro, Nova Iguaçu - RJ, 26220-099.\n\n"
                + " LOCATÓRIO: " + jTextFieldRazaoSocial.getText() + " CNPJ:" + jTextFieldCnpjCli.getText() + " com sede" + jTextFieldenderecoCli.getText() + "\n"
                + "\n"
                + "As partes acima identificadas têm, entre si, justo e acertado o presente Contrato de Locação de Automóvel que se regerá pelas cláusulas seguintes e pelas condições descritas no presente.\n"
                + "\n"
                + "1. CLÁUSULA PRIMEIRA – DO OBJETO, PRAZO E USO\n"
                + "\n"
                + "\n"
                + "2.1. O LOCATÁRIO pagará ao LOCADOR a título de locação o valor anual de R$:...\n"
                + "\n"
                + "2.1.1. O atraso no pagamento do acordo da cláusula acima enseja multa de 5 % (cinco por cento) e juros de 1% (um por cento) ao dia.\n"
                + "\n"
                + "3. CLAÚSULA TERCEIRA – DAS OBRIGAÇÕES\n"
                + "\n"
                + "3.1. O LOCATÁRIO deverá manter o veículo em perfeito estado de conservação, de ordem mecânica, tapeçaria, funilaria e pneus, devendo entregar, com o término do contrato, o veículo e sua documentação ao LOCADOR nas mesmas condições em que recebeu.\n"
                + "\n"
                + "3.2. É de inteira responsabilidade do LOCATÁRIO os débitos de qualquer natureza, com data posterior a assinatura do presente contrato e até a data da rescisão, sejam de multas de trânsito, taxa de licenciamento, seguro obrigatório, seguro do veículo, IPVA e outros relacionados ao veículo.\n"
                + "\n"
                + "4. CLÁUSULA QUARTA - DA AUTORIZAÇÃO\n"
                + "\n"
                + "4.1. O LOCADOR, desde já autoriza o LOCATÁRIO, à implantação da identificação visual e do sistema de monitoramento instituído pela ARSAL.\n"
                + "\n"
                + "5. CLÁUSULA QUINTA – DA RESCISÃO \n"
                + "\n"
                + "5.1. A rescisão, antes do vencimento contratual, por iniciativa de qualquer das partes deverá ser precedida de notificação expressa com antecedência mínima de 60 (sessenta) dias a outra parte.\n"
                + "\n"
                + "5.2. O LOCATÁRIO, permissionário/autorizado, fica obrigado a comunicar à ARSAL sobre a intenção de rescisão do presente contrato manifestada por qualquer das partes, com antecedência mínima de 15 (quinze) dias.\n"
                + "\n"
                + "5.3. O descumprimento de qualquer das cláusulas por parte dos contratantes ensejará a rescisão deste instrumento e o devido pagamento de multa, pela parte inadimplente no valor de 3% (três por cento) do valor contratual.\n"
                + "\n"
                + "6. CLÁUSULA SEXTA – DAS DISPOSIÇÕES GERAIS \n"
                + "\n"
                + "6.1. O LOCADOR e LOCATÁRIO atestam que o veículo está sendo entregue em perfeitas condições de uso, na data da assinatura do presente instrumento, mediante vistoria.\n"
                + "\n"
                + "6.2. As partes contratantes elegem o foro de Maceió-AL, para dirimir qualquer ação oriunda deste contrato.\n"
                + "\n"
                + "E por estarem justo e contratados, assinam o presente instrumento em 02 (duas) vias de igual teor e forma, na presença de 02 (duas) testemunhas abaixo assinadas.\n"
                + "\n"
                + "\n";
            pst = conectar.prepareStatement(atualizar);
            pst.setString(1, jTextFieldRazaoSocial.getText());
            pst.setString(2, jTextFieldenderecoCli.getText());
            pst.setString(3, jTextFieldCnpjCli.getText());
            pst.setString(4, jTextFieldTelefone.getText());
            pst.setString(5, jTextFieldEmail.getText());
            jTextArea1.setVisible(true);
           
            jTextArea1.setText(contrato);
            pst.setString(6, jTextArea1.getText());
            pst.setString(7, jTextFieldNumeroCli.getText());
            if (jTextFieldNumeroCli.getText().isEmpty() || jTextFieldRazaoSocial.getText().isEmpty() || jTextFieldenderecoCli.getText().isEmpty()
                    || jTextFieldCnpjCli.getText().isEmpty() || jTextFieldTelefone.getText().isEmpty() || jTextFieldEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {

                int c = pst.executeUpdate();
                if (c > 0) {
                    JOptionPane.showMessageDialog(null, jTextFieldRazaoSocial.getText() + "\n Foi alterado com sussesso. ");
                    jTextFieldNumeroCli.setText(null);
                    jTextFieldenderecoCli.setText(null);
                    jTextFieldCnpjCli.setText(null);
                    jTextFieldTelefone.setText(null);
                    jTextFieldRazaoSocial.setText(null);
                    jTextFieldEmail.setText(null);
                    jLabelBotaoSalvar1.setVisible(true);
                    jLabelSalvar.setVisible(true);
                } else {

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void apapgar() {
        int ap = JOptionPane.showConfirmDialog(null, "Os dados apagados não poderão ser recuperados\nTem certeza que deseja apagá-lo? ", "Atenção", JOptionPane.YES_NO_OPTION);
        if (ap == 0) {

            String a = "delete from cliente where nrCliente=? ";

            try {
                pst = conectar.prepareStatement(a);
                pst.setString(1, jTextFieldNumeroCli.getText());
                int confg = pst.executeUpdate();
                if (confg > 0) {
                    JOptionPane.showMessageDialog(null, "Os dados foram apagados com sussesso.");
                    jTextFieldNumeroCli.setText(null);
                    jTextFieldenderecoCli.setText(null);
                    jTextFieldCnpjCli.setText(null);
                    jTextFieldTelefone.setText(null);
                    jTextFieldRazaoSocial.setText(null);
                    jTextFieldEmail.setText(null);
                    jLabelBotaoSalvar1.setVisible(true);
                    jLabelSalvar.setVisible(true);
                    jTextArea1.setText(null);
                    telaInicialClienete();
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

        jLabel8 = new javax.swing.JLabel();
        jLabelTelaDeFundoCliente = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
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
        jLabelBotaoAtualizar = new javax.swing.JLabel();
        jLabelBotaoExcluir = new javax.swing.JLabel();
        jLabelSalvar = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabelBotaoSalvar1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1Ciente = new javax.swing.JTable();
        jTextFieldPesquisarTabelaCliente = new javax.swing.JTextField();
        jLabelBotaoOK = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabelBotaoVoltar2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        jLabelTelaDeFundoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/telaCliente1.jpg"))); // NOI18N
        jLabelTelaDeFundoCliente.setText("jLabel2");

        jLabel9.setText("jLabel9");

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1018, 680));
        getContentPane().setLayout(null);

        jTextFieldRazaoSocial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldRazaoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRazaoSocialActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldRazaoSocial);
        jTextFieldRazaoSocial.setBounds(660, 258, 346, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("N°");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(620, 210, 40, 22);

        jTextFieldenderecoCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldenderecoCli);
        jTextFieldenderecoCli.setBounds(660, 300, 346, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Razão Social");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(540, 260, 120, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setText("Endereço");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(570, 300, 90, 22);

        jTextFieldNumeroCli.setEditable(false);
        jTextFieldNumeroCli.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jTextFieldNumeroCli.setToolTipText("Este Campo é preenchido automaticamaente");
        getContentPane().add(jTextFieldNumeroCli);
        jTextFieldNumeroCli.setBounds(660, 210, 340, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setText("CNPJ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(600, 350, 50, 22);

        jTextFieldCnpjCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldCnpjCli);
        jTextFieldCnpjCli.setBounds(660, 350, 346, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel6.setText("Telefone");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(570, 390, 80, 22);

        jTextFieldTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldTelefone);
        jTextFieldTelefone.setBounds(660, 390, 346, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel7.setText("Email");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(589, 440, 60, 22);

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextFieldEmail);
        jTextFieldEmail.setBounds(660, 440, 346, 30);

        jLabelBotaoAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoUpdate.png"))); // NOI18N
        jLabelBotaoAtualizar.setToolTipText("Atualizar dados do cliente");
        jLabelBotaoAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotaoAtualizarMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBotaoAtualizar);
        jLabelBotaoAtualizar.setBounds(810, 530, 84, 77);

        jLabelBotaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/botaoExcluir.png"))); // NOI18N
        jLabelBotaoExcluir.setToolTipText("Excluir permanentemente os dados do cliente");
        jLabelBotaoExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotaoExcluirMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBotaoExcluir);
        jLabelBotaoExcluir.setBounds(910, 530, 84, 77);

        jLabelSalvar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelSalvar.setText("Salvar");
        getContentPane().add(jLabelSalvar);
        jLabelSalvar.setBounds(650, 510, 50, 17);

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel18.setText("Atualizar");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(830, 510, 70, 17);

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 0));
        jLabel19.setText("Excluir");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(930, 510, 50, 17);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(310, 470, 300, 170);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jCheckBox2.setText("Aceitar");
        getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(80, 540, 70, 35);

        jLabelBotaoSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/BotaoSalvar.png"))); // NOI18N
        jLabelBotaoSalvar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotaoSalvar1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBotaoSalvar1);
        jLabelBotaoSalvar1.setBounds(630, 530, 90, 77);
        jLabelBotaoSalvar1.getAccessibleContext().setAccessibleName("jLabelBotaoSalvar1");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/pesquisar11112.png"))); // NOI18N
        jLabel10.setText("Pesquisar");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(530, 10, 150, 50);

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
        jScrollPane2.setBounds(540, 80, 452, 110);

        jTextFieldPesquisarTabelaCliente.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jTextFieldPesquisarTabelaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarTabelaClienteKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisarTabelaCliente);
        jTextFieldPesquisarTabelaCliente.setBounds(690, 20, 290, 30);

        jLabelBotaoOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/BotaPadraoOK.png"))); // NOI18N
        jLabelBotaoOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotaoOKMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBotaoOK);
        jLabelBotaoOK.setBounds(170, 520, 84, 80);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("OK");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 500, 30, 20);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 30, 500, 480);

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel17.setText("Voltar");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(740, 500, 50, 40);

        jLabelBotaoVoltar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/BotaoVoltar.png"))); // NOI18N
        jLabelBotaoVoltar2.setToolTipText("Pesquisar cliente");
        jLabelBotaoVoltar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotaoVoltar2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBotaoVoltar2);
        jLabelBotaoVoltar2.setBounds(720, 530, 84, 77);

        jLabel11.setText("Reinaldo C Santos");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 4, 150, 20);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/telaCliente1.jpg"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(-10, 0, 1020, 660);

        setBounds(0, 0, 1018, 679);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldRazaoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRazaoSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRazaoSocialActionPerformed

    private void jLabelBotaoAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotaoAtualizarMouseClicked
        // TODO add your handling code here:
        updatee();
    }//GEN-LAST:event_jLabelBotaoAtualizarMouseClicked

    private void jLabelBotaoExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotaoExcluirMouseClicked
        // TODO add your handling code here:
        apapgar();
    }//GEN-LAST:event_jLabelBotaoExcluirMouseClicked

    private void jLabelBotaoSalvar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotaoSalvar1MouseClicked
        // TODO add your handling code here:
        contrato();
    }//GEN-LAST:event_jLabelBotaoSalvar1MouseClicked

    private void jTextFieldPesquisarTabelaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarTabelaClienteKeyReleased
        // TODO add your handling code here:
        consultarCliente01();
    }//GEN-LAST:event_jTextFieldPesquisarTabelaClienteKeyReleased

    private void jTable1CienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1CienteMouseClicked
        // TODO add your handling code here:
        preenchimentoAuto();
    }//GEN-LAST:event_jTable1CienteMouseClicked

    private void jLabelBotaoOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotaoOKMouseClicked
        // TODO add your handling code here:
        checkbox_verdadeiro_falso(jCheckBox2);
        confirmarCliente();
    }//GEN-LAST:event_jLabelBotaoOKMouseClicked

    private void jLabelBotaoVoltar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotaoVoltar2MouseClicked
        // TODO add your handling code here:
        telaInicialClienete();
    }//GEN-LAST:event_jLabelBotaoVoltar2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBotaoAtualizar;
    private javax.swing.JLabel jLabelBotaoExcluir;
    private javax.swing.JLabel jLabelBotaoOK;
    private javax.swing.JLabel jLabelBotaoSalvar1;
    private javax.swing.JLabel jLabelBotaoVoltar2;
    private javax.swing.JLabel jLabelSalvar;
    private javax.swing.JLabel jLabelTelaDeFundoCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1Ciente;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldCnpjCli;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNumeroCli;
    private javax.swing.JTextField jTextFieldPesquisarTabelaCliente;
    private javax.swing.JTextField jTextFieldRazaoSocial;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JTextField jTextFieldenderecoCli;
    // End of variables declaration//GEN-END:variables
}
