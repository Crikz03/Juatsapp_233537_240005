/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author 
 * @param <DTO>
 */
public interface ICrudUsuarioBO<DTO> extends IAgregaBO<DTO>,IActualizaBO<DTO>,IConsultaTodoBO<DTO>, IConsultaPorIdBO<DTO>, IConsultaUsuarioPorTelefonoBO, IExisteUsuarioBO<DTO> {
    
}
