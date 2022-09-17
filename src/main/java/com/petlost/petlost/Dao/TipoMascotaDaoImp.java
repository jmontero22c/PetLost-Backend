/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.TipoMascotaDao;
import com.petlost.petlost.Models.TipoMascota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jesus
 */
@Repository
public class TipoMascotaDaoImp implements TipoMascotaDao {
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<TipoMascota> getKindPets() {
        String query = "FROM TipoMascota";
        return entityManager.createQuery(query).getResultList();
    }
    
}
