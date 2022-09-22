package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.IContactoDao;
import com.petlost.petlost.Models.Contacto;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactoController {
    @Autowired
    public IContactoDao contactDao;
    
    @RequestMapping(value="contactos", method=RequestMethod.GET)
    private List<Contacto> getContact(){
        return contactDao.getContact();
    }
    
    @RequestMapping(value = "contactos/{id}", method = RequestMethod.PUT)
    private String updateContact(@PathVariable(value = "id") Long id, @RequestBody Contacto contact){
        return contactDao.updateContact(contact, id);
    }

    @RequestMapping(value="contactos/add", method=RequestMethod.POST)
    private String createContact(@RequestBody Contacto contact){
        return contactDao.createContact(contact);
    }

    @RequestMapping(value = "contactar/{id}")
    private Map<String,String> showInfoPetOwner(@PathVariable(value = "id") Long id){
        return contactDao.showInfoPetOwner(id);
    }
    
    
}
