package com.bci.api.user.service;

import com.bci.api.user.dto.UserDataDTO;
import com.bci.api.user.dto.UserResponseDTO;

import java.util.List;


/**
 * Interface of User service
 */
public interface UserService {

    /**
     * Creacion de usuario
     * @param user datos de usuario a crear
     * @return datos del usuario creado
     */
    UserResponseDTO createUser(final UserDataDTO user);

    /**
     * Actualizacion de los datos del usuario
     * @param user datos usuario a modificar
     * @return datos del usuario modificado
     */
    UserResponseDTO updateUser(final String id, final UserDataDTO user);

    /**
     * Eliminacion lógica del usuario por id
     * @param id identificador del usuario
     * @return datos del usuario borrado logicamente
     */
    UserResponseDTO logicallyDeleteUser(final String id);

    /**
     * Obtencion del usuario por id
     * @param id identificador del usuario
     * @return datos del usuario obtenido por el id
     */
    UserResponseDTO getUserById(final String id);

    /**
     * Obtener los usuario
     * @return la lista de usuario
     */
     List<UserResponseDTO> getAllUsers();

    /**
     * Obtener los usuario activos
     * @return lista de usuarios activos
     */
    List<UserResponseDTO> getAllUsersActive();


}
