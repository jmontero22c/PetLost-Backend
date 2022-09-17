package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.ContactoDao;
import com.petlost.petlost.Models.Contacto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactoController {
    @Autowired
    public ContactoDao contactDao;
    
    @RequestMapping(value="contacto", method=RequestMethod.GET)
    private List<Contacto> getContact(){
        return contactDao.getContact();
    }
    
    
    @RequestMapping(value="contacto", method=RequestMethod.POST)
    private String createContact(@RequestBody Contacto contact){
        return contactDao.createContact(contact);
    }
    
    
}
