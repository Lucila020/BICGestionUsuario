package com.bci.api.user.service.impl;

import com.bci.api.user.converter.UserDTOToUserConverter;
import com.bci.api.user.converter.UserToUserResponseDTOConverter;
import com.bci.api.user.dto.UserDataDTO;
import com.bci.api.user.dto.UserResponseDTO;
import com.bci.api.user.entity.User;
import com.bci.api.user.exception.ExistEmailException;
import com.bci.api.user.exception.IllegalArgumentException;
import com.bci.api.user.exception.InActiveUserException;
import com.bci.api.user.exception.UserNotFoundException;
import com.bci.api.user.repository.UserRepository;
import com.bci.api.user.service.UserService;
import com.bci.api.user.validator.EmailValidator;
import com.bci.api.user.validator.PasswordValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de gestion de usuarios
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserResponseDTOConverter userResponseConvert;
    private final UserDTOToUserConverter userDTOToUser;
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    @Override
    public UserResponseDTO createUser(final UserDataDTO userData) {
        log.info("Creacion del usuario {}", userData.getName());
        var user= this.userRepository.findByEmailAndIsActiveTrue(userData.getEmail());
        if(user.isPresent()) {
                throw new ExistEmailException("El correo ya registrado");
        }
        this.validator(userData);
        var userEntity = this.userDTOToUser.convert(userData);
        return this.userResponseConvert.convert(this.userRepository.save(userEntity));

    }

    @Override
    public UserResponseDTO updateUser(final String id, final UserDataDTO userData) {
        log.info("Actualizacion del usuario {}", userData.getName());
        var user = this.findUserById(id);
        this.validator(userData);
        if(!userData.getEmail().equals(user.getEmail())){
            throw new IllegalArgumentException("El mail no puede modificarse");
        }
        var userUpdate = this.userDTOToUser.convert(userData);
        return this.userResponseConvert.convert(this.userRepository.save(userUpdate));

    }

    @Override
    public UserResponseDTO logicallyDeleteUser(final String id) {
        log.info("Inhabilitacion del usuario {}", id);
        final var user = this.findUserById(id);
        user.setIsActive(false);
        return this.userResponseConvert.convert(this.userRepository.save(user));

    }

    @Override
    public UserResponseDTO getUserById(final String id) {
        log.info("Obtener usuario por id {}" , id);
        final var user = this.findUserById(id);
        return this.userResponseConvert.convert(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        log.info("Obtener listado de usuarios");
        List<UserResponseDTO> listUsers = new ArrayList<>();
        this.userRepository.findAll().stream().
                forEach( list -> {
                            UserResponseDTO userList = this.userResponseConvert.convert(list);
                            listUsers.add(userList);
                        }
                );
        return listUsers;
    }

    @Override
    public List<UserResponseDTO> getAllUsersActive() {
        log.info("Obtener listado de usuarios activos");
        List<UserResponseDTO> listUsers = new ArrayList<>();
        this.userRepository.findAllByIsActiveTrue().stream().
                forEach( list -> {
                            UserResponseDTO userList = this.userResponseConvert.convert(list);
                            listUsers.add(userList);
                        }
                );
        return listUsers;
    }

    private User findUserById(final String id){
        log.info("Obtener usuario por id {}" , id);
        var user = userRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException
                        ("No se encontró el usuario de referencia"));
        if(!user.getIsActive()){
            throw new InActiveUserException("El usuario se encuentra inactivo");
        }
        return user;
    }

    private void validator(final UserDataDTO userData){
        this.emailValidator.validateEmail(userData.getEmail());
        this.passwordValidator.validatePasswordFormat(userData.getPassword());

    }

}
