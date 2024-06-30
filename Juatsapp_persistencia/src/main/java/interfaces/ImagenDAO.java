/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Imagen;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public interface ImagenDAO {

    public void guardar(Imagen imagen) throws PersistenciaException;

    public void actualizar(Imagen imagen) throws PersistenciaException;

    public void Eliminar(Imagen imagen) throws PersistenciaException;

    public List<Imagen> consultarTodo() throws PersistenciaException;

    public Imagen consultarPorId(String id) throws PersistenciaException;
}
