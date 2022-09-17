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
@Table(name="tipomascota")
public class TipoMascota {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Setter @Getter @Column(name="idtipoMascota")
    private int id;
    
    @Setter @Getter @Column(name="descripcion")
    private String description;
    
}
