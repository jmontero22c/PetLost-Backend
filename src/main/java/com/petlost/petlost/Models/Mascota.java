/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlost.petlost.Models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jesus
 */

@Entity
@Table(name="mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Setter @Getter @Column(name="idMascota")
    private int id;
    
    @Setter @Getter @Column(name="Nombre")
    private String name;
    
    @Setter @Getter @Column(name="fotografia")
    private String photo;
    
    @Setter @Getter @Column(name="fechaperdida")
    private Date dateLost;
    
    @Setter @Getter @Column(name="lugarperdida")
    private String placeLost;
    
    @Setter @Getter @Column(name="fk_idPersona")
    private int id_person;
    
    @Setter @Getter @Column(name="fk_tipoMascota")
    private int id_kindpet;
    
}
