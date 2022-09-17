/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.PersonaDao;
import com.petlost.petlost.Models.Contacto;
import com.petlost.petlost.Models.Persona;
import com.petlost.petlost.Models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jesus
 */
@Repository
//@Transactional
public class PersonDaoImp implements PersonaDao{
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
        List<Persona> personas = entityManager.createQuery(query).getResultList();
        Persona last_person = personas.get(personas.size()-1);
        return last_person.getIdPerson();
    }

    @Override
    @Transactional
    public List<Persona> getPeople() {
        String query = "FROM Persona";
        return entityManager.createQuery(query).getResultList();
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
            person.setLastnames(persona.getLastnames());
            entityManager.merge(person);
            entityManager.getTransaction().commit();
            return person;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public List<Persona> storageUserSession(Usuario user) {
        String query = "FROM Usuario WHERE email = :email AND password = :password";
        List<Usuario> answer = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();
        
        List<Persona> person = entityManager.createQuery("FROM Persona WHERE id = :id")
                .setParameter("id", answer.get(0).getId_person())
                .getResultList();
        return person;
    }
    
    public List<Contacto> storageContactSession(Usuario user) {
        String query = "FROM Usuario WHERE email = :email AND password = :password";
        List<Usuario> answer = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();
        
        List<Contacto> contact = entityManager.createQuery("FROM Contacto WHERE id_person = :id")
                .setParameter("id", answer.get(0).getId_person())
                .getResultList();
        return contact;
    }
}
