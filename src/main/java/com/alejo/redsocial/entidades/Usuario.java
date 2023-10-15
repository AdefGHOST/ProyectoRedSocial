package com.alejo.redsocial.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.alejo.redsocial.enumeraciones.Rol;

import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private Long id;

    private String name;
    private String apellido;
    private String mail;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;

    @OneToOne
    private Imagen imagen;

    @Enumerated(EnumType.STRING)
    private Rol rol;
    
}
