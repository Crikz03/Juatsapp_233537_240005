/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import org.bson.types.Binary;
import org.bson.types.ObjectId;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public class Imagen {

    private ObjectId id;
    private String nombre;
    private Binary archivoImagen;

    public Imagen() {
    }

    public Imagen(ObjectId id, String nombre, Binary archivoImagen) {
        this.id = id;
        this.nombre = nombre;
        this.archivoImagen = archivoImagen;
    }

    public Imagen(String nombre, Binary archivoImagen) {
        this.nombre = nombre;
        this.archivoImagen = archivoImagen;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Binary getArchivoImagen() {
        return archivoImagen;
    }

    public void setArchivoImagen(Binary archivoImagen) {
        this.archivoImagen = archivoImagen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Imagen{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", archivoImagen=").append(archivoImagen);
        sb.append('}');
        return sb.toString();
    }

}
