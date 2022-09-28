package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.IMascotaDao;
import com.petlost.petlost.Models.Mascota;
import com.petlost.petlost.Models.Usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    @Autowired
    IMascotaDao mascotaDao;
    
    @RequestMapping(value="mascotas")
    public List<Mascota> getPet(){
        return mascotaDao.getPet();
    }
    
    @RequestMapping(value="mascotas/add", method=RequestMethod.POST)
    public String createPet(@RequestBody Mascota pet){
        return mascotaDao.createPet(pet);
    }

    @Transactional
    @RequestMapping(value = "mascotas/del/{id}", method = RequestMethod.DELETE)
    @CrossOrigin("*")
    public String deletePet(@PathVariable(value = "id") Long idPet) {
        return mascotaDao.deletePet(idPet);
    }

    @RequestMapping(value="mascotasxperson", method=RequestMethod.POST)
    public List<Mascota> updateUser(@RequestBody Usuario user){
        return mascotaDao.getPetsxPerson(user);
    }

    @RequestMapping(value = "/mascotas/kind/{id}", method = RequestMethod.GET)
    @CrossOrigin("*")
    public List<Mascota> getPetsByKind(@PathVariable Long id){
        return mascotaDao.getPetsByKind(id);
    }
}
