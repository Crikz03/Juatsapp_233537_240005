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
import entidades.Chat;
import excepciones.PersistenciaException;
import interfaces.IChatDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class ChatDAO implements IChatDAO {
  private final String connectionString;
    private final String databaseName;

    public ChatDAO(String connectionString, String databaseName) {
        this.connectionString = connectionString;
        this.databaseName = databaseName;
    }

    @Override
    public void guardar(Chat chat) throws PersistenciaException {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Chat> coleccionChats = conexionMongoDB.getDatabase().getCollection("chats", Chat.class);
            coleccionChats.insertOne(chat);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo agregar el chat con: " + chat.getId() + "a la coleccion.");
        }
    }

    @Override
    public void actualizar(Chat chat) throws PersistenciaException {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Chat> coleccionChats = conexionMongoDB.getDatabase().getCollection("chats", Chat.class);
            Bson filter = Filters.eq("_id", chat.getId());
            coleccionChats.replaceOne(filter, chat);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo actualizar el chat con id: " + chat.getId());
        }
    }

    @Override
    public void eliminar(Chat chat) throws PersistenciaException {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Chat> coleccionChats = conexionMongoDB.getDatabase().getCollection("chats", Chat.class);
            coleccionChats.deleteOne(Filters.eq("_id", chat.getId()));
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo eliminar el chat con id: " + chat.getId());
        }
    }

    @Override
    public List<Chat> consultarTodos() throws PersistenciaException {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Chat> coleccionChats = conexionMongoDB.getDatabase().getCollection("chats", Chat.class);
            FindIterable<Chat> findIterable = coleccionChats.find();
            return findIterable.into(new ArrayList<>());
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo consultar la lista de chats.");
        }
    }

    @Override
    public Chat consultarPorId(String id) throws PersistenciaException {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Chat> coleccionChats = conexionMongoDB.getDatabase().getCollection("chats", Chat.class);
            Bson filter = Filters.eq("_id", new ObjectId(id));
            return coleccionChats.find(filter).first();
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo consultar el chat con id: " + id);
        }
    }

    @Override
    public void pushMensaje(ObjectId chatId, ObjectId mensajeId)throws PersistenciaException  {
        try (ConexionMongoDB conexionMongoDB = MongoClientFactory.createConexionMongoDB(connectionString, databaseName)) {
            MongoCollection<Chat> coleccionChats = conexionMongoDB.getDatabase().getCollection("chats", Chat.class);
            Document updateQuery = new Document("$push", new Document("historialMensajes", mensajeId));
            coleccionChats.updateOne(new Document("_id", chatId), updateQuery);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo agregar el mensaje al chat con id: " + chatId);
        }
    }
}