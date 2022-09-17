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
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="idPersona")
    private int idPerson;
    
    @Getter @Setter @Column(name="nombres")
    private String names;
    
    @Getter @Setter @Column(name="apellidos")
    private String lastnames;
    
}
