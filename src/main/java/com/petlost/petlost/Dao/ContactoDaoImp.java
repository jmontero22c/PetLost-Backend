package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.ContactoDao;
import com.petlost.petlost.Models.Contacto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ContactoDaoImp implements ContactoDao {
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Contacto> getContact() {
        List<Contacto> contact = null;
        String sql = "FROM Contacto";
        try {
            contact = entityManager.createQuery(sql).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public String createContact(Contacto contact) {
        entityManager.merge(contact);
        return "Contacto Creado";
    }
    
}
