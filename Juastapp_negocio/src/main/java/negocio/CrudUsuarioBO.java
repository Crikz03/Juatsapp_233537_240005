/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import convertidores.ConvertidorGeneral;
import dao.UsuarioDAO;
import dtos.DireccionDTO;
import dtos.ImagenDTO;
import dtos.UsuarioDTO;
import entidades.Usuario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;
import java.util.List;
import utilidades.Encriptador;
import interfaces.ICrudUsuarioBO;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class CrudUsuarioBO implements ICrudUsuarioBO<UsuarioDTO> {

    IUsuarioDAO usuariodao;

    public CrudUsuarioBO() {
        this.usuariodao = new UsuarioDAO();
    }

    @Override
    public void Guardar(UsuarioDTO entidad) throws NegocioException {
        try {
            String hashedPassword = Encriptador.encriptarPassword(entidad.getContrasena());
            entidad.setContrasena(hashedPassword);
            usuariodao.guardar(ConvertidorGeneral.convertidorEntidad(entidad, Usuario.class));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo agregar el usuario con nombre: " + entidad.getNombres());
        }
    }

    @Override
    public void Actualizar(UsuarioDTO entidad) throws NegocioException {
        try {
            String hashedPassword = Encriptador.encriptarPassword(entidad.getContrasena());
            entidad.setContrasena(hashedPassword);
            usuariodao.actualizar(ConvertidorGeneral.convertidorEntidad(entidad, Usuario.class));
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo actualizar el usuario con id: " + entidad.getId());
        }
    }

    @Override
    public List<UsuarioDTO> consultaTodo() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuarioDTO consultaPorId(String id) throws NegocioException {
        try {
            Usuario usuario = usuariodao.consultarPorId(id);

            UsuarioDTO u = ConvertidorGeneral.convertidoraDTO(usuario, UsuarioDTO.class);

            return u;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el usuario con id: " + id);
        }
    }

    @Override
    public UsuarioDTO consultaPorTelefono(String telefono) throws NegocioException {
        try {
            Usuario usuario = usuariodao.consultarPortelefono(telefono);
            UsuarioDTO u = ConvertidorGeneral.convertidoraDTO(usuario, UsuarioDTO.class);
            DireccionDTO d= ConvertidorGeneral.convertidoraDTO(usuario.getDireccion(), DireccionDTO.class);
            ImagenDTO i= ConvertidorGeneral.convertidoraDTO(usuario.getImagenPerfil(), ImagenDTO.class);
            u.setDireccion(d);
            u.setImagenPerfil(i);
            return u;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el usuario con telefono: " + telefono);
        }
    }

    @Override
    public UsuarioDTO existeUsuario(String telefono) throws NegocioException {
        try {
            Usuario usuario = usuariodao.consultarPortelefono(telefono);

            if (usuario == null) {
                return null;
            }
            UsuarioDTO u = ConvertidorGeneral.convertidoraDTO(usuario, UsuarioDTO.class);
            return u;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar el teléfono", e);
        }
    }

    @Override
    public void actualizarContactosUsuario(String telefono, List<String> contactos) throws NegocioException {
        try {
            usuariodao.actualizarContactos(telefono, contactos);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo actualizar los contactos del usuario", e);
        }
    }

    @Override
    public void agregarContactoUsuario(String telefono, String telefonoContacto) throws NegocioException {
        try {
            usuariodao.agregarContacto(telefono, telefonoContacto);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo agregar el contacto al usuario", e);
        }
    }

}
