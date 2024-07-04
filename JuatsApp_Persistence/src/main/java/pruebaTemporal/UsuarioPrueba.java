/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaTemporal;

import dao.UsuarioDAO;
import entidades.Direccion;
import entidades.Imagen;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.time.LocalDateTime;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import utilidades.Genero;

/**
 *
 * @author Chris
 */
public class UsuarioPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Imagen imagenPerfil = new Imagen(new ObjectId(), "fotoPerfil.jpg", new Binary(new byte[]{0x01, 0x02, 0x03}));
        Direccion direccion = new Direccion("Calle Falsa", "123", "Colonia Inventada", 12345);
        Genero genero = Genero.Masculino;
//
        Usuario usuario = new Usuario(
                "555-1234",
                "contrasenaSegura",
                "Pepe",
                "Pistolas",
                "Lopez",
                genero,
                imagenPerfil,
                LocalDateTime.now(),
                direccion
        );

        try {
            usuarioDAO.guardar(usuario);
            usuarioDAO.consultarTodos();
            System.out.println("a"+ usuarioDAO.consultarTodos());
            System.out.println("Usuario guardado exitosamente");
        } catch (PersistenciaException e) {
            e.printStackTrace();
        }

//        usuario.setTelefono("555-5678");
//        usuario.setContrasena("nuevaContrasena");
//        usuario.setNombres("Juanito");
//        usuario.setApellidoPaterno("Gomez");
//        usuario.setApellidoMaterno("Rodriguez");
//        usuario.setSexo(Genero.Femenino);
//        usuario.getImagenPerfil().setNombre("nuevaFotoPerfil.jpg");
//        usuario.getDireccion().setCalle("Nueva Calle");
//        usuario.getDireccion().setNumero("456");
//        usuario.getDireccion().setColonia("Nueva Colonia");
//        usuario.getDireccion().setCodigoPostal(67890);
//        try {
//            usuarioDAO.actualizar(usuario);
//            System.out.println("Usuario actualizado exitosamente");
//        } catch (PersistenciaException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            System.out.println(usuarioDAO.consultarTodos());
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(UsuarioPrueba.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
