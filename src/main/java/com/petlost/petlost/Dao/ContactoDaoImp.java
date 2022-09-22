package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.IContactoDao;
import com.petlost.petlost.Models.Contacto;
import com.petlost.petlost.Models.Mascota;
import com.petlost.petlost.Models.Persona;
import com.petlost.petlost.Models.Usuario;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ContactoDaoImp implements IContactoDao {
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Contacto> getContact() {
        List<Contacto> contact = null;
        String sql = "FROM Contacto";
        try {
            contact = entityManager.createQuery(sql, Contacto.class).getResultList();
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

    @Override
    @Transactional
    public String updateContact(Contacto contacto, Long id){
        try {
            String sql ="FROM Contacto WHERE id_person = :id";
            Contacto contact = entityManager.createQuery(sql, Contacto.class)
            .setParameter("id", id.intValue()).getResultList().get(0);
            
            contact.setAddress(contacto.getAddress());
            contact.setCity(contacto.getCity());
            contact.setPhone(contacto.getPhone());
            contact.setId_person(id.intValue());
            
            entityManager.merge(contact);
            return "Actualizado con éxito";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<Contacto> getContactByIdPerson(int id){
        String query = "FROM Contacto WHERE id_person = :id";
        
        List<Contacto> contact = entityManager.createQuery(query, Contacto.class)
                        .setParameter("id", id)
                        .getResultList();
        return contact;
    }

    public Map<String, String> showInfoPetOwner(Long id){
        Map<String,String> info = new HashMap<String,String>();

        Mascota pet = entityManager.find(Mascota.class, id.intValue());
        Persona person = entityManager.find(Persona.class, pet.getId_person());

        Usuario user = entityManager.find(Usuario.class, person.getIdPerson());

        List<Contacto> contact = getContactByIdPerson(person.getIdPerson());
        

        info.put("Nombres", person.getNames() + " " + person.getLastnames());
        info.put("Telefono", Long.toString(contact.get(0).getPhone()));
        info.put("Email", user.getEmail());

        return info;
    }
    
}
