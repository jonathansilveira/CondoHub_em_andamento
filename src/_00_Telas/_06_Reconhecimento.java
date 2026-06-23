package _00_Telas;

import _01_Classes.ConectaBanco;
import _01_Classes.ControlPerson;
import _01_Classes.ModelPerson;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Array;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

public class _06_Reconhecimento extends javax.swing.JDialog {

// Instâncias
    ModelPerson mod = new ModelPerson();
    ControlPerson cod = new ControlPerson();
    ConectaBanco conecta = new ConectaBanco();

// Variáveis globais    
    String firstNamePerson, cargo;
    int id;
    static int ICONIFIED;
    private _06_Reconhecimento.DaemonThread myThread = null;
    private int mouseX, mouseY;

// JavaCV - Captura de vídeo e processamento de imagem
    VideoCapture webSource = null; // Objeto responsável pela captura de vídeo da câmera (inicializado como null).
    Mat cameraImage = new Mat(); // Matriz (Mat) que armazena a imagem capturada pela câmera.
    CascadeClassifier cascade = new CascadeClassifier("C:\\photos\\haarcascade_frontalface_alt.xml"); // Classificador Haar (para detecção de faces) carregado de um arquivo XML.
    LBPHFaceRecognizer recognizer = LBPHFaceRecognizer.create(); // Inicializa o reconhecedor de faces usando o método LBPH (Local Binary Patterns Histograms)
    BytePointer mem = new BytePointer();  // Ponteiro para armazenar dados em memória, possivelmente utilizado para manipulação de imagens.
    RectVector detectedFaces = new RectVector(); // Vetor que armazena as regiões da imagem onde faces foram detectadas (usado pelo CascadeClassifier).

    public _06_Reconhecimento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);  // Chama o construtor da classe pai (JDialog), passando o frame pai e o parâmetro modal para configurar a janela de diálogo
        initComponents(); // Inicialização
        setIcon(); // Classe setIcon, abre a tela com icon especificado
        Move(); // Classe Move, para movimentação da janela 
        
        // Carrega o modelo de reconhecimento facial previamente treinado a partir de um arquivo YAML.
        recognizer.read("C:\\photos\\classifierLBPH.yml"); // O arquivo "classifierLBPH.yml" contém os dados do classificador LBPH treinado para reconhecimento de faces.

        // Define o limiar (threshold) de confiança para o reconhecimento facial.
        recognizer.setThreshold(80);// O valor de 80 indica que o sistema deve aceitar uma correspondência de face se a confiança for maior que 80
                                      // Valores mais altos podem aumentar a precisão, mas podem reduzir a taxa de reconhecimento.
        startCamera();
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
        Panel_Main_2 = new javax.swing.JPanel();
        txt_id_label = new javax.swing.JLabel();
        lbl_faceid = new javax.swing.JLabel();
        lbl_cargo = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        lbl_camera = new javax.swing.JLabel();
        lbl_nome2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JLabel();
        btn_minimiza = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCJR SOLUTIONS");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Main.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Main.setPreferredSize(new java.awt.Dimension(400, 500));
        Panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Main_2.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Main_2.setMinimumSize(new java.awt.Dimension(400, 500));
        Panel_Main_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_label.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_label.setText("0");
        Panel_Main_2.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        lbl_faceid.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_faceid.setForeground(new java.awt.Color(255, 255, 255));
        lbl_faceid.setText("FACE ID");
        Panel_Main_2.add(lbl_faceid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        lbl_cargo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_cargo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cargo.setText("Cargo:");
        Panel_Main_2.add(lbl_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, -1, -1));

        lbl_nome.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_nome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome.setText("ID:");
        Panel_Main_2.add(lbl_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));
        Panel_Main_2.add(lbl_camera, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 430, 340));

        lbl_nome2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_nome2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome2.setText("Nome:");
        Panel_Main_2.add(lbl_nome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, -1));

        txt_nome.setBackground(new java.awt.Color(0, 102, 102));
        txt_nome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_nome.setForeground(new java.awt.Color(0, 102, 102));
        txt_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Main_2.add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 170, 30));

        txt_id.setBackground(new java.awt.Color(0, 102, 102));
        txt_id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_id.setForeground(new java.awt.Color(0, 102, 102));
        txt_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Main_2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 170, 30));

        txt_cargo.setBackground(new java.awt.Color(255, 255, 255));
        txt_cargo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_cargo.setForeground(new java.awt.Color(255, 255, 255));
        txt_cargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Main_2.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 170, 30));

        btn_minimiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_02_Imagens/Btn_Minimizar.png"))); // NOI18N
        btn_minimiza.setBorderPainted(false);
        btn_minimiza.setContentAreaFilled(false);
        btn_minimiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizaActionPerformed(evt);
            }
        });
        Panel_Main_2.add(btn_minimiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, -1));

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
        Panel_Main_2.add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 56, -1));

        Panel_Main.add(Panel_Main_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        getContentPane().add(Panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        setSize(new java.awt.Dimension(500, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(_06_Reconhecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_06_Reconhecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_06_Reconhecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_06_Reconhecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                _06_Reconhecimento dialog = new _06_Reconhecimento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JPanel Panel_Main_2;
    private javax.swing.JButton btn_minimiza;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel lbl_camera;
    private javax.swing.JLabel lbl_cargo;
    private javax.swing.JLabel lbl_faceid;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_nome2;
    private javax.swing.JLabel txt_cargo;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_id_label;
    private javax.swing.JLabel txt_nome;
    // End of variables declaration//GEN-END:variables

// Classe que implementa a interface Runnable, criando uma thread que pode ser executada em paralelo
class DaemonThread implements Runnable {

// A variável 'runnable' controla o loop da thread, sendo volátil para garantir a visibilidade entre threads
    protected volatile boolean runnable = false;

    @Override
    public void run() {
        // Usando 'synchronized' para garantir que o acesso ao bloco de código seja seguro em um ambiente multithread
        synchronized (this) {
            // Loop enquanto a variável 'runnable' for verdadeira
            while (runnable) {
                try {
                    // Tenta capturar um novo quadro de vídeo da câmera
                    if (webSource.grab()) {
                        // Recupera o quadro capturado e o armazena na variável 'cameraImage'
                        webSource.retrieve(cameraImage);

                        // Obtém o gráfico da label 'lbl_camera' para desenhar a imagem da câmera
                        Graphics g = lbl_camera.getGraphics();

                        // Cria uma nova Mat para armazenar a versão em escala de cinza da imagem capturada
                        Mat imageGray = new Mat();
                        // Converte a imagem capturada de BGRA para escala de cinza
                        cvtColor(cameraImage, imageGray, COLOR_BGRA2GRAY);

                        // Cria um vetor para armazenar as faces detectadas
                        RectVector detectedFace = new RectVector();
                        // Detecta faces na imagem em escala de cinza
                        cascade.detectMultiScale(imageGray, detectedFace, 1.1, 2, 0, new Size(150, 150), new Size(500, 500));

                        // Itera sobre todas as faces detectadas
                        for (int i = 0; i < detectedFace.size(); i++) {
                            // Obtém as coordenadas do retângulo de uma face detectada
                            Rect dadosFace = detectedFace.get(i);
                            // Desenha um retângulo verde ao redor da face detectada
                            rectangle(cameraImage, dadosFace, new Scalar(0, 255, 0, 3), 3, 0, 0);

                            // Cria uma Mat com a região da face detectada
                            Mat faceCapturada = new Mat(imageGray, dadosFace);
                            // Redimensiona a face para 160x160 pixels para ser reconhecida
                            opencv_imgproc.resize(faceCapturada, faceCapturada, new Size(160, 160));

                            // Ponteiros para armazenar o rótulo e a confiança do reconhecimento facial
                            IntPointer rotulo = new IntPointer(1);
                            DoublePointer confidence = new DoublePointer(1);
                            // Realiza a previsão do reconhecimento facial usando o classificador LBPH
                            recognizer.predict(faceCapturada, rotulo, confidence);
                            int prediction = rotulo.get(0);
                            String nome;
                            nome = firstNamePerson;

                            // Se o reconhecimento facial falhar (prediction == -1), marca a face como desconhecida
                            if (prediction == -1) {
                                // Desenha um retângulo vermelho para faces desconhecidas
                                rectangle(cameraImage, dadosFace, new Scalar(0, 0, 255, 3), 3, 0, 0);
                                id = 0;
                                // Atualiza o texto da UI com informações sobre a pessoa desconhecida
                                txt_id.setText("Desconhecido");
                                txt_cargo.setText("");
                            } else {
                                // Desenha um retângulo verde para faces reconhecidas
                                rectangle(cameraImage, dadosFace, new Scalar(0, 255, 0, 3), 3, 0, 0);
                                // Exibe o nível de confiança da previsão no console
                                System.out.println(confidence.get(0));
                                id = prediction;
                                System.out.println("PESSOA RECONHECIDA COMO ID: " + id);
                                rec(); // Chama um método de reconhecimento 

                                // Se o cargo da pessoa for "Analista", abre o menu do analista
                                if (txt_cargo.getText().equals("Assistente")) {
                                    stopCamera();
                                    String usuario = txt_nome.getText();
                                    String cargo = txt_cargo.getText();
                                    String id = txt_id_label.getText();
                                    new _07_N1_Assistente_Menu(usuario, cargo, id).setVisible(true);
                                }
                                // Se o cargo for "Gerente", abre o menu do gerente
                                if (txt_cargo.getText().equals("Gerente")) {
                                    stopCamera();
                                    String usuario = txt_nome.getText();
                                    String cargo = txt_cargo.getText();
                                    String id = txt_id_label.getText();
                                    new _09_N2_Gerente_Menu(usuario, cargo, id).setVisible(true);
                                }
                                // Se o cargo for "Diretor", abre o menu do diretor
                                if (txt_cargo.getText().equals("Diretor(a)")) {
                                    stopCamera();
                                    String usuario = txt_nome.getText();
                                    String cargo = txt_cargo.getText();
                                    String id = txt_id_label.getText();
                                    new _14_N3_Diretor_Menu(usuario, cargo, id).setVisible(true);
                                }
                            }
                        }

                        // Codifica a imagem para o formato BMP e armazena os bytes em 'mem'
                        imencode(".bmp", cameraImage, mem);
                        // Converte os bytes da imagem para um objeto Image
                        Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                        BufferedImage buff = (BufferedImage) im;

                        try {
                            // Desenha a imagem da câmera na interface gráfica
                            if (g.drawImage(buff, 0, 0, 360, 390, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                // Se 'runnable' for falso, a thread aguarda
                                if (runnable == false) {
                                    this.wait();
                                }
                            }
                        } catch (Exception e) {
                            // Trata exceções no desenho da imagem (não detalhado)
                        }
                    }
                } catch (Exception ex) {
                    // Trata exceções durante o processo de captura e processamento de imagem
                }
            }
        }
    }
}


// Método 'rec' que realiza a recuperação de dados do banco de dados em uma thread separada
private void rec() {
    // Cria e inicia uma nova thread para não bloquear a interface gráfica enquanto os dados são recuperados do banco
    new Thread() {
        @Override
        public void run() {
            // Estabelece uma conexão com o banco de dados
            conecta.conexao();
            try {
                // Executa uma consulta SQL para buscar informações do usuário com base no 'id'
                conecta.executaSQL("SELECT * FROM usuarios WHERE id = " + String.valueOf(id));
                
                // Enquanto houver resultados na consulta, entra no loop
                while (conecta.rs.next()) {
                    // Recupera o primeiro nome da pessoa do banco de dados e armazena em 'firstNamePerson'
                    firstNamePerson = conecta.rs.getString("nome");

                    // Exibe o nome completo na interface gráfica (campo txt_nome)
                    txt_nome.setText(conecta.rs.getString("nome") + " " + conecta.rs.getString("sobrenome"));
                    
                    // Exibe o cargo da pessoa no campo txt_cargo
                    txt_cargo.setText(conecta.rs.getString("cargo"));
                    
                    // Exibe o id do usuário no campo txt_id_label e txt_id
                    txt_id_label.setText(conecta.rs.getString("id"));
                    txt_id.setText(conecta.rs.getString("id"));

                    // Recupera um array de strings armazenado na coluna "nome" no banco de dados
                    Array ident = conecta.rs.getArray("nome");
                    // Converte o array em um array de strings
                    String[] person = (String[]) ident.getArray();

                    // Itera sobre cada elemento do array de strings e imprime no console
                    for (String person1 : person) {
                        System.out.println(person1);
                    }

                }
            } catch (Exception e) {
                // Se houver alguma exceção, ela é silenciosamente ignorada
            }
            // Fecha a conexão com o banco de dados ao final
            conecta.desconecta();
        }
    }.start(); // Inicia a execução da thread
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
                myThread = new _06_Reconhecimento.DaemonThread();

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

// Método 'setState' que não foi implementado ainda. Lança uma exceção informando que a operação não é suportada.
private void setState(int ICONIFIED) {
    throw new UnsupportedOperationException("Not supported yet."); // Lança uma exceção indicando que a funcionalidade ainda não foi implementada.
}

}
