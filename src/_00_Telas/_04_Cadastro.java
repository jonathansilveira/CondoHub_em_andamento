package _00_Telas;

import _01_Classes.ModelPerson;
import _01_Classes.ControlPerson;
import _01_Classes.TrainLBPH;
import _01_Classes.ConectaBanco;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;

public class _04_Cadastro extends javax.swing.JDialog {

// Instâncias
    ConectaBanco conecta = new ConectaBanco(); // Instância da classe de conexão ao banco de dados

// Variáveis globais
    static int ICONIFIED;  // Variável estática que é usada para indicar o estado da janela (minimizada)
    private int mouseX, mouseY;

// Instância
    private _04_Cadastro.DaemonThread myThread = null;  // Instância de DaemonThread, provavelmente usada para executar operações em segundo plano (como captura de vídeo ou detecção de face).

// JavaCV - Captura de vídeo e processamento de imagem
    VideoCapture webSource = null;  // Objeto responsável pela captura de vídeo da câmera (inicializado como null).
    Mat cameraImage = new Mat();  // Matriz (Mat) que armazena a imagem capturada pela câmera.
    CascadeClassifier cascade = new CascadeClassifier("C://photos//haarcascade_frontalface_alt.xml");  // Classificador Haar (para detecção de faces) carregado de um arquivo XML.

    BytePointer mem = new BytePointer();  // Ponteiro para armazenar dados em memória, utilizado para manipulação de imagens.
    RectVector detectedFaces = new RectVector();  // Vetor que armazena as regiões da imagem onde faces foram detectadas (usado pelo CascadeClassifier).

    int numSamples = 25, sample = 1, idPerson;  // Variáveis para controle das amostras de rosto coletadas: 
    //numSamples define o número total (25), sample é o contador de amostras e idPerson é o identificador da pessoa.

    public _04_Cadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal); // Chama o construtor da classe pai (JDialog), passando o frame pai e o parâmetro modal para configurar a janela de diálogo
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        getIdUser(); // Classe para localizar ID do usuário cadastrado
        startCamera(); // Classe para iniciar camera ao abrir a tela
        Move(); // Classe Move, para movimentação da janela 
    }

    public _04_Cadastro() {
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        getIdUser(); // Classe para localizar ID do usuário cadastrado
        startCamera(); // Classe para iniciar camera ao abrir a tela
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
        Panel_Left = new javax.swing.JPanel();
        btn_foto = new javax.swing.JButton();
        txt_id_label = new javax.swing.JLabel();
        lbl_camera = new javax.swing.JLabel();
        lbl_faceid = new javax.swing.JLabel();
        ctn_foto = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        Panel_Right = new javax.swing.JPanel();
        lbl_dados = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_sobrenome = new javax.swing.JLabel();
        txt_sobrenome = new javax.swing.JTextField();
        lbl_telefone = new javax.swing.JLabel();
        lbl_cpf = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_cargo = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JComboBox<>();
        lbl_sexo = new javax.swing.JLabel();
        txt_sexo = new javax.swing.JComboBox<>();
        txt_telefone = new javax.swing.JFormattedTextField();
        txt_cpf = new javax.swing.JFormattedTextField();
        btn_sair = new javax.swing.JButton();
        btn_minimiza = new javax.swing.JButton();
        btn_limpa1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCJR SOLUTIONS");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Main.setPreferredSize(new java.awt.Dimension(800, 500));
        Panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Left.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Left.setMinimumSize(new java.awt.Dimension(400, 500));
        Panel_Left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Camera.png"))); // NOI18N
        btn_foto.setContentAreaFilled(false);
        Panel_Left.add(btn_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 70, 47));

        txt_id_label.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_label.setText("0");
        Panel_Left.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));
        Panel_Left.add(lbl_camera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 360, 330));

        lbl_faceid.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_faceid.setForeground(new java.awt.Color(255, 255, 255));
        lbl_faceid.setText("Face ID");
        Panel_Left.add(lbl_faceid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        ctn_foto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ctn_foto.setForeground(new java.awt.Color(255, 255, 255));
        ctn_foto.setText("00/25");
        Panel_Left.add(ctn_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 70, 30));

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

        Panel_Main.add(Panel_Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        Panel_Right.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Right.setMinimumSize(new java.awt.Dimension(400, 500));
        Panel_Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dados.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_dados.setForeground(new java.awt.Color(0, 102, 102));
        lbl_dados.setText("Dados");
        Panel_Right.add(lbl_dados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

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

        lbl_cpf.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cpf.setText("CPF");
        Panel_Right.add(lbl_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 260, -1, -1));

        lbl_email.setForeground(new java.awt.Color(0, 0, 0));
        lbl_email.setText("E-mail");
        Panel_Right.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 320, -1, -1));
        Panel_Right.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 340, 200, 25));

        lbl_cargo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cargo.setText("Cargo");
        Panel_Right.add(lbl_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 440, -1, -1));

        txt_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Assistente", "Gerente", "Diretor(a)" }));
        Panel_Right.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 460, 200, 25));

        lbl_sexo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_sexo.setText("Sexo");
        Panel_Right.add(lbl_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 380, -1, -1));

        txt_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino", "Outro" }));
        Panel_Right.add(txt_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 400, 200, 25));

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Panel_Right.add(txt_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 220, 200, 25));

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Panel_Right.add(txt_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 280, 200, 25));

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

        btn_limpa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Limpa.png"))); // NOI18N
        btn_limpa1.setBorderPainted(false);
        btn_limpa1.setContentAreaFilled(false);
        btn_limpa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpa1ActionPerformed(evt);
            }
        });
        Panel_Right.add(btn_limpa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        Panel_Main.add(Panel_Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 550));

        getContentPane().add(Panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        setSize(new java.awt.Dimension(800, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_minimizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizaActionPerformed
        setState(this.ICONIFIED);
    }//GEN-LAST:event_btn_minimizaActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        new _03_MenuADM().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_limpa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpa1ActionPerformed
        txt_nome.setText("");
        txt_sobrenome.setText("");
        txt_telefone.setText("");
        txt_cpf.setText("");
        txt_email.setText("");
        txt_sexo.setSelectedItem("Selecione");
        txt_cargo.setSelectedItem("Selecione");
    }//GEN-LAST:event_btn_limpa1ActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            _04_Cadastro dialog = new _04_Cadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_foto;
    private javax.swing.JButton btn_limpa1;
    private javax.swing.JButton btn_minimiza;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel ctn_foto;
    private javax.swing.JLabel lbl_camera;
    private javax.swing.JLabel lbl_cargo;
    private javax.swing.JLabel lbl_cpf;
    private javax.swing.JLabel lbl_dados;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_faceid;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_sexo;
    private javax.swing.JLabel lbl_sobrenome;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JComboBox<String> txt_cargo;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JTextField txt_email;
    private javax.swing.JLabel txt_id_label;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JComboBox<String> txt_sexo;
    private javax.swing.JTextField txt_sobrenome;
    private javax.swing.JFormattedTextField txt_telefone;
    // End of variables declaration//GEN-END:variables

// Método para obter o próximo ID disponível para o usuário
private int getIdUser() {
    int id = 0;  // Inicializa a variável id com 0
    conecta.conexao();  // Estabelece a conexão com o banco de dados

    // Executa a consulta SQL para obter o último ID registrado na tabela 'usuarios'
    conecta.executaSQL("SELECT * FROM usuarios ORDER BY id DESC LIMIT 1");

    try {
        // Verifica se a consulta retornou resultados
        if (conecta.rs.next()) {
            // Se houver registros, recupera o ID do último usuário registrado
            id = conecta.rs.getInt("id");

            // Incrementa o ID para o próximo usuário
            id++;
        } else {
            // Caso não haja registros (tabela vazia), inicia o ID com 1
            id = 1;
        }

        // Atualiza o campo 'txt_id_label' com o novo ID
        txt_id_label.setText(String.valueOf(id));

    } catch (SQLException e) {
        // Caso ocorra algum erro durante a execução da consulta, imprime o erro
        e.printStackTrace();
    }

    // Retorna o próximo ID
    return id;
}


// O objetivo do método é modificar o estado da janela com base no valor de ICONIFIED.
    private void setState(int ICONIFIED) {
        // Lança uma exceção UnsupportedOperationException indicando que este método ainda não foi implementado.
        throw new UnsupportedOperationException("Not supported yet.");
    }

// Classe DaemonThread implementando Runnable para captura de vídeo e detecção de faces
    class DaemonThread implements Runnable {

        // Variável para controle do loop da thread
        protected volatile boolean runnable = false;

        // Método run, que contém a lógica da thread
        @Override
        public void run() {
            synchronized (this) {  // Sincroniza o acesso à thread
                while (runnable) {  // Enquanto a variável 'runnable' for verdadeira, continua rodando
                    try {
                        // Captura um frame da câmera (webSource)
                        if (webSource.grab()) {
                            // Armazena a imagem capturada em 'cameraImage'
                            webSource.retrieve(cameraImage);

                            // Recupera o gráfico do componente 'lbl_camera' para desenhar a imagem
                            Graphics g = lbl_camera.getGraphics();

                            // Converte a imagem capturada de cor para escala de cinza
                            Mat imageColor = new Mat();  // Matriz para a imagem colorida
                            imageColor = cameraImage;

                            Mat imageGray = new Mat();  // Matriz para a imagem em escala de cinza
                            cvtColor(imageColor, imageGray, COLOR_BGRA2GRAY);  // Converte para escala de cinza

                            // Cria um vetor para armazenar as faces detectadas
                            RectVector detectedFaces = new RectVector();

                            // Detecta faces na imagem colorida com a ajuda do classificador Haar
                            cascade.detectMultiScale(imageColor, detectedFaces, 1.1, 1, 1, new Size(150, 150), new Size(500, 500));

                            // Loop para verificar todas as faces detectadas
                            for (int i = 0; i < detectedFaces.size(); i++) {
                                Rect dadosFace = detectedFaces.get(0);  // Obtém a face detectada

                                // Desenha um retângulo em torno da face detectada
                                rectangle(imageColor, dadosFace, new Scalar(255, 255, 0, 2), 3, 0, 0);

                                // Cria uma subimagem apenas com a face detectada
                                Mat face = new Mat(imageGray, dadosFace);
                                opencv_imgproc.resize(face, face, new Size(160, 160));  // Redimensiona a face para 160x160

                                // Verifica se o botão de captura de foto foi pressionado
                                if (btn_foto.getModel().isPressed()) {
                                    // Verifica se todos os campos obrigatórios estão preenchidos
                                    if (txt_nome.getText().equals("") || txt_nome.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Campo vazio");
                                    } else if (txt_sobrenome.getText().equals("") || txt_sobrenome.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Campo vazio");
                                    } else if (txt_telefone.getText().equals("") || txt_telefone.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Campo vazio");
                                    } else if (txt_cpf.getText().equals("") || txt_cpf.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Campo vazio");
                                    } else if (txt_email.getText().equals("") || txt_email.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Campo vazio");
                                    } else if (txt_sexo.getSelectedItem().equals("") || txt_sexo.getSelectedItem().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Campo vazio");
                                    } else if (txt_cargo.getSelectedItem().equals("") || txt_cargo.getSelectedItem().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Campo vazio");
                                    } else {
                                        // Verifica se o número de amostras é menor ou igual a 25, caso contrário salva a foto
                                        if (sample <= numSamples) {
                                            String cropped = "C:\\photos\\person." + txt_id_label.getText() + "." + sample + ".jpg";  // Caminho para salvar a foto
                                            imwrite(cropped, face);  // Salva a foto da face

                                            // Atualiza o contador de fotos tiradas
                                            ctn_foto.setText(String.valueOf(sample) + "/25");
                                            sample++;  // Incrementa o contador de amostras
                                        }

                                        // Se 25 fotos foram tiradas, treina o modelo de reconhecimento facial e insere no banco de dados
                                        if (sample > 25) {
                                            new TrainLBPH().trainPhotos();  // Treina o classificador
                                            insertDatabase();  // Insere os dados no banco de dados

                                            System.out.println("File Generated");
                                            stopCamera();  // Fecha a câmera
                                            new _00_Login(null, rootPaneCheckingEnabled).setVisible(true);  // Exibe a tela de login
                                            dispose();  // Fecha a tela atual
                                        }
                                    }
                                }
                            }

                            // Codifica a imagem em formato BMP
                            imencode(".bmp", cameraImage, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));  // Lê a imagem
                            BufferedImage buff = (BufferedImage) im;  // Converte para BufferedImage

                            try {
                                // Desenha a imagem no JLabel
                                if (g.drawImage(buff, 0, 0, 360, 390, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                    // Se o valor de runnable for falso, aguarda
                                    if (runnable == false) {
                                        System.out.println("Salve a Foto");
                                        this.wait();  // Espera a foto ser salva
                                    }
                                }
                            } catch (Exception e) {
                                // Trata exceções
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();  // Exibe exceções no console
                    }
                }
            }
        }
    }

// Classe para inserção dos dados no banco de dados
    public void insertDatabase() {
        // Instância das classes ControlPerson (responsável por operações SQL) e ModelPerson (contém os dados da pessoa)
        ControlPerson cod = new ControlPerson();
        ModelPerson mod = new ModelPerson();

        // Atribui os valores dos campos do formulário aos atributos do modelo (ModelPerson)
        mod.setId(Integer.parseInt(txt_id_label.getText()));
        mod.setNome(txt_nome.getText());
        mod.setSobrenome(txt_sobrenome.getText());
        mod.setTelefone(txt_telefone.getText());
        mod.setCpf(txt_cpf.getText());
        mod.setEmail(txt_email.getText());
        mod.setSexo(txt_sexo.getSelectedItem().toString());
        mod.setCargo(txt_cargo.getSelectedItem().toString());
        cod.insert(mod);
    }
    
// Classe para parar a câmera
    public void stopCamera() {
        // Define a variável 'runnable' como false para interromper o loop de captura de imagens no DaemonThread
        myThread.runnable = false;

        // Libera a câmera, parando a captura de vídeo
        webSource.release();

        // Fecha a janela atual, liberando os recursos gráficos
        dispose();
    }

// Classe para iniciar a câmera
    public void startCamera() {
        // Cria um novo thread para iniciar a captura de vídeo
        new Thread() {
            @Override
            public void run() {
                // Inicializa a câmera (webSource) no índice 0, geralmente a câmera padrão
                webSource = new VideoCapture(0);

                // Cria uma instância do thread que irá capturar as imagens da câmera
                myThread = new _04_Cadastro.DaemonThread();

                // Cria um novo thread para rodar o DaemonThread
                Thread t = new Thread(myThread);

                // Define o thread como Daemon, para que ele termine quando o programa principal terminar
                t.setDaemon(true);

                // Ativa a captura de vídeo no DaemonThread
                myThread.runnable = true;

                // Inicia o thread de captura de vídeo
                t.start();
            }
        }.start();
    }

}
