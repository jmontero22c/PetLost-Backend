/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petlost.petlost.Controllers;

import com.petlost.petlost.Dao.Interfaces.UsuarioDao;
import com.petlost.petlost.Models.Usuario;
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
public class AuthController {
    @Autowired
    private UsuarioDao userDao;
    
    @RequestMapping(value="login", method = RequestMethod.POST)
    public boolean login(@RequestBody Usuario user){
        return userDao.loginUser(user);
                
    }
}
