/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IAñadeContactoBO {

    public void actualizarContactosUsuario(String telefono, List<String> contactos) throws NegocioException;

    public void agregarContactoUsuario(String telefono, String telefonoContacto) throws NegocioException;
}
