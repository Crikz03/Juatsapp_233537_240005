/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Chat;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public interface IChatDAO {

    public void guardar(Chat chat) throws PersistenciaException;

    public void actualizar(Chat chat) throws PersistenciaException;

    public void Eliminar(Chat chat) throws PersistenciaException;

    public List<Chat> consultarTodos() throws PersistenciaException;

    public Chat consultarPorId(String id) throws PersistenciaException;

    public void pushMensaje(ObjectId chatId, ObjectId mensajeId) throws PersistenciaException;
    
    public boolean verificarChatExistente(String idEmisor, String idReceptor) throws PersistenciaException;
}
