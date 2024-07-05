/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.ChatDAO;
import entidades.Chat;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IChatDAO;
import interfaces.IVerificaChatExistenteBO;

/**
 *
 * @author Chris
 */
public class VerificaChatExistenteBO implements IVerificaChatExistenteBO {

    IChatDAO chatdao;

    public VerificaChatExistenteBO() {
        this.chatdao = new ChatDAO();
    }

    @Override
    public boolean verificarChatExistente(String idEmisor, String idReceptor) throws NegocioException {
        try {
            return chatdao.verificarChatExistente(idEmisor, idReceptor);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al verificar si el chat existe", e);
        }
    }

}
