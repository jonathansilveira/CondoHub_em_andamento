package _00_Telas;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class _01_Menu extends javax.swing.JFrame {

// Variáveis globais
    private int mouseX, mouseY;

    public _01_Menu(String usuario) {
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela
        txt_usuario.setText(usuario); // Seta o nome do usuário recebido pela tela _00_Login
    }

    private _01_Menu() {
        throw new UnsupportedOperationException("Not supported yet."); // Lança uma exceção UnsupportedOperationException com a mensagem "Not supported yet." indicando que a implementação está pendente.
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
        txt_usuario = new javax.swing.JLabel();
        btn_reconhecimento = new javax.swing.JButton();
        foto_user = new javax.swing.JLabel();
        lbl_bemvindo = new javax.swing.JLabel();
        btn_cadastrar = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
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

        txt_usuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(255, 255, 255));
        txt_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_usuario.setText("@USER");
        txt_usuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Main.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        btn_reconhecimento.setBackground(new java.awt.Color(255, 255, 255));
        btn_reconhecimento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_reconhecimento.setForeground(new java.awt.Color(0, 102, 102));
        btn_reconhecimento.setText("Reconhecer");
        btn_reconhecimento.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_reconhecimento.setFocusPainted(false);
        btn_reconhecimento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_reconhecimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reconhecimentoActionPerformed(evt);
            }
        });
        Panel_Main.add(btn_reconhecimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 170, 50));

        foto_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Usuário_1.png"))); // NOI18N
        Panel_Main.add(foto_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 191, 203));

        lbl_bemvindo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_bemvindo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bemvindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bemvindo.setText("Bem-vindo");
        lbl_bemvindo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Main.add(lbl_bemvindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        btn_cadastrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cadastrar.setForeground(new java.awt.Color(0, 102, 102));
        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btn_cadastrar.setFocusPainted(false);
        btn_cadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        Panel_Main.add(btn_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 170, 50));

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
        Panel_Main.add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 0, -1, -1));

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

    private void btn_reconhecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reconhecimentoActionPerformed
        new _06_Reconhecimento(this, rootPaneCheckingEnabled).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_reconhecimentoActionPerformed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        new _02_LoginADM().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

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
                new _01_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_minimiza;
    private javax.swing.JButton btn_reconhecimento;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel foto_user;
    private javax.swing.JLabel lbl_bemvindo;
    private javax.swing.JLabel txt_usuario;
    // End of variables declaration//GEN-END:variables
}
