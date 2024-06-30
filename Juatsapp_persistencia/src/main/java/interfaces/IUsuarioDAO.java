/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Usuario;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public interface IUsuarioDAO {

    public void guardar(Usuario msuario) throws PersistenciaException;

    public void actualizar(Usuario msuario) throws PersistenciaException;

    public List<Usuario> consultarTodos() throws PersistenciaException;

    public Usuario consultarPorId(String id) throws PersistenciaException;

}
