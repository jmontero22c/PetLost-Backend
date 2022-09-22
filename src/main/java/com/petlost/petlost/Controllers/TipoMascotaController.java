package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.ITipoMascotaDao;
import com.petlost.petlost.Models.TipoMascota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoMascotaController {
    @Autowired
    ITipoMascotaDao tipoMascotaDao;
    
    @RequestMapping(value="tipomascota")
    public List<TipoMascota> getKindPets(){
        return tipoMascotaDao.getKindPets();
    }
}
