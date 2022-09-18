package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.UsuarioDao;
import com.petlost.petlost.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao userDao;
    
    @RequestMapping(value="login", method = RequestMethod.POST)
    public boolean login(@RequestBody Usuario user){
        return userDao.loginUser(user);
                
    }
}
