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
    private Binary ArchivoImagen;

    public Imagen() {
    }

    public Imagen(String nombre, Binary ArchivoImagen) {
        this.nombre = nombre;
        this.ArchivoImagen = ArchivoImagen;
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
        return ArchivoImagen;
    }

    public void setImageData(Binary imageData) {
        this.ArchivoImagen = imageData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Imagen{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", ArchivoImagen=").append(ArchivoImagen);
        sb.append('}');
        return sb.toString();
    }

}
