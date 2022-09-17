/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.TipoMascotaDao;
import com.petlost.petlost.Models.TipoMascota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jesus
 */
@RestController
public class TipoMascotaController {
    @Autowired
    TipoMascotaDao tipoMascotaDao;
    
    @RequestMapping(value="tipomascota")
    public List<TipoMascota> getKindPets(){
        return tipoMascotaDao.getKindPets();
    }
}
