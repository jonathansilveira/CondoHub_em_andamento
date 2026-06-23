package _00_Telas;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class _18_N3_Diretor extends javax.swing.JFrame {
    
// Variáveis globais  
    private int mouseX, mouseY;

    public _18_N3_Diretor(String usuario, String cargo, String id) {
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela 
        
        // Recebe os parametros e seta nos labels
        lbl_nome1.setText(usuario);
        lbl_cargo.setText(cargo);
        lbl_id1.setText(id);
    }

// Isso impede que a classe seja instanciada sem os parâmetros necessários
    private _18_N3_Diretor() {
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
        btn_voltar = new javax.swing.JButton();
        lbl_grafico = new javax.swing.JLabel();
        btn_minimiza = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        lbl_nome1 = new javax.swing.JLabel();
        lbl_cargo = new javax.swing.JLabel();
        lbl_id1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCJR SOLUTIONS");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Main.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Main.setPreferredSize(new java.awt.Dimension(900, 700));
        Panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Panel_Main.add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        lbl_grafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Gráfico_3.jpg"))); // NOI18N
        Panel_Main.add(lbl_grafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 740, 450));

        btn_minimiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Minimizar.png"))); // NOI18N
        btn_minimiza.setBorderPainted(false);
        btn_minimiza.setContentAreaFilled(false);
        btn_minimiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizaActionPerformed(evt);
            }
        });
        Panel_Main.add(btn_minimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 40, -1));

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
        Panel_Main.add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(873, 0, 30, 23));

        lbl_nome1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_nome1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome1.setText("Nome");
        lbl_nome1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Main.add(lbl_nome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 160, -1));

        lbl_cargo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_cargo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cargo.setText("Cargo");
        lbl_cargo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Main.add(lbl_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 160, -1));

        lbl_id1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id1.setText("ID");
        lbl_id1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_Main.add(lbl_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, -1));

        getContentPane().add(Panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        setSize(new java.awt.Dimension(900, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        String usuario = lbl_nome1.getText();
        String cargo = lbl_cargo.getText();
        String id = lbl_id1.getText();
        new _16_N3_Diretor(usuario, cargo, id).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_minimizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizaActionPerformed
        setState(this.ICONIFIED);
    }//GEN-LAST:event_btn_minimizaActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(_18_N3_Diretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_18_N3_Diretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_18_N3_Diretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_18_N3_Diretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new _18_N3_Diretor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JButton btn_minimiza;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel lbl_cargo;
    private javax.swing.JLabel lbl_grafico;
    private javax.swing.JLabel lbl_id1;
    private javax.swing.JLabel lbl_nome1;
    // End of variables declaration//GEN-END:variables
}
