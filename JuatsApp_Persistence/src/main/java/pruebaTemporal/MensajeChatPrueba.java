/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaTemporal;

import dao.ChatDAO;
import dao.MensajeDAO;
import dao.UsuarioDAO;
import entidades.Chat;
import entidades.Mensaje;
import excepciones.PersistenciaException;
import java.time.LocalDateTime;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class MensajeChatPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MensajeDAO mensajeDAO = new MensajeDAO();
        ChatDAO chatDAO = new ChatDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            // Crear un mensaje y guardarlo usando MensajeDAO
            ObjectId usuarioReceptor = new ObjectId("6681110cc832224a66fe753f"); // Ejemplo de ObjectId para el usuario receptor
            ObjectId usaurioEmisor = new ObjectId("6681108d68383f04564c5848");
            Mensaje mensaje = new Mensaje(usuarioReceptor, "Hola, ¿cómo estás?", LocalDateTime.now());
            mensajeDAO.guardar(mensaje);
            System.out.println("Mensaje guardado correctamente.");

            // Crear un chat y guardarlo usando ChatDAO
            Chat chat = new Chat(usuarioReceptor, usaurioEmisor, LocalDateTime.now());
            chatDAO.guardar(chat);
            System.out.println("Chat guardado correctamente.");

            // Obtener el ID del mensaje guardado y el ID del chat guardado
            ObjectId mensajeId = mensaje.getId();
            ObjectId chatId = chat.getId();

            // Insertar mensaje en el historial de mensajes del chat usando pushMensaje
            chatDAO.pushMensaje(chatId, mensajeId);

            usuarioDAO.pushChat(usaurioEmisor.toString(), chatId.toString());
            usuarioDAO.pushChat(usuarioReceptor.toString(), chatId.toString());

            System.out.println("Mensaje insertado en el historial de mensajes del chat.");

        } catch (PersistenciaException e) {
            System.err.println("Error de persistencia: " + e.getMessage());
        }

    }
}
