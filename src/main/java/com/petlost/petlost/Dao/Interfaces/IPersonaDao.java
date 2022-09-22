package com.petlost.petlost.Dao.Interfaces;

import com.petlost.petlost.Models.Contacto;
import com.petlost.petlost.Models.Persona;
import com.petlost.petlost.Models.Usuario;
import java.util.List;


public interface IPersonaDao {
    public List<Persona> getPeople();

    public int createUser(Persona person);

    public void deletePerson(Long id);
    
    public List<Persona> getPersonInSession(Usuario user);
    
    public List<Contacto> getContactInSession(Usuario user);
    
    public Persona updatePerson(Persona person, Long id);
}
