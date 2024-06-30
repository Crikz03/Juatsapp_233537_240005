/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.ConexionMongoDB;
import entidades.Chat;
import excepciones.PersistenciaException;
import interfaces.IChatDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class ChatDAO implements IChatDAO {

    private final MongoCollection<Chat> coleccionChats;

    public ChatDAO() {
        this.coleccionChats = ConexionMongoDB.getDatabase().getCollection("chats", Chat.class);
    }

    @Override
    public void guardar(Chat chat) throws PersistenciaException {
        try {
            this.coleccionChats.insertOne(chat);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo agregar el chat con: " + chat.getId() + "a la coleccion.");
        }
    }

    @Override
    public void actualizar(Chat chat) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Eliminar(Chat chat) throws PersistenciaException {
        try {
            this.coleccionChats.deleteOne(Filters.eq("_id", chat.getId()));
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo eliminar el chat con id: " + chat.getId());
        }
    }

    @Override
    public List<Chat> consultarTodos() throws PersistenciaException {
        List<Chat> listaChat = new ArrayList<>();
        this.coleccionChats.find().into(listaChat);
        return listaChat;
    }

    @Override
    public Chat consultarPorId(String id) throws PersistenciaException {
        List<Chat> listaChats = new ArrayList<>();
        Document filtro = new Document();
        filtro.append("_id", new ObjectId(id));
        this.coleccionChats.find(filtro).into(listaChats);
        if (listaChats.isEmpty()) {
            return null;
        } else {
            return listaChats.get(0);
        }
    }

    public void pushMensaje(ObjectId chatId, ObjectId mensajeId) {
        Document updateQuery = new Document("$push", new Document("historialMensajes", mensajeId));
        this.coleccionChats.updateOne(new Document("_id", chatId), updateQuery);
    }

}
