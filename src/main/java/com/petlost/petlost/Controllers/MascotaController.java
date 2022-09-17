package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.MascotaDao;
import com.petlost.petlost.Models.Mascota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MascotaController {
    @Autowired
    MascotaDao mascotaDao;
    
    @RequestMapping(value="mascota")
    public List<Mascota> getPet(){
        return mascotaDao.getPet();
    }
    
    @RequestMapping(value="mascota", method=RequestMethod.POST)
    public String createPet(@RequestBody Mascota pet){
        return mascotaDao.createPet(pet);
    }
}
