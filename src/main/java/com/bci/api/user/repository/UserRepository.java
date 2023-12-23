package com.bci.api.user.repository;

import com.bci.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * JPA Repository for the {@link User} entity
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Obtener el listado de usuarios activos
     * @return listado de usuarios que esten activos
     */
    List<User> findAllByIsActiveTrue();


    /**
     * Buscar un usuario por mail y que esta activo
     * @param correoActivo
     * @return el usuario que se encuentre activo y haga match con el mail
     */
    Optional<User> findByEmailAndIsActiveTrue(String correoActivo);

    /**
     * Se obtiene el usuario por el id generado
     * @param id identificador del usuario
     * @return un optional del usuario
     */
    Optional<User> findById(String id);

}
