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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
