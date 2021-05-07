/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import dto.UserDto;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author Vlad
 */
public class UserService {
    
    private EntityManagerFactory emf;
    
    private UserService(){
        emf = Persistence.createEntityManagerFactory("caseHelper-serverPU");
    }
    
    private static final class SingletonHolder {
        private static final UserService SINGLETON = new UserService();
    }
    
    public static UserService getInstance() {
        return SingletonHolder.SINGLETON;
    }
    
    public void addUser(UserDto userDto){
        EntityManager em = emf.createEntityManager();
        UserDao userDao = new UserDao(em);
        
        em.getTransaction().begin();
        
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userDao.addUser(user);
        
        em.getTransaction().commit();
        
    }
    
    public boolean registerUser(UserDto userDto) {
        
        EntityManager em = emf.createEntityManager();
        UserDao userDao = new UserDao(em);
        
        User user = userDao.findUserByUser(userDto.getUsername());
        
        if(user == null){
            
            addUser(userDto);
            
            return true;
            
        }else{
            return false;
        }

    }
    
    public void updateUser(UserDto userDto){
        EntityManager em = emf.createEntityManager();
        UserDao userDao = new UserDao(em);
        
        User user = userDao.findUserByUser(userDto.getUsername());
        
        em.getTransaction().begin();
        
        if(user == null){
            
            throw new EntityNotFoundException();
            
        }else{
            userDao.updateUser(user);
        }
        
        em.getTransaction().commit();
    }
}
