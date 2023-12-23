package com.bci.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Map request information about User data
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDTO {

    @NotBlank(message = "El nombre del usuario no puede venir vacio")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "El email del usuario no puede venir vacio")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "El password del usuario no puede venir vacio")
    @JsonProperty("password")
    private String password;

    @JsonProperty("phones")
    private List<PhoneDTO> phones;

}
