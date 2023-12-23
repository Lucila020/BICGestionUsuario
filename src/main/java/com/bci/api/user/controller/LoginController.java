package com.bci.api.user.controller;

import com.bci.api.user.dto.LoginRequestDTO;
import com.bci.api.user.dto.LoginResponseDTO;
import com.bci.api.user.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contrador de Usuarios
 */
@Validated
@Api //(tags = {SwaggerApiConfig.API_GESTION_USUARIOS})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private final LoginService loginService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody final LoginRequestDTO login){
        return new ResponseEntity<>(this.loginService.Login(login), HttpStatus.OK);
    }

    @PatchMapping(name = "/{id}/activation", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Modificacion en el estado del usaurio")
    public  ResponseEntity<HttpStatus> changeUserActivationState(@PathVariable Long id) {
        this.loginService.changeUserActivationState(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
