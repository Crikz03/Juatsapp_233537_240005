/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import convertidores.ConvertidorGeneral;
import dtos.ImagenDTO;
import entidades.Imagen;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import org.bson.types.Binary;

/**
 *
 * @author Chris
 */
public class GestorImagenesMongoDTO {

    /**
     * Tamaño de la imagen.
     */
    public enum SizeImage {
        /**
         * Dimensión de imágen pequeña.
         */
        SMALL,
        /**
         * Dimensión de imágen mediana.
         */
        MEDIUM,
        /**
         * Dimensión de imágen grande.
         */
        LARGE
    }

    /**
     * Ancho para imagen pequeña.
     */
    private static final int SMALL_WIDTH = 70;
    /**
     * Alto para imagen pequeña.
     */
    private static final int SMALL_HEIGHT = 70;

    /**
     * Ancho para imagen mediana.
     */
    private static final int MEDIUM_WIDTH = 200;
    /**
     * Largo para imagen mediana.
     */
    private static final int MEDIUM_HEIGHT = 200;

    /**
     * Ancho para imagen grande.
     */
    private static final int LARGE_WIDTH = 600;
    /**
     * Largo para imagen grande.
     */
    private static final int LARGE_HEIGHT = 600;

    private GestorImagenesMongoDTO() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Lee un archivo de imagen y regresa un documento con su nombre e
     * informacion.
     *
     * @param fileName
     * @param imageFile
     * @return El documento con la información de la imagen.
     * @throws IOException
     */
    public static ImagenDTO crearImagen(
            final String fileName,
            final File imageFile
    ) throws IOException {

        // Lee el archivo de imagen y conviértelo en un arreglo de bytes
        byte[] imageData = readImageData(imageFile);

        Imagen imagenDocument = new Imagen();
        imagenDocument.setArchivoImagen(new Binary(imageData));
        imagenDocument.setNombre(fileName);
        ImagenDTO imagenDTO = ConvertidorGeneral.convertidoraDTO(imagenDocument, ImagenDTO.class);

        return imagenDTO;
    }

    /**
     * Regresa un ImageIcon con dimensión especificada de un documento que
     * contenga informacion de una imagen.
     *
     * @param imageDocument
     * @param size
     * @return El icono con las dimensiones pedidas.
     */
    public static ImageIcon getImageIcon(
            final ImagenDTO imageDocument,
            final SizeImage size) {

        Binary imageData = imageDocument.getArchivoImagen();

        return resizeImageIcon(imageData, size);

    }

    /**
     * Ajusta la dimensión de la imagen.
     *
     * @param imageData
     * @param size
     * @return El icono ajustado.
     */
    private static ImageIcon resizeImageIcon(
            final Binary imageData,
            final SizeImage size
    ) {
        Image originalImage
                = Toolkit.getDefaultToolkit().createImage(imageData.getData());

        int width;
        int height;

        switch (size) {
            case SMALL:
                width = SMALL_WIDTH;
                height = SMALL_HEIGHT;
                break;
            case MEDIUM:
                width = MEDIUM_WIDTH;
                height = MEDIUM_HEIGHT;
                break;
            case LARGE:
                width = LARGE_WIDTH;
                height = LARGE_HEIGHT;
                break;
            default:
                throw new AssertionError();
        }

        // Ajustar dimensiones
        Image resizedImage = originalImage
                .getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);

    }

    /**
     * Lee un archivo y regresa la informacion de la imagen.
     *
     * @param file
     * @return el arreglo de bytes con la información.
     * @throws IOException
     */
    private static byte[] readImageData(final File file) throws IOException {
        byte[] data;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            data = new byte[(int) file.length()];
            inputStream.read(data);
        }
        return data;
    }
}
