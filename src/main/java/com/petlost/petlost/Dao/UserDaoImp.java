package com.petlost.petlost.Dao;

import com.petlost.petlost.Dao.Interfaces.IUsuarioDao;
import com.petlost.petlost.Models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoImp implements IUsuarioDao {
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Usuario> getUsers() {
        List<Usuario> users = null;
        String sql = "FROM Usuario";
        try{
            users = entityManager.createQuery(sql, Usuario.class).getResultList();
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
    @Transactional
    public String updateUser(Usuario usuario, Long id){
        try {
            Usuario user = entityManager.find(Usuario.class, id.intValue());
            user.setEmail(usuario.getEmail());
            user.setPassword(usuario.getPassword());
            entityManager.merge(user);
            return "Usuario actualizado";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public void deleteUser(Long id) {
        
    }

    @Override
    public boolean loginUser(Usuario user) {
        String query = "FROM Usuario WHERE email = :email AND password = :password";
        List<Usuario> answer = entityManager.createQuery(query, Usuario.class)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();
        return !answer.isEmpty();
    }
    
    public int getIdUser(Usuario user) {
        String query = "FROM Usuario WHERE email = :email AND password = :password";
        List<Usuario> answer = entityManager.createQuery(query, Usuario.class)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();
        return answer.get(0).getId_person();
    }
}
