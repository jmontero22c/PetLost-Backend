package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.IMascotaDao;
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
    IMascotaDao mascotaDao;
    
    @RequestMapping(value="mascotas")
    public List<Mascota> getPet(){
        return mascotaDao.getPet();
    }
    
    @RequestMapping(value="mascotas/add", method=RequestMethod.POST)
    public String createPet(@RequestBody Mascota pet/*, @RequestParam(defaultValue = "") MultipartFile image */){
        /*if(!image.isEmpty()){
            Path imageDirectory = Paths.get("http://127.0.0.1:5500/assets/img");
            String pathAbsolute = imageDirectory.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = image.getBytes();    
                Path fullPath = Paths.get(pathAbsolute + "/" + image.getOriginalFilename());
                Files.write(fullPath, bytesImg);

                pet.setPhoto(image.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }*/
        return mascotaDao.createPet(pet);
    }

    @Transactional
    @RequestMapping(value = "mascotas/del/{id}", method = RequestMethod.DELETE)
    public String deletePet(@PathVariable(value = "id") Long idPet) {
        return mascotaDao.deletePet(idPet);
    }
}
