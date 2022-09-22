package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.IPersonaDao;
import com.petlost.petlost.Models.Contacto;
import com.petlost.petlost.Models.Persona;
import com.petlost.petlost.Models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImp implements IPersonaDao{
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    @Transactional
    public int createUser(Persona person){
        entityManager.merge(person);
        return getLastIdPerson();
    }
    
    public int getLastIdPerson(){
        String query = "FROM Persona";
        List<Persona> personas = entityManager.createQuery(query, Persona.class).getResultList();
        Persona last_person = personas.get(personas.size()-1);
        return last_person.getIdPerson();
    }

    @Override
    @Transactional
    public List<Persona> getPeople() {
        String query = "FROM Persona";
        return entityManager.createQuery(query, Persona.class).getResultList();
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        try{
        Persona person = entityManager.find(Persona.class, id.intValue());
        entityManager.remove(person);    
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
    
    @Override
    @Transactional
    public Persona updatePerson(Persona persona, Long id){
        try {
            Persona person = entityManager.find(Persona.class, id.intValue());
            person.setNames(persona.getNames());
            person.setLastnames(persona.getLastnames());
            entityManager.merge(person);
            entityManager.getTransaction().commit();
            return person;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public List<Persona> getPersonInSession(Usuario user) {
        List<Usuario> contact_in_session = getUserInSesssion(user);
        
        List<Persona> person = entityManager.createQuery("FROM Persona WHERE id = :id", Persona.class)
                .setParameter("id", contact_in_session.get(0).getId_person())
                .getResultList();
        return person;
    }
    
    public List<Contacto> getContactInSession(Usuario user) {
        List<Usuario> user_in_session = getUserInSesssion(user);
        List<Contacto> contact = entityManager.createQuery("FROM Contacto WHERE id_person = :id", Contacto.class)
                .setParameter("id", user_in_session.get(0).getId_person())
                .getResultList();
        return contact;
    }

    public List<Usuario> getUserInSesssion(Usuario user){
        String query = "FROM Usuario WHERE email = :email AND password = :password";
        List<Usuario> user_in_session = entityManager.createQuery(query, Usuario.class)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();
        return user_in_session;
    }
}
