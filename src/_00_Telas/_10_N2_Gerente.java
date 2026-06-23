package _00_Telas;

import _01_Classes.ConectaBanco;
import _01_Classes.ControlProp;
import _01_Classes.ModelProp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.table.JTableHeader;

public class _10_N2_Gerente extends javax.swing.JFrame {

// Instâncias
    ConectaBanco conecta = new ConectaBanco();
    ControlProp cod = new ControlProp();

// Variáveis globais  
    private int mouseX, mouseY;
    int id;

    public _10_N2_Gerente(String usuario, String cargo, String id) {
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        paint_table(); // Classe de personalização da tabela
        Move(); // Classe Move, para movimentação da janela 
        ButtonGroupAgrotoxico(); // Classe de grupo RadioButton Agrotóxico
        ButtonGroupVilaCidade();  // Classe de grupo RadioButton Vila_Cidade

        // Recebe os parametros e seta nos labels
        lbl_nome1.setText(usuario);
        lbl_cargo.setText(cargo);
        lbl_id1.setText(id);

        // Preenche tabela
        cod.preencherTabela("SELECT * FROM propriedades ORDER BY id", tabela_2);
    }

// Isso impede que a classe seja instanciada sem os parâmetros necessários
    private _10_N2_Gerente() {
        throw new UnsupportedOperationException("Not supported yet."); // Lança uma exceção para indicar que o construtor não é suportado
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
    
// Classe para personalização da tabela
    private void paint_table() {
        ScrollPane_1.getViewport().setBackground(Color.white);
        tabela_2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela_2.getTableHeader().setOpaque(false);
        tabela_2.getTableHeader().setBackground(new Color(229, 255, 221));
        tabela_2.getTableHeader().setForeground(new Color(255, 255, 255));
        tabela_2.setRowHeight(50);

        JTableHeader header = tabela_2.getTableHeader();
        header.setBackground(Color.RED);
        header.setForeground(Color.BLACK);
    }

// Classe para inserção dos dados
    public void insertDatabase(String usuario, String cargo, String id) {
        ControlProp cod = new ControlProp();
        ModelProp mod = new ModelProp();
        
        String usuariox = lbl_nome1.getText();
        String cargox = lbl_cargo.getText();
        String idx = lbl_id1.getText();


        mod.setNome(txt_nome.getText().toString());
        mod.setEndereco(txt_endereco.getText());
        mod.setCep(txt_cep.getText());
        mod.setCpf(txt_cpf.getText());
        mod.setTipo(txt_tipo.getSelectedItem().toString());
        mod.setTamanho(txt_tamanho.getText());
        if (txt_vila_cidadeS.isSelected()) {
            mod.setVila_Cidade("Sim");
        } else {
            mod.setVila_Cidade("Não");
        }

        if (txt_agrotoxicosS.isSelected()) {
            mod.setAgrotoxico("Sim");
        } else {
            mod.setAgrotoxico("Não");
        }
        cod.insert(mod);
    }

// Classe para agrupar radio buttons
    public void ButtonGroupAgrotoxico() {
        ButtonGroup A = new ButtonGroup();
        A.add(txt_agrotoxicosS);
        A.add(txt_agrotoxicosN);
    }

// Classe para agrupar radio buttons
    public void ButtonGroupVilaCidade() {
        ButtonGroup V = new ButtonGroup();
        V.add(txt_vila_cidadeS);
        V.add(txt_vila_cidadeN);
    }

// Classe para limpar grupo de radio buttons
    public void ButtonGroupAgrotoxicoLimpa() {
        ButtonGroup A = new ButtonGroup();
        A.add(txt_agrotoxicosS);
        A.add(txt_agrotoxicosN);
        A.clearSelection();
    }

// Classe para limpar grupo de radio buttons
    public void ButtonGroupVilaCidadeLimpa() {
        ButtonGroup V = new ButtonGroup();
        V.add(txt_vila_cidadeS);
        V.add(txt_vila_cidadeN);
        V.clearSelection();
    }
    
    // Classe pegar dados do usuário
    public void Dados() {
        String usuario = lbl_nome1.getText();
        String cargo = lbl_cargo.getText();
        String id = lbl_id1.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        Panel_Main = new javax.swing.JPanel();
        Panel_Left = new javax.swing.JPanel();
        ScrollPane_1 = new javax.swing.JScrollPane();
        tabela_2 = new javax.swing.JTable();
        lbl_listadepropriedades = new javax.swing.JLabel();
        btn_voltar1 = new javax.swing.JButton();
        lbl_nome1 = new javax.swing.JLabel();
        lbl_cargo = new javax.swing.JLabel();
        lbl_id1 = new javax.swing.JLabel();
        Panel_Right = new javax.swing.JPanel();
        btn_inserir = new javax.swing.JButton();
        lbl_id = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_bairro = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        lbl_cep = new javax.swing.JLabel();
        txt_cep = new javax.swing.JFormattedTextField();
        lbl_cpf = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JFormattedTextField();
        lbl_tipo = new javax.swing.JLabel();
        txt_tipo = new javax.swing.JComboBox<>();
        lbl_tamanho = new javax.swing.JLabel();
        txt_tamanho = new javax.swing.JFormattedTextField();
        txt_agrotoxicosN = new javax.swing.JRadioButton();
        txt_agrotoxicosS = new javax.swing.JRadioButton();
        lbl_vila_cidades = new javax.swing.JLabel();
        lbl_agrotoxicos = new javax.swing.JLabel();
        txt_vila_cidadeS = new javax.swing.JRadioButton();
        txt_vila_cidadeN = new javax.swing.JRadioButton();
        txt_id = new javax.swing.JTextField();
        lbl_nome = new javax.swing.JLabel();
        lbl_formulario = new javax.swing.JLabel();
        btn_minimiza = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        btn_alterar1 = new javax.swing.JButton();
        btn_limpa = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCJR SOLUTIONS");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Left.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Left.setForeground(new java.awt.Color(0, 102, 102));
        Panel_Left.setPreferredSize(new java.awt.Dimension(400, 500));
        Panel_Left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ScrollPane_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        tabela_2.setBackground(new java.awt.Color(255, 255, 255));
        tabela_2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tabela_2.setForeground(new java.awt.Color(0, 0, 0));
        tabela_2.setFillsViewportHeight(true);
        tabela_2.setGridColor(new java.awt.Color(0, 0, 0));
        tabela_2.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tabela_2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabela_2.setShowGrid(true);
        tabela_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabela_2MouseReleased(evt);
            }
        });
        ScrollPane_1.setViewportView(tabela_2);

        Panel_Left.add(ScrollPane_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 677, 380));

        lbl_listadepropriedades.setBackground(new java.awt.Color(0, 102, 102));
        lbl_listadepropriedades.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_listadepropriedades.setForeground(new java.awt.Color(255, 255, 255));
        lbl_listadepropriedades.setText("Lista de propriedades");
        Panel_Left.add(lbl_listadepropriedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        btn_voltar1.setBackground(new java.awt.Color(0, 102, 102));
        btn_voltar1.setForeground(new java.awt.Color(255, 255, 255));
        btn_voltar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Seta_voltar.png"))); // NOI18N
        btn_voltar1.setBorderPainted(false);
        btn_voltar1.setContentAreaFilled(false);
        btn_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltar1ActionPerformed(evt);
            }
        });
        Panel_Left.add(btn_voltar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        lbl_nome1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_nome1.setForeground(new java.awt.Color(0, 102, 102));
        lbl_nome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome1.setText("Nome");
        lbl_nome1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Left.add(lbl_nome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 160, -1));

        lbl_cargo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cargo.setForeground(new java.awt.Color(0, 102, 102));
        lbl_cargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cargo.setText("Cargo");
        lbl_cargo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Left.add(lbl_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 160, -1));

        lbl_id1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id1.setForeground(new java.awt.Color(0, 102, 102));
        lbl_id1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id1.setText("ID");
        lbl_id1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Left.add(lbl_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 160, -1));

        Panel_Main.add(Panel_Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 620));

        Panel_Right.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Right.setMinimumSize(new java.awt.Dimension(400, 500));
        Panel_Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_inserir.setBackground(new java.awt.Color(0, 102, 102));
        btn_inserir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_inserir.setForeground(new java.awt.Color(255, 255, 255));
        btn_inserir.setText("Inserir");
        btn_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserirActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_inserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 520, 100, 35));

        lbl_id.setForeground(new java.awt.Color(0, 0, 0));
        lbl_id.setText("ID");
        Panel_Right.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));
        Panel_Right.add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 25));

        lbl_bairro.setForeground(new java.awt.Color(0, 0, 0));
        lbl_bairro.setText("Bairro");
        Panel_Right.add(lbl_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        Panel_Right.add(txt_endereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 25));

        lbl_cep.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cep.setText("CEP");
        Panel_Right.add(lbl_cep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Panel_Right.add(txt_cep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 25));

        lbl_cpf.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cpf.setText("CPF proprietário");
        Panel_Right.add(lbl_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Panel_Right.add(txt_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 200, 25));

        lbl_tipo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_tipo.setText("Tipo de propriedade");
        Panel_Right.add(lbl_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        txt_tipo.setForeground(new java.awt.Color(204, 204, 204));
        txt_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Agricultura", "Fazenda", "Granja", "Haras", "Pecuária", "Piscicultura", "Reflorestamento" }));
        Panel_Right.add(txt_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 200, 25));

        lbl_tamanho.setForeground(new java.awt.Color(0, 0, 0));
        lbl_tamanho.setText("Tamanho da propriedade (ha)");
        Panel_Right.add(lbl_tamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        try {
            txt_tamanho.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###,### m²")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Panel_Right.add(txt_tamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 200, 25));

        txt_agrotoxicosN.setForeground(new java.awt.Color(0, 0, 0));
        txt_agrotoxicosN.setText("Não");
        Panel_Right.add(txt_agrotoxicosN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 70, 30));

        txt_agrotoxicosS.setForeground(new java.awt.Color(0, 0, 0));
        txt_agrotoxicosS.setText("Sim");
        Panel_Right.add(txt_agrotoxicosS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 70, 30));

        lbl_vila_cidades.setForeground(new java.awt.Color(0, 0, 0));
        lbl_vila_cidades.setText("Proxímo de vilas/cidades?");
        Panel_Right.add(lbl_vila_cidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        lbl_agrotoxicos.setForeground(new java.awt.Color(0, 0, 0));
        lbl_agrotoxicos.setText("Utiliza agrotóxicos?");
        Panel_Right.add(lbl_agrotoxicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, -1, -1));

        txt_vila_cidadeS.setForeground(new java.awt.Color(0, 0, 0));
        txt_vila_cidadeS.setText("Sim");
        Panel_Right.add(txt_vila_cidadeS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 70, 30));

        txt_vila_cidadeN.setForeground(new java.awt.Color(0, 0, 0));
        txt_vila_cidadeN.setText("Não");
        Panel_Right.add(txt_vila_cidadeN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 70, 30));

        txt_id.setEnabled(false);
        Panel_Right.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 40, -1));

        lbl_nome.setForeground(new java.awt.Color(0, 0, 0));
        lbl_nome.setText("Nome da propriedade");
        Panel_Right.add(lbl_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lbl_formulario.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_formulario.setForeground(new java.awt.Color(0, 102, 102));
        lbl_formulario.setText("Formulário");
        Panel_Right.add(lbl_formulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 7, -1, -1));

        btn_minimiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Minimizar.png"))); // NOI18N
        btn_minimiza.setBorderPainted(false);
        btn_minimiza.setContentAreaFilled(false);
        btn_minimiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizaActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_minimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 40, -1));

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
        Panel_Right.add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 0, 30, 23));

        btn_alterar1.setBackground(new java.awt.Color(0, 102, 102));
        btn_alterar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_alterar1.setForeground(new java.awt.Color(255, 255, 255));
        btn_alterar1.setText("Alterar");
        btn_alterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterar1ActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_alterar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 100, 35));

        btn_limpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Limpa.png"))); // NOI18N
        btn_limpa.setBorderPainted(false);
        btn_limpa.setContentAreaFilled(false);
        btn_limpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpaActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_limpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 60, 60));

        Panel_Main.add(Panel_Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 420, 620));

        getContentPane().add(Panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 620));

        setSize(new java.awt.Dimension(1200, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserirActionPerformed
        String usuario = lbl_nome1.getText();
        String cargo = lbl_cargo.getText();
        String id = lbl_id1.getText();
        insertDatabase(usuario, cargo, id);
        new _10_N2_Gerente(usuario, cargo, id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_inserirActionPerformed

   
// Ao selecionar dados na tabela
    private void tabela_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_2MouseClicked
        conecta.conexao();
        try {
            String nome = "" + tabela_2.getValueAt(tabela_2.getSelectedRow(), 1);
            conecta.executaSQL("SELECT * FROM propriedades WHERE id = '" + nome + "'");
            conecta.rs.first();
            id = conecta.rs.getInt("id");
            txt_id.setText(String.valueOf(id));
            txt_nome.setText(String.valueOf(conecta.rs.getString("nome")));
            txt_endereco.setText(String.valueOf(conecta.rs.getString("endereco")));
            txt_cep.setText(String.valueOf(conecta.rs.getString("cep")));
            txt_cpf.setText(String.valueOf(conecta.rs.getString("cpf")));
            txt_tipo.setSelectedItem(String.valueOf(conecta.rs.getString("tipo")));
            txt_tamanho.setText(String.valueOf(conecta.rs.getString("tamanho")));

            if ("Sim".equals(conecta.rs.getString("vila_cidade"))) {
                txt_vila_cidadeS.setSelected(true);
            } else {
                txt_vila_cidadeN.setSelected(true);
            }

            if ("Sim".equals(conecta.rs.getString("agrotoxico"))) {
                txt_agrotoxicosS.setSelected(true);
            } else {
                txt_agrotoxicosN.setSelected(true);
            }
        } catch (SQLException s) {
            //JOptionPane.showMessageDialog(rootPane, "Erro ao Selecionar os Dados!\nErro:" + s);
        }
        conecta.desconecta();
    }//GEN-LAST:event_tabela_2MouseClicked

    private void tabela_2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_2MouseReleased
        if (evt.isPopupTrigger()) {//Se o mouse foi clicado com o botão de PopupMenu default do sistema operacional em uso
            jPopupMenu1.show(tabela_2, evt.getX(), evt.getY()); //p é o JPopupMenu, t é a tabela, e.getX() recupera a posição horizontal do mouse e e.getY() recupera a posição vertical.
        }
    }//GEN-LAST:event_tabela_2MouseReleased

    private void btn_minimizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizaActionPerformed
        setState(this.ICONIFIED);
    }//GEN-LAST:event_btn_minimizaActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_alterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterar1ActionPerformed
        ButtonGroupAgrotoxico();
        ButtonGroupVilaCidade();
        
        Dados();
        
        ModelProp mod = new ModelProp();
        mod.setId((id));
        mod.setId(Integer.parseInt(txt_id.getText()));
        mod.setNome(txt_nome.getText());
        mod.setEndereco(txt_endereco.getText());
        mod.setCep(txt_cep.getText());
        mod.setCpf(txt_cpf.getText());
        mod.setTipo(txt_tipo.getSelectedItem().toString());
        mod.setTamanho(txt_tamanho.getText());

        if (txt_vila_cidadeS.isSelected()) {
            mod.setVila_Cidade("Sim");
        } else if (txt_vila_cidadeN.isSelected()) {
            mod.setVila_Cidade("Não");
        }

        if (txt_agrotoxicosS.isSelected()) {
            mod.setAgrotoxico("Sim");
        } else if (txt_agrotoxicosN.isSelected()) {
            mod.setAgrotoxico("Não");
        }

        cod.update(mod, id);
        dispose();
        
        String usuario = lbl_nome1.getText();
        String cargo = lbl_cargo.getText();
        String id = lbl_id1.getText();
        
        new _10_N2_Gerente(usuario, cargo, id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_alterar1ActionPerformed

    private void btn_limpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpaActionPerformed
        txt_nome.setText("");
        txt_endereco.setText("");
        txt_id.setText("");
        txt_cep.setText("");
        txt_cpf.setText("");
        txt_tipo.setSelectedItem("Selecione");
        txt_tamanho.setText("");
        ButtonGroupAgrotoxicoLimpa();
        ButtonGroupVilaCidadeLimpa();
    }//GEN-LAST:event_btn_limpaActionPerformed

    private void btn_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltar1ActionPerformed
        String usuario = lbl_nome1.getText();
        String cargo = lbl_cargo.getText();
        String id = lbl_id1.getText();
        new _09_N2_Gerente_Menu(usuario, cargo, id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_voltar1ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(_10_N2_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_10_N2_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_10_N2_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_10_N2_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new _10_N2_Gerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Left;
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JPanel Panel_Right;
    private javax.swing.JScrollPane ScrollPane_1;
    private javax.swing.JButton btn_alterar1;
    private javax.swing.JButton btn_inserir;
    private javax.swing.JButton btn_limpa;
    private javax.swing.JButton btn_minimiza;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_voltar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbl_agrotoxicos;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_cargo;
    private javax.swing.JLabel lbl_cep;
    private javax.swing.JLabel lbl_cpf;
    private javax.swing.JLabel lbl_formulario;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id1;
    private javax.swing.JLabel lbl_listadepropriedades;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_nome1;
    private javax.swing.JLabel lbl_tamanho;
    private javax.swing.JLabel lbl_tipo;
    private javax.swing.JLabel lbl_vila_cidades;
    private javax.swing.JTable tabela_2;
    private javax.swing.JRadioButton txt_agrotoxicosN;
    private javax.swing.JRadioButton txt_agrotoxicosS;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JFormattedTextField txt_tamanho;
    private javax.swing.JComboBox<String> txt_tipo;
    private javax.swing.JRadioButton txt_vila_cidadeN;
    private javax.swing.JRadioButton txt_vila_cidadeS;
    // End of variables declaration//GEN-END:variables
}
