package com.petlost.petlost.Dao.Interfaces;

import com.petlost.petlost.Models.Contacto;
import java.util.List;
import java.util.Map;

public interface IContactoDao {
    public List<Contacto> getContact();
    
    public String createContact(Contacto contact);

    public Map<String, String> showInfoPetOwner(Long id);
    
    public String updateContact(Contacto contact, Long id);
}
