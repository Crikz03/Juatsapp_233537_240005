/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.UsuarioDTO;
import excepciones.NegocioException;

/**
 *
 * @author Chris
 */
public interface IiniciaSesionBO  {

    public UsuarioDTO iniciarSesion(String telefono) throws NegocioException;
}
