package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.ITipoMascotaDao;
import com.petlost.petlost.Models.TipoMascota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TipoMascotaDaoImp implements ITipoMascotaDao {
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<TipoMascota> getKindPets() {
        String query = "FROM TipoMascota";
        return entityManager.createQuery(query, TipoMascota.class).getResultList();
    }
    
}
