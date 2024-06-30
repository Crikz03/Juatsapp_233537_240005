/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.ConexionMongoDB;
import conexion.MongoClientFactory;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author eljulls
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final String connectionString;
    private final String databaseName;

    public UsuarioDAO(String connectionString, String databaseName) {
        this.connectionString = connectionString;
        this.databaseName = databaseName;
    }

    @Override
    public void guardar(Usuario usuario) throws PersistenciaException {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Usuario> coleccionUsuarios = conexionMongoDB.getDatabase().getCollection("usuarios", Usuario.class);
            coleccionUsuarios.insertOne(usuario);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo agregar el usuario a la coleccion.");
        }
    }

    @Override
    public void actualizar(Usuario usuario) throws PersistenciaException {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Usuario> coleccionUsuarios = conexionMongoDB.getDatabase().getCollection("usuarios", Usuario.class);
            Bson filter = Filters.eq("_id", usuario.getId());
            coleccionUsuarios.replaceOne(filter, usuario);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo actualizar el usuario.");
        }
    }

    @Override
    public Usuario consultarPorId(String id) throws PersistenciaException {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Usuario> coleccionUsuarios = conexionMongoDB.getDatabase().getCollection("usuarios", Usuario.class);
            Bson filter = Filters.eq("_id", new ObjectId(id));
            return coleccionUsuarios.find(filter).first();
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo consultar el usuario con id: " + id);
        }
    }

    @Override
    public List<Usuario> consultarTodos() throws PersistenciaException {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Usuario> coleccionUsuarios = conexionMongoDB.getDatabase().getCollection("usuarios", Usuario.class);
            FindIterable<Usuario> iterable = coleccionUsuarios.find();
            return iterable.into(new ArrayList<>());
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo consultar todos los usuarios.");
        }
    }
}
