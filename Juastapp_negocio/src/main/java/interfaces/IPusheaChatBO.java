/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.NegocioException;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public interface IPusheaChatBO {

    public void pusheaChat(String idUsuario, String idChat) throws NegocioException;
}
