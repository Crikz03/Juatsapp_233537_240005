/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.UsuarioDAO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IPusheaChatBO;
import interfaces.IUsuarioDAO;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class PusheaChatBO implements IPusheaChatBO {

    IUsuarioDAO usuariodao;

    public PusheaChatBO() {
        this.usuariodao = new UsuarioDAO();
    }

    @Override
    public void pusheaChat(String idUsuario, String idChat) throws NegocioException {
        try {
            usuariodao.pushChat(idUsuario, idChat);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al verificar si el chat existe", e);
        }
    }

}
