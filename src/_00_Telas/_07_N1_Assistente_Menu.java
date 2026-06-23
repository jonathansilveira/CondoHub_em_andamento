package _00_Telas;

import _01_Classes.ConectaBanco;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Image;
import javax.swing.ImageIcon;

public class _07_N1_Assistente_Menu extends javax.swing.JFrame {

// Instâncias
    ConectaBanco conecta = new ConectaBanco();

// Variáveis globais    
    private int mouseX, mouseY;

    public _07_N1_Assistente_Menu(java.awt.Frame parent, boolean modal, String usuario, String cargo, String id) {
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela 

        // Recebe os parametros e seta nos labels
        lbl_nome.setText(usuario);
        lbl_cargo.setText(cargo);
        lbl_id.setText(id);

        
        File image = new File("C:\\photos\\person." + id + ".1.jpg"); // Cria um objeto File que representa a imagem no caminho especificado
        String path = image.getAbsolutePath(); // Obtém o caminho absoluto do arquivo de imagem
      
        ImageIcon i = new ImageIcon(new ImageIcon(String.valueOf(path)).getImage() // Cria um ImageIcon a partir da imagem do caminho especificado e redimensiona 
       .getScaledInstance(lbl_imagem.getWidth() + 120, lbl_imagem.getHeight() + 120, Image.SCALE_SMOOTH));// a imagem para as dimensões do JLabel
        
        lbl_imagem.setIcon(i); // Define o ícone da JLabel para a imagem redimensionada

    }

    public _07_N1_Assistente_Menu(String usuario, String cargo, String id) {
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela 

        lbl_nome.setText(usuario);
        lbl_cargo.setText(cargo);
        lbl_id.setText(id);

        File image = new File("C:\\photos\\person." + id + ".1.jpg"); // Cria um objeto File que representa a imagem no caminho especificado
        String path = image.getAbsolutePath(); // Obtém o caminho absoluto do arquivo de imagem
      
        ImageIcon i = new ImageIcon(new ImageIcon(String.valueOf(path)).getImage() // Cria um ImageIcon a partir da imagem do caminho especificado e redimensiona 
       .getScaledInstance(lbl_imagem.getWidth() + 120, lbl_imagem.getHeight() + 120, Image.SCALE_SMOOTH));// a imagem para as dimensões do JLabel
        
        lbl_imagem.setIcon(i); // Define o ícone da JLabel para a imagem redimensionada
    }


// Isso impede que a classe seja instanciada sem os parâmetros necessários
    private _07_N1_Assistente_Menu() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Main = new javax.swing.JPanel();
        Panel_Left = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_gcjr = new javax.swing.JLabel();
        lbl_copy = new javax.swing.JLabel();
        btn_home = new javax.swing.JButton();
        Panel_Right = new javax.swing.JPanel();
        lbl_bemvindo = new javax.swing.JLabel();
        btn_minimiza = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        lbl_nome = new javax.swing.JLabel();
        lbl_cargo = new javax.swing.JLabel();
        lbl_imagem = new javax.swing.JLabel();
        btn_lista = new javax.swing.JButton();
        lbl_id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCJR SOLUTIONS");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Main.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Main.setPreferredSize(new java.awt.Dimension(400, 500));
        Panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Left.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Left.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panel_Left.setPreferredSize(new java.awt.Dimension(400, 500));
        Panel_Left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/GCJR.png"))); // NOI18N
        Panel_Left.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 80, -1, -1));

        lbl_gcjr.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lbl_gcjr.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gcjr.setText("GCJR SOLUTIONS");
        Panel_Left.add(lbl_gcjr, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 278, 225, 56));

        lbl_copy.setBackground(new java.awt.Color(204, 204, 204));
        lbl_copy.setForeground(new java.awt.Color(204, 204, 204));
        lbl_copy.setText("copyright © GCJR SOLUTIONS All rights reserved");
        Panel_Left.add(lbl_copy, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        btn_home.setBackground(new java.awt.Color(0, 102, 102));
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Home.png"))); // NOI18N
        btn_home.setBorderPainted(false);
        btn_home.setContentAreaFilled(false);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        Panel_Left.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Panel_Main.add(Panel_Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Panel_Right.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Right.setForeground(new java.awt.Color(0, 102, 102));
        Panel_Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bemvindo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_bemvindo.setForeground(new java.awt.Color(0, 102, 102));
        lbl_bemvindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bemvindo.setText("Bem-vindo");
        lbl_bemvindo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Right.add(lbl_bemvindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 210, -1));

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
        Panel_Right.add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 56, -1));

        lbl_nome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_nome.setForeground(new java.awt.Color(0, 102, 102));
        lbl_nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome.setText("Nome");
        lbl_nome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Right.add(lbl_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 250, -1));

        lbl_cargo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_cargo.setForeground(new java.awt.Color(0, 102, 102));
        lbl_cargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cargo.setText("Cargo");
        lbl_cargo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Right.add(lbl_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 80, -1));

        lbl_imagem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Panel_Right.add(lbl_imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 120, 120));

        btn_lista.setBackground(new java.awt.Color(0, 102, 102));
        btn_lista.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_lista.setForeground(new java.awt.Color(255, 255, 255));
        btn_lista.setText("Propriedades");
        btn_lista.setBorderPainted(false);
        btn_lista.setFocusPainted(false);
        btn_lista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listaActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 170, 40));

        lbl_id.setBackground(new java.awt.Color(255, 255, 255));
        lbl_id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id.setText("ID");
        lbl_id.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Right.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 60, -1));

        Panel_Main.add(Panel_Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 500));

        getContentPane().add(Panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        setSize(new java.awt.Dimension(800, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed
        String usuario = lbl_nome.getText();
        String cargo = lbl_cargo.getText();
        String id = lbl_id.getText();
        new _08_N1_Assistente(usuario, cargo, id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_listaActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_minimizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizaActionPerformed
        setState(this.ICONIFIED);
    }//GEN-LAST:event_btn_minimizaActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        String usuario = null;
        new _00_Login(null, rootPaneCheckingEnabled).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(_07_N1_Assistente_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_07_N1_Assistente_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_07_N1_Assistente_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_07_N1_Assistente_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new _07_N1_Assistente_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Left;
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JPanel Panel_Right;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_lista;
    private javax.swing.JButton btn_minimiza;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel lbl_bemvindo;
    private javax.swing.JLabel lbl_cargo;
    private javax.swing.JLabel lbl_copy;
    private javax.swing.JLabel lbl_gcjr;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_imagem;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_nome;
    // End of variables declaration//GEN-END:variables
}
