/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import convertidores.ConvertidorGeneral;
import dao.ImagenDAO;
import dtos.ImagenDTO;
import entidades.Imagen;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.ICrudImagenBO;
import interfaces.IimagenDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class CrudImagenBO implements ICrudImagenBO<ImagenDTO> {

    IimagenDAO imagendao;

    public CrudImagenBO() {
        this.imagendao = new ImagenDAO();
    }

    @Override
    public void Guardar(ImagenDTO entidad) throws NegocioException {
        try {
            entidad.setId(new ObjectId());
            imagendao.guardar(ConvertidorGeneral.convertidorEntidad(entidad, Imagen.class));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo agregar la imagen.");
        }
    }

    @Override
    public void Actualizar(ImagenDTO entidad) throws NegocioException {
        try {
            imagendao.actualizar(ConvertidorGeneral.convertidorEntidad(entidad, Imagen.class));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo actualizar la imagen.");
        }
    }

    @Override
    public void Elimina(ImagenDTO entidad) throws NegocioException {
        try {
            imagendao.Eliminar(ConvertidorGeneral.convertidorEntidad(entidad, Imagen.class));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo eliminar la imagen o ya no existe.");
        }
    }

    @Override
    public List<ImagenDTO> consultaTodo() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ImagenDTO consultaPorId(String id) throws NegocioException {
        try {
            Imagen imagen = imagendao.consultarPorId(id);

            ImagenDTO i = ConvertidorGeneral.convertidoraDTO(imagen, ImagenDTO.class);
            return i;
        } catch (PersistenciaException e) {
            throw new NegocioException("No se encontro la imagen con id de: " + id);
        }
    }

}
