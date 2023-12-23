package com.bci.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Map request information about phone
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    @JsonProperty("number")
    private String number;

    @JsonProperty("citycode")
    private String cityCode;

    @JsonProperty("contrycode")
    private String contryCode;


}
