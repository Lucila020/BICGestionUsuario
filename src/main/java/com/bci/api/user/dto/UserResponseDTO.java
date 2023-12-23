package com.bci.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mapea la informacion sobre la respuesta del usuario
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private UserDataDTO user;

    @JsonProperty("id")
    private String id;

    @JsonProperty("created")
    private String created;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("last_login")
    private String lastLogin;

    @JsonProperty("token")
    private String token;

    @JsonProperty("isactive")
    private boolean isActive;

}
