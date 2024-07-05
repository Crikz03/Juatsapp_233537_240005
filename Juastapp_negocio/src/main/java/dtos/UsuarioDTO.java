/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import utilidades.Genero;

/**
 *
 * @author Chris
 */
public class UsuarioDTO {

    private ObjectId id;
    private String telefono;
    private String contrasena;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Genero sexo;
    private List<String> chats;
    private List<String> contactos;
    private ImagenDTO imagenPerfil;
    private LocalDateTime fechaNacimiento;
    private DireccionDTO direccion;

    public UsuarioDTO() {
        this.chats = new ArrayList<>();
        this.contactos = new ArrayList<>();
    }

    public UsuarioDTO(String telefono, String contrasena, String nombres, String apellidoPaterno, String apellidoMaterno, Genero sexo, ImagenDTO imagenPerfil, LocalDateTime fechaNacimiento, DireccionDTO direccion) {
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
        return contactos;
    }

    public void setContactos(List<String> contactos) {
        this.contactos = contactos;
    }

    public ImagenDTO getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(ImagenDTO imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", telefono=" + telefono + ", contrasena=" + contrasena + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", sexo=" + sexo + ", chats=" + chats + ", contactos=" + contactos + ", imagenPerfil=" + imagenPerfil + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }



}
