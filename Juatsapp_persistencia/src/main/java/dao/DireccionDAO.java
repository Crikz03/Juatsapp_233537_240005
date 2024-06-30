/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongoDB;
import entidades.Direccion;
import excepciones.PersistenciaException;
import interfaces.IDireccionDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class DireccionDAO implements IDireccionDAO {

    private final MongoCollection<Direccion> coleccionDirecciones;

    public DireccionDAO() {
        this.coleccionDirecciones = ConexionMongoDB.getDatabase().getCollection("direcciones", Direccion.class);
    }

    @Override
    public void guardar(Direccion direccion) throws PersistenciaException {
        try {
            this.coleccionDirecciones.insertOne(direccion);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo agregar la direccion a la coleccion.");
        }
    }

    @Override
    public void actualizar(Direccion direccion) throws PersistenciaException {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
        try {
            Document filter = new Document("numero", direccion.getNumero());

            Document actualiza = new Document();
            actualiza.append("calle", direccion.getCalle());
            actualiza.append("numero", direccion.getNumero());
            actualiza.append("colonia", direccion.getColonia());
            actualiza.append("codigoPostal", direccion.getCodigoPostal());

            Document update = new Document("$set", actualiza);

            coleccionDirecciones.updateOne(filter, update);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al actualizar la dirección con numero: " + direccion.getNumero());
        }
>>>>>>> parent of ed23030 (Reestructuracion)
    }

    @Override
    public Direccion consultarPorId(String id) throws PersistenciaException {
        List<Direccion> listaDirecciones = new ArrayList<>();
        Document filtro = new Document();
        filtro.append("_id", new ObjectId(id));
        this.coleccionDirecciones.find(filtro).into(listaDirecciones);
        if (listaDirecciones.isEmpty()) {
            return null;
        } else {
            return listaDirecciones.get(0);
        }
    }

}
