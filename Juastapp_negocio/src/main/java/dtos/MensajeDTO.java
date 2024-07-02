/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import entidades.Imagen;
import java.time.LocalDateTime;

/**
 *
 * @author Chris
 */
public class MensajeDTO {

    private String id;
    private String usuarioReceptor;
    private String contenidoMensaje;
    private Imagen imagen;
    private LocalDateTime hora;

    public MensajeDTO() {
    }

    public MensajeDTO(String usuarioReceptor, String contenidoMensaje, LocalDateTime hora) {
        this.usuarioReceptor = usuarioReceptor;
        this.contenidoMensaje = contenidoMensaje;
        this.hora = hora;
    }

    public MensajeDTO(String usuarioReceptor, String contenidoMensaje, Imagen imagen, LocalDateTime hora) {
        this.usuarioReceptor = usuarioReceptor;
        this.contenidoMensaje = contenidoMensaje;
        this.imagen = imagen;
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(String usuarioReceptor) {
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
