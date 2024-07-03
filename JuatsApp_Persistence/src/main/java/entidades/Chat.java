/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public class Chat {

    private ObjectId id;
    private ObjectId receptor;
    private ObjectId emisor;
    private LocalDateTime fecha;
    private List<ObjectId> historialMensajes;

    public Chat() {
        this.historialMensajes = new ArrayList<>();
    }

    public Chat(ObjectId receptor, ObjectId emisor, LocalDateTime fecha) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.fecha = fecha;
        this.historialMensajes = new ArrayList<>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getReceptor() {
        return receptor;
    }

    public void setReceptor(ObjectId receptor) {
        this.receptor = receptor;
    }

    public ObjectId getEmisor() {
        return emisor;
    }

    public void setEmisor(ObjectId emisor) {
        this.emisor = emisor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<ObjectId> getHistorialMensajes() {
        return historialMensajes;
    }

    public void setHistorialMensajes(List<ObjectId> historialMensajes) {
        this.historialMensajes = historialMensajes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chat{");
        sb.append("id=").append(id);
        sb.append(", receptor=").append(receptor);
        sb.append(", emisor=").append(emisor);
        sb.append(", fecha=").append(fecha);
        sb.append(", historialMensajes=").append(historialMensajes);
        sb.append('}');
        return sb.toString();
    }

}
