/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.NegocioException;

/**
 *
 * @author Chris
 */
public interface IVerificaChatExistenteBO {

    public boolean verificarChatExistente(String idEmisor, String idReceptor) throws NegocioException;
}
