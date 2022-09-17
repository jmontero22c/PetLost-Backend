package com.petlost.petlost.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @Getter @Setter @Column(name="fk_idPersona")
    private int id_person;
    
    
    @Getter @Setter @Column(name="correo")
    private String email;
    
    
    @Getter @Setter @Column(name="contraseña")
    private String password;

    
}
