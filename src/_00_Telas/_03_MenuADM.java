package _00_Telas;

import _01_Classes.ConectaBanco;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class _03_MenuADM extends javax.swing.JFrame {

// Instâncias
    ConectaBanco conecta = new ConectaBanco(); // Instância da classe de conexão ao banco de dados

// Variáveis globais
    private int mouseX, mouseY;

    public _03_MenuADM(java.awt.Frame parent, boolean modal) {
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela
    }

    public _03_MenuADM() {
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela
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
        btn_cadastrar = new javax.swing.JButton();
        btn_cadastrados = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        foto_user = new javax.swing.JLabel();
        lbl_bemvindo = new javax.swing.JLabel();
        btn_minimiza = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCJR SOLUTIONS");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Main.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Main.setPreferredSize(new java.awt.Dimension(400, 500));
        Panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cadastrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cadastrar.setForeground(new java.awt.Color(0, 102, 102));
        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.setBorderPainted(false);
        btn_cadastrar.setFocusPainted(false);
        btn_cadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        Panel_Main.add(btn_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 170, 50));

        btn_cadastrados.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadastrados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cadastrados.setForeground(new java.awt.Color(0, 102, 102));
        btn_cadastrados.setText("Cadastrados");
        btn_cadastrados.setBorderPainted(false);
        btn_cadastrados.setFocusPainted(false);
        btn_cadastrados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastradosActionPerformed(evt);
            }
        });
        Panel_Main.add(btn_cadastrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 170, 50));

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
        Panel_Main.add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 56, -1));

        foto_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Admin_1.png"))); // NOI18N
        Panel_Main.add(foto_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 210, 203));

        lbl_bemvindo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_bemvindo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bemvindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bemvindo.setText("Bem-vindo ADMIN");
        lbl_bemvindo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Main.add(lbl_bemvindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 220, -1));

        btn_minimiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Minimizar.png"))); // NOI18N
        btn_minimiza.setBorderPainted(false);
        btn_minimiza.setContentAreaFilled(false);
        btn_minimiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizaActionPerformed(evt);
            }
        });
        Panel_Main.add(btn_minimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

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
        Panel_Main.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(400, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        new _04_Cadastro(this, true).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void btn_cadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastradosActionPerformed
        new _05_Cadastrados(this, rootPaneCheckingEnabled).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_cadastradosActionPerformed

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
            java.util.logging.Logger.getLogger(_03_MenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_03_MenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_03_MenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_03_MenuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new _03_MenuADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JButton btn_cadastrados;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_minimiza;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel foto_user;
    private javax.swing.JLabel lbl_bemvindo;
    // End of variables declaration//GEN-END:variables
}
