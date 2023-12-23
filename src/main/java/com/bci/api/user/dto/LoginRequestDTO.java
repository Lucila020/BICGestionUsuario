package com.bci.api.user.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mapea los datos de login
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "El email no puede ser vacio")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "El password no puede ser vacio")
    @JsonProperty("password")
    private String password;
}
