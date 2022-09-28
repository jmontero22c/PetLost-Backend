package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.IMascotaDao;
import com.petlost.petlost.Models.Mascota;
import com.petlost.petlost.Models.Usuario;

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

    public List<Mascota> getPetsxPerson(Usuario user){
        String query = "FROM Usuario WHERE email = :email AND password = :password";
        Usuario usuario = entityManager.createQuery(query,Usuario.class)
                            .setParameter("email", user.getEmail())
                            .setParameter("password", user.getPassword())
                            .getResultList().get(0);
        
        String queryMascota = "FROM Mascota WHERE fk_idPersona = :id";
        return entityManager.createQuery(queryMascota, Mascota.class)
                            .setParameter("id", usuario.getId_person())
                            .getResultList();
    }

    public List<Mascota> getPetsByKind(Long id){
        String query = "FROM Mascota WHERE id_kindpet = :id";
        List<Mascota> pets = entityManager.createQuery(query, Mascota.class)
                            .setParameter("id", id.intValue())
                            .getResultList();

        return pets;
    }
}
