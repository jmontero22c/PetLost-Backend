package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.MascotaDao;
import com.petlost.petlost.Models.Mascota;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MascotaController {
    @Autowired
    MascotaDao mascotaDao;
    
    @RequestMapping(value="mascotas")
    public List<Mascota> getPet(){
        return mascotaDao.getPet();
    }
    
    @RequestMapping(value="mascotas/add", method=RequestMethod.POST)
    public String createPet(@RequestBody Mascota pet){
        return mascotaDao.createPet(pet);
    }

    @Transactional
    @RequestMapping(value="mascotas/del/{id}", method = RequestMethod.DELETE)
    public String deletePet(@PathVariable(value="id") Long idPet){
        return mascotaDao.deletePet(idPet);
    }
}
