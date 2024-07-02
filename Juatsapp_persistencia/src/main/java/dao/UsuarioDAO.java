/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongoDB;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<Usuario> coleccionUsuarios;
    private final ImagenDAO imadao;

    public UsuarioDAO() {
        this.coleccionUsuarios = ConexionMongoDB.getDatabase().getCollection("usuarios", Usuario.class);
        this.imadao = new ImagenDAO();
    }

    @Override
    public void guardar(Usuario usuario) throws PersistenciaException {
        try {
            this.coleccionUsuarios.insertOne(usuario);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo agregar el usuario con: " + usuario.getId() + "a la coleccion.");
        }
    }

    @Override
    public void actualizar(Usuario usuario) throws PersistenciaException {
        try {
            Document filter = new Document("_id", usuario.getId());

            Document updateContenido = new Document();
            updateContenido.append("telefono", usuario.getTelefono());
            updateContenido.append("contrasena", usuario.getContrasena());
            updateContenido.append("nombres", usuario.getNombres());
            updateContenido.append("apellidoPaterno", usuario.getApellidoPaterno());
            updateContenido.append("apellidoMaterno", usuario.getApellidoMaterno());
            updateContenido.append("sexo", usuario.getSexo().toString());
            updateContenido.append("imagenPerfil", imadao.toDocument(usuario.getImagenPerfil()));

            Document update = new Document("$set", updateContenido);

            coleccionUsuarios.updateOne(filter, update);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al actualizar el usuario con id: " + usuario.getId());
        }
    }

    @Override
    public List<Usuario> consultarTodos() throws PersistenciaException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        this.coleccionUsuarios.find().into(listaUsuarios);
        return listaUsuarios;
    }

    @Override
    public Usuario consultarPorId(String id) throws PersistenciaException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Document filtro = new Document();
        filtro.append("_id", new ObjectId(id));
        this.coleccionUsuarios.find(filtro).into(listaUsuarios);
        if (listaUsuarios.isEmpty()) {
            return null;
        } else {
            return listaUsuarios.get(0);
        }
    }

    @Override
    public Usuario consultarPortelefono(String telefono) throws PersistenciaException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Document filtro = new Document();
        filtro.append("telefono", telefono);
        this.coleccionUsuarios.find(filtro).into(listaUsuarios);
        if (listaUsuarios.isEmpty()) {
            return null;
        } else {
            return listaUsuarios.get(0);
        }
    }

    public void pushChat(ObjectId userId, ObjectId chatId) {
        Document updateQuery = new Document("$push", new Document("chats", chatId));

        this.coleccionUsuarios.updateOne(new Document("_id", userId), updateQuery);
    }

}
