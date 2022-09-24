package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.IUsuarioDao;
import com.petlost.petlost.Models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private IUsuarioDao userDao;
    
    @RequestMapping(value="usuarios")
    public List<Usuario> getUsers(){
        return userDao.getUsers();
    }
    
    @RequestMapping(value="usuarios/add", method=RequestMethod.POST)
    public String createUser(@RequestBody Usuario user){
        return userDao.createUser(user);
    }

    @CrossOrigin("*")
    @RequestMapping(value="usuarios/{id}", method=RequestMethod.PUT)
    public String updateUser(@RequestBody Usuario user, @PathVariable Long id){
        return userDao.updateUser(user, id);
    }

    @RequestMapping(value="usuarios/id", method=RequestMethod.POST)
    public int getIdUser(@RequestBody Usuario user){
        return userDao.getIdUser(user);
    }
}
