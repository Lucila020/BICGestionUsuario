package com.bci.api.user.dto

import com.bci.api.user.converter.UserDTOToUserConverter
import com.bci.api.user.util.JSONUtils
import spock.lang.Specification

class UserDTOToUserConverterTest extends Specification{

    UserDTOToUserConverter userConverter

    def setup(){
        userConverter = new UserDTOToUserConverter()
    }

     def "Se realiza conversion de UserDataDTO a User"() {

        given: "Un usuario"
        def usuario = obtenerUserDatosDTO()


        when: "Al realizar la conversion"
        def response = userConverter.convert(usuario)

        then: "Se verifica la conversion realizada"
        response.name == usuario.getName()
        response.email == usuario.getEmail()

    }

    UserDataDTO obtenerUserDatosDTO() {
        return JSONUtils.readJsonString(new File(getClass().getResource("/json/jsonUserDataDTO.json").toURI()).text, UserDataDTO.class)
    }



}
