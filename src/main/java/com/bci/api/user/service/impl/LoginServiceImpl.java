package com.bci.api.user.service.impl;

import com.bci.api.user.dto.LoginRequestDTO;
import com.bci.api.user.dto.LoginResponseDTO;
import com.bci.api.user.exception.UnauthorizedAccessException;
import com.bci.api.user.exception.UserNotFoundException;
import com.bci.api.user.repository.UserRepository;
import com.bci.api.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementacion de gestion de usuarios
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public LoginResponseDTO autenticationUser(LoginRequestDTO login) {
        log.info("Validacion de datos Login");
        var user= this.userRepository.findByEmailAndIsActiveTrue(login.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Usuario no existente"));

        if(!login.getPassword().equals(user.getPassword())){
            throw new UnauthorizedAccessException("Usuario o Password incorrectos");
        }
        log.info("Login exitoso");
        return new LoginResponseDTO(user.getToken());
    }

}
