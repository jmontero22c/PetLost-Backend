package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.UsuarioDao;
import com.petlost.petlost.Models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoImp implements UsuarioDao {
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Usuario> getUsers() {
        List<Usuario> users = null;
        String sql = "FROM Usuario";
        try{
            users = entityManager.createQuery(sql).getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    @Transactional
    public String createUser(Usuario user) {
        try{
            entityManager.merge(user);
            return "Registro exitoso";
        }catch(Exception e){
            e.printStackTrace();
            return "Registro Fallido";
        }
        
    }

    @Override
    public void deleteUser(Long id) {
        
    }

    @Override
    public boolean loginUser(Usuario user) {
        String query = "FROM Usuario WHERE email = :email AND password = :password";
        List<Usuario> answer = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();
        return !answer.isEmpty();
    }
    
}
