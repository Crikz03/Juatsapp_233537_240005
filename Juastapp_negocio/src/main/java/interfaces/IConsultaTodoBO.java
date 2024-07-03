/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Chris
 * @param <DTO>
 */
public interface IConsultaTodoBO<DTO> {

    public List<DTO> consultaTodo()throws NegocioException;
}
