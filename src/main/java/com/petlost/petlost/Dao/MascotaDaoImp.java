package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.MascotaDao;
import com.petlost.petlost.Models.Mascota;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class MascotaDaoImp implements MascotaDao{
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Mascota> getPet() {
        String query = "FROM Mascota";
        return entityManager.createQuery(query, Mascota.class).getResultList();
    }
    
    @Override
    @Transactional
    public String createPet(Mascota pet){
        entityManager.merge(pet);
        return "Mascota Publicada";
    }

    @Override
    public String deletePet(Long id){
        try {
            Mascota pet = entityManager.find(Mascota.class, id.intValue());
            entityManager.remove(pet);
            return "Mascota Eliminada";
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }
}
