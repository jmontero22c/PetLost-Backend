package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.IMascotaDao;
import com.petlost.petlost.Models.Mascota;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class MascotaDaoImp implements IMascotaDao{
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
        try {
            entityManager.merge(pet);
            return "Mascota Publicada";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        
        
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
