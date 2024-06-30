/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Chat;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public interface IChatDAO {

    public void guardar(Chat chat) throws PersistenciaException;

    public void actualizar(Chat chat) throws PersistenciaException;

    public void eliminar(Chat chat) throws PersistenciaException;

    public List<Chat> consultarTodos() throws PersistenciaException;

    public Chat consultarPorId(String id) throws PersistenciaException;
}
