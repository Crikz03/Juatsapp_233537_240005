/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import utilidades.Genero;

/**
 *
 * @author Carlos 233537, Chris 240005
 */
public class Usuario {

    private ObjectId id;
    private String telefono;
    private String contrasena;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Genero sexo;
    private List<String> chats;
    private List<String> contactos;
    private Imagen imagenPerfil;
    private LocalDateTime fechaNacimiento;
    private Direccion direccion;

    public Usuario() {
        this.chats = new ArrayList<>();
        this.contactos = new ArrayList<>();
    }

    public Usuario(String telefono, String contrasena, String nombres, String apellidoPaterno, String apellidoMaterno, Genero sexo, Imagen imagenPerfil, LocalDateTime fechaNacimiento, Direccion direccion) {
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.chats = new ArrayList<>();
        this.contactos = new ArrayList<>();
        this.imagenPerfil = imagenPerfil;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public List<String> getChats() {
        return chats;
    }

    public void setChats(List<String> chats) {
        this.chats = chats;
    }

    public List<String> getContactos() {
        return this.contactos;
    }

    public void agregarContacto(String nombreContacto) {
        if (!this.contactos.contains(nombreContacto)) {
            this.contactos.add(nombreContacto);
        }
    }

    public boolean tieneContacto(String nombreContacto) {
        return this.contactos.contains(nombreContacto);
    }

    public void eliminarContacto(String nombreContacto) {
        this.contactos.remove(nombreContacto);
    }

    public Imagen getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(Imagen imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("id=").append(id);
        sb.append(", contrasena=").append(contrasena);
        sb.append(", telefono=").append(telefono);
        sb.append(", sexo=").append(sexo);
        sb.append(", chats=").append(chats);
        sb.append(", imagenPerfil=").append(imagenPerfil);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", direccion=").append(direccion);
        sb.append('}');
        return sb.toString();
    }

}
