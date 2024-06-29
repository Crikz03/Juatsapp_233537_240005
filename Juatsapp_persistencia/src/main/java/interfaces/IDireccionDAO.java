/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Direccion;
import excepciones.PersistenciaException;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public interface IDireccionDAO {

    public void guardar(Direccion direccion) throws PersistenciaException;

    public void actualizar(Direccion direccion) throws PersistenciaException;

    public Direccion consultarPorId(String id) throws PersistenciaException;
}
