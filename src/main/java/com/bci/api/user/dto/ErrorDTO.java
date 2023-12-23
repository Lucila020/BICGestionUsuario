package com.bci.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mapea los errores con el formato requerido
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    private String message;
}
