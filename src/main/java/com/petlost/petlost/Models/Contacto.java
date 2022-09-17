package com.petlost.petlost.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="contacto")
public class Contacto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="idContacto")
    private int id;
    
    @Getter @Setter @Column(name="direccion")
    private String address;
    
    @Getter @Setter @Column(name="celular")
    private long phone;
    
    @Getter @Setter @Column(name="ciudad")
    private String city;
    
    @Getter @Setter @Column(name="fk_idPersona")
    private int id_person;
    
}
