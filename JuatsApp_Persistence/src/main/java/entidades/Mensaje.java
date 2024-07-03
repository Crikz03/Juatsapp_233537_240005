/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public class Mensaje {

    private ObjectId id;
    private ObjectId usuarioReceptor;
    private String contenidoMensaje;
    private Imagen imagen;
    private LocalDateTime hora;

    public Mensaje() {
    }

    public Mensaje(ObjectId usuarioReceptor, String contenidoMensaje, LocalDateTime hora) {
        this.usuarioReceptor = usuarioReceptor;
        this.contenidoMensaje = contenidoMensaje;
        this.hora = hora;
    }

    public Mensaje(ObjectId usuarioReceptor, String contenidoMensaje, Imagen imagen, LocalDateTime hora) {
        this.usuarioReceptor = usuarioReceptor;
        this.contenidoMensaje = contenidoMensaje;
        this.imagen = imagen;
        this.hora = hora;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(ObjectId usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    public String getContenidoMensaje() {
        return contenidoMensaje;
    }

    public void setContenidoMensaje(String contenidoMensaje) {
        this.contenidoMensaje = contenidoMensaje;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mensaje{");
        sb.append("id=").append(id);
        sb.append(", usuarioReceptor=").append(usuarioReceptor);
        sb.append(", contenidoMensaje=").append(contenidoMensaje);
        sb.append(", imagen=").append(imagen);
        sb.append(", hora=").append(hora);
        sb.append('}');
        return sb.toString();
    }

}
