package com.petlost.petlost.Dao.Interfaces;

import com.petlost.petlost.Models.Usuario;
import java.util.List;

public interface IUsuarioDao {
    public List<Usuario> getUsers();
    public String createUser(Usuario user);
    public void deleteUser(Long id);
    public boolean loginUser(Usuario user);
    public String updateUser(Usuario user, Long id);
}
