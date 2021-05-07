/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Vlad
 */
public class UserDao {
    
    private EntityManager em;
    
    public UserDao(EntityManager em){
        this.em = em;
    }
    
    public void addUser(User user){
        
        em.persist(user);
    }
    
    public User findUserByUser(String username){
        String query = "SELECT u FROM USER WHERE u.USERNAME = :username";
        TypedQuery<User> typedQuery = em.createQuery(query, User.class);
        typedQuery.setParameter("username", username);
        List<User> users = typedQuery.getResultList();
        if(users.isEmpty()) return null;
        else return users.get(0);
    }
    
    public void updateUser(User user){
        em.merge(user);
    }
    
}
