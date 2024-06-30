/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.ConexionMongoDB;
import entidades.Mensaje;
import excepciones.PersistenciaException;
import interfaces.IMensajeDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class MensajeDAO implements IMensajeDAO {

    private final MongoCollection<Mensaje> coleccionMensajes;

    public MensajeDAO() {
        this.coleccionMensajes = ConexionMongoDB.getDatabase().getCollection("mensajes", Mensaje.class);
    }

    @Override
    public void guardar(Mensaje mensaje) throws PersistenciaException {
        try {
            this.coleccionMensajes.insertOne(mensaje);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo agregar el mensaje con: " + mensaje.getId() + "a la coleccion.");
        }
    }

    @Override
    public void actualizar(Mensaje mensaje) throws PersistenciaException {
        try {
            Document filter = new Document("_id", mensaje.getId());
            Document updateContenido = new Document("$set", new Document("contenidoMensaje", mensaje.getContenidoMensaje()));

            this.coleccionMensajes.updateOne(filter, updateContenido);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al actualizar el mensaje con id: " + mensaje.getId());
        }

    }

    @Override
    public void Eliminar(Mensaje mensaje) throws PersistenciaException {
        try {
            this.coleccionMensajes.deleteOne(Filters.eq("_id", mensaje.getId()));
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo eliminar el mensaje con id: " + mensaje.getId());
        }
    }

    @Override
    public List<Mensaje> consultarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Mensaje consultarPorId(String id) throws PersistenciaException {
        List<Mensaje> listaMensajes = new ArrayList<>();
        Document filtro = new Document();
        filtro.append("_id", new ObjectId(id));
        this.coleccionMensajes.find(filtro).into(listaMensajes);
        if (listaMensajes.isEmpty()) {
            return null;
        } else {
            return listaMensajes.get(0);
        }
    }

}
