package _00_Telas;

import _01_Classes.ConectaBanco;
import _01_Classes.ControlPerson;
import _01_Classes.ModelPerson;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

public class _05_Cadastrados extends javax.swing.JDialog {

// Instâncias
    ConectaBanco conecta = new ConectaBanco(); // Instância da classe de conexão ao banco de dados
    ControlPerson cod = new ControlPerson();  // Instância da classe ControlPerson, que gerencia r controla as informações relacionadas aos usuários

// Variáveis globais
    static int ICONIFIED; // Variável estática que é usada para indicar o estado da janela (minimizada)
    private int mouseX, mouseY;
    int id;

    public _05_Cadastrados(java.awt.Frame parent, boolean modal) {
        super(parent, modal); // Chama o construtor da classe pai (JDialog), passando o frame pai e o parâmetro modal para configurar a janela de diálogo
        initComponents(); // Inicialização
        paint_table(); // Classe de personalização da tabela
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela 
        
        // Preenche tabela
        cod.preencherTabela("SELECT * FROM usuarios ORDER BY id", tabela_1);

    }

    public _05_Cadastrados() {
        initComponents(); // Inicialização
        paint_table(); // Classe de personalização da tabela
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela
        cod.preencherTabela("SELECT * FROM usuarios ORDER BY id", tabela_1);
    }

// Carrega a imagem do ícone a partir do recurso no caminho especificado
    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/_02_Imagens/GCJR.png")));
    }

// Classe que permite a movimentação da janela arrastando com o mouse
    public void Move() {
        // Adicionando o MouseListener e MouseMotionListener ao Panel_Main
        Panel_Main.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Armazena as coordenadas X e Y do ponto onde o mouse foi pressionado na tela
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        Panel_Main.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Calcula a nova posição da janela enquanto o mouse está sendo arrastado
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;
                // Define a nova posição da janela com base na movimentação do mouse
                setLocation(x, y);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Panel_Main = new javax.swing.JPanel();
        Panel_Left = new javax.swing.JPanel();
        lbl_face = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        ScrollPane_1 = new javax.swing.JScrollPane();
        tabela_1 = new javax.swing.JTable();
        btn_voltar = new javax.swing.JButton();
        Panel_Right = new javax.swing.JPanel();
        btn_alterar = new javax.swing.JButton();
        lbl_dados = new javax.swing.JLabel();
        btn_excluir = new javax.swing.JButton();
        btn_minimiza = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        lbl_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_sobrenome = new javax.swing.JLabel();
        txt_sobrenome = new javax.swing.JTextField();
        lbl_telefone = new javax.swing.JLabel();
        txt_telefone = new javax.swing.JFormattedTextField();
        lbl_cpf = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JFormattedTextField();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_sexo = new javax.swing.JLabel();
        txt_sexo = new javax.swing.JComboBox<>();
        lbl_cargo = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JComboBox<>();
        btn_limpa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCJR SOLUTIONS");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Left.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Left.setPreferredSize(new java.awt.Dimension(400, 500));
        Panel_Left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_face.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_face.setForeground(new java.awt.Color(255, 255, 255));
        lbl_face.setText("FACE ID");
        Panel_Left.add(lbl_face, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        txt_id.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setText("0");
        Panel_Left.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        ScrollPane_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        tabela_1.setBackground(new java.awt.Color(255, 255, 255));
        tabela_1.setForeground(new java.awt.Color(0, 0, 0));
        tabela_1.setFillsViewportHeight(true);
        tabela_1.setGridColor(new java.awt.Color(0, 0, 0));
        tabela_1.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tabela_1.setShowGrid(true);
        tabela_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabela_1MouseReleased(evt);
            }
        });
        ScrollPane_1.setViewportView(tabela_1);

        Panel_Left.add(ScrollPane_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 510, 440));

        btn_voltar.setBackground(new java.awt.Color(0, 102, 102));
        btn_voltar.setForeground(new java.awt.Color(255, 255, 255));
        btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Seta_voltar.png"))); // NOI18N
        btn_voltar.setBorderPainted(false);
        btn_voltar.setContentAreaFilled(false);
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        Panel_Left.add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Panel_Main.add(Panel_Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 550));

        Panel_Right.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Right.setMinimumSize(new java.awt.Dimension(400, 500));
        Panel_Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_alterar.setBackground(new java.awt.Color(0, 102, 102));
        btn_alterar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_alterar.setForeground(new java.awt.Color(255, 255, 255));
        btn_alterar.setText("Alterar");
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 100, 35));

        lbl_dados.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_dados.setForeground(new java.awt.Color(0, 102, 102));
        lbl_dados.setText("Dados");
        Panel_Right.add(lbl_dados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        btn_excluir.setBackground(new java.awt.Color(0, 102, 102));
        btn_excluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_excluir.setForeground(new java.awt.Color(255, 255, 255));
        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 100, 35));

        btn_minimiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Minimizar.png"))); // NOI18N
        btn_minimiza.setBorderPainted(false);
        btn_minimiza.setContentAreaFilled(false);
        btn_minimiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizaActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_minimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Sair.png"))); // NOI18N
        btn_sair.setBorderPainted(false);
        btn_sair.setContentAreaFilled(false);
        btn_sair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_sair.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btn_sair.setPreferredSize(new java.awt.Dimension(23, 23));
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 0, 30, 23));

        lbl_nome.setForeground(new java.awt.Color(0, 0, 0));
        lbl_nome.setText("Nome ");
        Panel_Right.add(lbl_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, -1, -1));
        Panel_Right.add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 100, 200, 25));

        lbl_sobrenome.setForeground(new java.awt.Color(0, 0, 0));
        lbl_sobrenome.setText("Sobrenome");
        Panel_Right.add(lbl_sobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 140, -1, -1));
        Panel_Right.add(txt_sobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 160, 200, 25));

        lbl_telefone.setForeground(new java.awt.Color(0, 0, 0));
        lbl_telefone.setText("Telefone");
        Panel_Right.add(lbl_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 200, -1, -1));

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Panel_Right.add(txt_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 220, 200, 25));

        lbl_cpf.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cpf.setText("CPF");
        Panel_Right.add(lbl_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 260, -1, -1));

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Panel_Right.add(txt_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 280, 200, 25));

        lbl_email.setForeground(new java.awt.Color(0, 0, 0));
        lbl_email.setText("E-mail");
        Panel_Right.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 320, -1, -1));
        Panel_Right.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 340, 200, 25));

        lbl_sexo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_sexo.setText("Sexo");
        Panel_Right.add(lbl_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 380, -1, -1));

        txt_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino", "Outro" }));
        Panel_Right.add(txt_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 400, 200, 25));

        lbl_cargo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cargo.setText("Cargo");
        Panel_Right.add(lbl_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 440, -1, -1));

        txt_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Assistente", "Gerente", "Diretor(a)" }));
        Panel_Right.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 460, 200, 25));

        btn_limpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Limpa.png"))); // NOI18N
        btn_limpa.setBorderPainted(false);
        btn_limpa.setContentAreaFilled(false);
        btn_limpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpaActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_limpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, -1));

        Panel_Main.add(Panel_Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 400, 550));

        getContentPane().add(Panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        setSize(new java.awt.Dimension(1000, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

// Classe para personalização da tabela
    private void paint_table() {
        ScrollPane_1.getViewport().setBackground(Color.white);
        tabela_1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela_1.getTableHeader().setOpaque(false);
        tabela_1.getTableHeader().setBackground(new Color(229, 255, 221));
        tabela_1.getTableHeader().setForeground(new Color(255, 255, 255));
        tabela_1.setRowHeight(50);

        JTableHeader header = tabela_1.getTableHeader();
        header.setBackground(Color.RED);
        header.setForeground(Color.BLACK);
    }

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        ModelPerson mod = new ModelPerson();
        mod.setId(id);
        mod.setId(Integer.parseInt(txt_id.getText()));
        mod.setNome(txt_nome.getText());
        mod.setSobrenome(txt_sobrenome.getText());
        mod.setTelefone(txt_telefone.getText());
        mod.setCpf(txt_cpf.getText());
        mod.setEmail(txt_email.getText());
        mod.setSexo(txt_sexo.getSelectedItem().toString());
        mod.setCargo(txt_cargo.getSelectedItem().toString());
        cod.update(mod, id);
        new _05_Cadastrados().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_alterarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        cod.delete(id);
        cod.preencherTabela("SELECT * FROM usuarios ORDER BY id", tabela_1);
        new _05_Cadastrados().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_excluirActionPerformed

// Ao selecionar dados na tabela
    private void tabela_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_1MouseClicked
        conecta.conexao();
        try {
            String nome = "" + tabela_1.getValueAt(tabela_1.getSelectedRow(), 1);
            conecta.executaSQL("SELECT * FROM usuarios WHERE id = '" + nome + "'");
            conecta.rs.first();
            id = conecta.rs.getInt("id");
            txt_id.setText(String.valueOf(id));
            txt_nome.setText(String.valueOf(conecta.rs.getString("nome")));
            txt_sobrenome.setText(String.valueOf(conecta.rs.getString("sobrenome")));
            txt_telefone.setText(String.valueOf(conecta.rs.getString("telefone")));
            txt_cpf.setText(String.valueOf(conecta.rs.getString("cpf")));
            txt_email.setText(String.valueOf(conecta.rs.getString("email")));
            txt_sexo.setSelectedItem(String.valueOf(conecta.rs.getString("sexo")));
            txt_cargo.setSelectedItem(String.valueOf(conecta.rs.getString("cargo")));
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao Selecionar os Dados!\nErro:" + s);
        }
        conecta.desconecta();
    }//GEN-LAST:event_tabela_1MouseClicked

    private void tabela_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_1MouseReleased
        if (evt.isPopupTrigger()) {// Se o mouse foi clicado com o botão de PopupMenu default do sistema operacional em uso
            jPopupMenu1.show(tabela_1, evt.getX(), evt.getY()); // p é o JPopupMenu, t é a tabela, e.getX() recupera a posição horizontal do mouse e e.getY() recupera a posição vertical.
        }
    }//GEN-LAST:event_tabela_1MouseReleased

    private void btn_minimizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizaActionPerformed
        setState(this.ICONIFIED);
    }//GEN-LAST:event_btn_minimizaActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        new _03_MenuADM().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_limpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpaActionPerformed
        txt_nome.setText("");
        txt_sobrenome.setText("");
        txt_telefone.setText("");
        txt_cpf.setText("");
        txt_email.setText("");
        txt_sexo.setSelectedItem("Selecione");
        txt_cargo.setSelectedItem("Selecione");
    }//GEN-LAST:event_btn_limpaActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(_05_Cadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_05_Cadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_05_Cadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_05_Cadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new _05_Cadastrados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Left;
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JPanel Panel_Right;
    private javax.swing.JScrollPane ScrollPane_1;
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_limpa;
    private javax.swing.JButton btn_minimiza;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbl_cargo;
    private javax.swing.JLabel lbl_cpf;
    private javax.swing.JLabel lbl_dados;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_face;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_sexo;
    private javax.swing.JLabel lbl_sobrenome;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JTable tabela_1;
    private javax.swing.JComboBox<String> txt_cargo;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JTextField txt_email;
    private javax.swing.JLabel txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JComboBox<String> txt_sexo;
    private javax.swing.JTextField txt_sobrenome;
    private javax.swing.JFormattedTextField txt_telefone;
    // End of variables declaration//GEN-END:variables

// Este método não está implementado, apenas lança uma exceção
    private void setState(int ICONIFIED) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
