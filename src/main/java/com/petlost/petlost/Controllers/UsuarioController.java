/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.UsuarioDao;
import com.petlost.petlost.Models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jesus
 */
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao userDao;
    
    @RequestMapping(value="usuarios")
    public List<Usuario> getUsers(){
        return userDao.getUsers();
    }
    
    @RequestMapping(value="usuarios", method=RequestMethod.POST)
    public String createUser(@RequestBody Usuario user){
        return userDao.createUser(user);
    }
}
