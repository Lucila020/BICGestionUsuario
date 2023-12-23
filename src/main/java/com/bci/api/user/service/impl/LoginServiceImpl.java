package com.bci.api.user.service.impl;

import com.bci.api.user.dto.ErrorDTO;
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
    public LoginResponseDTO Login(LoginRequestDTO login) {
        var user= this.userRepository.findByEmailAndIsActiveTrue(login.getEmail())
                .orElseThrow(() -> new UserNotFoundException(new ErrorDTO("Usuario no existente")));

        if(login.getPassword().equals(user.getPassword())){
            throw new UnauthorizedAccessException(new ErrorDTO("Usuario o Password incorrectos"));
        }

        return new LoginResponseDTO(user.getToken());
    }

    @Override
    public void changeUserActivationState(Long id) {
    /**    var user = this.userRepository.findByIsActiveFalse(id).
                orElseThrow(() -> new UserNotFoundException(new ErrorDTO("Usuario no existente")));
        user.setActive(true);
        this.userRepository.save(user);
**/
    }
}
