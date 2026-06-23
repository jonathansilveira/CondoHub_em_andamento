package _00_Telas;

import _01_Classes.ConectaBanco;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class _00_Login extends javax.swing.JFrame {
    
// Instâncias
    ConectaBanco conecta = new ConectaBanco(); // Instância da classe de conexão ao banco de dados

// Variáveis globais
    String usuario;
    private int mouseX, mouseY;

    public _00_Login(java.awt.Frame parent, boolean modal) {
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela
    }


// Lança uma exceção UnsupportedOperationException com a mensagem "Not supported yet." indicando que a implementação está pendente.
    public _00_Login() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        Panel_Right = new javax.swing.JPanel();
        lbl_login = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        lbl_senha = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        btn_minimiza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCJR SOLUTIONS");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Main.setMinimumSize(new java.awt.Dimension(800, 500));
        Panel_Main.setPreferredSize(new java.awt.Dimension(800, 500));
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

        Panel_Main.add(Panel_Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Panel_Left.getAccessibleContext().setAccessibleName("");

        Panel_Right.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Right.setMinimumSize(new java.awt.Dimension(400, 500));
        Panel_Right.setPreferredSize(new java.awt.Dimension(400, 500));
        Panel_Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_login.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_login.setForeground(new java.awt.Color(0, 102, 102));
        lbl_login.setText("LOGIN");
        Panel_Right.add(lbl_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(0, 0, 0));
        lbl_usuario.setText("Usuário");
        Panel_Right.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txt_usuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Panel_Right.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 290, 36));

        lbl_senha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_senha.setForeground(new java.awt.Color(0, 0, 0));
        lbl_senha.setText("Senha");
        Panel_Right.add(lbl_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        Panel_Right.add(txt_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 290, 36));

        btn_login.setBackground(new java.awt.Color(0, 102, 102));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Acessar");
        btn_login.setBorderPainted(false);
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_login.setFocusPainted(false);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 100, 35));

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

        btn_minimiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Minimizar.png"))); // NOI18N
        btn_minimiza.setBorderPainted(false);
        btn_minimiza.setContentAreaFilled(false);
        btn_minimiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizaActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_minimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        Panel_Main.add(Panel_Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 500));

        getContentPane().add(Panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        setSize(new java.awt.Dimension(800, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        usuario = txt_usuario.getText();
        new _01_Menu(usuario).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_minimizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizaActionPerformed
        setState(this.ICONIFIED);
    }//GEN-LAST:event_btn_minimizaActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(_04_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_04_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_04_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_04_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            _00_Login dialog = new _00_Login(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Left;
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JPanel Panel_Right;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_minimiza;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel lbl_copy;
    private javax.swing.JLabel lbl_gcjr;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
