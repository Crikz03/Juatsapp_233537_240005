/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris
 */
public class ChatDTO {

    private String id;
    private String receptor;
    private String emisor;
    private LocalDateTime fecha;
    private List<String> historialMensajes;

    public ChatDTO() {
        this.historialMensajes = new ArrayList<>();
    }

    public ChatDTO(String receptor, String emisor, LocalDateTime fecha) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.fecha = fecha;
        this.historialMensajes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<String> getHistorialMensajes() {
        return historialMensajes;
    }

    public void setHistorialMensajes(List<String> historialMensajes) {
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
