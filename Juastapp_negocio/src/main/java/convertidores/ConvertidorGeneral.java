/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import java.lang.reflect.Field;

/**
 *
 * @author eljulls
 */
public class ConvertidorGeneral {

    public static <D, E> E convertidorEntidad(D dto, Class<E> entityClass) {
        try {
            E entidad = entityClass.getDeclaredConstructor().newInstance();

            // Obtener los campos del DTO y de la entidad
            Field[] camposDto = dto.getClass().getDeclaredFields();
            Field[] camposEntidad = entityClass.getDeclaredFields();

            // Iterar sobre los campos y copiar los valores
            for (Field campoDto : camposDto) {
                for (Field campoEntidad : camposEntidad) {
                    if (campoDto.getName().equals(campoEntidad.getName())
                            && campoDto.getType().equals(campoEntidad.getType())) {
                        campoDto.setAccessible(true);
                        campoEntidad.setAccessible(true);
                        campoEntidad.set(entidad, campoDto.get(dto));
                        break;
                    }
                }
            }

            return entidad;
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir DTO a entidad", e);
        }
    }

    // Método genérico para convertir una Entidad a un DTO (Mismos Nombres)
    public static <E, D> D convertidoraDTO(E entidad, Class<D> claseDto) {
        try {
            D dto = claseDto.getDeclaredConstructor().newInstance();

            // Obtener los campos de la entidad y del DTO
            Field[] camposEntidad = entidad.getClass().getDeclaredFields();
            Field[] camposDto = claseDto.getDeclaredFields();

            // Iterar sobre los campos y copiar los valores
            for (Field campoEntidad : camposEntidad) {
                for (Field campoDto : camposDto) {
                    if (campoEntidad.getName().equals(campoDto.getName())
                            && campoEntidad.getType().equals(campoDto.getType())) {
                        campoEntidad.setAccessible(true);
                        campoDto.setAccessible(true);
                        campoDto.set(dto, campoEntidad.get(entidad));
                        break;
                    }
                }
            }

            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir entidad a DTO", e);
        }
    }
}
