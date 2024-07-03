/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import convertidores.ConvertidorGeneral;
import dao.ChatDAO;
import dtos.ChatDTO;
import entidades.Chat;
import entidades.Imagen;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IChatDAO;
import interfaces.ICrudChatBO;
import java.util.List;

/**
 *
 * @author Chris
 */
public class CrudChatBO implements ICrudChatBO<ChatDTO> {

    IChatDAO chatdao;

    public CrudChatBO() {
        this.chatdao = new ChatDAO();
    }

    @Override
    public void Guardar(ChatDTO entidad) throws NegocioException {
        try {
            chatdao.guardar(ConvertidorGeneral.convertidorEntidad(entidad, Chat.class));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo agregar el chat.");
        }
    }

    @Override
    public void Actualizar(ChatDTO entidad) throws NegocioException {
        try {
            chatdao.actualizar(ConvertidorGeneral.convertidorEntidad(entidad, Chat.class));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo actualizar el chat.");
        }
    }

    @Override
    public void Elimina(ChatDTO entidad) throws NegocioException {
        try {
            chatdao.Eliminar(ConvertidorGeneral.convertidorEntidad(entidad, Chat.class));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo eliminar el chat.");
        }
    }

    @Override
    public List<ChatDTO> consultaTodo() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChatDTO consultaPorId(String id) throws NegocioException {
        try {
            Chat chat = chatdao.consultarPorId(id);

            ChatDTO chatdto = ConvertidorGeneral.convertidorEntidad(chat, ChatDTO.class);
            return chatdto;
        } catch (PersistenciaException e) {
            throw new NegocioException("No se encontro el chat con id de: " + id);
        }
    }

}
