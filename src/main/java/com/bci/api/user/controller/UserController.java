package com.bci.api.user.controller;

import com.bci.api.user.dto.UserDataDTO;
import com.bci.api.user.dto.UserResponseDTO;
import com.bci.api.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller de Usuarios
 */
@Validated
@Api
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1.0/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Creacion de Datos del usuario")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody final UserDataDTO user){
        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Actualización de los datos del usuario por id")
    public  ResponseEntity<UserResponseDTO> updateUser(@ApiParam(name = "id", value = "id del usuario", required = true)
                                                           @PathVariable("id") String id,
                                                       @RequestBody final UserDataDTO userData) {
        return new ResponseEntity<>(this.userService.updateUser(id, userData), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Borrado logico del usuario por id")
    public ResponseEntity<UserResponseDTO> logicallyDeleteUser(@ApiParam(name = "id", value = "id del usuario", required = true)
                                                                   @PathVariable("id") String id) {
        return new ResponseEntity<>(this.userService.logicallyDeleteUser(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Obtener el listado con todos los usuarios")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener los datos del usuario por id")
    public ResponseEntity<UserResponseDTO> getUserById(@ApiParam(name = "id", value = "id del usuario", required = true)
                                                           @PathVariable("id") String id) {
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/activos")
    @ApiOperation("Obtener el listado de todos los usuarios activos")
    public ResponseEntity<List<UserResponseDTO>> getAllUsersActive() {
        return new ResponseEntity<>(this.userService.getAllUsersActive(), HttpStatus.OK);
    }

}
