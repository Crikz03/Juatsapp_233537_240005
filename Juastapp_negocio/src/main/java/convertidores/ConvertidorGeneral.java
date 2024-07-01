/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

/**
 *
 * @author eljulls
 */
public class ConvertidorGeneral {
    public static <E, D> D convertEntityToDTO(E entity, Class<D> dtoClass) {
        D dto = null;
        try {
            dto = dtoClass.newInstance();
          //  BeanUtils.copyProperties(entity, dto);
        } catch (InstantiationException | IllegalAccessException e) {
            // manejar excepción
        }
        return dto;
    }

    public static <E, D> E convertDTOToEntity(D dto, Class<E> entityClass) {
        E entity = null;
        try {
            entity = entityClass.newInstance();
         //   BeanUtils.copyProperties(dto, entity);
        } catch (InstantiationException | IllegalAccessException e) {
            // manejar excepción
        }
        return entity;
    }
}