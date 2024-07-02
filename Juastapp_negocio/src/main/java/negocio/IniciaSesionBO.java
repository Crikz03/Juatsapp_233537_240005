/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import convertidores.ConvertidorGeneral;
import dao.UsuarioDAO;
import dtos.UsuarioDTO;
import entidades.Usuario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;
import interfaces.IiniciaSesionBO;

/**
 *
 * @author Chris
 */
public class IniciaSesionBO implements IiniciaSesionBO {

    IUsuarioDAO usuariodao;

    public IniciaSesionBO() {
        this.usuariodao = new UsuarioDAO();
    }

    @Override
    public UsuarioDTO iniciarSesion(String telefono) throws NegocioException {
        try {
            Usuario usuario = usuariodao.consultarPortelefono(telefono);
            if (usuario == null) {
                throw new NegocioException("El usuario no esta registrado.");
            }

            UsuarioDTO u = ConvertidorGeneral.convertidoraDTO(usuario, UsuarioDTO.class);
            return u;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al iniciar sesion con el usuario con telefono: " + telefono);
        }
    }

}
