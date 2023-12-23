package com.bci.api.user.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * Utilitario para operaciones basicas de JSON con la configuracion del componente
 */
public class JSONUtils {

    private static final ObjectMapper mapper = crearMapper();

    // Clase Utilitaria
    private JSONUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Escribe la representacion del objeto como JSON string
     *
     * @param <T> tipo de objeto a recibir
     * @param obj contiene el objeto que se procesara
     * @return JSON String
     * @throws com.fasterxml.jackson.core.JsonProcessingException error base para el manejo de archivos json
     */
    public static <T> String writeAsJson(final T obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    /**
     * Lee el JSON String como el objeto representado que se espera
     *
     * @param <T> ipo de objeto a recibir
     * @param json cadena se leerar como un json
     * @param valueType tipo de objeto especifico
     * @return Objeto representado
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    public static <T> T readJsonString(final String json, final Class<T> valueType) throws JsonProcessingException {
        return mapper.readValue(json, valueType);
    }


    private static ObjectMapper crearMapper() {
        return JsonMapper
                .builder()
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();
    }
}
