package com.bci.api.user.service.impl;

import com.bci.api.user.converter.UserDTOToUserConverter;
import com.bci.api.user.converter.UserToUserResponseDTOConverter;
import com.bci.api.user.dto.ErrorDTO;
import com.bci.api.user.dto.UserDataDTO;
import com.bci.api.user.dto.UserResponseDTO;
import com.bci.api.user.entity.User;
import com.bci.api.user.exception.UserNotFoundException;
import com.bci.api.user.repository.UserRepository;
import com.bci.api.user.service.UserService;
import com.bci.api.user.util.JwtUser;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private final JwtUser jwtUser;

    @Override
    public UserResponseDTO createUser(final UserDataDTO user) {

        var userEntity = this.userDTOToUser.convert(user);
        userEntity.setToken(UUID.randomUUID().toString());
        //userEntity.setToken(jwtUser.createJwt(user.getEmail()));
        return this.userResponseConvert.convert(this.userRepository.save(userEntity));

    }

    @Override
    public UserResponseDTO updateUser(final Long id, final UserDataDTO userData) {
        var user = this.findUserById(id);
        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        return this.userResponseConvert.convert(this.userRepository.save(user));

    }

    @Override
    public UserResponseDTO logicallyDeleteUser(final Long id) {
        final var user = this.findUserById(id);
        user.setIsActive(false);
        return this.userResponseConvert.convert(this.userRepository.save(user));

    }

    @Override
    public UserResponseDTO getUserById(final Long id) {
       final var user = this.findUserById(id);
       return this.userResponseConvert.convert(user);

    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

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
        List<UserResponseDTO> listUsers = new ArrayList<>();
        this.userRepository.findAllByIsActiveTrue().stream().
                forEach( list -> {
                            UserResponseDTO userList = this.userResponseConvert.convert(list);
                            listUsers.add(userList);
                        }
                );
        return listUsers;
    }

    private User findUserById(final Long id){
       return userRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException
                        (new ErrorDTO("No se encontró el usuario de referencia")));

    }

}
