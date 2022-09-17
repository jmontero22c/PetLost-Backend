package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.PersonaDao;
import com.petlost.petlost.Models.Contacto;
import com.petlost.petlost.Models.Persona;
import com.petlost.petlost.Models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class PersonaController {
    @Autowired
    private PersonaDao personDao;
    
    @RequestMapping(value="personas/{id}", method=RequestMethod.DELETE)
    public void deletePerson(@PathVariable Long id){
            personDao.deletePerson(id);
    }
    
    @RequestMapping(value="personas", method=RequestMethod.GET)
    public List<Persona> getPeople(){
        return personDao.getPeople();
    }
    
    @RequestMapping(value="personas", method=RequestMethod.POST)
    public int createPerson(@RequestBody Persona person){
        return personDao.createUser(person);
    }
    
    @RequestMapping(value="personas/info", method=RequestMethod.POST)
    public List<Persona> getInfoPerson(@RequestBody Usuario user){
        return personDao.storageUserSession(user);
    }
    
    @RequestMapping(value="contactos/info", method=RequestMethod.POST)
    public List<Contacto> getContactPerson(@RequestBody Usuario user){
        return personDao.storageContactSession(user);
    }
    
    @PutMapping(value="personas/{id}")
    public Persona updatePerson(@RequestBody Persona person,@PathVariable Long id){
            return personDao.updatePerson(person,id);
    }
}
