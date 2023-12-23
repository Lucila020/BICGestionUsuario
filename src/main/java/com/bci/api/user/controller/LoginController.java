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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contrador de Usuarios
 */
@Validated
@Api
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1.0/login")
public class LoginController {

    @Autowired
    private final LoginService loginService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody final LoginRequestDTO login){
        return new ResponseEntity<>(this.loginService.autenticationUser(login), HttpStatus.OK);
    }

}
