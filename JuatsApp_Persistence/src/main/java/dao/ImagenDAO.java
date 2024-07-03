/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import conexion.ConexionMongoDB;
import entidades.Imagen;
import excepciones.PersistenciaException;
import interfaces.IimagenDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class ImagenDAO implements IimagenDAO{

    private final MongoCollection<Imagen> coleccionImagenes;

    public ImagenDAO() {
        this.coleccionImagenes = ConexionMongoDB.getDatabase().getCollection("imagenes", Imagen.class);
    }

    @Override
    public void guardar(Imagen imagen) throws PersistenciaException {
        try {
            this.coleccionImagenes.insertOne(imagen);
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo agregar la imagen con: " + imagen.getId() + "a la coleccion.");
        }
    }

    @Override
    public void actualizar(Imagen imagen) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Eliminar(Imagen imagen) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Imagen> consultarTodo() throws PersistenciaException {
        List<Imagen> listaImagenes = new ArrayList<>();
        this.coleccionImagenes.find().into(listaImagenes);
        return listaImagenes;
    }

    @Override
    public Imagen consultarPorId(String id) throws PersistenciaException {
        List<Imagen> listaImagenes = new ArrayList<>();
        Document filtro = new Document();
        filtro.append("_id", new ObjectId(id));
        this.coleccionImagenes.find(filtro).into(listaImagenes);
        if (listaImagenes.isEmpty()) {
            return null;
        } else {
            return listaImagenes.get(0);
        }
    }

    public Document toDocument(Imagen imagen) {
        Document document = new Document();
        document.append("_id", imagen.getId());
        document.append("nombre", imagen.getNombre());
        document.append("archivoImagen", imagen.getArchivoImagen());
        return document;
    }
}
