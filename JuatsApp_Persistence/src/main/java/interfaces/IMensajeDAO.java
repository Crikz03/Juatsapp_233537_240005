/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Mensaje;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public interface IMensajeDAO {

    public void guardar(Mensaje Mensaje) throws PersistenciaException;

    public void actualizar(Mensaje Mensaje) throws PersistenciaException;

    public void Eliminar(Mensaje Mensaje) throws PersistenciaException;

    public List<Mensaje> consultarTodos() throws PersistenciaException;
    
    public Mensaje consultarPorId(String id) throws PersistenciaException;
}
