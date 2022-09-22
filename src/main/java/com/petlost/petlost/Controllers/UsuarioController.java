package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.IUsuarioDao;
import com.petlost.petlost.Models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
}
