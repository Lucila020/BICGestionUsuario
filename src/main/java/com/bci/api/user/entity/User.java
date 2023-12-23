package com.bci.api.user.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

/**
 * Representa la tabla en base de datos de {@link User} entidad
 */
@Data
@Entity
public class User {


    @Column(name = "ID")
    @Id
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

   @Column(name = "CREATED_DATE")
   @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @Column(name = "LAST_LOGIN_DATE")
    private Date lastLogin;

    @Column(name = "TOKEN")
    private String token;

    private Boolean isActive = true;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "FK_USER", updatable = false, nullable = false)
   private List<Phone> phones;


}
