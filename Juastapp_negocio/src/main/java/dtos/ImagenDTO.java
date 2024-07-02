/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import org.bson.types.Binary;

/**
 *
 * @author Chris
 */
public class ImagenDTO {
    private String id;
    private String nombre;
    private Binary archivoImagen;

    public ImagenDTO() {
    }

    public ImagenDTO(String id, String nombre, Binary archivoImagen) {
        this.id = id;
        this.nombre = nombre;
        this.archivoImagen = archivoImagen;
    }

    public ImagenDTO(String nombre, Binary archivoImagen) {
        this.nombre = nombre;
        this.archivoImagen = archivoImagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
