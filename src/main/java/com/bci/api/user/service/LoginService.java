package com.bci.api.user.service;

import com.bci.api.user.dto.LoginRequestDTO;
import com.bci.api.user.dto.LoginResponseDTO;

/**
 * Interface of Login service
 */
public interface LoginService {

    /**
     * Login de usuario
     * @param login por mail y password
     * @return el token
     */
    LoginResponseDTO Login(final LoginRequestDTO login);

    /**
     *
     * @param id
     */
    void changeUserActivationState(Long id);
}
