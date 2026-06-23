package _01_Classes;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;
import static org.bytedeco.opencv.global.opencv_core.CV_32SC1;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGR2GRAY;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.MatVector;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;

public class TrainLBPH {

    // Método para treinar o classificador LBPH usando as fotos armazenadas
    public void trainPhotos() {
        // Definir o diretório onde as fotos estão armazenadas
        File directory = new File("C:\\photos\\");

        // Filtrar arquivos que terminam com .jpg ou .png
        FilenameFilter filter = (File dir, String name1) -> name1.endsWith(".jpg") || name1.endsWith(".png");

        // Listar os arquivos que atendem ao filtro
        File[] files = directory.listFiles(filter);

        // Verificar se o diretório está vazio ou se não encontrou nenhuma imagem
        if (files == null || files.length == 0) {
            System.out.println("No images found in the specified directory.");
            return; // Encerra o método se não encontrar imagens
        }

        // MatVector para armazenar as fotos
        MatVector photos = new MatVector(files.length);

        // Mat para armazenar os rótulos (IDs das pessoas)
        Mat labels = new Mat(files.length, 1, CV_32SC1);

        // Buffer para armazenar os rótulos
        IntBuffer labelsBuffer = labels.createBuffer();

        // Contador para percorrer as imagens
        int counter = 0;

        // Laço para processar cada imagem encontrada no diretório
        for (File image : files) {
            // Ler a imagem da pasta
            Mat photo = imread(image.getAbsolutePath());

            // Verificar se a imagem foi lida com sucesso
            if (photo.empty()) {
                System.out.println("Could not read image: " + image.getAbsolutePath());
                continue; // Pular a imagem atual e continuar com as próximas
            }

            // Converter a imagem para escala de cinza (necessário para o treinamento)
            Mat grayPhoto = new Mat();
            opencv_imgproc.cvtColor(photo, grayPhoto, COLOR_BGR2GRAY);

            // Extrair o ID da pessoa da imagem (usando o nome do arquivo)
            int idP = Integer.parseInt(image.getName().split("\\.")[1]);

            // Redimensionar a imagem para um tamanho fixo (160x160)
            opencv_imgproc.resize(grayPhoto, grayPhoto, new Size(160, 160));

            // Armazenar a imagem processada e seu rótulo
            photos.put(counter, grayPhoto);
            labelsBuffer.put(counter, idP);
            counter++; // Incrementa o contador para a próxima imagem
        }

        // Criar o reconhecedor de face LBPH com parâmetros definidos
        LBPHFaceRecognizer lbph = LBPHFaceRecognizer.create(1, 8, 8, 8, 12);

        // Treinar o classificador LBPH com as imagens e seus rótulos
        lbph.train(photos, labels);

        // Salvar o modelo treinado no arquivo "classifierLBPH.yml"
        lbph.save("C:\\photos\\classifierLBPH.yml");
    }
}
